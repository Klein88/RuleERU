<template>
  <el-form label-position="top">
    <el-form-item v-show="showdata" class="questionnaireStyle">
      <el-text style="font-size: 15px">数据处理行为是否涉及个人数据</el-text>
      <el-radio-group v-model="involvingpersonaldata" @change="datachange($event)" style="margin-left: 100px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item v-show="showestablishment" class="questionnaireStyle">
      <el-text style="font-size: 15px">数据控制者和数据处理者在欧盟境内是否有营业活动</el-text>
      <el-radio-group v-model="establishment" @change="establishmentchange($event)" style="margin-left: 100px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item v-show="showinextricablylinked" class="questionnaireStyle">
      <el-text style="font-size: 15px">数据处理活动是否与欧盟境内的营业活动具有不可分离的联系</el-text>
      <el-radio-group v-model="inextricablylinked" @change="inextricablylinkedchange($event)" style="margin-left: 100px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item v-show="showtargeting" class="questionnaireStyle">
      <el-text style="font-size: 15px">数据处理活动是否针对欧盟境内主体</el-text>
      <el-radio-group v-model="targeting" @change="targetingchange($event)" style="margin-left: 100px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item v-show="showmonitor" class="questionnaireStyle">
      <el-text style="font-size: 15px">数据处理活动是否与针对欧盟境内主体提供商品服务或监控有关</el-text>
      <el-radio-group v-model="monitor" @change="monitorchange($event)" style="margin-left: 100px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item v-show="showlaw" class="questionnaireStyle">
      <el-text style="font-size: 15px">数据处理活动是否基于国际公法而适用欧盟成员国法律</el-text>
      <el-radio-group v-model="law" @change="lawchange($event)" style="margin-left: 100px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 50px">
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "QuestionnaireInvestigation",
  data(){
    return{
      showdata:true,
      involvingpersonaldata:'',
      showestablishment:false,
      establishment:'',
      showinextricablylinked:false,
      inextricablylinked:'',
      showtargeting:false,
      targeting:'',
      showmonitor:false,
      monitor:'',
      showlaw:false,
      law:''
    }
  },
  methods:{
    datachange(e){
      if (e == 1){
        this.showestablishment = true
      } else {
        this.showestablishment = false
        this.showinextricablylinked = false
        this.showtargeting = false
        this.showmonitor = false
        this.showlaw = false
        this.$message({
          message:"不落入GDPR第三条地域管辖",
          type:"warning"
        })
      }
    },
    establishmentchange(e){
      if (e == 1){
        this.showinextricablylinked = true
        this.showtargeting = false
        this.showmonitor = false
        this.showlaw = false
      } else {
        this.showinextricablylinked = false
        this.showtargeting = true
      }
    },
    inextricablylinkedchange(e){
      if (e == 1){
        this.$message({
          message:"落入GDPR管辖",
          type:"success"
        })
      } else {
        this.$message({
          message:"不落入GDPR第三条地域管辖",
          type:"warning"
        })
      }
    },
    targetingchange(e){
      if (e == 1){
        this.showmonitor = true
        this.showlaw = false
      } else {
        this.showmonitor = false
        this.showlaw = true
      }
    },
    monitorchange(e){
      if (e == 1){
        this.$message({
          message:"落入GDPR管辖",
          type:"success"
        })
      } else {
        this.$message({
          message:"不落入GDPR第三条地域管辖",
          type:"warning"
        })
      }
    },
    lawchange(e){
      if (e == 1){
        this.$message({
          message:"落入GDPR管辖",
          type:"success"
        })
      } else {
        this.$message({
          message:"不落入GDPR第三条地域管辖",
          type:"warning"
        })
      }
    }
  }
}
</script>

<style>
.questionnaireStyle{
  background: #fff;
  border: 2px solid #e8e8e8;
  border-radius: 5px;
  text-align: left;
  padding: 20px;
}
</style>