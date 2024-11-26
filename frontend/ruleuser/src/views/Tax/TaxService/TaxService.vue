<template>
  <el-form :inline="true" style="margin-top: 25px; display: flex; justify-content: center">
    <el-form-item label="税务号">
      <el-input v-model="taxserviceid" placeholder="请输入税务号" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchid(taxserviceid)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item label="VAT税号">
      <el-input v-model="vatnumber" placeholder="请输入VAT税号" style="width: 120px"></el-input>
      <el-button type="primary" icon="Search" @click="searchnumber(vatnumber)" style="margin-left: 15px">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="List" @click="getTableData()">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="danger" icon="CirclePlus" @click="add()">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column label="税务号" prop="taxserviceid" width="70"></el-table-column>
    <el-table-column label="国家" prop="country" width="90"></el-table-column>
    <el-table-column label="公司名称" prop="companyname" width="210"></el-table-column>
    <el-table-column label="VAT税号" prop="vatnumber" width="210"></el-table-column>
    <el-table-column label="税率(%)" prop="taxrate" width="80"></el-table-column>
    <el-table-column label="申报规则" prop="servicetype" width="110"></el-table-column>
    <el-table-column label="申报周期" prop="taxtype" width="90"></el-table-column>
    <el-table-column label="服务进度" prop="serviceprogress" width="100"></el-table-column>
    <el-table-column label="服务提交次数" prop="servicesummit" width="120"></el-table-column>
    <el-table-column label="操作" width="140">
      <template #default="scope">
        <el-button type="warning" icon="Edit" @click="information(scope.row.taxserviceid)">填写资料</el-button>
      </template>
    </el-table-column>
  </el-table>
  <TaxServiceAdd1 ref="TaxServiceAdd1"></TaxServiceAdd1>
</template>

<script>
import TaxServiceAdd1 from "@/views/Tax/TaxService/TaxServiceAdd1.vue";

export default {
  name: "taxservice",
  components:{TaxServiceAdd1},
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      taxserviceid:'',
      vatnumber:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    searchid(taxserviceid){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Taxservice/find",{
        params:{
          taxserviceid:this.taxserviceid
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
      this.$axios.get("http://121.40.119.233:8081/Taxservice/findbyvatnumber",{
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
      this.$axios.get("http://121.40.119.233:8081/Taxservice/pageList",{
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
      this.$refs.TaxServiceAdd1.open()
    },
    async information(taxserviceid){
      await this.$axios.get("http://121.40.119.233:8081/Taxservice/find",{
        params:{
          taxserviceid:taxserviceid
        }
      }).then((res)=>{
        console.log(res)
        console.log(res.data.data['vatnumber'])
        this.$router.push({
          path:'/taxdeclarationadd/'+taxserviceid,
          query:{
            taxserviceid:taxserviceid,
            country:res.data.data['country'],
            companyname:res.data.data['companyname'],
            vatnumber:res.data.data['vatnumber'],
            taxrate:res.data.data['taxrate'],
            servicetype:res.data.data['servicetype'],
            taxtype:res.data.data['taxtype'],
            serviceprogress:res.data.data['serviceprogress'],
            servicesummit:res.data.data['servicesummit']
          }
        })
      })
    }
  }
}
</script>

<style scoped>

</style>