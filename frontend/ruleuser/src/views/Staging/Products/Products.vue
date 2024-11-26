<template>
  <el-tag type="warning" size="large" closable style="width: 910px">想要查看数据或刷新表格需点击  “查询所有”  按钮哦！</el-tag>
  <el-form :inline="true" style="margin-top: 25px">
    <el-form-item label="产品编号">
      <el-input v-model="productid" placeholder="请输入想要查询的产品编号" style="width: 200px"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="Search" @click="search(productid)">搜索</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="List" @click="getTableData()">查询所有</el-button>
    </el-form-item>
    <el-form-item>
      <el-button type="success" icon="CirclePlus" @click="add()">新增</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column label="产品编号" prop="productid" width="100"></el-table-column>
    <el-table-column label="公司编号" prop="companyid" width="100"></el-table-column>
    <el-table-column label="产品名称" prop="productname" width="180"></el-table-column>
    <el-table-column label="产品描述" prop="productdescription" width="180"></el-table-column>
    <el-table-column label="产品价格" prop="productprice" width="100"></el-table-column>
    <el-table-column label="产品类别" prop="productcategory" width="120"></el-table-column>
    <el-table-column label="生产地区" prop="productorigin" width="100"></el-table-column>
    <el-table-column label="生产日期" prop="manufacturedate" width="180"></el-table-column>
    <el-table-column label="到期日期" prop="expirydate" width="180"></el-table-column>
    <el-table-column label="操作" width="200">
      <template #default="scope">
        <el-button type="warning" icon="Refresh" @click="update(scope.row.productid)">编辑</el-button>
        <el-button type="danger" icon="Remove" @click="del(scope.row.productid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "products",
  data(){
    return{
      tableData:[],
      pageNum:1,
      pageSize:10,
      productid:''
    }
  },
  created() {
    this.getTableData()
  },
  methods:{
    search(productid){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Products/find",{
        params:{
          productid:this.productid
        }
      }).then((res)=>{
        this.tableData.push(res.data.data)
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    getTableData(){
      this.tableData=[]
      this.$axios.get("http://121.40.119.233:8081/Products/pageList",{
        params:{
          pageNum:this.pageNum,
          pageSize:this.pageSize
        }
      }).then((res)=>{
        this.tableData = res.data.data.records
        console.log(res)
      }).catch((err)=>{
        console.log(err)
      })
    },
    add(){
      this.$router.push({
        path:'/productsadd'
      })
    },
    update(productid){
      this.$router.push({
        path:'/productsupdate/'+productid
      })
    },
    del(productid){
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning"
      }).then(()=>{
        this.$axios.delete("http://121.40.119.233:8081/Products/delete/"+productid).then((res)=>{
          console.log(res)
          this.$message({
            message:"删除成功",
            type:"success"
          })
          this.getTableData()
        }).catch((err)=>{
          console.log(err)
        })
      }).catch(()=>{
        this.$message({
          message:"已取消删除",
          type:"info"
        })
      })
    }
  }
}
</script>

<style scoped>

</style>