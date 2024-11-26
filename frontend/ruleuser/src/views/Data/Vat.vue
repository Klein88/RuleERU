<template>
  <div id="myChart" style="height: 300px; margin-top: 30px"></div>
  <div id="myChart2" style="height: 300px; margin-top: 80px"></div>
</template>

<script>
import  * as echarts from 'echarts'
import {markRaw, toRaw} from "vue";
export default {
  name: "DataAnalysis",
  data(){
    return{
      myChart:null,
      option:{
        title: {
          text: '欧盟各个国家的VAT税率'
        },
        tooltip: {},
        xAxis: {
          data: ["英国", "德国", "法国", "意大利", "西班牙", "瑞典", "挪威", "荷兰", "瑞士", "芬兰"]
        },
        yAxis: {
          name: '单位（%）'
        },
        series: [{
          name: 'VAT税率',
          type: 'bar',
          data: [20, 19, 20, 22, 21, 25, 25, 21, 8, 24]
        }]
      },
      myChart2:null,
      pageNum:1,
      pageSize:10,
    }
  },
  watch:{
    option:{
      handler(newVal){
        if (newVal){
          this.myChart.setOption(newVal)
        }
      },
      deep:true
    }
  },
  mounted() {
    this.drawBar()
    this.drawBar2()
  },
  methods:{
    drawBar(){
      this.myChart = markRaw(echarts.init(document.getElementById('myChart')))
      this.myChart.setOption(this.option)
      window.addEventListener("resize",()=>{
        this.myChart.resize
      })
    },
    async drawBar2(){
      var values = []
      await this.$axios.get("http://121.40.119.233:8081/Taxpayment/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        for (let i = 0; i < res.data.data.records.length; i++){
          values.push(res.data.data.records[i].amountdue)
        }
        console.log(toRaw(values))
      })
      var names = []
      await this.$axios.get("http://121.40.119.233:8081/Taxpayment/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        for (let i = 0; i < res.data.data.records.length; i++){
          names.push(res.data.data.records[i].companyname)
        }
        console.log(toRaw(names))
      })
      this.myChart2 = markRaw(echarts.init(document.getElementById('myChart2')))
      this.myChart2.setOption({
        title: {
          text: '所缴VAT税额'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ["缴纳税款"]
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
            dataZoom:{
              yAxisIndex:'none'
            },
            dataView:{
              readOnly:false
            },
            magicType:{
              type:['line']
            },
            restore:{},
            saveAsImage:{}
          }
        },
        color:['red'],
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: toRaw(names)
        },
        yAxis: {
          type: 'value',
          name: '单位（元）',
          axisLabel: {
            formatter: '{value}'
          }
        },
        series: [
          {
            name: '缴纳税款',
            type: 'line',
            data: toRaw(values)
          }
        ]
      })
      window.addEventListener("resize",()=>{
        this.myChart2.resize
      })
    }
  }
}
</script>

<style scoped>

</style>