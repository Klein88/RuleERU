<template>
  <Particles
      id="tsparticles"
      :particlesInit="particlesInit"
      :particlesLoaded="particlesLoaded"
      :options="options"
  />
  <div class="formContainer">
    <div style="display: flex; justify-content: center; align-items: center">
      <img src="../../picture/icon.png" height="70" width="70"/>
      <h3 style="margin-left: 20px">欧盟合规综服平台</h3>
    </div>
    <el-form
        ref="loginFormRef"
        :model="loginForm"
        status-icon
        :rules="loginRules"
        label-width="80px"
        class="loginform"
    >
      <div style="display: flex; justify-content: center; align-items: center">
        <el-form-item label="用户名" prop="username" style="margin-top: 5px">
          <el-input v-model="loginForm.username" autocomplete="off" style="width: 250px"/>
        </el-form-item>
      </div>
      <div style="display: flex; justify-content: center; align-items: center">
        <el-form-item label="密码" prop="password" style="margin-top: 10px">
          <el-input v-model="loginForm.password" type="password" autocomplete="off" style="width: 250px" />
        </el-form-item>
      </div>
      <el-form-item>
        <el-button type="primary" @click="submitForm()" style="width: 100px; margin-left: 140px; margin-top: 15px">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import {loadFull} from "tsparticles";
import {reactive,ref} from "vue";
import {useRouter} from "vue-router";
import axios from 'axios';
import { ElMessage } from "element-plus";

const router  = useRouter()
//配置particles
const options = {
  background: {
    color: {
      value: '#0d47a1'
    }
  },
  fpsLimit: 120,
  interactivity: {
    events: {
      onClick: {
        enable: true,
        mode: 'push'
      },
      onHover: {
        enable: true,
        mode: 'repulse'
      },
      resize: true
    },
    modes: {
      bubble: {
        distance: 400,
        duration: 2,
        opacity: 0.8,
        size: 40
      },
      push: {
        quantity: 4
      },
      repulse: {
        distance: 200,
        duration: 0.4
      }
    }
  },
  particles: {
    color: {
      value: '#ffffff'
    },
    links: {
      color: '#ffffff',
      distance: 150,
      enable: true,
      opacity: 0.5,
      width: 1
    },
    collisions: {
      enable: true
    },
    move: {
      direction: 'none',
      enable: true,
      outModes: {
        default: 'bounce'
      },
      random: false,
      speed: 6,
      straight: false
    },
    number: {
      density: {
        enable: true,
        area: 800
      },
      value: 80
    },
    opacity: {
      value: 0.5
    },
    shape: {
      type: 'circle'
    },
    size: {
      value: { min: 1, max: 5 },
    }
  },
  detectRetina: true
}
const particlesInit = async (engine) => {
  await loadFull(engine)
}
const loginForm = reactive({
  username:"",
  password:""
})//表单绑定的响应式对象
const loginFormRef = ref() //表单的引用对象
const loginRules = reactive({
  username:[
    {
      required:true,message:"请输入用户名",trigger:"blur"
    }
  ],
  password:[
    {
      required:true,message:"请输入密码",trigger:"blur"
    }
  ],
})
const submitForm = ()=>{
  //1.校验表单
  loginFormRef.value.validate((valid)=>{
    console.log(valid)
    if(valid){
      // console.log(loginForm)
      // localStorage.setItem("token","kerwin")
      axios.post("http://121.40.119.233:8081/user/login",loginForm).then(res=>{
        console.log(res.data)
        if(res.data.code==20000){
          // console.log(res.data.data)
          // store.commit("changeUserInfo",res.data.data)
          // store.commit("changeGetterRouter",false)
          router.push("home")
        }else{
          ElMessage.error('用户名和密码不匹配')
        }
      })
      // router.push("/index")
    }
  })
  //2.拿到表单内容，提交后台
  //3.设置token
}
</script>

<style lang="scss" scoped>
.formContainer{
  width: 500px;
  height: 300px;
  position: fixed;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
  background: rgba($color: #000000, $alpha: 0.5);
  color: white;
  text-align: center;
  padding-top: 20px;
  h3{
    font-size: 30px;
  }
  .loginform{
    margin-top: 20px;
  }
}

::v-deep .el-form-item__label{
  color:white;
}
</style>