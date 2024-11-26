

<template>



  <el-dialog v-model="isshowVATreturnsDialog">

    {{VATreturns}}

    <el-button type="primary" @click="isshowVATreturnsDialog = false">取消</el-button>
  </el-dialog>


  <el-dialog v-model="isshowVATInformationDialog">
    {{VATInformation}}

    <el-button type="primary" @click="isshowVATInformationDialog = false">取消</el-button>

  </el-dialog>
  <el-dialog v-model="isshowusermessage">
    用户id : {{User.userId}}<br/>
    密码 : {{User.password}}<br/>
    邮箱地址 : {{User.emailAddress}}<br/>
    groupIdentifier : {{User.groupIdentifier}}<br/>
    VAT注册日期 : {{User.vatRegistrationDate}}<br/>
    vrn（VAT税号） : {{User.vrn}}  <br/>
    Token(请注意保存) : {{textData.access_token}}<br/>

    请复制下列网址并在新标签页中打开操作 : https://test-www.tax.service.gov.uk/oauth/authorize?response_type=code&client_id=hMklCXtoDTJ2yIWdo2cBFHwn0UvV&scope=read:vat+write:vat+write:sent-invitations&redirect_uri=http://localhost:8081/oauth/authorize <br/>
    <el-button type="primary" @click="isshowusermessage = false">取消</el-button>
  </el-dialog>

  <el-dialog v-model="isshowToken2dialog">
    code : <el-input v-model="code"></el-input><br/>
    token2 : {{token2}}<br/>

    <el-button type="primary" @click="getToken2">获取token2</el-button>    <el-button type="primary" @click="isshowToken2dialog = false">取消</el-button>
  </el-dialog>



  <el-table :data="datass">
    <el-table-column prop="declarationid" label="id" ></el-table-column>
    <el-table-column prop="companyname" label="公司名称" width="200px"></el-table-column>
    <el-table-column prop="vatnumber" label="VAT税号" width="200px"></el-table-column>
    <el-table-column prop="gatewayid" label="gatewayid" width="200px"></el-table-column>
    <el-table-column prop="gatewaypassword" label="gatewaypassword" width="200px"></el-table-column>
    <el-table-column prop="mtdusername" label="mtdusername" width="200px"></el-table-column>
    <el-table-column prop="mtdpassword" label="mtdpassword" width="200px"></el-table-column>
    <el-table-column width="200px">
      <el-button type="primary" @click="DemoTest">获取用户信息和token1</el-button>
    </el-table-column>
    <el-table-column width="200px">
      <el-button type="primary" @click="isshowToken2dialog = true">获取token2</el-button>
    </el-table-column>
    <el-table-column width="200px">
      <el-button type="primary" @click="getVATInformation">获取VAT详细信息</el-button>
    </el-table-column>

    <el-table-column width="200px">
      <el-button type="primary" @click="">获取VAT合约</el-button>
    </el-table-column>

    <el-table-column width="200px">
      <el-button type="primary" @click="submitVATreturns">VAT申报</el-button>
    </el-table-column>
  </el-table>
</template>


<script>

export  default
{
  data()
  {
    return{
      VATreturns : "",
      datass : [],
      textData : "",
      isshowVATreturnsDialog : false,
      isshowToken2dialog : false,
      isshowVATInformationDialog : false,
      VATInformation : "",
      token2 : "",
      code : "",
      User : {
        emailAddress : "",
        groupIdentifier : "",
        password : "",
        userFullName : "",
        userId : "",
        vatRegistrationDate : "",
        organisationDetails : {
          name : "",
          address : {
            line1 : "",
            line2 : "",
            postcode : ""
          }
        },
        individualDetails : {
          address : {
            line1 : "",
            line2 : "",
            postcode : ""
          },
          dateOfBirth : "",
          firstName : "",
          lastName : ""
        }
      },
      isshowusermessage : false
    }
  },
  created() {
    this.$axios({
      url : "http://121.40.119.233:8081/Taxdeclaration/pageList?pageSize=1&pageNum=1",
      method : "GET"
    }).then(req => {

      this.datass = req.data.data.records
      console.log("This.datas : ------" , this.datass)
    }).catch(error => {
      console.log(error)

    })


  },
  methods:{
    DemoTest(){

      this.$axios.post('http://121.40.119.233:8081/hmrc/getInitialAccessToken', {}, { responseType: 'text' })
          .then(response => {
            this.textData = JSON.parse(response.data)
            console.log("token :  " , this.textData.access_token);
            // 在这里对接收到的文本数据进行处理



            const formData = new FormData();
            formData.append('accessToken', this.textData.access_token);
            this.$axios.post('http://121.40.119.233:8081/hmrc/createTestUser', formData)
                .then(response => {
                  console.log(response.data);
                  this.User = response.data
                  this.isshowusermessage = true
                  // 在这里处理后端返回的响应数据
                })
                .catch(error => {
                  console.error('Error while submitting form:', error);
                })
          })
          .catch(error => {
            console.error('Error while uploading file:', error);
          });


    },
    getToken2(){
      const formData = new FormData();


      formData.append("authorizationCode" , this.code)


      this.$axios.post('http://121.40.119.233:8081/hmrc/getAccessTokenWithCode', formData)
          .then(req => {
            console.log("token2" ,  req.data)
            this.token2 = req.data.access_token

          })
          .catch(error => {
            console.log(error)
          })
    },
    getVATInformation(access_token  , vrn)
    {
      const formData = new URLSearchParams()
      formData.append("accessToken" , this.token2)
      formData.append("vrn" , this.User.vrn)
      console.log("formData" , formData)

      this.$axios.get("http://121.40.119.233:8081/hmrc/getVATInformation" , {params:{"accessToken" : this.token2, "vrn" : this.User.vrn}})
          .then(req => {
            this.VATInformation = req.data
            console.log(req.data)

            this.isshowVATInformationDialog = true

          })
          .catch(error  => {
            console.log(error)
          })
    },
    getVATObligations()
    {
      this.$axios.get("http://121.40.119.233:8081/hmrc/getVATObligations" , {params:{"accessToken" : this.token2, "vrn" : this.User.vrn}})
          .then(req => {
            console.log(req.data)
          })
          .catch(error => {
            console.log(error)
          })
    },
    submitVATreturns()
    {
      const formData = new FormData()
      formData.append("accessToken" , this.token2)
      formData.append("vrn" , this.User.vrn )
      console.log("accessToken" , this.token2)
      console.log("vrn" , this.User.vrn)
      this.$axios.post("http://121.40.119.233:8081/hmrc/submitVATReturns" , {accessToken : this.token2 , vrn : this.User.vrn})
          .then(req => {
            this.VATreturns = req.data
            this.isshowVATreturnsDialog = true
            console.log("submitVATreturns" , req.data)
          })
          .catch(error => {
            console.log(error)
          })


    }
  }
}



</script>



<style>



</style>