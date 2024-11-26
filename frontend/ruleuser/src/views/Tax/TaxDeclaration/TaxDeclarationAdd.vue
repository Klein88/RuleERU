<template>
  <div style="margin-top: 10px">
    <el-text style="display: flex; justify-content: center; font-size: 25px; font-weight: bold">VAT转代理服务资料</el-text>
  </div>
  <div style="margin-top: 30px">
    <el-text style="font-size: 20px">VAT信息</el-text>
  </div>
  <el-form :inline="true" label-position="top" style="margin-top: 20px">
    <el-form-item label="VAT税号" style="width: 420px;">
      <el-input v-model="vatnumber" prefix-icon="Postcard" placeholder="请输入VAT税号"></el-input>
    </el-form-item>
    <el-form-item label="税率" style="width: 420px;">
      <el-select v-model="taxrate" suffix-icon="Discount" clearable placeholder="请选择税率" style="width: 420px">
        <el-option v-for="item in taxrates" :key="item.value" :label="item.label" :value="item.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="税号生效日期">
      <el-date-picker v-model="taxnumbereffectivedate" type="date" placeholder="请选择税号生效日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="申报截止日期">
      <el-date-picker v-model="lastdeclarationdate" type="date" placeholder="请选择申报截止日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="Gateway ID" style="width: 420px">
      <el-input v-model="gatewayid" prefix-icon="Postcard" placeholder="请输入Gateway ID"></el-input>
    </el-form-item>
    <el-form-item label="Gateway Password" style="width: 420px">
      <el-input v-model="gatewaypassword" prefix-icon="Postcard" placeholder="请输入Gateway Password"></el-input>
    </el-form-item>
    <el-form-item label="最后一次申报日期">
      <el-date-picker v-model="lastreporteddate" type="date" placeholder="请选择最后一次申报日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="是否已有MTD账号">
      <el-radio-group v-model="radio" style="width: 420px">
        <el-radio label="1">是</el-radio>
        <el-radio label="2">否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="MTD账号" style="width: 420px">
      <el-input v-model="mtdusername" prefix-icon="Postcard" placeholder="请输入MTD账号"></el-input>
    </el-form-item>
    <el-form-item label="MTD账号密码" style="width: 420px">
      <el-input v-model="mtdpassword" prefix-icon="Postcard" placeholder="请输入MTD账号密码"></el-input>
    </el-form-item>
    <el-form-item label="VAT税号证书" style="width: 900px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload1" v-model="vatcertificate">
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
    <el-form-item label="最近三次VAT申报(最少上传一份)" style="width: 900px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload2" v-model="vatdeclarationdocument">
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
    <el-form-item label="转代理承诺书" style="width: 900px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload3" v-model="proxycommitmentdocument">
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
  </el-form>
  <div style="margin-top: 50px">
    <el-text style="font-size: 20px">公司信息</el-text>
  </div>
  <el-form :inline="true" label-position="top" style="margin-top: 20px">
    <el-form-item label="选择公司注册地" style="width: 900px; margin-bottom: 30px">
      <el-radio-group v-model="companyregistrationlocation">
        <el-radio label="1">大陆公司</el-radio>
        <el-radio label="2">港台公司</el-radio>
        <el-radio label="3">其他公司</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-text style="font-size: 16px; width: 900px">填写公司名称并上传公司指定文件</el-text>
    <el-form-item label="公司名称" style="margin-top: 20px; width: 872px">
      <el-input v-model="companyname" prefix-icon="Document" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item label="上传营业执照 / 公司注册证明" style="width: 900px; margin-bottom: 30px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload4" v-model="companyregistrationproof">
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
    <el-text style="font-size: 16px; width: 900px">填写公司营业信息</el-text>
    <el-form-item label="营业执照号码" style="margin-top: 20px; width: 420px">
      <el-input v-model="businesslicensenumber" prefix-icon="Postcard" placeholder="请输入营业执照号码"></el-input>
    </el-form-item>
    <el-form-item label="公司成立日期" style="margin-top: 20px">
      <el-date-picker v-model="companyestablishmentdate" type="date" placeholder="请输入公司成立日期" style="width: 420px"></el-date-picker>
    </el-form-item>
    <el-form-item label="公司经营注册地址及邮编" style="margin-top: 20px; width: 420px">
      <el-input v-model="companyoperationaladdress" prefix-icon="MapLocation" placeholder="请输入公司经营注册地址" style="width: 295px"></el-input>
      <el-input v-model="postalcode" prefix-icon="Place" placeholder="请输入邮编" style="width: 120px; margin-left: 5px"></el-input>
    </el-form-item>
    <el-form-item label="公司联系电话及邮箱" style="margin-top: 20px; width: 420px">
      <el-input v-model="companyphonenumber" prefix-icon="Phone" placeholder="请输入公司联系电话" style="width: 200px"></el-input>
      <el-input v-model="companycontactemail" prefix-icon="TakeawayBox" placeholder="请输入公司联系邮箱" style="width: 200px; margin-left: 20px"></el-input>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; margin-bottom: 30px">
    <el-text style="font-size: 20px">法人代表信息</el-text>
  </div>
  <el-text style="font-size: 16px">上传法人代表证件信息</el-text>
  <el-form label-position="top">
    <el-form-item label="法人代表身份证(人像面)" style="width: 900px; margin-top: 20px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload5" v-model="idcardfront">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview5(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled5"
              class="el-upload-list__item-delete"
              @click="handleDownload5(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled5"
              class="el-upload-list__item-delete"
              @click="handleRemove5(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible5">
        <img w-full :src="dialogImageUrl5" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
    <el-form-item label="法人代表身份证(国徽面)" style="width: 900px; margin-top: 20px; margin-bottom: 30px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload6" v-model="idcardback">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview6(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled6"
              class="el-upload-list__item-delete"
              @click="handleDownload6(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled6"
              class="el-upload-list__item-delete"
              @click="handleRemove6(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible6">
        <img w-full :src="dialogImageUrl6" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
    <el-text style="font-size: 16px">填写法人代表信息</el-text>
    <el-form-item label="法人代表中文名" style="margin-top: 20px; width: 872px">
      <el-input v-model="legalrepresentativename" prefix-icon="Postcard" placeholder="请输入法人代表中文名"></el-input>
    </el-form-item>
    <el-form-item label="法人代表签名" style="width: 900px; margin-top: 20px; margin-bottom: 30px">
      <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload7" v-model="signature">
        <el-icon><Plus /></el-icon>
        <template #file="{ file }">
          <div>
            <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
            <span class="el-upload-list__item-actions">
          <span
              class="el-upload-list__item-preview"
              @click="handlePictureCardPreview7(file)"
          >
            <el-icon><zoom-in /></el-icon>
          </span>
          <span
              v-if="!disabled7"
              class="el-upload-list__item-delete"
              @click="handleDownload7(file)"
          >
            <el-icon><Download /></el-icon>
          </span>
          <span
              v-if="!disabled7"
              class="el-upload-list__item-delete"
              @click="handleRemove7(file)"
          >
            <el-icon><Delete /></el-icon>
          </span>
        </span>
          </div>
        </template>
      </el-upload>
      <el-dialog v-model="dialogVisible7">
        <img w-full :src="dialogImageUrl7" alt="Preview Image" />
      </el-dialog>
    </el-form-item>
  </el-form>
  <div style="margin-top: 50px; margin-bottom: 30px">
    <el-text style="font-size: 20px">店铺信息</el-text>
  </div>
  <el-text style="font-size: 16px">填写店铺信息</el-text>
  <el-form :inline="true" label-position="top" style="margin-top: 20px">
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
  </el-form>
  <div style="margin-top: 50px; display: flex; justify-content: right; margin-right: 100px">
    <el-button @click="close()" icon="CaretLeft" style="margin-right: 50px">取消并返回上一页</el-button>
    <el-button type="primary" @click="confirm()" style="width: 100px">确定</el-button>
  </div>
</template>

<script>
import {ref, toRaw} from "vue";

export default {
  name: "taxeeclarationadd",
  data(){
    return{
      vatnumber:'',
      taxrate:'',
      taxrates:[
        {
          label: '22',
          value: '22'
        },
        {
          label: '21',
          value: '21'
        },
        {
          label: '20',
          value: '20'
        },
        {
          label: '19',
          value: '19'
        },
        {
          label: '10',
          value: '10'
        },
        {
          label: '7',
          value: '7'
        },
        {
          label: '5',
          value: '5'
        },
        {
          label: '4',
          value: '4'
        },
        {
          label: '0',
          value: '0'
        }
      ],
      taxnumbereffectivedate:'',
      lastdeclarationdate:'',
      gatewayid:'',
      gatewaypassword:'',
      lastreporteddate:'',
      radio:ref('1'),
      mtdusername:'',
      mtdpassword:'',
      vatcertificate:'',
      dialogImageUrl1:ref(''),
      dialogVisible1:ref(false),
      disabled1:ref(false),
      vatdeclarationdocument:'',
      dialogImageUrl2:ref(''),
      dialogVisible2:ref(false),
      disabled2:ref(false),
      proxycommitmentdocument:'',
      dialogImageUrl3:ref(''),
      dialogVisible3:ref(false),
      disabled3:ref(false),
      companyregistrationlocation:ref('1'),
      companyname:'',
      companyregistrationproof:'',
      dialogImageUrl4:ref(''),
      dialogVisible4:ref(false),
      disabled4:ref(false),
      businesslicensenumber:'',
      companyestablishmentdate:'',
      companyoperationaladdress:'',
      postalcode:'',
      companyphonenumber:'',
      companycontactemail:'',
      idcardfront:'',
      dialogImageUrl5:ref(''),
      dialogVisible5:ref(false),
      disabled5:ref(false),
      idcardback:'',
      dialogImageUrl6:ref(''),
      dialogVisible6:ref(false),
      disabled6:ref(false),
      legalrepresentativename:'',
      signature:'',
      dialogImageUrl7:ref(''),
      dialogVisible7:ref(false),
      disabled7:ref(false),
      mainsalesplatform:ref('1'),
      shopname:'',
      informationlink:'',
      shopbackendselleraddress:'',
      shopbackendcompanyname:'',
      mainbusinessscope:''
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
    handleRemove5(file) {
      this.$refs.upload5.clearFiles()
    },
    handlePictureCardPreview5(file) {
      this.dialogImageUrl5 = file.url
      this.dialogVisible5 = true
    },
    handleDownload5(file) {
      console.log(file)
    },
    handleRemove6(file) {
      this.$refs.upload6.clearFiles()
    },
    handlePictureCardPreview6(file) {
      this.dialogImageUrl6 = file.url
      this.dialogVisible6 = true
    },
    handleDownload6(file) {
      console.log(file)
    },
    handleRemove7(file) {
      this.$refs.upload7.clearFiles()
    },
    handlePictureCardPreview7(file) {
      this.dialogImageUrl7 = file.url
      this.dialogVisible7 = true
    },
    handleDownload7(file) {
      console.log(file)
    },
    close(){
      this.$router.push({
        path:'/taxservice'
      })
    },
    // confirm(){
    //   this.$axios.get("http://121.40.119.233:8081/vat-check/lookup/"+this.vatnumber,{timeout:10000}).then((res)=>{
    //     this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
    //       text:this.companyname
    //     },{timeout:600000}).then((res)=>{
    //       if (res.data.isClean == true){
    //         this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
    //           text:this.legalrepresentativename
    //         },{timeout:600000}).then((res)=>{
    //           if (res.data.isClean == true){
    //             this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
    //               text:this.shopname
    //             },{timeout:2000000}).then((res)=>{
    //               if (res.data.isClean == true){
    //                 this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
    //                   text:this.shopbackendcompanyname
    //                 },{timeout:8000000}).then((res)=>{
    //                   if (res.data.isClean == true){
    //                     this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
    //                       text:this.mainbusinessscope
    //                     },{timeout:12000000}).then((res)=>{
    //                       if (res.data.isClean == true){
    //                         this.$axios.post("http://121.40.119.233:8081/Taxdeclaration/add",{
    //                           vatnumber:this.vatnumber,
    //                           taxrate:this.taxrate,
    //                           taxnumbereffectivedate:this.taxnumbereffectivedate,
    //                           lastdeclarationdate:this.lastdeclarationdate,
    //                           gatewayid:this.gatewayid,
    //                           gatewaypassword:this.gatewaypassword,
    //                           lastreporteddate:this.lastreporteddate,
    //                           mtdusername:this.mtdusername,
    //                           mtdpassword:this.mtdpassword,
    //                           vatcertificate:this.vatcertificate,
    //                           vatdeclarationdocument:this.vatdeclarationdocument,
    //                           proxycommitmentdocument:this.proxycommitmentdocument,
    //                           companyregistrationlocation:this.companyregistrationlocation,
    //                           companyname:this.companyname,
    //                           companyregistrationproof:this.companyregistrationproof,
    //                           businesslicensenumber:this.businesslicensenumber,
    //                           companyestablishmentdate:this.companyestablishmentdate,
    //                           companyoperationaladdress:this.companyoperationaladdress,
    //                           postalcode:this.postalcode,
    //                           companyphonenumber:this.companyphonenumber,
    //                           companycontactemail:this.companycontactemail,
    //                           idcardfront:this.idcardfront,
    //                           idcardback:this.idcardback,
    //                           legalrepresentativename:this.legalrepresentativename,
    //                           signature:this.signature,
    //                           mainsalesplatform:this.mainsalesplatform,
    //                           shopname:this.shopname,
    //                           informationlink:this.informationlink,
    //                           shopbackendselleraddress:this.shopbackendselleraddress,
    //                           shopbackendcompanyname:this.shopbackendcompanyname,
    //                           mainbusinessscope:this.mainbusinessscope
    //                         },{timeout:600000}).then((res)=>{
    //                           console.log(res)
    //                         }).catch((err)=>{
    //                           console.log(err)
    //                         })
    //                         this.$router.push({
    //                           path:'/taxdeclaration'
    //                         })
    //                       } else {
    //                         this.$message({
    //                           message:"请输入正确的店铺主要经营范围",
    //                           type:"warning"
    //                         })
    //                       }
    //                     })
    //                   } else {
    //                     this.$message({
    //                       message:"请输入正确的店铺后台公司名称",
    //                       type:"warning"
    //                     })
    //                   }
    //                 })
    //               } else {
    //                 this.$message({
    //                   message:"请输入正确的店铺名称",
    //                   type:"warning"
    //                 })
    //               }
    //             })
    //           } else {
    //             this.$message({
    //               message:"请输入正确的法人代表姓名",
    //               type:"warning"
    //             })
    //           }
    //         })
    //       } else {
    //         this.$message({
    //           message:"请输入正确的公司名称",
    //           type:"warning"
    //         })
    //       }
    //     })
    //   }).catch((err)=>{
    //     this.$message({
    //       message:"请输入正确的VAT税号",
    //       type:"warning"
    //     })
    //     console.log(err)
    //   })
    // }
    async confirm(){
      let k = true;
      this.$axios.get("http://121.40.119.233:8081/vat-check/lookup/"+this.vatnumber).then((res)=>{
        console.log(res)
      }).catch((err)=>{
        this.$message({
          message:"请输入正确的VAT税号",
          type:"warning"
        })
        k = false
      })
      await this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
        text:this.companyname
      },{timeout:600000}).then((res)=>{
        if (res.data.isClean == false){
          this.$message({
            message:"请输入正确的公司名称",
            type:"warning"
          })
          k = false
        }
      })
      // await this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
      //   text:this.legalrepresentativename
      // },{timeout:600000}).then((res)=>{
      //   if (res.data.isClean == false){
      //     this.$message({
      //       message:"请输入正确的法人代表姓名",
      //       type:"warning"
      //     })
      //     k = false
      //   }
      // })
      await this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
        text:this.shopname
      },{timeout:1200000}).then((res)=>{
        if (res.data.isClean == false){
          this.$message({
            message:"请输入正确的店铺名称",
            type:"warning"
          })
          k = false
        }
      }).catch((err)=>{
        console.log(err)
      })
      // await this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
      //   text:this.shopbackendcompanyname
      // },{timeout:2400000}).then((res)=>{
      //   if (res.data.isClean == false){
      //     this.$message({
      //       message:"请输入正确的店铺后台公司名称",
      //       type:"warning"
      //     })
      //     k = false
      //   }
      // }).catch((err)=>{
      //   console.log(err)
      // })
      // await this.$axios.post("http://121.40.119.233:8081/baicucheck_content",{
      //   text:this.mainbusinessscope
      // },{timeout:2400000}).then((res)=>{
      //   if (res.data.isClean == false){
      //     this.$message({
      //       message:"请输入正确的店铺主要经营范围",
      //       type:"warning"
      //     })
      //     k = false
      //   }
      // }).catch((err)=>{
      //   console.log(err)
      // })
      if (k == true){
        await this.$axios.post("http://121.40.119.233:8081/Taxdeclaration/add",{
          vatnumber:this.vatnumber,
          taxrate:this.taxrate,
          taxnumbereffectivedate:this.taxnumbereffectivedate,
          lastdeclarationdate:this.lastdeclarationdate,
          gatewayid:this.gatewayid,
          gatewaypassword:this.gatewaypassword,
          lastreporteddate:this.lastreporteddate,
          mtdusername:this.mtdusername,
          mtdpassword:this.mtdpassword,
          vatcertificate:this.vatcertificate,
          vatdeclarationdocument:this.vatdeclarationdocument,
          proxycommitmentdocument:this.proxycommitmentdocument,
          companyregistrationlocation:this.companyregistrationlocation,
          companyname:this.companyname,
          companyregistrationproof:this.companyregistrationproof,
          businesslicensenumber:this.businesslicensenumber,
          companyestablishmentdate:this.companyestablishmentdate,
          companyoperationaladdress:this.companyoperationaladdress,
          postalcode:this.postalcode,
          companyphonenumber:this.companyphonenumber,
          companycontactemail:this.companycontactemail,
          idcardfront:this.idcardfront,
          idcardback:this.idcardback,
          legalrepresentativename:this.legalrepresentativename,
          signature:this.signature,
          mainsalesplatform:this.mainsalesplatform,
          shopname:this.shopname,
          informationlink:this.informationlink,
          shopbackendselleraddress:this.shopbackendselleraddress,
          shopbackendcompanyname:this.shopbackendcompanyname,
          mainbusinessscope:this.mainbusinessscope
        }).then((res)=>{
          console.log(res)
        }).catch((err)=>{
          console.log(err)
        })
        await this.$axios.post("http://121.40.119.233:8081/Taxservice/update",{
          taxserviceid:this.$route.query.taxserviceid,
          country:this.$route.query.country,
          companyname:this.$route.query.companyname,
          vatnumber:this.$route.query.vatnumber,
          taxrate:this.$route.query.taxrate,
          servicetype:this.$route.query.servicetype,
          taxtype:this.$route.query.taxtype,
          serviceprogress:'待申报',
          servicesummit:this.$route.query.servicesummit
        }).then((res)=>{
          console.log(res)
        }).catch((err)=>{
          console.log(err)
        })
        this.$router.push({
          path:'/taxdeclaration'
        })
      }
    }
  }
}
</script>

<style scoped>

</style>