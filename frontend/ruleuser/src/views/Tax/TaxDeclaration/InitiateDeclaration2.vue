<template xmlns="http://www.w3.org/1999/html">
  <el-steps :active="1" process-status="finish" finish-status="success" align-center style="margin-top: 20px">
    <el-step title="确认申报信息" />
    <el-step title="上传销售数据" />
    <el-step title="查看算税结果" />
    <el-step title="添加其他申报项" />
    <el-step title="查看申报明细" />
  </el-steps>
<!--  <p style="margin-top: 30px">上传销售数据</p>-->
<!--  <el-upload action="#" list-type="picture-card" :auto-upload="false" ref="upload" style="margin-top: 10px">-->
<!--    <el-icon><Plus /></el-icon>-->
<!--    <template #file="{ file }">-->
<!--      <div>-->
<!--        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />-->
<!--        <span class="el-upload-list__item-actions">-->
<!--          <span-->
<!--              class="el-upload-list__item-preview"-->
<!--              @click="handlePictureCardPreview(file)"-->
<!--          >-->
<!--            <el-icon><zoom-in /></el-icon>-->
<!--          </span>-->
<!--          <span-->
<!--              v-if="!disabled"-->
<!--              class="el-upload-list__item-delete"-->
<!--              @click="handleDownload(file)"-->
<!--          >-->
<!--            <el-icon><Download /></el-icon>-->
<!--          </span>-->
<!--          <span-->
<!--              v-if="!disabled"-->
<!--              class="el-upload-list__item-delete"-->
<!--              @click="handleRemove(file)"-->
<!--          >-->
<!--            <el-icon><Delete /></el-icon>-->
<!--          </span>-->
<!--        </span>-->
<!--      </div>-->
<!--    </template>-->
<!--  </el-upload>-->
<!--  <el-dialog v-model="dialogVisible">-->
<!--    <img w-full :src="dialogImageUrl" alt="Preview Image" />-->
<!--  </el-dialog>-->
<!--  <p style="margin-top: 30px">含税销售额</p>-->
<!--  <el-input prefix-icon="Money" placeholder="请输入含税销售额" style="margin-top: 10px"></el-input>-->
  <input type="file" @change="handleFileUpload" id="default-btn1">
  <div style="margin-top: 30px; margin-left: 20px">
    <el-text style="font-size: 18px">含税销售额： {{ money }} 元</el-text>
  </div>
  <el-table :data="data" style="margin-top: 30px">
    <el-table-column label="Date" prop="Date"></el-table-column>
    <el-table-column label="Product Type" prop="Product Type"></el-table-column>
    <el-table-column label="Daily Sales (EUR)" prop="Daily Sales (EUR)"></el-table-column>
  </el-table>
  <div style="margin-top: 50px; display: flex; justify-content: center">
    <el-button type="default" @click="back()" style="width: 150px">返回 “申报” 主页</el-button>
    <el-button type="primary" @click="next()" style="margin-left: 100px; width: 150px">下一步</el-button>
  </div>
</template>

<script>
import {ref} from "vue";
import Papa from 'papaparse'

export default {
  name: "InitiateDeclaration2",
  data(){
    return{
      // dialogImageUrl:ref(''),
      // dialogVisible:ref(false),
      // disabled:ref(false),
      data:null,
      money:0
    }
  },
  methods:{
    // handleRemove(file) {
    //   this.$refs.upload.clearFiles()
    // },
    // handlePictureCardPreview(file) {
    //   this.dialogImageUrl = file.url
    //   this.dialogVisible = true
    // },
    // handleDownload(file) {
    //   console.log(file)
    // },
    handleFileUpload(event){
      console.log(event)
      const file=event.target.files[0]
      Papa.parse(file,{
        header: true,
        complete: (result)=>{
          this.data=result.data
          console.log('Parsed Data:',this.data)
          for (let i=0; i<this.data.length-1; i++){
            this.money=this.money+parseInt(this.data[i]['Daily Sales (EUR)'])
            console.log(this.money)
          }
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
        path:'/initiatedeclaration3',
        query:{
          money:this.money,
          taxrate:this.$route.query.taxrate
        }
      })
    }
  }
}
</script>

<style>
#default-btn1::file-selector-button{
  margin-top: 30px;
  margin-left: 20px;
  padding: 6px 10px;
  background-color: #1E9FFF;
  border: 1px solid #1E9FFF;
  border-radius: 5px;
  cursor: pointer;
  color: #fff;
  font-size: 15px;
}
</style>