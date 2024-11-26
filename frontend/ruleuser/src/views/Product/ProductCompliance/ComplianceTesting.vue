<template>
  <el-form :inline="true" style="margin-top: 25px; display: flex; justify-content: center">
    <el-form-item label="申请编号">
      <el-input v-model="applicationid" placeholder="请输入申请编号" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid()" style="margin-left: 20px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()" style="width: 150px; margin-left: 50px">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" icon="CirclePlus" @click="add()" style="width: 130px; margin-left: 50px">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border>
    <el-table-column label="申请编号" prop="applicationid" width="90"></el-table-column>
    <el-table-column label="文件类型" prop="filetype" width="150"></el-table-column>
    <el-table-column label="公司名称" prop="companyname" width="180"></el-table-column>
    <el-table-column label="产品中文名称" prop="productchinesename" width="180"></el-table-column>
    <el-table-column label="产品英文名称" prop="productenglishname" width="250"></el-table-column>
<!--    <el-table-column label="商标" prop="trademark" width="100"></el-table-column>-->
    <el-table-column label="办理日期" prop="applicationdate" width="150"></el-table-column>
    <el-table-column label="操作" width="110">
      <template #default="scope">
        <el-button type="info" icon="Remove" @click="del(scope.row.applicationid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "ComplianceTesting",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      applicationid:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Complianceapplication/find",{
        params:{
          applicationid:this.applicationid
        }
      }).then((res)=>{
        this.tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    getTableData(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Complianceapplication/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.tableData=res.data.data.records
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    add(){
      this.$router.push({
        path:'/compliancetestingadd'
      })
    },
    del(applicationid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Complianceapplication/delete/"+applicationid).then((res)=>{
          console.log(res)
          this.$message({
            message:"删除成功",
            type:"success"
          })
          this.getTableData()
        }).catch((err)=>{
          console.log(err)
        })
      }).catch(()=>{
        this.$message({
          message:"已取消删除",
          type:"info"
        })
      })
    }
  }
}
</script>

<style scoped>

</style>