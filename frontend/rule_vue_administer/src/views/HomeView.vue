<template xmlns="http://www.w3.org/1999/html">
  <div class="home">

    <h1 :style="{fontSize : 50}">欧盟综合服务平台管理员端</h1>


    <input v-model="username"><br/>

    <input v-model="password"><br/>

    <el-button type="primary" @click="Login(username , password)">登录</el-button>

  </div>
</template>

<script>
import {ref} from 'vue'
export default {
  data(){
    return{
      username : ref(""),
      password : ref(""),


    }
  },
  methods:{
      Login(username  , password){
        this.$axios({
          url : "http://121.40.119.233:8081/user/login",
          method : "POST",
          data:{
            "username" : this.username,
            "password" : this.password
          }
        }).then( req => {
              console.log("req ------ " , req)
          if(req.data.code == 20000)
          {
            this.$router.push({name : 'loginhome' , query : {username : username , password : password}})
          }
            }).catch(error => {
              console.log(error)
        })
       // this.$router.push({ name: 'loginhome', params: { id: 123 }})

      }



  },
  created() {



  }
}
</script>
