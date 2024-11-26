<template>
  <el-tag type="warning" size="large" closable style="width: 910px">想要查看数据或刷新表格需点击  “查询所有”  按钮哦！</el-tag>
  <el-form :inline="true" style="margin-top: 25px">
    <el-form-item label="工单编号">
      <el-input v-model="workorderid" placeholder="请输入想要查询的工单编号" style="width: 200px"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="Search" @click="search(workorderid)">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="warning" icon="CirclePlus" @click="add()">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border  style="width: 100%">
    <el-table-column label="工单编号" prop="workorderid" width="120"></el-table-column>
    <el-table-column label="用户编号" prop="userid" width="120"></el-table-column>
    <el-table-column label="工单主题" prop="workordertheme" width="150"></el-table-column>
    <el-table-column label="工单描述" prop="description" width="220"></el-table-column>
    <el-table-column label="工单状态" prop="status" width="120"></el-table-column>
    <el-table-column label="创建日期" prop="creationdate" width="180"></el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "workorders",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      workorderid:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    search(workorderid){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Workorder/find",{
        params:{
          workorderid:this.workorderid
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
      this.$axios.get("http://121.40.119.233:8081/Workorder/pageList",{
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
    add(){
      this.$router.push({
        path:'/workordersadd'
      })
    }
  }
}
</script>

<style scoped>

</style>