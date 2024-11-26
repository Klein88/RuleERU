<template>
  <el-form :inline="true" style="margin-top: 25px">
    <el-form-item label="缴税号" style="margin-left: 9px">
      <el-input v-model="taxpaymentid" placeholder="请输入缴税号" style="width: 105px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid(taxpaymentid)" style="margin-left: 10px">搜索</el-button>
    </el-form-item>
    <el-form-item label="公司名称">
      <el-input v-model="companyname" placeholder="请输入公司名称" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchname(companyname)" style="margin-left: 10px">搜索</el-button>
    </el-form-item>
    <el-form-item label="缴税状态">
      <el-input v-model="paymentstatus" placeholder="请输入缴税状态" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchstatus(paymentstatus)" style="margin-left: 10px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()" style="width: 220px; margin-left: 320px">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" icon="CirclePlus" @click="add()" style="width: 220px; margin-left: 60px">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column label="缴税号" prop="taxpaymentid" width="70"></el-table-column>
    <el-table-column label="公司名称" prop="companyname" width="210"></el-table-column>
    <el-table-column label="国家" prop="country" width="70"></el-table-column>
    <el-table-column label="税号" prop="vatnumber" width="210"></el-table-column>
    <el-table-column label="申报类型" prop="declarationtype" width="100"></el-table-column>
    <el-table-column label="应缴税金" prop="amountdue" width="110"></el-table-column>
    <el-table-column label="货币种类" prop="currency" width="90"></el-table-column>
    <el-table-column label="申报周期" prop="declarationcycle" width="120"></el-table-column>
    <el-table-column label="申报期间" prop="declarationperiod" width="150"></el-table-column>
    <el-table-column label="税金截止到账时间" prop="duedate" width="150"></el-table-column>
    <el-table-column label="缴税状态" prop="paymentstatus" width="90"></el-table-column>
    <el-table-column label="操作" width="200">
      <template #default="scope">
        <el-button type="warning" icon="Ticket" @click="update(scope.row.taxpaymentid)">缴税</el-button>
        <el-button type="info" icon="Remove" @click="del(scope.row.taxpaymentid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "taxpayment",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      taxpaymentid:'',
      companyname:'',
      paymentstatus:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(taxpaymentid){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxpayment/findbyid",{
        params:{
          taxpaymentid:this.taxpaymentid
        }
      }).then((res)=>{
        this.tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    searchname(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxpayment/findbycompanyname",{
        params:{
          companyname:this.companyname
        }
      }).then((res)=>{
        this.tableData=res.data.data
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    searchstatus(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxpayment/findbystatus",{
        params:{
          paymentstatus:this.paymentstatus
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
      this.$axios.get("http://121.40.119.233:8081/Taxpayment/pageList",{
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
        path:'/taxpaymentadd'
      })
    },
    update(taxpaymentid){
      this.$router.push({
        path:'/taxpaymentupdate/'+taxpaymentid
      })
    },
    del(taxpaymentid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Taxpayment/delete/"+taxpaymentid).then((res)=>{
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