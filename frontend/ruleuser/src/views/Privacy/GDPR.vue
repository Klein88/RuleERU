<template>
  <div style="margin-top: 10px">
    <el-text style="display: flex; justify-content: center; font-size: 25px; font-weight: bold">GDPR详解</el-text>
  </div>
  <a @click="open1()" style="color: dodgerblue">
    <el-row class="GDPRStyle" style="margin-top: 30px; margin-left: 20px; width: 400px">
      <el-col :span="4">
        <img src="../../picture/GDPR1.png" width="55" height="55" style="border-radius: 10px"/>
      </el-col>
      <el-col :span="20">
        <el-col>
          <el-text style="font-size: 17px; display: flex; justify-content: center">一文读懂GDPR</el-text>
        </el-col>
        <el-col style="display: flex; justify-content: center">
          <el-button type="text" icon="VideoPlay">2.5k</el-button>
          <el-button type="text" icon="Download" style="margin-left: 50px">1.7k</el-button>
        </el-col>
      </el-col>
    </el-row>
  </a>
  <a @click="open2()" style="color: dodgerblue">
    <el-row class="GDPRStyle" style="margin-top: 30px; margin-left: 20px; width: 500px">
      <el-col :span="4">
        <img src="../../picture/GDPR2.png" width="55" height="55" style="border-radius: 10px"/>
      </el-col>
      <el-col :span="20">
        <el-col>
          <el-text style="font-size: 17px; display: flex; justify-content: center">一次性说清《通用数据保护条例》（GDPR）管辖权</el-text>
        </el-col>
        <el-col style="display: flex; justify-content: center">
          <el-button type="text" icon="Reading">3k</el-button>
          <el-button type="text" icon="Download" style="margin-left: 50px">1k</el-button>
        </el-col>
      </el-col>
    </el-row>
  </a>
</template>

<script>
export default {
  name: "GDPR",
  methods:{
    open1(){
      window.open("https://zhuanlan.zhihu.com/p/401330458")
    },
    open2(){
      window.open("https://baijiahao.baidu.com/s?id=1778077063794072770&wfr=spider&for=pc")
    }
  }
}
</script>

<style>
.GDPRStyle{
  background: #fff;
  border: 2px solid #DCDFE6;
  border-radius: 5px;
  padding: 10px 10px 5px 10px;
}
</style>