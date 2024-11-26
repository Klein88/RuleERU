<template>
  <el-steps :active="4" process-status="finish" finish-status="success" align-center style="margin-top: 20px">
    <el-step title="确认申报信息" />
    <el-step title="上传销售数据" />
    <el-step title="查看算税结果" />
    <el-step title="添加其他申报项" />
    <el-step title="查看申报明细" />
  </el-steps>
  <p style="margin-top: 30px">查看申报明细</p>
  <el-table :data="data" style="margin-top: 20px">
    <el-table-column label="申报项" prop="name" width="600"></el-table-column>
    <el-table-column label="金额" prop="money"></el-table-column>
  </el-table>
  <div style="margin-top: 50px; display: flex; justify-content: center">
    <el-button type="default" @click="back()" style="width: 150px">返回 “申报” 主页</el-button>
    <el-button type="primary" @click="next()" style="margin-left: 100px; width: 150px">提交申报</el-button>
  </div>
</template>

<script>
export default {
  name: "InitiateDeclaration5",
  data(){
    return{
      data:''
    }
  },
  created() {
    this.get()
  },
  methods:{
    get(){
      this.data=[
        {
          name: 'amazon平台销售额',
          money: this.$route.query.amazonmoney
        },
        {
          name: 'ebay平台销售额',
          money: this.$route.query.ebaymoney
        },
        {
          name: '总销售额',
          money: parseInt(this.$route.query.amazonmoney) + parseInt(this.$route.query.ebaymoney)
        },
        {
          name: '缴税额',
          money: parseInt(this.$route.query.amazonpay) + parseInt(this.$route.query.ebaypay)
        }
      ]
    },
    back(){
      this.$router.push({
        path:'/taxdeclaration'
      })
    },
    next(){

    }
  }
}
</script>

<style scoped>

</style>