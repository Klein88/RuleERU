<template>
  <div class="style">
    <el-carousel :interval="3000" trigger="click" indicator-position="outside" style="margin: auto; width: 60%">
      <el-carousel-item v-for="item in carousels" :key="item">
        <img :src="item.url" style="width: 550px">
      </el-carousel-item>
    </el-carousel>
    <el-row style="margin-top: 30px">
      <el-col :span="18">
        <IconText icon="Share" text="最新推荐" style="color: cadetblue; font-size: 30px; margin-left: 100px"></IconText>
      </el-col>
      <el-col :span="3">
        <el-button type="warning" icon="Search" @click="search()" style="margin-top: 5px">搜索</el-button>
      </el-col>
      <el-col :span="3">
        <el-button type="danger" icon="ChatDotRound" style="margin-top: 5px">论坛</el-button>
      </el-col>
    </el-row>
    <div style="margin-top: 30px; margin-left: 30px">
      <el-text style="color: dimgray; font-size: 20px">欧盟市场培训课程</el-text>
    </div>
    <el-scrollbar>
      <el-row style="margin-left: 30px; width: 1000px">
        <a @click="marketopen1()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/market1.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">中国企业在欧盟发展报告2023/2024</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="Reading">2.5k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">1k</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
        <a @click="marketopen2()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; margin-left: 50px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/market2.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">2023年欧洲电子商务报告分析</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="Reading">2k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">800+</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
      </el-row>
    </el-scrollbar>
    <div style="margin-top: 30px; margin-left: 30px">
      <el-text style="color: dimgray; font-size: 20px">欧盟法规培训课程</el-text>
    </div>
    <el-scrollbar>
      <el-row style="margin-left: 30px; width: 1000px">
        <a @click="lawsopen1()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/laws1.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">欧盟电池法规</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="Reading">3k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">1.5k</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
        <a @click="lawsopen2()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; margin-left: 50px; width: 500px">
            <el-col :span="4">
              <img src="../../picture/laws2.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">欧盟物质和混合物的分类、标签和包装法规</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="Reading">3k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">1k</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
      </el-row>
    </el-scrollbar>
    <div style="margin-top: 30px; margin-left: 30px">
      <h1 style="color: dimgray; font-size: 20px">合规操作视频教程</h1>
    </div>
    <el-scrollbar>
      <el-row style="margin-left: 30px; width: 1000px">
        <a @click="complianceopen1()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/conformance1.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">欧盟化妆品合规要点指南</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="VideoPlay">2k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">1.5k</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
        <a @click="complianceopen2()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; margin-left: 50px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/conformance2.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">欧洲站合规政策解析</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="VideoPlay">2k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">1.3k</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
      </el-row>
    </el-scrollbar>
    <div style="margin-top: 30px; margin-left: 30px">
      <el-text style="color: dimgray; font-size: 20px">申报操作视频教程</el-text>
    </div>
    <el-scrollbar>
      <el-row style="margin-left: 30px; width: 1000px">
        <a @click="declareopen1()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/declare1.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">欧洲VAT申报要求解析</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="VideoPlay">2.5k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">1.7k</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
        <a @click="declareopen2()" style="color: dodgerblue">
          <el-row class="trainingStyle" style="margin-top: 10px; margin-left: 50px; width: 400px">
            <el-col :span="4">
              <img src="../../picture/declare2.png" width="55" height="55" style="border-radius: 10px"/>
            </el-col>
            <el-col :span="20">
              <el-col>
                <el-text style="font-size: 17px; display: flex; justify-content: center">欧洲EPR合规2023全新策略指南！</el-text>
              </el-col>
              <el-col style="display: flex; justify-content: center">
                <el-button type="text" icon="VideoPlay">2k</el-button>
                <el-button type="text" icon="Download" style="margin-left: 50px">700+</el-button>
              </el-col>
            </el-col>
          </el-row>
        </a>
      </el-row>
    </el-scrollbar>
  </div>
  <Search ref="Search"></Search>
</template>

<script>
import IconText from "@/components/IconText.vue";
import Search from "@/views/Training/Search.vue";
export default {
  name: "training",
  components:{Search, IconText},
  data(){
    return{
      carousels:[
        {url: require('@/picture/carousel1.png')},
        {url: require('@/picture/carousel2.png')},
        {url: require('@/picture/carousel3.png')},
        {url: require('@/picture/carousel4.png')}
      ]
    }
  },
  methods:{
    search(){
      this.$refs.Search.open()
    },
    lawsopen1(){
      window.open("https://baijiahao.baidu.com/s?id=1777603392414370645&wfr=spider&for=pc")
    },
    lawsopen2(){
      window.open("https://zhuanlan.zhihu.com/p/641300670?utm_id=0")
    },
    complianceopen1(){
      window.open("https://baijiahao.baidu.com/s?id=1772916414172686400&wfr=spider&for=pc")
    },
    complianceopen2(){
      window.open("https://zhuanlan.zhihu.com/p/663215198")
    },
    marketopen1(){
      window.open("https://finance.eastmoney.com/a/202311152904695633.html")
    },
    marketopen2(){
      window.open("https://www.163.com/dy/article/IHR0B6AS055631OX.html")
    },
    declareopen1(){
      window.open("https://www.tq365.cn/article/5864.html")
    },
    declareopen2(){
      window.open("https://zhuanlan.zhihu.com/p/660342824")
    }
  }
}
</script>

<style>
.style{
  background: #fff;
  border: 1px solid #e8e8e8;
  border-radius: 5px;
  padding: 20px;
}
.trainingStyle{
  background: #fff;
  border: 2px solid #DCDFE6;
  border-radius: 5px;
  padding: 10px 10px 5px 10px;
}
</style>