
<template>
  <el-dialog v-model="isshowDialog">
    问题 :{{nowdatas.workordertheme}} <br/>
    回答 :<el-input v-model="nowdatas.description" /><br/>
    <el-button type="primary" @click="submit">提交</el-button>
    <el-button type="primary" @click="isshowDialog = false">取消</el-button>
  </el-dialog>
  <el-table :data="datas">
    <el-table-column prop="workorderid" label="工单编号"></el-table-column>
    <el-table-column prop="workordertheme" label="问题" width="200px"></el-table-column>
    <el-table-column prop="description" label="回答" width="200px"></el-table-column>
    <el-table-column prop="creationdate" label="工单日期" width="200px"></el-table-column>
    <el-table-column prop="status" label="状态" width="200px"></el-table-column>
    <el-table-column>
      <template v-slot="{row}">
        <el-button type="primary" @click="changeNowDatas(row)">回复</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>



<script>
export default
{
  data()
  {
    return{
      datas : "",
      isshowDialog : false,
      nowdatas : ""
    }
  },
  created() {
    this.$axios.get("http://121.40.119.233:8081/Workorder/pageList?pageSize=1&pageNum=1")
        .then(req => {
          this.datas = req.data.data.records

          console.log(req.data)
        }).catch(error  => {
          console.log(error)
    })
  },
  methods:{
    changeNowDatas(row)
    {
      this.nowdatas = row
      this.isshowDialog = true
    },
    submit()
    {
      this.nowdatas.status = "已完成"
      this.$axios.post("http://121.40.119.233:8081/Workorder/update" , this.nowdatas)
          .then(req => {
            console.log(req)
            this.isshowDialog = false
            this.$router.go(0)
          }).catch(error => {
            console.log(error)
      })
    }
  }


}





</script>


<style scoped>

</style>