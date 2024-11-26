<template>
  <div style="margin-top: 10px">
    <el-text style="display: flex; justify-content: center; font-size: 25px; font-weight: bold">公司资料</el-text>
  </div>
  <el-form :inline="true" label-position="top" style="margin-top: 30px">
    <el-form-item label="编号" style="width: 420px">
      <el-input v-model="eprdeclarationid" prefix-icon="Postcard" placeholder="请输入编号"></el-input>
    </el-form-item>
    <el-form-item label="公司注册地" style="width: 420px">
      <el-input v-model="companyregistrationlocation" prefix-icon="MapLocation" placeholder="请输入公司注册地"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" style="width: 872px">
      <el-input v-model="companyname" prefix-icon="Document" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item label="公司注册证明" style="width: 900px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload1" v-model="companyregistrationproof">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview1(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled1"
              class="el-upload-list__item-delete"
              @click="handleDownload1(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled1"
              class="el-upload-list__item-delete"
              @click="handleRemove1(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible1">
        <img w-full :src="dialogImageUrl1" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
    <el-form-item label="营业执照号码" style="width: 420px">
      <el-input v-model="businesslicensenumber" prefix-icon="Postcard" placeholder="请输入营业执照号码"></el-input>
    </el-form-item>
    <el-form-item label="公司成立日期">
      <el-date-picker v-model="companyestablishmentdate" type="date" placeholder="请选择公司成立日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="公司经营注册地址" style="width: 420px">
      <el-input v-model="companyoperationaladdress" prefix-icon="LocationInformation" placeholder="请输入公司经营注册地址"></el-input>
    </el-form-item>
    <el-form-item label="邮编" style="width: 420px">
      <el-input v-model="postalcode" prefix-icon="Place" placeholder="请输入邮编"></el-input>
    </el-form-item>
    <el-form-item label="公司联系电话" style="width: 420px">
      <el-input v-model="companyphonenumber" prefix-icon="Phone" placeholder="请输入公司联系电话"></el-input>
    </el-form-item>
    <el-form-item label="公司联系人邮箱" style="width: 420px">
      <el-input v-model="companycontactemail" prefix-icon="TakeawayBox" placeholder="请输入公司联系人邮箱"></el-input>
    </el-form-item>
    <el-form-item label="公司注册号" style="width: 420px">
      <el-input v-model="registrationnumber" prefix-icon="Postcard" placeholder="请输入公司注册号"></el-input>
    </el-form-item>
    <el-form-item label="法人代表姓名" style="width: 420px">
      <el-input v-model="legalrepresentativename" prefix-icon="Postcard" placeholder="请输入法人代表姓名"></el-input>
    </el-form-item>
    <el-form-item label="法人代表身份证(人像面)" style="width: 900px; margin-top: 20px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload2" v-model="idcardfront">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview2(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled2"
              class="el-upload-list__item-delete"
              @click="handleDownload2(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled2"
              class="el-upload-list__item-delete"
              @click="handleRemove2(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible2">
        <img w-full :src="dialogImageUrl2" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
    <el-form-item label="法人代表身份证(国徽面)" style="width: 900px; margin-top: 20px; margin-bottom: 30px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload3" v-model="idcardback">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview3(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled3"
              class="el-upload-list__item-delete"
              @click="handleDownload3(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled3"
              class="el-upload-list__item-delete"
              @click="handleRemove3(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible3">
        <img w-full :src="dialogImageUrl3" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
    <el-form-item label="法人代表签名" style="width: 900px; margin-top: 20px; margin-bottom: 30px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload4" v-model="signature">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview4(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled4"
              class="el-upload-list__item-delete"
              @click="handleDownload4(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled4"
              class="el-upload-list__item-delete"
              @click="handleRemove4(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible4">
        <img w-full :src="dialogImageUrl4" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
    <el-form-item label="主要销售平台" style="width: 900px; margin-bottom: 30px">
      <el-radio-group v-model="mainsalesplatform">
        <el-radio label="1">亚马逊</el-radio>
        <el-radio label="2">eBay</el-radio>
        <el-radio label="3">其他</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="店铺名称" style="width: 420px">
      <el-input v-model="shopname" prefix-icon="Document" placeholder="请输入店铺名称"></el-input>
    </el-form-item>
    <el-form-item label="店铺信息链接" style="width: 420px">
      <el-input v-model="informationlink" prefix-icon="Link" placeholder="请输入店铺信息链接"></el-input>
    </el-form-item>
    <el-form-item label="店铺后台卖家地址" style="width: 420px">
      <el-input v-model="shopbackendselleraddress" prefix-icon="LocationInformation" placeholder="请输入店铺后台卖家地址"></el-input>
    </el-form-item>
    <el-form-item label="店铺后台公司名称" style="width: 420px">
      <el-input v-model="shopbackendcompanyname" prefix-icon="Document" placeholder="请输入店铺后台公司名称"></el-input>
    </el-form-item>
    <el-form-item label="店铺主要经营范围" style="width: 872px">
      <el-input v-model="mainbusinessscope" prefix-icon="Operation" placeholder="请输入店铺主要经营范围"></el-input>
    </el-form-item>
    <el-form-item label="品牌数量" style="width: 420px">
      <el-input v-model="brandcount" prefix-icon="Goods" placeholder="请输入品牌数量"></el-input>
    </el-form-item>
    <el-form-item label="品牌英文名称" style="width: 420px">
      <el-input v-model="brandenglishname" prefix-icon="Document" placeholder="请输入品牌英文名称"></el-input>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 100px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
import {ref} from "vue";

export default {
  name: "EPRServiceInformation",
  data(){
    return{
      eprdeclarationid:'',
      companyregistrationlocation:'',
      companyname:'',
      companyregistrationproof:'',
      dialogImageUrl1:ref(''),
      dialogVisible1:ref(false),
      disabled1:ref(false),
      businesslicensenumber:'',
      companyestablishmentdate:'',
      companyoperationaladdress:'',
      postalcode:'',
      companyphonenumber:'',
      companycontactemail:'',
      registrationnumber:'',
      legalrepresentativename:'',
      idcardfront:'',
      dialogImageUrl2:ref(''),
      dialogVisible2:ref(false),
      disabled2:ref(false),
      idcardback:'',
      dialogImageUrl3:ref(''),
      dialogVisible3:ref(false),
      disabled3:ref(false),
      signature:'',
      dialogImageUrl4:ref(''),
      dialogVisible4:ref(false),
      disabled4:ref(false),
      mainsalesplatform:ref('1'),
      shopname:'',
      informationlink:'',
      shopbackendselleraddress:'',
      shopbackendcompanyname:'',
      mainbusinessscope:'',
      brandcount:'',
      brandenglishname:''
    }
  },
  methods:{
    handleRemove1(file) {
      this.$refs.upload1.clearFiles()
    },
    handlePictureCardPreview1(file) {
      this.dialogImageUrl1 = file.url
      this.dialogVisible1 = true
    },
    handleDownload1(file) {
      console.log(file)
    },
    handleRemove2(file) {
      this.$refs.upload2.clearFiles()
    },
    handlePictureCardPreview2(file) {
      this.dialogImageUrl2 = file.url
      this.dialogVisible2 = true
    },
    handleDownload2(file) {
      console.log(file)
    },
    handleRemove3(file) {
      this.$refs.upload3.clearFiles()
    },
    handlePictureCardPreview3(file) {
      this.dialogImageUrl3 = file.url
      this.dialogVisible3 = true
    },
    handleDownload3(file) {
      console.log(file)
    },
    handleRemove4(file) {
      this.$refs.upload4.clearFiles()
    },
    handlePictureCardPreview4(file) {
      this.dialogImageUrl4 = file.url
      this.dialogVisible4 = true
    },
    handleDownload4(file) {
      console.log(file)
    },
    close(){
      this.$router.push({
        path:'/eprservice'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Eprdeclaration1/add",{
        eprdeclarationid:this.eprdeclarationid,
        companyregistrationlocation:this.companyregistrationlocation,
        companyname:this.companyname,
        companyregistrationproof:this.companyregistrationproof,
        businesslicensenumber:this.businesslicensenumber,
        companyestablishmentdate:this.companyestablishmentdate,
        companyoperationaladdress:this.companyoperationaladdress,
        postalcode:this.postalcode,
        companyphonenumber:this.companyphonenumber,
        companycontactemail:this.companycontactemail,
        registrationnumber:this.registrationnumber,
        legalrepresentativename:this.legalrepresentativename,
        idcardfront:this.idcardfront,
        idcardback:this.idcardback,
        signature:this.signature,
        mainsalesplatform:this.mainsalesplatform,
        shopname:this.shopname,
        informationlink:this.informationlink,
        shopbackendselleraddress:this.shopbackendselleraddress,
        shopbackendcompanyname:this.shopbackendcompanyname,
        mainbusinessscope:this.mainbusinessscope,
        brandcount:this.brandcount,
        brandenglishname:this.brandenglishname
      }).then((res)=>{
        console.log(res)
      }).catch((err)=>{
        console.log(err)
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