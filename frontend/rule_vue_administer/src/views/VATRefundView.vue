
<template>


<el-table :data="datas">
  <el-table-column prop="taxrefundid" label="id"></el-table-column>
  <el-table-column prop="country" label="国家" width="200px"></el-table-column>
  <el-table-column prop="vatnumber" label="VAT税号" width="200px"></el-table-column>
  <el-table-column prop="declarationtype" label="季度申报" width="200px"></el-table-column>
  <el-table-column prop="refundamount" label="需退税金额(/￥)" width="200px"></el-table-column>
  <el-table-column prop="declarationdate" label="退税日期" width="200px"></el-table-column>
  <el-table-column label="退税状态" width="200px">
    <template v-slot="{row}">
      {{getColor(row.operation)}}
    </template>
  </el-table-column>
  <el-table-column label="处理退税" width="200px">
    <template v-slot="{row}">
    <el-button type="success" @click="updateRefund(row)">点击进行退税</el-button>
    </template>
  </el-table-column>
</el-table>
</template>
<script>



export default
{
  data()
  {
    return{
      datas : ""
    }
  },
  methods:{
    getColor(operation)
    {
      if(operation == 1)
      {
        return "未退税"
      }
      else
      {
        return "已退税"
      }
    },
    updateRefund(row){
      row.operation = 2
      console.log("row" , row)
      this.$axios.post("http://121.40.119.233:8081/Taxrefund/update" , row)
          .then(req => {
            this.$router.go(0)
          }).catch(error => {
            console.log(error)
      })

    }
  },
  created() {

      this.$axios.get("http://121.40.119.233:8081/Taxrefund/pageList?pageSize=1&pageNum=1")
          .then(req => {
            this.datas = req.data.data.records
          }).catch(error => {
            console.log(error)
          })
  }
}
</script>




<style scoped>

</style>