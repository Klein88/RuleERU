<template>
  <el-form :inline="true" style="margin-top: 25px; display: flex; justify-content: center">
    <el-form-item label="编号">
      <el-input v-model="declarationid" placeholder="请输入编号" style="width: 100px"></el-input>
      <el-button type="primary" icon="Search" @click="search()" style="margin-left: 10px">搜索</el-button>
    </el-form-item>
    <el-form-item label="申请号">
      <el-input v-model="applicationid" placeholder="请输入申请号" style="width: 110px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid()" style="margin-left: 10px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()" style="width: 130px; margin-left: 25px">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" icon="CirclePlus" @click="add()" style="width: 110px; margin-left: 25px">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border>
    <el-table-column label="编号" prop="declarationid" width="80"></el-table-column>
    <el-table-column label="制造商名称" prop="manufacturername" width="180"></el-table-column>
    <el-table-column label="公司地址" prop="businessaddress" width="220"></el-table-column>
    <el-table-column label="授权代表" prop="authorizedrepresentative" width="120"></el-table-column>
    <el-table-column label="产品序列号" prop="productserialnumber" width="130"></el-table-column>
    <el-table-column label="型号或类型标识" prop="modelortypeidentification" width="180"></el-table-column>
    <el-table-column label="责任声明" prop="responsibilitystatement" width="200"></el-table-column>
    <el-table-column label="产品识别手段" prop="productidentification" width="200"></el-table-column>
    <el-table-column label="指定机构的详细信息" prop="notifiedbodydetails" width="200"></el-table-column>
    <el-table-column label="遵守的相关法律和标准" prop="legislationandstandards" width="200"></el-table-column>
    <el-table-column label="签名者姓名" prop="signatoryname" width="120"></el-table-column>
    <el-table-column label="签名" prop="signatorysignature" width="150"></el-table-column>
    <el-table-column label="声明签发日期" prop="declarationdate" width="150"></el-table-column>
    <el-table-column label="补充信息" prop="supplementaryinformation" width="200"></el-table-column>
    <el-table-column label="进口商责任" prop="importerresponsibility" width="200"></el-table-column>
    <el-table-column label="翻译要求" prop="translationrequirement" width="200"></el-table-column>
    <el-table-column label="产品图片" prop="productimage" width="150"></el-table-column>
    <el-table-column label="申请号" prop="applicationid" width="80"></el-table-column>
    <el-table-column label="操作" width="200">
      <template #default="scope">
        <el-button type="warning" icon="Refresh" @click="update(scope.row.declarationid)">编辑</el-button>
        <el-button type="info" icon="Remove" @click="del(scope.row.declarationid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "DocumentApplication",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      declarationid:'',
      applicationid:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    search(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Eudeclarationofconformity/find",{
        params:{
          declarationid:this.declarationid
        }
      }).then((res)=>{
        this.tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    searchid(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Eudeclarationofconformity/findbyapplicationid",{
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
      this.$axios.get("http://121.40.119.233:8081/Eudeclarationofconformity/pageList",{
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
        path:'/documentapplicationadd'
      })
    },
    update(declarationid){
      this.$router.push({
        path:'/documentapplicationupdate/'+declarationid
      })
    },
    del(declarationid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Eudeclarationofconformity/delete/"+declarationid).then((res)=>{
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