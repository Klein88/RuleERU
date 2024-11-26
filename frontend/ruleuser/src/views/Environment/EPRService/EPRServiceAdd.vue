<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="服务号" style="width: 420px">
      <el-input v-model="serviceid" prefix-icon="Postcard" placeholder="请输入服务号"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" style="width: 420px">
      <el-input v-model="companyname" prefix-icon="Document" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item label="注册号" style="width: 420px">
      <el-input v-model="registrationnumber" prefix-icon="Postcard" placeholder="请输入注册号"></el-input>
    </el-form-item>
    <el-form-item label="国家" style="width: 420px">
      <el-input v-model="country" prefix-icon="Compass" placeholder="请输入国家"></el-input>
    </el-form-item>
    <el-form-item label="服务类型">
      <el-select v-model="servicetype" suffix-icon="CopyDocument" clearable placeholder="请选择服务类型" style="width: 420px">
        <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="服务提交次数" style="width: 420px">
      <el-input v-model="servicesummit" prefix-icon="DCaret" placeholder="请输入服务提交次数"></el-input>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 50px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "RegistrationAdd",
  data(){
    return{
      serviceid:'',
      companyname:'',
      registrationnumber:'',
      country:'',
      servicetype:'',
      types:[
        {
          label: '待提交资料',
          value: '待提交资料'
        },
        {
          label: '待申报',
          value: '待申报'
        },
        {
          label: '注册中',
          value: '注册中'
        },
        {
          label: '待续费',
          value: '待续费'
        }
      ],
      servicesummit:''
    }
  },
  methods:{
    close(){
      this.$router.push({
        path:'/eprservice'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Eprservice/add",{
        serviceid:this.serviceid,
        companyname:this.companyname,
        registrationnumber:this.registrationnumber,
        country:this.country,
        servicetype:this.servicetype,
        servicesummit:this.servicesummit
      })
      this.$router.push({
        path:'/eprservice'
      })
    }
  }
}
</script>

<style scoped>

</style>