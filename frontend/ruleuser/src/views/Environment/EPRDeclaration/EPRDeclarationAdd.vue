<template>
  <el-form :inline="true" label-position="top">
    <el-form-item label="编号" style="width: 420px">
      <el-input v-model="summaryid" prefix-icon="Postcard" placeholder="请输入编号"></el-input>
    </el-form-item>
    <el-form-item label="注册码" style="width: 420px">
      <el-input v-model="registrationcode" prefix-icon="Postcard" placeholder="请输入注册码"></el-input>
    </el-form-item>
    <el-form-item label="申报年份" style="width: 420px">
      <el-input v-model="declarationyear" placeholder="请选择申报年份"></el-input>
    </el-form-item>
    <el-form-item label="申报数据序号" style="width: 420px">
      <el-input v-model="declarationdataserialnumber" prefix-icon="Postcard" placeholder="请输入申报数据序号"></el-input>
    </el-form-item>
    <el-form-item label="品牌名称" style="width: 872px">
      <el-input v-model="brandname" prefix-icon="Document" placeholder="请输入品牌名称"></el-input>
    </el-form-item>
    <el-form-item label="包装材料">
      <el-select v-model="packagingmaterial" suffix-icon="CopyDocument" clearable placeholder="请输入包装材料" style="width: 420px">
        <el-option v-for="item in materials" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="预申报重量" style="width: 420px">
      <el-input v-model="predeclaredweight" prefix-icon="ShoppingCart" placeholder="请输入预申报重量"></el-input>
    </el-form-item>
    <el-form-item label="实际包装重量" style="width: 420px">
      <el-input v-model="actualpackagingweight" prefix-icon="ShoppingCartFull" placeholder="请输入实际包装重量"></el-input>
    </el-form-item>
    <el-form-item label="EPR申报号" style="width: 420px">
      <el-input v-model="eprdeclarationid" prefix-icon="Postcard" placeholder="请输入EPR申报号"></el-input>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 50px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
export default {
  name: "EPRDeclarationAdd",
  data(){
    return{
      summaryid:'',
      registrationcode:'',
      declarationyear:'',
      brandname:'',
      declarationdataserialnumber:'',
      packagingmaterial:'',
      materials:[
        {
          label: 'Paper',
          value: 'Paper'
        },
        {
          label: 'Plastic',
          value: 'Plastic'
        },
        {
          label: 'Metal',
          value: 'Metal'
        },
        {
          label: 'Glass',
          value: 'Glass'
        },
        {
          label: 'Alloy',
          value: 'Alloy'
        }
      ],
      predeclaredweight:'',
      actualpackagingweight:'',
      eprdeclarationid:''
    }
  },
  methods:{
    close(){
      this.$router.push({
        path:'/eprdeclaration'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Packagingsummarydeclaration/add",{
        summaryid:this.summaryid,
        registrationcode:this.registrationcode,
        declarationyear:this.declarationyear,
        brandname:this.brandname,
        declarationdataserialnumber:this.declarationdataserialnumber,
        packagingmaterial:this.packagingmaterial,
        predeclaredweight:this.predeclaredweight,
        actualpackagingweight:this.actualpackagingweight,
        eprdeclarationid:this.eprdeclarationid
      }).then((res)=>{
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
      this.$router.push({
        path:'/eprdeclaration'
      })
    }
  }
}
</script>

<style scoped>

</style>