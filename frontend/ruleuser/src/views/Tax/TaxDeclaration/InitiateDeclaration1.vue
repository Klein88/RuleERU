<template>
  <el-steps :active="0" process-status="finish" finish-status="success" align-center style="margin-top: 20px">
    <el-step title="确认申报信息" />
    <el-step title="上传销售数据" />
    <el-step title="查看算税结果" />
    <el-step title="添加其他申报项" />
    <el-step title="查看申报明细" />
  </el-steps>
  <el-descriptions :column="2" border style="margin-top: 30px">
    <el-descriptions-item :span="2">
      <template #label>
        <div>
          公司名称
        </div>
      </template>
      {{this.$route.query.companyname}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        VAT税号
      </template>
      {{this.$route.query.vatnumber}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        税率
      </template>
      {{this.$route.query.taxrate}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        VAT申报书
      </template>
      {{this.$route.query.vatdeclarationdocument}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        转代理承诺书
      </template>
      {{this.$route.query.proxycommitmentdocument}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        最后一次申报日期
      </template>
      {{this.$route.query.lastreporteddate}}
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        申报截止日期
      </template>
      {{this.$route.query.lastdeclarationdate}}
    </el-descriptions-item>
  </el-descriptions>
  <div style="margin-top: 50px; display: flex; justify-content: center">
    <el-button type="default" @click="back()" style="width: 150px">返回 “申报” 主页</el-button>
    <el-button type="primary" @click="next()" style="margin-left: 100px; width: 150px">下一步</el-button>
  </div>
</template>

<script>
export default {
  name: "initiatedeclaration1",
  methods:{
    back(){
      this.$router.push({
        path:'/taxdeclaration'
      })
    },
    next(){
      this.$router.push({
        path:'/initiatedeclaration2',
        query:{
          taxrate:this.$route.query.taxrate
        }
      })
    }
  }
}
</script>

<style scoped>

</style>