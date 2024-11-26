<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="缴税号" style="width: 420px">
      <el-input v-model="taxpaymentid" prefix-icon="Postcard" placeholder="请输入缴税号"></el-input>
    </el-form-item>
    <el-form-item label="国家" style="width: 420px">
      <el-input v-model="country" prefix-icon="Compass" placeholder="请输入国家"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" style="width: 872px">
      <el-input v-model="companyname" prefix-icon="Document" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item label="VAT税号" style="width: 420px">
      <el-input v-model="vatnumber" prefix-icon="Postcard" placeholder="请输入税号"></el-input>
    </el-form-item>
    <el-form-item label="申报类型" style="width: 420px">
      <el-select v-model="declarationtype" suffix-icon="CopyDocument" clearable placeholder="请选择申报类型" style="width: 420px">
        <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="应缴税金" style="width: 420px">
      <el-input v-model="amountdue" prefix-icon="Money" placeholder="请输入应缴税金"></el-input>
    </el-form-item>
    <el-form-item label="货币种类" style="width: 420px">
      <el-input v-model="currency" prefix-icon="Coin" placeholder="请输入货币种类"></el-input>
    </el-form-item>
    <el-form-item label="申报周期" style="width: 420px">
      <el-input v-model="declarationcycle" prefix-icon="DCaret" placeholder="请输入申报周期"></el-input>
    </el-form-item>
    <el-form-item label="申报期间">
      <el-date-picker v-model="declarationperiod" type="date" placeholder="请选择申报期间" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="税金截止到账时间">
      <el-date-picker v-model="duedate" type="date" placeholder="请选择税金截止到账时间" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="缴税状态" style="width: 420px">
      <el-select v-model="paymentstatus" suffix-icon="Switch" clearable placeholder="请选择缴税状态" style="width: 420px">
        <el-option v-for="item in status" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 50px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "taxpaymentadd",
  data(){
    return{
      taxpaymentid:'',
      companyname:'',
      country:'',
      vatnumber: '',
      declarationtype:'',
      types:[
        {
          label: 'Monthly',
          value: 'Monthly'
        },
        {
          label: 'Quarterly',
          value: 'Quarterly'
        },
        {
          label: 'Yearly',
          value: 'Yearly'
        }
      ],
      amountdue:'',
      currency:'',
      declarationcycle:'',
      declarationperiod:'',
      duedate:'',
      paymentstatus:'',
      status:[
        {
          label: '1',
          value: '1'
        },
        {
          label: '2',
          value: '2'
        }
      ]
    }
  },
  methods:{
    close(){
      this.$router.push({
        path:'/taxpayment'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Taxpayment/add",{
        taxpaymentid:this.taxpaymentid,
        country:this.country,
        companyname:this.companyname,
        vatnumber:this.vatnumber,
        declarationtype:this.declarationtype,
        amountdue:this.amountdue,
        currency:this.currency,
        declarationcycle:this.declarationcycle,
        declarationperiod:this.declarationperiod,
        duedate:this.duedate,
        paymentstatus:this.paymentstatus
      }).then((res)=>{
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
      this.$router.push({
        path:'/taxpayment'
      })
    }
  }
}
</script>

<style scoped>

</style>