<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="退税号" style="width: 420px">
      <el-input v-model="taxrefundid" prefix-icon="Postcard" placeholder="请输入退税号"></el-input>
    </el-form-item>
    <el-form-item label="国家" style="width: 420px">
      <el-input v-model="country" prefix-icon="Compass" placeholder="请输入国家"></el-input>
    </el-form-item>
    <el-form-item label="VAT税号" style="width: 420px">
      <el-input v-model="vatnumber" prefix-icon="Postcard" placeholder="请输入VAT税号"></el-input>
    </el-form-item>
    <el-form-item label="申报类型" style="width: 420px">
      <el-select v-model="declarationtype" suffix-icon="CopyDocument" clearable placeholder="请选择申报类型" style="width: 420px">
        <el-option v-for="item in types" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="申报周期" style="width: 420px">
      <el-input v-model="declarationcycle" prefix-icon="DCaret" placeholder="请输入申报周期"></el-input>
    </el-form-item>
    <el-form-item label="申报时间" style="width: 420px">
      <el-date-picker v-model="declarationdate" type="date" placeholder="请选择申报时间" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="应退税金" style="width: 420px">
      <el-input v-model="refundamount" prefix-icon="Money" placeholder="请输入应退税金"></el-input>
    </el-form-item>
    <el-form-item label="退税状态" style="width: 420px">
      <el-select v-model="operation" suffix-icon="Switch" clearable placeholder="请选择退税状态" style="width: 420px">
        <el-option v-for="item in operations" :key="item.value" :label="item.label" :value="item.value"></el-option>
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
  name: "TaxRefundAdd",
  data(){
    return{
      taxrefundid:'',
      country:'',
      vatnumber:'',
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
      declarationcycle:'',
      declarationdate:'',
      refundamount:'',
      operation:'',
      operations:[
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
        path:'/taxrefund'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Taxrefund/add",{
        taxrefundid:this.taxrefundid,
        country:this.country,
        vatnumber:this.vatnumber,
        declarationtype:this.declarationtype,
        declarationcycle:this.declarationcycle,
        declarationdate:this.declarationdate,
        refundamount:this.refundamount,
        operation:this.operation
      }).then((res)=>{
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
      this.$router.push({
        path:'/taxrefund'
      })
    }
  }
}
</script>

<style scoped>

</style>