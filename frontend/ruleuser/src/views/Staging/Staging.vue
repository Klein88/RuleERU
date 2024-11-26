<template>
  <div class="account" style="margin-top: 15px">
    <el-button type="default" size="large" icon="ChatDotRound" color="#FF69B4" style="padding: 30px; margin-left: 20px" plain
    >个人信息</el-button>
    <el-button type="default" size="large" icon="ChatLineSquare" color="#FFA500" style="padding: 30px; margin-left: 40px" plain
                >企业信息</el-button>
    <el-button type="default" size="large" icon="OfficeBuilding" color="#9932CC" style="padding: 30px; margin-left: 40px" plain
               @click="CompanyInfo()">公司管理</el-button>
    <el-button type="default" size="large" icon="Box" color="#32CD32" style="padding: 30px; margin-left: 40px" plain
               @click="Products()">产品管理</el-button>
    <el-button type="default" size="large" icon="Edit" color="#00BFFF" style="padding: 30px; margin-left: 40px" plain
               @click="WorkOrders()">我的工单</el-button>
    <el-row :gutter="50">
      <el-col :span="12">
        <div style="width: 420px; margin-top: 50px" class="stagingStyle">
          <el-text style="color: dimgray; font-size: 22px; font-weight: bold">待办事项</el-text>
          <div class="Style" style="margin-top: 10px">
            <div style="display: flex; justify-content: left; align-items: center">
              <div style="background-color: lawngreen; width: 8px; height: 20px; border-radius: 5px"></div>
              <el-text style="font-size: 16px; margin-left: 10px">待提交资料 ( {{total1}} )</el-text>
            </div>
            <el-descriptions :column="3" border style="margin-top: 10px">
              <el-descriptions-item>
                <template #label>
                  <div>
                    VAT
                  </div>
                </template>
                {{vat1}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  EPR
                </template>
                {{epr1}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  产品合规
                </template>
                {{product1}}
              </el-descriptions-item>
            </el-descriptions>
          </div>
          <div class="Style" style="margin-top: 10px">
            <div style="display: flex; justify-content: left; align-items: center">
              <div style="background-color: lightskyblue; width: 8px; height: 20px; border-radius: 5px"></div>
              <el-text style="font-size: 16px; margin-left: 10px">待申报 ( {{total2}} )</el-text>
            </div>
            <el-descriptions :column="3" border style="margin-top: 10px">
              <el-descriptions-item>
                <template #label>
                  <div>
                    VAT
                  </div>
                </template>
                {{vat2}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  EPR
                </template>
                {{epr2}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  产品合规
                </template>
                {{product2}}
              </el-descriptions-item>
            </el-descriptions>
          </div>
          <div class="Style" style="margin-top: 10px">
            <div style="display: flex; justify-content: left; align-items: center">
              <div style="background-color: #efed0b; width: 8px; height: 20px; border-radius: 5px"></div>
              <el-text style="font-size: 16px; margin-left: 10px">注册中 ( {{total3}} )</el-text>
            </div>
            <el-descriptions :column="3" border style="margin-top: 10px">
              <el-descriptions-item>
                <template #label>
                  <div>
                    VAT
                  </div>
                </template>
                {{vat3}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  EPR
                </template>
                {{epr3}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  产品合规
                </template>
                {{product3}}
              </el-descriptions-item>
            </el-descriptions>
          </div>
          <div class="Style" style="margin-top: 10px">
            <div style="display: flex; justify-content: left; align-items: center">
              <div style="background-color: pink; width: 8px; height: 20px; border-radius: 5px"></div>
              <el-text style="font-size: 16px; margin-left: 10px">待续费 ( {{total4}} )</el-text>
            </div>
            <el-descriptions :column="3" border style="margin-top: 10px">
              <el-descriptions-item>
                <template #label>
                  <div>
                    VAT
                  </div>
                </template>
                {{vat4}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  EPR
                </template>
                {{epr4}}
              </el-descriptions-item>
              <el-descriptions-item>
                <template #label>
                  产品合规
                </template>
                {{product4}}
              </el-descriptions-item>
            </el-descriptions>
          </div>
        </div>
        <div style="width: 420px; margin-top: 50px" class="stagingStyle">
          <el-text style="color: dimgray; font-size: 22px; font-weight: bold">进度查询</el-text>
          <el-table :data="things" style="margin-top: 20px">

          </el-table>
        </div>
      </el-col>
      <el-col :span="12">
        <div  style="margin-top: 50px" class="stagingStyle">
          <el-text style="color: dimgray; font-size: 22px; font-weight: bold">合规日历</el-text>
          <el-calendar v-model="value" style="width: 400px; margin-top: 20px"></el-calendar>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import {ref} from "vue";
export default {
  name:'staging',
  data(){
    return{
      value:ref(new Date()),
      pageNum:1,
      pageSize:10,
      vat1:'',
      epr1:'',
      product1:'',
      total1:0,
      vat2:'',
      epr2:'',
      product2:'',
      total2:0,
      vat3:'',
      epr3:'',
      product3:'',
      total3:0,
      vat4:'',
      epr4:'',
      product4:'',
      total4:0
    }
  },
  created() {
    this.get1()
    this.get2()
    this.get3()
    this.get4()
  },
  methods:{
    get1(){
      this.$axios.get("http://121.40.119.233:8081/Taxservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].serviceprogress == '待提交资料'){
            sum++
          }
        }
        this.vat1=sum
        this.total1=this.total1+sum
        console.log(this.vat1)
      })
      this.$axios.get("http://121.40.119.233:8081/Eprservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].servicetype == '待提交资料'){
            sum++
          }
        }
        this.epr1=sum
        this.total1=this.total1+sum
        console.log(this.epr1)
      })
      this.$axios.get("http://121.40.119.233:8081/Complianceapplication/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.product1=res.data.data.records.length
        this.total1=this.total1+this.product1
        console.log(this.product1)
      })
    },
    get2(){
      this.$axios.get("http://121.40.119.233:8081/Taxservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].serviceprogress == '待申报'){
            sum++
          }
        }
        this.vat2=sum
        this.total2=this.total2+sum
        console.log(this.vat2)
      })
      this.$axios.get("http://121.40.119.233:8081/Eprservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].servicetype == '待申报'){
            sum++
          }
        }
        this.epr2=sum
        this.total2=this.total2+sum
        console.log(this.epr2)
      })
      this.$axios.get("http://121.40.119.233:8081/Complianceapplication/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.product2=res.data.data.records.length
        this.total2=this.total2+this.product2
        console.log(this.product2)
      })
    },
    get3(){
      this.$axios.get("http://121.40.119.233:8081/Taxservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].serviceprogress == '注册中'){
            sum++
          }
        }
        this.vat3=sum
        this.total3=this.total3+sum
        console.log(this.vat3)
      })
      this.$axios.get("http://121.40.119.233:8081/Eprservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].servicetype == '注册中'){
            sum++
          }
        }
        this.epr3=sum
        this.total3=this.total3+sum
        console.log(this.epr3)
      })
      this.$axios.get("http://121.40.119.233:8081/Complianceapplication/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.product3=res.data.data.records.length
        this.total3=this.total3+this.product3
        console.log(this.product3)
      })
    },
    get4(){
      this.$axios.get("http://121.40.119.233:8081/Taxservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].serviceprogress == '待续费'){
            sum++
          }
        }
        this.vat4=sum
        this.total4=this.total4+sum
        console.log(this.vat4)
      })
      this.$axios.get("http://121.40.119.233:8081/Eprservice/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        var sum = 0
        for (let i=0; i<res.data.data.records.length; i++){
          if (res.data.data.records[i].servicetype == '待续费'){
            sum++
          }
        }
        this.epr4=sum
        this.total4=this.total4+sum
        console.log(this.epr4)
      })
      this.$axios.get("http://121.40.119.233:8081/Complianceapplication/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.product4=res.data.data.records.length
        this.total4=this.total4+this.product4
        console.log(this.product4)
      })
    },
    CompanyInfo(){
      this.$router.push({
        path:'/companyinfo'
      })
    },
    Products(){
      this.$router.push({
        path:'/products'
      })
    },
    WorkOrders(){
      this.$router.push({
        path:'/workorders'
      })
    }
  }
}
</script>

<style>
.stagingStyle{
  background: #fff;
  border: 1px solid #e8e8e8;
  border-radius: 5px;
  text-align: left;
  padding: 20px;
}
.Style{
  background: rgba(0,0,0,0.03);
  border: 1px solid #fff;
  border-radius: 5px;
  text-align: left;
  padding: 20px;
}
</style>
