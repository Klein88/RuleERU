<template>
  <el-form :inline="true" style="margin-top: 25px; display: flex; justify-content: center">
    <el-form-item label="申报号" style="margin-left: 9px">
      <el-input v-model="declarationid" placeholder="请输入申报号" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid(declarationid)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item label="VAT税号" style="margin-left: 9px">
      <el-input v-model="vatnumber" placeholder="请输入VAT税号" style="width: 180px"></el-input>
      <el-button type="primary" icon="Search" @click="searchnumber(vatnumber)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()" style="width: 130px">查询所有</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border>
    <el-table-column label="申报号" prop="declarationid" width="70"></el-table-column>
    <el-table-column label="VAT税号" prop="vatnumber"></el-table-column>
    <el-table-column label="公司名称" prop="companyname" width="180"></el-table-column>
    <el-table-column label="最后一次申报日期" prop="lastreporteddate"></el-table-column>
    <el-table-column label="申报截止日期" prop="lastdeclarationdate"></el-table-column>
    <el-table-column label="操作" width="230">
      <template #default="scope">
        <el-button type="warning" icon="UploadFilled" @click="declaration(scope.row.declarationid)">发起申报</el-button>
        <el-button type="danger" icon="Remove" @click="del(scope.row.declarationid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <ConfirmInformation ref="ConfirmInformation"></ConfirmInformation>
</template>

<script>
import ConfirmInformation from "@/views/Tax/TaxDeclaration/ConfirmInformation.vue";

export default {
  name: "taxdeclaration",
  components:{ConfirmInformation},
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      declarationid:'',
      vatnumber:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(declarationid){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxdeclaration/find",{
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
    searchnumber(vatnumber){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxdeclaration/find2",{
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
    getTableData(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxdeclaration/pageList",{
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
    async declaration(declarationid){
      var tableData=[]
      await this.$axios.get("http://121.40.119.233:8081/Taxdeclaration/find",{
        params:{
          declarationid:declarationid
        }
      }).then((res)=>{
        tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
      this.$refs.ConfirmInformation.tableData=tableData
      this.$refs.ConfirmInformation.open()
    },
    del(declarationid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Taxdeclaration/delete/"+declarationid).then((res)=>{
          console.log(res)
          this.$message({
            message:"删除成功",
            type:"success"
          })
          this.getTableData()
        }).catch((err)=>{
          console.log(err)
        })
      }).catch((err)=>{
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