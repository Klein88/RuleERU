<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <el-menu>
          <el-menu-item>
            <img src="../assets/img2.png" height="40" width="40"/></el-menu-item>
            <h1>管理员端</h1>
          <el-menu-item >
            <el-button @click="ToVatDeclarationInformationView">VAT服务资料</el-button>
          </el-menu-item>
          <el-menu-item>
            <el-button @click="ToEORDeclarationInfoemationView">EPR服务资料</el-button>
          </el-menu-item>
          <el-menu-item>
            <el-button @click="ToVATRefund">VAT退税</el-button>
          </el-menu-item>
          <el-menu-item>
            <el-button @click="ToWorkorder">工单客服</el-button>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>欧盟综合服务平台管理员端</el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>





<script>
export default
{
  data()
  {
   return{



   }
  }
  ,
  created() {
    console.log(this.$route.query.username);
  },
  methods:{
    ToVatDeclarationInformationView()
    {
      this.$router.push({name : "vatdeclarationinformation"})
    },
    ToEORDeclarationInfoemationView()
    {
      this.$router.push({name :'eprdeclarationinformation'})
    },
    ToVATRefund()
    {
      this.$router.push({name : 'vatrefund'})
    },
    ToWorkorder()
    {
      this.$router.push({name : 'workorder'})
    }
  }
}
</script>