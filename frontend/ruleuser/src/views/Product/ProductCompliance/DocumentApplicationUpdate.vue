<template>
  <div style="margin-top: 10px">
    <el-text style="display: flex; justify-content: center; font-size: 25px; font-weight: bold">文件申请信息</el-text>
  </div>
  <el-form :inline="true" label-position="top" style="margin-top: 30px">
    <el-form-item label="编号" style="width: 420px">
      <el-input v-model="declarationid" prefix-icon="Postcard" placeholder="请输入编号"></el-input>
    </el-form-item>
    <el-form-item label="制造商名称" style="width: 420px">
      <el-input v-model="manufacturername" prefix-icon="Document" placeholder="请输入制造商名称"></el-input>
    </el-form-item>
    <el-form-item label="公司地址" style="width: 420px">
      <el-input v-model="businessaddress" prefix-icon="LocationInformation" placeholder="请输入公司地址"></el-input>
    </el-form-item>
    <el-form-item label="授权代表" style="width: 420px">
      <el-input v-model="authorizedrepresentative" prefix-icon="User" placeholder="请输入授权代表"></el-input>
    </el-form-item>
    <el-form-item label="产品序列号" style="width: 420px">
      <el-input v-model="productserialnumber" prefix-icon="Postcard" placeholder="请输入产品序列号"></el-input>
    </el-form-item>
    <el-form-item label="型号或类型标识" style="width: 420px">
      <el-input v-model="modelortypeidentification" prefix-icon="CopyDocument" placeholder="请输入型号或类型标识"></el-input>
    </el-form-item>
    <el-form-item label="责任声明" style="width: 872px">
      <el-input v-model="responsibilitystatement" prefix-icon="DocumentCopy" placeholder="请输入责任声明"></el-input>
    </el-form-item>
    <el-form-item label="产品识别手段" style="width: 872px">
      <el-input v-model="productidentification" prefix-icon="DocumentCopy" placeholder="请输入产品识别手段"></el-input>
    </el-form-item>
    <el-form-item label="指定机构的详细信息" style="width: 872px">
      <el-input v-model="notifiedbodydetails" prefix-icon="DocumentCopy" placeholder="请输入指定机构的详细信息"></el-input>
    </el-form-item>
    <el-form-item label="遵守的相关法律和标准" style="width: 872px">
      <el-input v-model="legislationandstandards" prefix-icon="DocumentCopy" placeholder="请输入遵守的相关法律和标准"></el-input>
    </el-form-item>
    <el-form-item label="签名者姓名" style="width: 420px">
      <el-input v-model="signatoryname" prefix-icon="User" placeholder="请输入签名者姓名"></el-input>
    </el-form-item>
    <el-form-item label="签名" style="width: 900px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload1" v-model="signatorysignature">
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
    <el-form-item label="声明签发日期">
      <el-date-picker v-model="declarationdate" type="date" placeholder="请输入声明签发日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="补充信息" style="width: 872px">
      <el-input v-model="supplementaryinformation" prefix-icon="DocumentCopy" placeholder="请输入补充信息"></el-input>
    </el-form-item>
    <el-form-item label="进口商责任" style="width: 872px">
      <el-input v-model="importerresponsibility" prefix-icon="DocumentCopy" placeholder="请输入进口商责任"></el-input>
    </el-form-item>
    <el-form-item label="翻译要求" style="width: 872px">
      <el-input v-model="translationrequirement" prefix-icon="DocumentCopy" placeholder="请输入翻译要求"></el-input>
    </el-form-item>
    <el-form-item label="产品图片" style="width: 872px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload2" v-model="productimage">
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
    <el-form-item label="申请号" style="width: 420px">
      <el-input v-model="applicationid" prefix-icon="Postcard" placeholder="请输入申请号"></el-input>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 50px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
import {ref} from "vue";

export default {
  name: "DocumentApplicationUpdate",
  data(){
    return{
      declarationid:'',
      manufacturername:'',
      businessaddress:'',
      authorizedrepresentative:'',
      productserialnumber:'',
      modelortypeidentification:'',
      responsibilitystatement:'',
      productidentification:'',
      notifiedbodydetails:'',
      legislationandstandards:'',
      signatoryname:'',
      signatorysignature:'',
      dialogImageUrl1:ref(''),
      dialogVisible1:ref(false),
      disabled1:ref(false),
      declarationdate:'',
      supplementaryinformation:'',
      importerresponsibility:'',
      translationrequirement:'',
      productimage:'',
      dialogImageUrl2:ref(''),
      dialogVisible2:ref(false),
      disabled2:ref(false),
      applicationid:''
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
    close(){
      this.$router.push({
        path:'/documentapplication'
      })
    },
    confirm(){
      this.$axios.post("http://121.40.119.233:8081/Eudeclarationofconformity/update",{
        declarationid:this.declarationid,
        manufacturername:this.manufacturername,
        businessaddress:this.businessaddress,
        authorizedrepresentative:this.authorizedrepresentative,
        productserialnumber:this.productserialnumber,
        modelortypeidentification:this.modelortypeidentification,
        responsibilitystatement:this.responsibilitystatement,
        productidentification:this.productidentification,
        notifiedbodydetails:this.notifiedbodydetails,
        legislationandstandards:this.legislationandstandards,
        signatoryname:this.signatoryname,
        signatorysignature:this.signatorysignature,
        declarationdate:this.declarationdate,
        supplementaryinformation:this.supplementaryinformation,
        importerresponsibility:this.importerresponsibility,
        translationrequirement:this.translationrequirement,
        productimage:this.productimage,
        applicationid:this.applicationid
      })
      this.$router.push({
        path:'/documentapplication'
      })
    }
  }
}
</script>

<style scoped>

</style>