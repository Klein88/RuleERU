<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="申请编号" style="width: 420px">
      <el-input v-model="applicationid" prefix-icon="Postcard" placeholder="请输入申请编号"></el-input>
    </el-form-item>
    <el-form-item label="文件类型">
      <el-select v-model="filetype" suffix-icon="CopyDocument" placeholder="请选择文件类型" style="width: 420px">
        <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="公司名称" style="width: 420px">
      <el-input v-model="companyname" prefix-icon="Document" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item label="产品中文名称" style="width: 420px">
      <el-input v-model="productchinesename" prefix-icon="Document" placeholder="请输入产品中文名称"></el-input>
    </el-form-item>
    <el-form-item label="产品英文名称" style="width: 420px">
      <el-input v-model="productenglishname" prefix-icon="Document" placeholder="请输入产品英文名称"></el-input>
    </el-form-item>
<!--    <el-form-item label="商标" style="width: 420px">-->
<!--      <el-input v-model="trademark" prefix-icon="Notification" placeholder="请输入商标"></el-input>-->
<!--    </el-form-item>-->
    <el-form-item label="办理日期">
      <el-date-picker v-model="applicationdate" type="date" placeholder="请选择办理日期" style="width: 420px"></el-date-picker>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 50px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "ComplianceTestingAdd",
  data(){
    return{
      applicationid:'',
      filetype:'',
      types:[
        {
          label: 'ISO Certification',
          value: 'ISO Certification'
        },
        {
          label: 'Safety Compliance',
          value: 'Safety Compliance'
        },
        {
          label: 'Quality Assurance',
          value: 'Quality Assurance'
        }
      ],
      companyname:'',
      productchinesename:'',
      productenglishname:'',
      trademark:'',
      applicationdate:''
    }
  },
  methods:{
    close(){
      this.$router.push({
        path:'/compliancetesting'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Complianceapplication/add",{
        applicationid:this.applicationid,
        filetype:this.filetype,
        companyname:this.companyname,
        productchinesename:this.productchinesename,
        productenglishname:this.productenglishname,
        trademark:this.trademark,
        applicationdate:this.applicationdate
      })
      this.$router.push({
        path:'/compliancetesting'
      })
    }
  }
}
</script>

<style scoped>

</style>