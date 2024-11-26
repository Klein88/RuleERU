<template>
  <p style="margin-top: 20px">选择账户</p>
  <el-radio-group v-model="radio" style="margin-top: 10px">
    <el-radio label="1">LianLian Global 连连国际</el-radio>
    <el-radio label="2">PingPong</el-radio>
    <el-radio label="3">空中云汇</el-radio>
    <el-radio label="4">万里汇</el-radio>
  </el-radio-group>
  <h1 style="margin-top: 30px">缴税信息</h1>
  <el-table :data="tableData" style="margin-top: 10px">
    <el-table-column label="VAT税号" prop="vatnumber"></el-table-column>
    <el-table-column label="销售平台" prop="salesplatform"></el-table-column>
    <el-table-column label="应税销售额" prop="taxablesales"></el-table-column>
    <el-table-column label="税率" prop="taxrate"></el-table-column>
    <el-table-column label="纳税额" prop="taxamount"></el-table-column>
  </el-table>
  <h1 style="margin-top: 30px">付款信息</h1>
  <el-descriptions :column="1" border style="margin-top: 10px">
    <el-descriptions-item width="100px">
      <template #label>
        <div>
          收款账户名称
        </div>
      </template>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        收款账户
      </template>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        付款备注
      </template>
    </el-descriptions-item>
  </el-descriptions>
  <el-text style="display: flex; justify-content: right; margin-top: 80px; margin-right: 120px">需缴税金：</el-text>
  <el-text style="display: flex; justify-content: right; margin-top: 20px; margin-right: 120px">服务费：</el-text>
  <el-text style="display: flex; justify-content: right; margin-top: 20px; margin-right: 120px; color: red">服务费优惠：</el-text>
  <el-text style="display: flex; justify-content: right; margin-top: 35px; margin-right: 120px">合计：</el-text>
  <el-row>
    <el-col :span="19">
      <el-button type="default" style="width: 150px; margin-top: 30px" @click="back()">返回 “缴税” 页面</el-button>
    </el-col>
    <el-col :span="5">
      <el-button type="primary" style="width: 150px; margin-top: 30px">支付</el-button>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "taxpaymentupdate",
  data(){
    return{
      tableData:[],
      radio:''
    }
  },
  methods:{
    back(){
      this.$router.push({
        path:'/taxpayment'
      })
    }
  }
}
</script>

<style scoped>

</style>