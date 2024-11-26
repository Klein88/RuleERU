<template>
  <el-steps :active="3" process-status="finish" finish-status="success" align-center style="margin-top: 20px">
    <el-step title="确认申报信息" />
    <el-step title="上传销售数据" />
    <el-step title="查看算税结果" />
    <el-step title="添加其他申报项" />
    <el-step title="查看申报明细" />
  </el-steps>
<!--  <p style="margin-top: 30px">添加其他申报项</p>-->
<!--  <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload1" v-model="vatcertificate" style="margin-top: 10px">-->
<!--    <el-icon><Plus /></el-icon>-->
<!--    <template #file="{ file }">-->
<!--      <div>-->
<!--        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />-->
<!--        <span class="el-upload-list__item-actions">-->
<!--          <span-->
<!--              class="el-upload-list__item-preview"-->
<!--              @click="handlePictureCardPreview1(file)"-->
<!--          >-->
<!--            <el-icon><zoom-in /></el-icon>-->
<!--          </span>-->
<!--          <span-->
<!--              v-if="!disabled1"-->
<!--              class="el-upload-list__item-delete"-->
<!--              @click="handleDownload1(file)"-->
<!--          >-->
<!--            <el-icon><Download /></el-icon>-->
<!--          </span>-->
<!--          <span-->
<!--              v-if="!disabled1"-->
<!--              class="el-upload-list__item-delete"-->
<!--              @click="handleRemove1(file)"-->
<!--          >-->
<!--            <el-icon><Delete /></el-icon>-->
<!--          </span>-->
<!--        </span>-->
<!--      </div>-->
<!--    </template>-->
<!--  </el-upload>-->
<!--  <el-dialog v-model="dialogVisible1">-->
<!--    <img w-full :src="dialogImageUrl1" alt="Preview Image" />-->
<!--  </el-dialog>-->
<!--  <p style="margin-top: 30px">递延进口增值税</p>-->
<!--  <el-table style="margin-top: 10px">-->
<!--    <el-table-column label="上传凭证">-->
<!--      <template #default="scope">-->
<!--        <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload2" v-model="vatdeclarationdocument">-->
<!--          <el-icon><Plus /></el-icon>-->
<!--          <template #file="{ file }">-->
<!--            <div>-->
<!--              <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />-->
<!--              <span class="el-upload-list__item-actions">-->
<!--          <span-->
<!--              class="el-upload-list__item-preview"-->
<!--              @click="handlePictureCardPreview2(file)"-->
<!--          >-->
<!--            <el-icon><zoom-in /></el-icon>-->
<!--          </span>-->
<!--          <span-->
<!--              v-if="!disabled2"-->
<!--              class="el-upload-list__item-delete"-->
<!--              @click="handleDownload2(file)"-->
<!--          >-->
<!--            <el-icon><Download /></el-icon>-->
<!--          </span>-->
<!--          <span-->
<!--              v-if="!disabled2"-->
<!--              class="el-upload-list__item-delete"-->
<!--              @click="handleRemove2(file)"-->
<!--          >-->
<!--            <el-icon><Delete /></el-icon>-->
<!--          </span>-->
<!--        </span>-->
<!--            </div>-->
<!--          </template>-->
<!--        </el-upload>-->
<!--        <el-dialog v-model="dialogVisible2">-->
<!--          <img w-full :src="dialogImageUrl2" alt="Preview Image" />-->
<!--        </el-dialog>-->
<!--      </template>-->
<!--    </el-table-column>-->
<!--    <el-table-column label="金额(欧元)">-->
<!--      <template #default="scope">-->
<!--        <el-input placeholder="请输入VAT税号"></el-input>-->
<!--      </template>-->
<!--    </el-table-column>-->
<!--  </el-table>-->
  <p style="font-size: 18px; margin-top: 30px">添加其他申报项</p>
  <input type="file" @change="handleFileUpload" id="default-btn2">
  <div style="margin-top: 30px; margin-left: 20px">
    <el-text style="font-size: 18px">含税销售额： {{ money }} 元</el-text>
  </div>
  <el-table :data="data" style="margin-top: 30px">
    <el-table-column label="Date" prop="Date"></el-table-column>
    <el-table-column label="Product Category" prop="Product Category"></el-table-column>
    <el-table-column label="Price (EUR per item)" prop="Price (EUR per item)"></el-table-column>
    <el-table-column label="Sales Quantity" prop="Sales Quantity"></el-table-column>
    <el-table-column label="Total Sales (EUR)" prop="Total Sales (EUR)"></el-table-column>
  </el-table>
  <div style="margin-top: 50px; display: flex; justify-content: center">
    <el-button type="default" @click="back()" style="width: 150px">返回 “申报” 主页</el-button>
    <el-button type="primary" @click="next()" style="margin-left: 100px; width: 150px">开始申报</el-button>
  </div>
</template>

<script>
import {ref} from "vue";
import Papa from "papaparse";

export default {
  name: "InitiateDeclaration4",
  data(){
    return{
      // dialogImageUrl1:ref(''),
      // dialogVisible1:ref(false),
      // disabled1:ref(false),
      // dialogImageUrl2:ref(''),
      // dialogVisible2:ref(false),
      // disabled2:ref(false),
      data:null,
      money:0,
      pay:0
    }
  },
  methods:{
    // handleRemove1(file) {
    //   this.$refs.upload1.clearFiles()
    // },
    // handlePictureCardPreview1(file) {
    //   this.dialogImageUrl1 = file.url
    //   this.dialogVisible1 = true
    // },
    // handleDownload1(file) {
    //   console.log(file)
    // },
    // handleRemove2(file) {
    //   this.$refs.upload2.clearFiles()
    // },
    // handlePictureCardPreview2(file) {
    //   this.dialogImageUrl2 = file.url
    //   this.dialogVisible2 = true
    // },
    // handleDownload2(file) {
    //   console.log(file)
    // },
    handleFileUpload(event){
      console.log(event)
      const file=event.target.files[0]
      Papa.parse(file,{
        header: true,
        complete: (result)=>{
          console.log(result)
          this.data=result.data
          console.log('Parsed Data:',this.data)
          for (let i=0; i<this.data.length-1; i++){
            this.money=this.money+parseInt(this.data[i]['Total Sales (EUR)'])
            console.log(this.money)
          }
          this.pay=this.money * this.$route.query.taxrate / 100
        }
      })
    },
    back(){
      this.$router.push({
        path:'/taxdeclaration'
      })
    },
    next(){
      this.$router.push({
        path:'/initiatedeclaration5',
        query:{
          ebaymoney:this.money,
          ebaypay:this.pay,
          amazonmoney:this.$route.query.amazonmoney,
          amazonpay: this.$route.query.amazonpay
        }
      })
    }
  }
}
</script>

<style>
#default-btn2::file-selector-button{
  margin-top: 20px;
  padding: 6px 10px;
  background-color: #1E9FFF;
  border: 1px solid #1E9FFF;
  border-radius: 5px;
  cursor: pointer;
  color: #fff;
  font-size: 15px;
}
</style>