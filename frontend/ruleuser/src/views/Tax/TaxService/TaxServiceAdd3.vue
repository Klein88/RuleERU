<template>
  <el-dialog v-model="visible"  title="添加VAT税号" width="650px">
    <el-steps :active="active" :space="300" process-status="finish" finish-status="success" align-center>
      <el-step title="选择国家" />
      <el-step title="填写税号信息" />
      <el-step title="添加完成" />
    </el-steps>
    <el-empty :image-size="100" description="您已完成VAT税号的添加，点击确认后生效"></el-empty>
    <div style="display: flex; justify-content: end; margin-top: 30px; margin-right: 20px">
      <el-button type="default" style="width: 80px" @click="back()">取消</el-button>
      <el-button type="primary" style="width: 100px" @click="next()">确认</el-button>
    </div>
  </el-dialog>
</template>

<script>
import {ref,toRaw} from "vue";

export default {
  name: "TaxServiceAdd3",
  data(){
    return{
      visible:false,
      active:ref(2),
      countries:[],
      vatnumbers:[],
      taxrates:[],
      servicetypes:[],
      taxtypes:[],
      serviceprogresses:[],
      servicesummits:[],
      companynames:[],
      taxserviceids:[]
    }
  },
  methods:{
    open(){
      this.visible=true
    },
    back(){
      this.visible=false
    },
    next(){
      for (let i=0; i<this.countries.length; i++){
        this.$axios.post("http://121.40.119.233:8081/Taxservice/add",{
          taxserviceid:parseInt(toRaw(this.taxserviceids[i])),
          country:toRaw(this.countries[i]),
          companyname:this.companynames[i],
          vatnumber:toRaw(this.vatnumbers[i]),
          taxrate:toRaw(this.taxrates[i]),
          servicetype:toRaw(this.servicetypes[i]),
          taxtype:toRaw(this.taxtypes[i]),
          serviceprogress:toRaw(this.serviceprogresses[i]),
          servicesummit:parseInt(toRaw(this.servicesummits[i]))
        }).then((res)=>{
          console.log(res)
        }).catch((err)=>{
          console.log(err)
        })
      }
      this.visible=false
    }
  }
}
</script>

<style scoped>

</style>