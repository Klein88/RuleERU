<template>
  <el-form style="margin-top: 25px">
    <el-form-item label="税收政策">
      <el-input v-model="taxpolicydescription" placeholder="请输入" style="width: 200px"></el-input>
      <el-button type="primary" icon="Search" style="margin-left: 30px">搜索</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border>
    <el-table-column label="政策编号" prop="policyid"></el-table-column>
    <el-table-column label="地区" prop="region"></el-table-column>
    <el-table-column label="税收政策内容" prop="taxpolicydescription"></el-table-column>
    <el-table-column label="税务法规说明" prop="taxregulationdescription"></el-table-column>
    <el-table-column label="生效日期" prop="effectivedate"></el-table-column>
    <el-table-column label="到期日期" prop="expirydate"></el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "LocalTaxPolicy",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    getTableData(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Localtaxpolicy/pageList",{
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