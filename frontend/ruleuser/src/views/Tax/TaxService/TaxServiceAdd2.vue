<template>
  <el-dialog v-model="visible" title="添加VAT税号" width="650px">
    <el-steps :active="active" :space="300" process-status="finish" finish-status="success" align-center>
      <el-step title="选择国家" />
      <el-step title="填写税号信息" />
      <el-step title="添加完成" />
    </el-steps>
    <h1 style="font-size: 15px; margin-top: 20px; margin-left: 10px">公司名称：{{companyname}}</h1>
    <el-table :data="toRaw(tableData)" border style="margin-top: 20px; margin-left: 10px">
      <el-table-column label="税务号" prop="taxserviceid" width="130">
        <template #default="scope">
          <el-input v-model="scope.row.taxserviceid" placeholder="请输入税务号"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="国家" prop="country" width="100"></el-table-column>
      <el-table-column label="VAT税号(不超过16位)" prop="vatnumber" width="210">
        <template #default="scope">
          <el-input v-model="scope.row.vatnumber" placeholder="请输入VAT税号"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="税率(%)" prop="taxrate" width="140">
        <template #default="scope">
          <el-select v-model="scope.row.taxrate" clearable placeholder="请选择税率">
            <el-option v-for="item in taxrates" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="申报规则" prop="servicetype" width="170">
        <template #default="scope">
          <el-select v-model="scope.row.servicetype" clearable placeholder="请选择申报规则">
            <el-option v-for="item in services" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="申报周期" prop="taxtype" width="170">
        <template #default="scope">
          <el-select v-model="scope.row.taxtype" clearable placeholder="请选择申报周期">
            <el-option v-for="item in taxs" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="服务进度" prop="serviceprogress" width="170">
        <template #default="scope">
          <el-select v-model="scope.row.serviceprogress" clearable placeholder="请选择服务进度">
            <el-option v-for="item in progress" :key="item.value" :label="item.label" :value="item.value"></el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column label="服务提交次数" prop="servicesummit" width="180">
        <template #default="scope">
          <el-input v-model="scope.row.servicesummit" placeholder="请输入服务提交次数"></el-input>
        </template>
      </el-table-column>
    </el-table>
    <div style="display: flex; justify-content: end; margin-top: 30px; margin-right: 20px">
      <el-button type="default" style="width: 80px" @click="back()">取消</el-button>
      <el-button type="primary" style="width: 100px" @click="next()">下一步</el-button>
    </div>
  </el-dialog>
  <TaxServiceAdd3 ref="TaxServiceAdd3"></TaxServiceAdd3>
</template>

<script>
import {ref,toRaw} from "vue";
import TaxServiceAdd3 from "@/views/Tax/TaxService/TaxServiceAdd3.vue";
export default {
  name: "TaxServiceAdd2",
  components:{TaxServiceAdd3},
  data(){
    return{
      visible:false,
      active:ref(1),
      tableData:[],
      companyname:'',
      vatnumber:'',
      taxrate:'',
      taxrates:[
        {
          label: '22',
          value: '22'
        },
        {
          label: '21',
          value: '21'
        },
        {
          label: '20',
          value: '20'
        },
        {
          label: '19',
          value: '19'
        },
        {
          label: '10',
          value: '10'
        },
        {
          label: '7',
          value: '7'
        },
        {
          label: '5',
          value: '5'
        },
        {
          label: '4',
          value: '4'
        },
        {
          label: '0',
          value: '0'
        }
      ],
      servicetype:'',
      services:[
        {
          label: 'VAT转申报',
          value: 'VAT转申报'
        },
        {
          label: '目的国',
          value: '目的国'
        }
      ],
      taxtype:'',
      taxs:[
        {
          label: '月度申报',
          value: '月度申报'
        },
        {
          label: '季度申报',
          value: '季度申报'
        },
        {
          label: '年度申报',
          value: '年度申报'
        }
      ],
      serviceprogress:'',
      progress:[
        {
          label: '待提交资料',
          value: '待提交资料'
        },
        {
          label: '待申报',
          value: '待申报'
        },
        {
          label: '注册中',
          value: '注册中'
        },
        {
          label: '待续费',
          value: '待续费'
        }
      ],
      servicesummit:''
    }
  },
  methods:{
    toRaw,
    open(){
      this.visible=true
    },
    back(){
      this.visible=false
      this.tableData=[]
      this.companyname=''
    },
    async next(){
      var countries = []
      var vatnumbers = []
      var taxrates = []
      var servicetypes = []
      var taxtypes = []
      var serviceprogresses = []
      var servicesummits = []
      var companynames = []
      var taxserviceids = []
      for (let i=0; i<this.tableData.length; i++){
        var obj = {}
        obj['country'] = this.tableData[i]['country']
        countries.push(obj['country'])
        obj['vatnumber'] = this.tableData[i]['vatnumber']
        vatnumbers.push(obj['vatnumber'])
        obj['taxrate'] = toRaw(this.tableData[i]['taxrate']).toString()
        taxrates.push(obj['taxrate'])
        obj['servicetype'] = this.tableData[i]['servicetype']
        servicetypes.push(obj['servicetype'])
        obj['taxtype'] = this.tableData[i]['taxtype']
        taxtypes.push(obj['taxtype'])
        obj['serviceprogress'] = this.tableData[i]['serviceprogress']
        serviceprogresses.push(obj['serviceprogress'])
        obj['servicesummit'] = this.tableData[i]['servicesummit']
        servicesummits.push(obj['servicesummit'])
        obj['companyname'] = this.companyname
        companynames.push(obj['companyname'])
        obj['taxserviceid'] = this.tableData[i]['taxserviceid']
        taxserviceids.push(obj['taxserviceid'])
      }
      this.$refs.TaxServiceAdd3.countries=countries
      this.$refs.TaxServiceAdd3.vatnumbers=vatnumbers
      this.$refs.TaxServiceAdd3.taxrates=taxrates
      this.$refs.TaxServiceAdd3.servicetypes=servicetypes
      this.$refs.TaxServiceAdd3.taxtypes=taxtypes
      this.$refs.TaxServiceAdd3.serviceprogresses=serviceprogresses
      this.$refs.TaxServiceAdd3.servicesummits=servicesummits
      this.$refs.TaxServiceAdd3.companynames=companynames
      this.$refs.TaxServiceAdd3.taxserviceids=taxserviceids
      var tores = []
      var k = true
      for (let i=0; i<this.tableData.length; i++){
        await this.$axios.get("http://121.40.119.233:8081/vat-check/lookup/"+vatnumbers[i]).then((res)=>{
          tores.push(res.data.valid)
          console.log(tores)
          console.log(res)
        }).catch((err)=>{
          tores.push(err.response.data.valid)
          console.log(tores)
          console.log(err)
        })
        if (tores[i] == false){
          k = false
        }
      }
      if (k == true){
        this.$message({
          message:"税号验证成功！",
          type:"success"
        })
        this.$refs.TaxServiceAdd3.open()
        this.visible=false
      } else {
        this.$message({
          message:"请输入正确的VAT税号",
          type:"warning"
        })
      }
    }
  }
}
</script>

<style>

</style>