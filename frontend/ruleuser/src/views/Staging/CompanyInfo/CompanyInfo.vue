<template>
  <el-tag type="warning" size="large" closable style="width: 910px">想要查看数据或刷新表格需点击  “查询所有”  按钮哦！</el-tag>
  <el-form :inline="true" style="margin-top: 25px">
    <el-form-item label="企业名称">
      <el-input v-model="companyname" placeholder="请输入想要查询的企业名称" style="width: 200px"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="Search" @click="search(companyname)">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()">查询所有</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column label="用户编号" prop="userid" width="100"></el-table-column>
    <el-table-column label="公司名称" prop="companyname" width="180"></el-table-column>
    <el-table-column label="公司类型" prop="companytype" width="100"></el-table-column>
    <el-table-column label="公司地址" prop="companyaddress" width="100"></el-table-column>
    <el-table-column label="公司电话" prop="companytel" width="120"></el-table-column>
    <el-table-column label="注册地址" prop="companyregister" width="100"></el-table-column>
    <el-table-column label="公司商标" prop="companyphoto" width="150"></el-table-column>
    <el-table-column label="公司邮编" prop="companynumber" width="150"></el-table-column>
    <el-table-column label="公司状态" prop="companystatue" width="100"></el-table-column>
    <el-table-column label="操作" width="120">
      <template #default="scope">
        <el-button type="warning" icon="Refresh" @click="update(scope.row.companyname)">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "companyinfo",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      companyname:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    search(companyname){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Companyinfo/find",{
        params:{
          companyname:this.companyname
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
      this.$axios.get("http://121.40.119.233:8081/Companyinfo/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.tableData = res.data.data.records
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    update(companyname){
      this.$router.push({
        path:'/companyinfoupdate/'+companyname
      })
    }
  }
}
</script>

<style scoped>

</style>