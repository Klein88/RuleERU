<template>
  <el-dialog v-model="visible" title="确认本次申报信息">
    <el-descriptions :column="2" border>
      <el-descriptions-item :span="2">
        <template #label>
          <div>
            公司名称
          </div>
        </template>
        {{tableData[0]['companyname']}}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          VAT税号
        </template>
        {{tableData[0]['vatnumber']}}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          税率
        </template>
        {{tableData[0]['taxrate']}}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          VAT申报书
        </template>
        {{tableData[0]['vatdeclarationdocument']}}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          转代理承诺书
        </template>
        {{tableData[0]['proxycommitmentdocument']}}
      </el-descriptions-item>
      <el-descriptions-item width="100px">
        <template #label>
          最后一次申报日期
        </template>
        <p style="width: 170px">{{tableData[0]['lastreporteddate']}}</p>
      </el-descriptions-item>
      <el-descriptions-item width="100px">
        <template #label>
          申报截止日期
        </template>
        <p style="width: 170px">{{tableData[0]['lastdeclarationdate']}}</p>
      </el-descriptions-item>
    </el-descriptions>
    <div style="margin-top: 30px; display: flex; justify-content: right">
      <el-button type="default" @click="close()">关闭</el-button>
      <el-button type="primary" @click="next()" style="margin-right: 20px">继续申报</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "ConfirmInformation",
  data(){
    return{
      visible:false,
      tableData:[]
    }
  },
  methods:{
    open(){
      this.visible=true
    },
    close(){
      this.visible=false
    },
    next(){
      this.visible=false
      this.$router.push({
        path:'/initiatedeclaration1',
        query:{
          companyname:this.tableData[0]['companyname'],
          vatnumber:this.tableData[0]['vatnumber'],
          taxrate:this.tableData[0]['taxrate'],
          vatdeclarationdocument:this.tableData[0]['vatdeclarationdocument'],
          proxycommitmentdocument:this.tableData[0]['proxycommitmentdocument'],
          lastreporteddate:this.tableData[0]['lastreporteddate'],
          lastdeclarationdate:this.tableData[0]['lastdeclarationdate']
        }
      })
    }
  }
}
</script>

<style scoped>

</style>