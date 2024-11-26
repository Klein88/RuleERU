<template>
  <el-form :inline="true" style="margin-top: 25px">
    <el-form-item label="退税号" style="margin-left: 5px">
      <el-input v-model="taxrefundid" placeholder="请输入退税号" style="width: 110px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid(taxrefundid)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item label="国家">
      <el-input v-model="country" placeholder="请输入国家" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchcountry(country)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item label="VAT税号">
      <el-input v-model="vatnumber" placeholder="请输入VAT税号" style="width: 130px"></el-input>
      <el-button type="primary" icon="Search" @click="searchnumber(vatnumber)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item label="退税状态" style="margin-left: 5px">
      <el-input v-model="operation" placeholder="请输入状态" style="width: 95px"></el-input>
      <el-button type="primary" icon="Search" @click="searchoperation(operation)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()" style="width: 220px; margin-left: 20px">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" icon="CirclePlus" @click="add()" style="width: 220px; margin-left: 55px">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border>
    <el-table-column label="退税号" prop="taxrefundid" width="80"></el-table-column>
    <el-table-column label="国家" prop="country" width="90"></el-table-column>
    <el-table-column label="税号" prop="vatnumber" width="150"></el-table-column>
    <el-table-column label="申报类型" prop="declarationtype" width="120"></el-table-column>
    <el-table-column label="申报周期" prop="declarationcycle" width="120"></el-table-column>
    <el-table-column label="申报时间" prop="declarationdate" width="150"></el-table-column>
    <el-table-column label="应退税金" prop="refundamount" width="100"></el-table-column>
    <el-table-column label="退税状态" prop="operation" width="100"></el-table-column>
    <el-table-column label="操作" width="200">
      <template #default="scope">
        <el-button type="warning" icon="Ticket" @click="update(scope.row.taxrefundid)">退税</el-button>
        <el-button type="info" icon="Remove" @click="del(scope.row.taxrefundid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "TaxRefund",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      taxrefundid:'',
      country:'',
      vatnumber:'',
      declarationtype:'',
      declarationcycle:'',
      declarationdate:'',
      refundamount:'',
      operation:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(taxrefundid){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxrefund/findbyid",{
        params:{
          taxrefundid:this.taxrefundid
        }
      }).then((res)=>{
        this.tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    searchcountry(country){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxrefund/findbycountry",{
        params:{
          country:this.country
        }
      }).then((res)=>{
        this.tableData=res.data.data
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    searchnumber(vatnumber){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxrefund/findbyvatnumber",{
        params:{
          vatnumber:this.vatnumber
        }
      }).then((res)=>{
        this.tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    searchoperation(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxrefund/findbystatus",{
        params:{
          operation:this.operation
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
      this.$axios.get("http://121.40.119.233:8081/Taxrefund/pageList",{
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
        path:'/taxrefundadd'
      })
    },
    update(taxrefundid){
      this.$axios.get("http://121.40.119.233:8081/Taxrefund/findbyid",{
        params:{
          taxrefundid:taxrefundid
        }
      }).then((res)=>{
        if (res.data.data['operation'] == 1){
          this.$axios.post("http://121.40.119.233:8081/Taxrefund/update",{
            taxrefundid:taxrefundid,
            operation:'2'
          }).then((res)=>{
            this.getTableData()
            this.$message({
              message:"退税成功",
              type:"success"
            })
            console.log(res)
          }).catch((err)=>{
            console.log(err)
          })
        } else {
          this.$message({
            message:"已退税",
            type:"warning"
          })
        }
        console.log(res.data.data['taxrefundid'])
      })
    },
    del(taxrefundid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Taxrefund/delete/"+taxrefundid).then((res)=>{
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