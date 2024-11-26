<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="用户编号" prop="userid" style="width: 420px">
      <el-input v-model="form.userid" prefix-icon="Postcard" placeholder="请输入用户编号"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" prop="companyname" style="width: 420px">
      <el-input v-model="form.companyname" prefix-icon="Document" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item label="公司类型" prop="companytype" style="width: 420px">
      <el-select v-model="form.companytype" suffix-icon="SetUp" clearable placeholder="请选择公司类型" style="width: 420px">
        <el-option v-for="item in companytype" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="公司状态" prop="companystatue" style="width: 420px">
      <el-select v-model="form.companystatue" suffix-icon="SetUp" clearable placeholder="请选择公司状态" style="width: 420px">
        <el-option v-for="item in companystatue" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="公司地址" prop="companyaddress" style="width: 872px">
      <el-input v-model="form.companyaddress" :autosize="{minRows:2}" type="textarea" placeholder="请输入公司地址"></el-input>
    </el-form-item>
    <el-form-item label="注册地址" prop="companyregister" style="width: 872px">
      <el-input v-model="form.companyregister" :autosize="{minRows:2}" type="textarea" placeholder="请输入注册地址"></el-input>
    </el-form-item>
    <el-form-item label="公司商标" prop="companyphoto" style="width: 872px">
      <el-input v-model="form.companyphoto" prefix-icon="Picture" placeholder="请输入公司商标"></el-input>
    </el-form-item>
    <el-form-item label="公司电话" prop="companytel" style="width: 420px">
      <el-input v-model="form.companytel" prefix-icon="Phone" placeholder="请输入公司电话"></el-input>
    </el-form-item>
    <el-form-item label="公司邮编" prop="companynumber" style="width: 420px">
      <el-input v-model="form.companynumber" prefix-icon="Place" placeholder="请输入公司邮编"></el-input>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px">
    <el-button type="text" icon="ArrowLeftBold" size="large" @click="back()">返回 “账户管理” 主页</el-button>
    <el-button @click="close()" icon="CaretLeft" style="margin-left: 350px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="margin-left: 50px">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "CompanyInfoUpdate",
  data(){
    return{
      form:{
        userid:'',
        companyname:'',
        companytype:'',
        companyaddress:'',
        companytel:'',
        companyregister:'',
        companyphoto:'',
        companynumber:'',
        companystatue:''
      },
      companytype:[
        {
          label:'贸易类',
          value:'贸易类'
        },
        {
          label: '科技类',
          value: '科技类'
        },
        {
          label: '文化类',
          value: '文化类'
        },
        {
          label: '广告类',
          value: '广告类'
        },
        {
          label: '传媒类',
          value: '传媒类'
        },
        {
          label: '咨询类',
          value: '咨询类'
        },
        {
          label: '管理类',
          value: '管理类'
        }
      ],
      companystatue:[
        {
          label: '正常状态',
          value: '正常状态'
        },
        {
          label: '异常状态',
          value: '异常状态'
        },
        {
          label: '注销状态',
          value: '注销状态'
        }
      ]
    }
  },
  methods:{
    back(){
      this.form={}
      this.$router.push({
        path:'/staging'
      })
    },
    close(){
      this.form={}
      this.$router.push({
        path:'/companyinfo'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Companyinfo/update",{
        userid:this.form.userid,
        companyname:this.form.companyname,
        companytype:this.form.companytype,
        companyaddress:this.form.companyaddress,
        companytel:this.form.companytel,
        companyregister:this.form.companyregister,
        companyphoto:this.form.companyphoto,
        companynumber:this.form.companynumber,
        companystatue:this.form.companystatue
      })
      this.form={}
      this.$router.push({
        path:'/companyinfo'
      })
    }
  }
}
</script>

<style scoped>

</style>