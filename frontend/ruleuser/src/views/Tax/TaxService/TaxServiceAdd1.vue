<template>
  <el-dialog v-model="visible" title="添加VAT税号" width="650px">
    <el-steps :active="active" :space="300" process-status="finish" finish-status="success" align-center>
      <el-step title="选择国家" />
      <el-step title="填写税号信息" />
      <el-step title="添加完成" />
    </el-steps>
    <el-form model="form" style="margin-top: 30px; margin-left: 20px">
      <el-form-item label="公司名称" prop="companyname" style="width: 550px">
        <el-input v-model="form.companyname" placeholder="请输入公司名称"></el-input>
      </el-form-item>
      <el-form-item label="税号国家">
        <el-checkbox-group v-model="form.country">
          <el-checkbox v-for="country in countries" :key="country" :label="country"></el-checkbox>
        </el-checkbox-group>
      </el-form-item>
    </el-form>
    <el-text style="color: red; font-size: 13px; margin-left: 13px">提示：请勾选已注册VAT税号的所有国家，否则会影响VAT归属国的判定，进而导致VAT计算不准确。</el-text>
    <div style="display: flex; justify-content: end; margin-top: 30px; margin-right: 20px">
      <el-button type="default" style="width: 80px" @click="close()">取消</el-button>
      <el-button type="primary" style="width: 100px" @click="next()">下一步</el-button>
    </div>
  </el-dialog>
  <TaxServiceAdd2 ref="TaxServiceAdd2"></TaxServiceAdd2>
</template>

<script>
import {ref} from "vue";
import TaxServiceAdd2 from "@/views/Tax/TaxService/TaxServiceAdd2.vue";
export default {
  name: "TaxServiceAdd1",
  components:{TaxServiceAdd2},
  data(){
    return{
      visible:false,
      active:ref(0),
      form:{
        companyname: '',
        country:[]
      },
      countries:['英国','德国','法国','意大利','西班牙'],
      detailParams:{}
    }
  },
  methods:{
    open(){
      this.visible=true
    },
    close(){
      this.visible=false
      this.form.companyname=''
      this.form.country=[]
    },
    next(){
      this.detailParams={
        companyname:this.form.companyname,
        country:this.form.country
      }
      var tableData = []
      this.detailParams.country.forEach((item) => {
        var obj = {}
        obj['country'] = item
        tableData.push(obj)
      })
      this.$refs.TaxServiceAdd2.tableData=tableData
      this.$refs.TaxServiceAdd2.companyname=this.detailParams.companyname
      this.$refs.TaxServiceAdd2.open()
      this.visible=false
    }
  }
}
</script>

<style scoped>

</style>