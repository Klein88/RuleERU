<template>
  <el-form :inline="true" label-position="top" :model="form">
    <el-form-item label="产品编号" prop="productid" style="width: 420px">
      <el-input v-model="form.productid" prefix-icon="Postcard" placeholder="请输入产品编号"></el-input>
    </el-form-item>
    <el-form-item label="公司编号" prop="companyid" style="width: 420px">
      <el-input v-model="form.companyid" prefix-icon="Postcard" placeholder="请输入公司编号"></el-input>
    </el-form-item>
    <el-form-item label="产品名称" prop="productname" style="width: 420px">
      <el-input v-model="form.productname" prefix-icon="Document" placeholder="请输入产品名称"></el-input>
    </el-form-item>
    <el-form-item label="产品价格" prop="productprice" style="width: 420px">
      <el-input v-model="form.productprice" prefix-icon="Money" placeholder="请输入产品价格"></el-input>
    </el-form-item>
    <el-form-item label="产品描述" prop="productdescription" style="width: 872px">
      <el-input v-model="form.productdescription" :autosize="{minRows:2}" type="textarea" placeholder="请输入产品描述"></el-input>
    </el-form-item>
    <el-form-item label="产品类别" prop="productcategory" style="width: 420px">
      <el-select v-model="form.productcategory" suffix-icon="CopyDocument" clearable placeholder="请选择产品类别" style="width: 420px">
        <el-option v-for="item in category" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="生产地区" prop="productorigin" style="width: 420px">
      <el-select v-model="form.productorigin" suffix-icon="Location" clearable placeholder="请选择生产地区" style="width: 420px">
        <el-option v-for="item in origin" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="使用日期" style="width: 872px">
      <el-date-picker v-model="form.manufacturedate" type="date" placeholder="请选择生产日期" style="width: 385px"></el-date-picker>
      <span style="width: 102px; text-align: center">-</span>
      <el-date-picker v-model="form.expirydate" type="date" placeholder="请选择到期日期" style="width: 385px"></el-date-picker>
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
  name: "productsupdate",
  data(){
    return{
      form:{
        productid:'',
        companyid:'',
        productname:'',
        productdescription:'',
        productprice:'',
        productcategory:'',
        productorigin:'',
        manufacturedate:'',
        expirydate:''
      },
      category:[
        {
          label:'家电',
          value:'家电'
        },
        {
          label: '家具',
          value: '家具'
        },
        {
          label: '汽车',
          value: '汽车'
        },
        {
          label: '个人电子产品',
          value: '个人电子产品'
        },
        {
          label: '食品和饮料',
          value: '食品和饮料'
        },
        {
          label: '个人护理产品',
          value: '个人护理产品'
        },
        {
          label: '家用清洁剂',
          value: '家用清洁剂'
        },
        {
          label: '纸制品',
          value: '纸制品'
        }
      ],
      origin:[
        {
          label:'英国',
          value:'英国'
        },
        {
          label: '法国',
          value: '法国'
        },
        {
          label: '德国',
          value: '德国'
        },
        {
          label: '意大利',
          value: '意大利'
        },
        {
          label: '西班牙',
          value: '西班牙'
        },
        {
          label: '波兰',
          value: '波兰'
        },
        {
          label: '捷克',
          value: '捷克'
        },
        {
          label: '荷兰',
          value: '荷兰'
        },
        {
          label: '奥地利',
          value: '奥地利'
        },
        {
          label: '沙特',
          value: '沙特'
        },
        {
          label: '阿联酋',
          value: '阿联酋'
        },
        {
          label: '欧盟',
          value: '欧盟'
        },
        {
          label: '日本',
          value: '日本'
        },
        {
          label: '美国',
          value: '美国'
        },
        {
          label: '比利时',
          value: '比利时'
        },
        {
          label: '瑞典',
          value: '瑞典'
        },
        {
          label: '爱尔兰',
          value: '爱尔兰'
        },
        {
          label: '埃及',
          value: '埃及'
        },
        {
          label: '瑞士',
          value: '瑞士'
        },
        {
          label: '墨西哥',
          value: '墨西哥'
        },
        {
          label: '澳大利亚',
          value: '澳大利亚'
        },
        {
          label: '全球',
          value: '全球'
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
        path:'/products'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Products/update",{
        productid:this.form.productid,
        companyid:this.form.companyid,
        productname:this.form.productname,
        productdescription:this.form.productdescription,
        productprice:this.form.productprice,
        productcategory:this.form.productcategory,
        productorigin:this.form.productorigin,
        manufacturedate:this.form.manufacturedate,
        expirydate:this.form.expirydate
      })
      this.form={}
      this.$router.push({
        path:'/products'
      })
    }
  }
}
</script>

<style scoped>

</style>