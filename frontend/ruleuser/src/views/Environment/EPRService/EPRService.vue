<template>
  <el-form :inline="true" style="margin-top: 25px; display: flex; justify-content: center">
    <el-form-item label="服务号">
      <el-input v-model="eprserviceid" placeholder="请输入服务号" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid()" style="margin-left: 20px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()" style="width: 150px; margin-left: 50px">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" icon="CirclePlus" @click="add()" style="width: 130px; margin-left: 50px">注册</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border>
    <el-table-column label="服务号" prop="eprserviceid" width="90"></el-table-column>
    <el-table-column label="公司名称" prop="companyname" width="230"></el-table-column>
    <el-table-column label="注册号" prop="registrationnumber" width="180"></el-table-column>
    <el-table-column label="国家" prop="country"></el-table-column>
    <el-table-column label="服务类型" prop="servicetype" width="100"></el-table-column>
    <el-table-column label="服务提交次数" prop="servicesummit" width="110"></el-table-column>
    <el-table-column label="操作" width="230">
      <template #default="scope">
        <el-button type="warning" icon="Edit" @click="information(scope.row.eprserviceid)">填写资料</el-button>
        <el-button type="info" icon="Remove" @click="del(scope.row.eprserviceid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "registration",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      eprserviceid:'',
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Eprservice/find",{
        params:{
          eprserviceid:this.eprserviceid
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
      this.$axios.get("http://121.40.119.233:8081/Eprservice/pageList",{
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
        path:'/eprserviceadd'
      })
    },
    information(eprserviceid){
      this.$router.push({
        path:'/eprserviceinformation/'+eprserviceid
      })
    }
  }
}
</script>

<style scoped>

</style>