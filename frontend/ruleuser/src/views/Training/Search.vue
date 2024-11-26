<template>
  <el-dialog v-model="visible" title="资料搜索">
    <el-form :inline="true" style="display: flex; justify-content: center">
      <el-form-item label="资料类别">
        <el-input v-model="documentcategory" placeholder="请输入资料类别" style="width: 120px"></el-input>
        <el-button type="primary" icon="Search" @click="search(documentcategory)" style="margin-left: 15px">搜索</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="success" icon="List" @click="getTableData()">查询所有</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" border>
      <el-table-column label="资料编号" prop="documentid" width="90"></el-table-column>
      <el-table-column label="资料名称" prop="documenttitle" width="140"></el-table-column>
      <el-table-column label="资料内容" prop="documentcontent" width="200"></el-table-column>
      <el-table-column label="资料类别" prop="documentcategory" width="90"></el-table-column>
      <el-table-column label="资料阅读数量" prop="documentreadcount" width="120"></el-table-column>
      <el-table-column label="资料创建日期" prop="documentcreated" width="150"></el-table-column>
      <el-table-column label="资料更新日期" prop="documentupdated" width="150"></el-table-column>
    </el-table>
  </el-dialog>
</template>

<script>
export default {
  name: "Search",
  data(){
    return{
      visible:false,
      tableData:[],
      pageNum:1,
      pageSize:10,
      documentcategory:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    open(){
      this.visible=true
    },
    search(documentcategory){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Documents/find",{
        params:{
          documentcategory:this.documentcategory
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
      this.$axios.get("http://121.40.119.233:8081/Documents/pageList",{
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
    }
  }
}
</script>

<style scoped>

</style>