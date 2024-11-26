<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="工单编号" prop="workorderid" style="width: 420px">
      <el-input v-model="form.workorderid" prefix-icon="Postcard" placeholder="请输入工单编号"></el-input>
    </el-form-item>
    <el-form-item label="用户编号" prop="userid" style="width: 420px">
      <el-input v-model="form.userid" prefix-icon="Postcard" placeholder="请输入用户编号"></el-input>
    </el-form-item>
    <el-form-item label="工单主题" prop="workordertheme" style="width: 872px">
      <el-input v-model="form.workordertheme" prefix-icon="Document" placeholder="请输入工单主题"></el-input>
    </el-form-item>
    <el-form-item label="工单描述" prop="description" style="width: 872px">
      <el-input v-model="form.description" :autosize="{minRows:2}" type="textarea" placeholder="请输入工单描述"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="creationdate">
      <el-date-picker v-model="form.creationdate" type="date" placeholder="请选择创建日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="工单状态" prop="status" style="width: 420px">
      <el-select v-model="form.status" suffix-icon="Switch" clearable placeholder="请选择工单状态" style="width: 420px">
        <el-option v-for="item in sta" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
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
  name: "WorkOrdersAdd",
  data(){
    return{
      form:{
        workorderid:'',
        userid:'',
        workordertheme:'',
        description:'',
        status:'',
        creationdate:''
      },
      sta:[
        {
          label: '待处理',
          value: '待处理'
        },
        {
          label: '处理中',
          value: '处理中'
        },
        {
          label: '已完成',
          value: '已完成'
        },
        {
          label: '已撤销',
          value: '已撤销'
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
        path:'/workorders'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Workorder/add",{
        workorderid:this.form.workorderid,
        userid:this.form.userid,
        workordertheme:this.form.workordertheme,
        description:this.form.description,
        status:this.form.status,
        creationdate:this.form.creationdate
      })
      this.form={}
      this.$router.push({
        path:'/workorders'
      })
    }
  }
}
</script>

<style scoped>

</style>