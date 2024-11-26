<template>
  <div style="display: flex; justify-content: center; margin-top: 20px">
    <el-text style="font-size: 20px">销售增长率 {{ rate1 }}%</el-text>
    <el-text style="margin-left: 50px; font-size: 20px;">市场占比 {{ rate2 }}%</el-text>
  </div>
  <div style="margin-top: 30px; display: flex; align-items: center; justify-content: center">
    <el-icon style="font-size: 30px; color: red"><Pointer /></el-icon>
    <el-text style="font-size: 30px; font-weight: bold; margin-left: 15px">市场建议:</el-text>
    <el-text style="font-size: 18px; margin-left: 30px">{{ suggest1 }} {{ suggest2 }}</el-text>
  </div>
  <div id="myChart2" style="height: 300px; margin-top: 80px"></div>
  <div id="myChart" style="height: 300px; margin-top: 80px"></div>
</template>

<script>
import {markRaw, toRaw} from "vue";
import * as echarts from "echarts";

export default {
  name: "Huaxuepin",
  data(){
    return{
      myChart:null,
      pageNum:1,
      pageSize:10,
      myChart2:null,
      rate1:'',
      rate2:'',
      suggest1:'',
      suggest2:''
    }
  },
  created() {
    this.get()
  },
  mounted() {
    this.drawBar()
    this.drawBar2()
  },
  methods:{
    get(){
      var sum1=0
      var sum2=0
      this.$axios.get("http://121.40.119.233:8081/Importbyhuaxuepin/pageList",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then((res)=>{
        var total = 0
        for (let i=0; i<res.data.data.records.length/2; i++){
          sum1=sum1+parseInt(res.data.data.records[i].importamount)
        }
        for (let i=res.data.data.records.length/2; i<res.data.data.records.length; i++){
          sum2=sum2+parseInt(res.data.data.records[i].importamount)
        }
        total=res.data.data.records[res.data.data.records.length-1].importamount
        this.rate1=((sum2-sum1)/sum2*100).toFixed(5)
        console.log(this.rate1)
        if (this.rate1<0){
          this.suggest1="销售增长率情况不乐观，面临一定的挑战！"
        } else {
          this.suggest1="销售额呈稳步增长的趋势，请继续保持！"
        }
        this.rate2=(total/224813.1*100).toFixed(5)
        console.log(this.rate2)
        if (this.rate2<1){
          this.suggest2="市场占有率较低，有进一步提升的空间！"
        } else if (this.rate2<10 && this.rate2>1){
          this.suggest2="市场占有率一般，请继续加油！"
        } else {
          this.suggest2="市场占有率较高，请继续保持！"
        }
      })
    },
    async drawBar() {
      var amount = []
      await this.$axios.get("http://121.40.119.233:8081/Importbyhuaxuepin/pageList", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then((res) => {
        for (let i = 0; i < res.data.data.records.length; i++) {
          amount.push(res.data.data.records[i].importamount)
        }
        console.log(toRaw(amount))
      })
      var date = []
      await this.$axios.get("http://121.40.119.233:8081/Importbyhuaxuepin/pageList", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then((res) => {
        for (let i = 0; i < res.data.data.records.length; i++) {
          date.push(res.data.data.records[i].date)
        }
        console.log(toRaw(date))
      })
      this.myChart = markRaw(echarts.init(document.getElementById('myChart')))
      this.myChart.setOption({
        title: {
          text: '化学品'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ["销售额"]
        },
        grid: {
          left: '1%',
          right: '1%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          show: false,
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            dataView: {
              readOnly: false
            },
            magicType: {
              type: ['line']
            },
            restore: {},
            saveAsImage: {}
          }
        },
        color: ['red'],
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: toRaw(date)
        },
        yAxis: {
          type: 'value',
          name: '亿欧元/月份',
          axisLabel: {
            formatter: '{value}'
          }
        },
        series: [
          {
            name: '销售额',
            type: 'line',
            data: toRaw(amount)
          }
        ]
      })
      window.addEventListener("resize", () => {
        this.myChart.resize
      })
    },
    async drawBar2() {
      var amount = []
      await this.$axios.get("http://121.40.119.233:8081/Importbyhuaxuepin/pageList", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then((res) => {
        for (let i = 0; i < res.data.data.records.length; i++) {
          amount.push(res.data.data.records[i].importamount)
        }
        console.log(toRaw(amount))
      })
      var date = []
      await this.$axios.get("http://121.40.119.233:8081/Importbyhuaxuepin/pageList", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then((res) => {
        for (let i = 0; i < res.data.data.records.length; i++) {
          date.push(res.data.data.records[i].date)
        }
        console.log(toRaw(date))
      })
      this.myChart2 = markRaw(echarts.init(document.getElementById('myChart2')))
      this.myChart2.setOption({
        title: {
          text: '化学品'
        },
        tooltip: {},
        xAxis: {
          data: toRaw(date)
        },
        yAxis: {
          name: '亿欧元/月份'
        },
        series: [{
          name: '销售额',
          type: 'bar',
          data: toRaw(amount)
        }]
      })
      window.addEventListener("resize", () => {
        this.myChart2.resize
      })
    }
  }
}
</script>

<style scoped>

</style>