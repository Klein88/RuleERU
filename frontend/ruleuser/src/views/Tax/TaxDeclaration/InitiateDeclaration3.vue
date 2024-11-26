<template>
  <el-steps :active="2" process-status="finish" finish-status="success" align-center style="margin-top: 20px">
    <el-step title="确认申报信息" />
    <el-step title="上传销售数据" />
    <el-step title="查看算税结果" />
    <el-step title="添加其他申报项" />
    <el-step title="查看申报明细" />
  </el-steps>
  <p style="margin-top: 30px; font-size: 18px">查看算税结果</p>
  <el-descriptions :column="2" border style="margin-top: 30px">
    <el-descriptions-item width="200px">
      <template #label>
        <div>含税销售额（元）</div>
      </template>
      {{this.$route.query.money}}
    </el-descriptions-item>
    <el-descriptions-item width="200px">
      <template #label>
        <div>需缴税款（元）</div>
      </template>
      {{pay}}
    </el-descriptions-item>
  </el-descriptions>
  <div style="margin-top: 50px; display: flex; justify-content: center">
    <el-button type="default" @click="back()" style="width: 150px">返回 “申报” 主页</el-button>
    <el-button type="primary" @click="next()" style="margin-left: 100px; width: 150px">下一步</el-button>
  </div>
</template>

<script>
export default {
  name: "InitiateDeclaration3",
  data(){
    return{
      money:0,
      pay:0
    }
  },
  created() {
    this.get()
  },
  methods:{
    get(){
      this.pay=this.$route.query.money * this.$route.query.taxrate / 100
    },
    back(){
      this.$router.push({
        path:'/taxdeclaration'
      })
    },
    next(){
      this.$router.push({
        path:'/initiatedeclaration4',
        query:{
          taxrate:this.$route.query.taxrate,
          amazonmoney:this.$route.query.money,
          amazonpay:this.pay
        }
      })
    }
  }
}
</script>

<style scoped>

</style>