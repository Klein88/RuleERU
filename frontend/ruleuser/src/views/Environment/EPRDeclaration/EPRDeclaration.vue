<template>
  <el-form :inline="true" style="margin-top: 25px; display: flex; justify-content: center">
    <el-form-item label="EPR申报号">
      <el-input v-model="eprdeclarationid" placeholder="请输入EPR申报号" style="width: 150px"></el-input>
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
    <el-table-column label="编号" prop="summaryid" width="70"></el-table-column>
    <el-table-column label="注册码" prop="registrationcode" width="130"></el-table-column>
    <el-table-column label="申报年份" prop="declarationyear" width="90"></el-table-column>
    <el-table-column label="品牌名称" prop="brandname" width="150"></el-table-column>
    <el-table-column label="申报数据序号" prop="declarationdataserialnumber" width="110"></el-table-column>
    <el-table-column label="包装材料" prop="packagingmaterial" width="90"></el-table-column>
    <el-table-column label="预申报重量" prop="predeclaredweight" width="100"></el-table-column>
    <el-table-column label="实际包装重量" prop="actualpackagingweight" width="110"></el-table-column>
    <el-table-column label="EPR申报号" prop="eprdeclarationid" width="100"></el-table-column>
    <el-table-column label="操作" width="200">
      <template #default="scope">
        <el-button type="warning" icon="Refresh" @click="update(scope.row.summaryid)">编辑</el-button>
        <el-button type="info" icon="Remove" @click="del(scope.row.summaryid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "Declaration",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      summaryid:'',
      eprdeclarationid:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Packagingsummarydeclaration/find",{
        params:{
          eprdeclarationid:this.eprdeclarationid
        }
      }).then((res)=>{
        this.tableData=res.data.data
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    getTableData(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Packagingsummarydeclaration/pageList",{
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
        path:'/eprdeclarationadd'
      })
    },
    update(declarationid){
      this.$router.push({
        path:'/eprdeclarationupdate/'+declarationid
      })
    },
    del(declarationid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Packagingsummarydeclaration/delete/"+declarationid).then((res)=>{
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