<template>
  <el-container class="home">
    <el-aside class="left" width="250px" style="background-color: #021c44">
      <el-menu :collapse="isCollapse"
               background-color="#021c44"
               active-text-color="#fff"
               text-color="darkgrey"
               router>
        <el-menu-item style="color: white">
          <el-icon><Menu /></el-icon>
          <span style="font-size: 25px">欧盟税务合规</span>
        </el-menu-item>
        <el-menu-item index="staging">
          <el-icon><DocumentCopy /></el-icon>
          <span>工作台</span>
        </el-menu-item>
        <el-sub-menu index="2">
          <template #title>
            <el-icon><Aim/></el-icon>
            <span>税务合规</span>
          </template>
          <el-menu-item index="localtaxpolicy">
            <el-icon><Notebook /></el-icon>
            <span>税收政策和税务法规查询</span>
          </el-menu-item>
          <el-sub-menu index="2-2">
            <template #title>
              <el-icon><Upload /></el-icon>
              <span>线上税务自助申报系统</span>
            </template>
            <el-menu-item index="taxservice">VAT税号</el-menu-item>
            <el-menu-item index="taxdeclaration">VAT申报</el-menu-item>
            <el-menu-item index="taxpayment">VAT缴税</el-menu-item>
            <el-menu-item index="taxrefund">VAT退税</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <el-icon><House/></el-icon>
            <span>环境保护</span>
          </template>
          <el-sub-menu index="3-1">
            <template #title>
              <el-icon><Stamp /></el-icon>
              <span>环境合规注册及申报</span>
            </template>
            <el-menu-item index="eprservice">EPR首页</el-menu-item>
            <el-menu-item index="eprdeclaration">EPR申报</el-menu-item>
            <el-menu-item index="eprpayment">EPR在线缴费</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-sub-menu index="4">
          <template #title>
            <el-icon><User/></el-icon>
            <span>消费者权益保护</span>
          </template>
          <el-sub-menu index="4-1">
            <template #title>
              <el-icon><Stamp /></el-icon>
              <span>产品合规注册及申报</span>
            </template>
            <el-menu-item index="compliancetesting">合规检测</el-menu-item>
            <el-menu-item index="documentapplication">文件申请</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-sub-menu index="5">
          <template #title>
            <el-icon><Postcard/></el-icon>
            <span>隐私保护</span>
          </template>
          <el-menu-item index="gdpr">
            <el-icon><Notebook /></el-icon>
            <span>GDPR详解</span>
          </el-menu-item>
          <el-menu-item index="questionnaireinvestigation">
            <el-icon><Memo /></el-icon>
            <span>问卷调查</span>
          </el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="6">
          <template #title>
            <el-icon><DataAnalysis /></el-icon>
            <span>数据分析与报告</span>
          </template>
          <el-menu-item index="vat">
            <el-icon><DataLine /></el-icon>
            <span>VAT税率、缴税额</span>
          </el-menu-item>
          <el-menu-item index="food">
            <el-icon><DataLine /></el-icon>
            <span>食品、饮料、烟草等</span>
          </el-menu-item>
          <el-menu-item index="huaxuepin">
            <el-icon><DataLine /></el-icon>
            <span>化学品</span>
          </el-menu-item>
          <el-menu-item index="jixie">
            <el-icon><DataLine /></el-icon>
            <span>机械制造</span>
          </el-menu-item>
          <el-menu-item index="yuancailiao">
            <el-icon><DataLine /></el-icon>
            <span>原材料</span>
          </el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="7">
          <template #title>
            <el-icon><Service /></el-icon>
            <span>客户服务与投诉处理</span>
          </template>
          <el-menu-item index="myworkorders">
            <el-icon><Avatar /></el-icon>
            <span>我的工单</span>
          </el-menu-item>
          <el-menu-item index="onlineservice">
            <el-icon><Avatar /></el-icon>
            <span>在线客服</span>
          </el-menu-item>
        </el-sub-menu>
        <el-menu-item index="training">
          <el-icon><Connection /></el-icon>
          <span>在线培训中心</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header class="main" style="margin-top: 20px">
        <div class="toolbar">
          <el-radio-group v-model="isCollapse">
            <el-radio-button :label="false"><el-icon><Open /></el-icon></el-radio-button>
            <el-radio-button :label="true"><el-icon><TurnOff /></el-icon></el-radio-button>
          </el-radio-group>
          <img src="../picture/user1.png" width="50" height="50" style="margin-left: 30px">
          <h1 style="font-size: 25px; margin-left: 20px">Welcome User !</h1>
          <div style="margin-left: 300px">
            <el-button color="#228B22" size="small" icon="Plus" round>注册</el-button>
            <el-button color="#4682B4" size="small" icon="Position" round @click="login()">登录</el-button>
            <el-button color="#808000" size="small" icon="Setting" round>设置</el-button>
          </div>
        </div>
        <el-divider border-style="dashed" style="margin-top: 13px"></el-divider>
      </el-header>
      <el-main class="content" style="margin-top: 3px; background-color: rgba(0,0,0,0.02)">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import IconText from "@/components/IconText.vue";
import {ref} from "vue";

export default {
  name: 'HomeView',
  components: {
    IconText,
    HelloWorld
  },
  data(){
    return{
      isCollapse: ref(false)
    }
  },
  methods:{
    login(){
      this.$router.push({
        path:'/'
      })
    }
  }
}
</script>

<style>
el-header{
  position: relative;
  width: 100%;
  margin-top: 20px;
}
el-aside{
  display: block;
  position: absolute;
}
.el-main{
  overflow-y: scroll;
}
.toolbar{
  display: inline-flex;
  align-items: center;
  justify-content: center;
  //color: darkgrey;
}
</style>
