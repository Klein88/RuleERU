<template>
  <div style="width: 800px; margin: 0 auto; background-color: white;
                    border-radius: 5px; box-shadow: 0 0 10px #ccc">
    <div style="text-align: center; line-height: 50px;">
      在线客服
    </div>
    <div style="height: 350px; overflow:auto; border-top: 1px solid #ccc" v-html="content"></div>
    <div style="height: 200px">
            <textarea v-model="text" style="height: 160px; width: 100%; padding: 20px; border: none; border-top: 1px solid #ccc;
             border-bottom: 1px solid #ccc; outline: none"></textarea>
<!--      <el-select v-model="text" placeholder="请问您想咨询什么？" style="width: 700px">-->
<!--        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>-->
<!--      </el-select>-->
      <div style="text-align: right; padding-right: 10px">
        <el-button type="primary" size="mini" @click="send">发送</el-button>
      </div>
    </div>
  </div>
</template>

<script>
let socket;
export default {
  name: "Im",
  data() {
    return {
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      user: {},
      isCollapse: false,
      users: [],
      chatUser: '',
      text: "",
      options:[
        {
          label:'你好',
          value:'你好'
        },
        {
          label: '你能帮助我税务申报吗',
          value: '你能帮助我税务申报吗'
        }
      ],
      messages: [],
      content: ''
    }
  },
  // created() {
  //   this.init()
  // },
  methods: {
    send() {
      // if (!this.chatUser) {
      //   this.$message({type: 'warning', message: "请选择聊天对象"})
      //   return;
      // }
      if (!this.text) {
        this.$message({type: 'warning', message: "请输入内容"})
      } else {
        if (typeof (WebSocket) == "undefined") {
          console.log("您的浏览器不支持WebSocket");
        } else {
          console.log("您的浏览器支持WebSocket");
          // 组装待发送的消息 json
          // {"from": "zhang", "to": "admin", "text": "聊天文本"}
          // let message = {from: this.user.username, to: this.chatUser, text: this.text}
          // socket.send(JSON.stringify(message));  // 将组装好的json发送给服务端，由服务端进行转发
          this.messages.push({user: this.user.username, text: this.text})
          // 构建消息内容，本人消息
          this.createContent(this.text)
          if (this.text == '你好'){
            setTimeout(()=>{
              this.createContent2('我是欧盟合规总服平台机器人，我可以帮助您了解和遵守税务合规、隐私保护、消费者权益和环境保护的相关法规。')
            },1500)
          } else if (this.text == '你能帮助我税务申报吗'){
            setTimeout(()=>{
              this.createContent2('当然，我可以帮助您了解税务申报的流程。您可以通过我们的在线系统提交您的税务表格，并且我们提供实时帮助来确保您遵守所有相关法规。')
            },1500)
          } else if (this.text == '请问如何进行VAT申报'){
            setTimeout(()=>{
              this.createContent2('(1)了解税法规定： 在进行VAT申报之前，首先了解所在国或地区的相关税法规定。这包括了解税率、适用范围、减免政策等信息。<br>\n' +
                  '(2)注册VAT： 在许多国家，企业需要在税务机关注册VAT。注册后，将被分配一个VAT号码，这是在报告和缴纳税款时使用的唯一标识符。<br>\n' +
                  '(3)收集销售和购买发票： 企业在销售产品或提供服务时需要向客户提供发票，同时在购买产品或服务时需收到供应商提供的发票。这些发票是VAT申报的重要依据。<br>\n' +
                  '(4)计算VAT： 根据所在地的税率，计算销售额和购买额的VAT。一般而言，应税销售额减去应税购买额即为应缴纳的增值税额。<br>\n' +
                  '(5)填写申报表： 根据税务机关提供的VAT申报表格，填写相关信息，包括销售、购买、减免等数据。<br>\n' +
                  '(6)提交申报： 将填写完整的VAT申报表格提交给税务机关。有些地方采用电子申报系统，有些则需要纸质申报。<br>\n' +
                  '(7)缴纳税款： 根据VAT申报的结果，及时缴纳应交的增值税款项。确保按时足额地缴纳税款，以避免罚款和其他法律责任。<br>\n' +
                  '(8)保留记录： 维护详细的财务记录，包括销售发票、购买发票、VAT申报表等，以备税务机关的审查和核实。')
            },1500)
          } else if (this.text == '请告诉我欧洲的GDPR法规中需要注意什么'){
            setTimeout(()=>{
              this.createContent2('(1)数据主体的权利： GDPR赋予数据主体（个人数据所属的个人）一系列权利，包括访问其个人数据、更正不准确的数据、删除数据（被称为“被遗忘权”）、限制处理等。<br>\n' +
                  '(2)透明度和法律基础： 处理个人数据时，必须明确目的，并且必须有法律基础。法律基础可以是数据主体同意、履行合同、法定义务、保护生命利益、履行公共任务、合法利益等。<br>\n' +
                  '(3)数据保护官（DPO）： 一些组织可能需要任命数据保护官，特别是那些大规模处理特殊类别的个人数据或监视大量数据主体行为的组织。<br>\n' +
                  '(4)数据安全： 组织必须采取适当的技术和组织措施，确保个人数据的安全性。这包括数据加密、访问控制、安全培训等。<br>\n' +
                  '(5)数据移植性： 数据主体有权要求其个人数据在不同服务提供商之间传输。<br>\n' +
                  '(6)违规通知： 在发生数据泄露或侵犯个人数据安全的情况下，组织必须在72小时内向监管机构报告，除非存在例外情况。<br>\n' +
                  '(7)合规影响评估（DPIA）： 在进行可能对个人数据造成高风险的数据处理操作之前，可能需要进行合规影响评估。<br>\n' +
                  '(8)跨境数据传输： 跨境传输个人数据时，组织需要确保目标国家或地区的数据保护水平适当。<br>\n' +
                  '(9)罚款： GDPR规定了严格的罚款制度，违反规定的组织可能面临高额罚款，最高可达全球年度营业额的4%或2000万欧元中的较高者。')
            },1500)
          }
          this.text = '';
        }
      }
    },
    createContent2(text){
      let html
      html = "<div class=\"el-row\" style=\"padding: 5px 0\">\n" +
          "  <div class=\"el-col el-col-2\" style=\"text-align: right\">\n" +
          "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px; line-height: 40px;\">\n" +
          "    <img src=\"https://seopic.699pic.com/photo_origin/40096/1017.png%21bd800\" style=\"object-fit: cover;\">\n" +
          "  </span>\n" +
          "  </div>\n" +
          "  <div class=\"el-col el-col-22\" style=\"text-align: left; padding-left: 10px\">\n" +
          "    <div class=\"tip right\" style='width: 350px'>" + text + "</div>\n" +
          "  </div>\n" +
          "</div>";
      console.log(html)
      this.content += html;
    },
    createContent(text) {  // 这个方法是用来将 json的聊天消息数据转换成 html的。
      let html
      html = "<div class=\"el-row\" style=\"padding: 5px 0\">\n" +
          "  <div class=\"el-col el-col-22\" style=\"text-align: right; padding-right: 10px\">\n" +
          "    <div class=\"tip left\">" + text + "</div>\n" +
          "  </div>\n" +
          "  <div class=\"el-col el-col-2\">\n" +
          "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px; line-height: 40px;\">\n" +
          "    <img src=\"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png\" style=\"object-fit: cover;\">\n" +
          "  </span>\n" +
          "  </div>\n" +
          "</div>";
      // 当前用户消息
      // if (nowUser) { // nowUser 表示是否显示当前用户发送的聊天消息，绿色气泡
      //   html = "<div class=\"el-row\" style=\"padding: 5px 0\">\n" +
      //       "  <div class=\"el-col el-col-22\" style=\"text-align: right; padding-right: 10px\">\n" +
      //       "    <div class=\"tip left\">" + text + "</div>\n" +
      //       "  </div>\n" +
      //       "  <div class=\"el-col el-col-2\">\n" +
      //       "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px; line-height: 40px;\">\n" +
      //       "    <img src=\"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png\" style=\"object-fit: cover;\">\n" +
      //       "  </span>\n" +
      //       "  </div>\n" +
      //       "</div>";
      // } else if (remoteUser) {   // remoteUser表示远程用户聊天消息，蓝色的气泡
      //   html = "<div class=\"el-row\" style=\"padding: 5px 0\">\n" +
      //       "  <div class=\"el-col el-col-2\" style=\"text-align: right\">\n" +
      //       "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px; line-height: 40px;\">\n" +
      //       "    <img src=\"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png\" style=\"object-fit: cover;\">\n" +
      //       "  </span>\n" +
      //       "  </div>\n" +
      //       "  <div class=\"el-col el-col-22\" style=\"text-align: left; padding-left: 10px\">\n" +
      //       "    <div class=\"tip right\">" + text + "</div>\n" +
      //       "  </div>\n" +
      //       "</div>";
      // }
      console.log(html)
      this.content += html;
    },
    // init() {
    //   this.user = localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    //   let username = this.user.username;
    //   let _this = this;
    //   if (typeof (WebSocket) == "undefined") {
    //     console.log("您的浏览器不支持WebSocket");
    //   } else {
    //     console.log("您的浏览器支持WebSocket");
    //     let socketUrl = "ws://localhost:9090/imserver/" + username;
    //     if (socket != null) {
    //       socket.close();
    //       socket = null;
    //     }
    //     // 开启一个websocket服务
    //     socket = new WebSocket(socketUrl);
    //     //打开事件
    //     socket.onopen = function () {
    //       console.log("websocket已打开");
    //     };
    //     //  浏览器端收消息，获得从服务端发送过来的文本消息
    //     socket.onmessage = function (msg) {
    //       console.log("收到数据====" + msg.data)
    //       let data = JSON.parse(msg.data)  // 对收到的json数据进行解析， 类似这样的： {"users": [{"username": "zhang"},{ "username": "admin"}]}
    //       if (data.users) {  // 获取在线人员信息
    //         _this.users = data.users.filter(user => user.username !== username)  // 获取当前连接的所有用户信息，并且排除自身，自己不会出现在自己的聊天列表里
    //       } else {
    //         // 如果服务器端发送过来的json数据 不包含 users 这个key，那么发送过来的就是聊天文本json数据
    //         //  // {"from": "zhang", "text": "hello"}
    //         if (data.from === _this.chatUser) {
    //           _this.messages.push(data)
    //           // 构建消息内容
    //           _this.createContent(data.from, null, data.text)
    //         }
    //       }
    //     };
    //     //关闭事件
    //     socket.onclose = function () {
    //       console.log("websocket已关闭");
    //     };
    //     //发生了错误事件
    //     socket.onerror = function () {
    //       console.log("websocket发生了错误");
    //     }
    //   }
    // }
  }
}
</script>

<!--<template>-->
<!--  <div class="chat">-->
<!--    <div class="list-pane">-->
<!--      <div class="user-pane">-->
<!--        <div class="user-count">-->
<!--          <h2>当前在线人数：{{ userCount }}</h2>-->
<!--        </div>-->
<!--        <div class="user-list">-->
<!--          <div class="user" v-for="user in userList" :key="user">-->
<!--            <el-image-->
<!--                class="user-img"-->
<!--                :src="require('../../assets/user.png')"-->
<!--            ></el-image>-->
<!--            <p class="username">{{ user }}</p>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--    <div class="chat-pane">-->
<!--      <div class="chat-header">-->
<!--        <h2>EZ-Chat - {{ nickname }}</h2>-->
<!--      </div>-->
<!--      <div class="chat-message" ref="chatHistory">-->
<!--        <div class="user-message" v-for="message in messages" :key="message">-->
<!--          <div class="img">-->
<!--            <el-image-->
<!--                class="user-img"-->
<!--                :src="require('../../assets/user.png')"-->
<!--            ></el-image>-->
<!--          </div>-->
<!--          <div class="message">-->
<!--            <div class="username">-->
<!--              {{ message.name }} <span class="time">{{ message.time }}</span>-->
<!--            </div>-->
<!--            <div class="text user-text" v-if="nickname === message.name">-->
<!--              {{ message.msg }}-->
<!--            </div>-->
<!--            <div class="text" v-if="nickname !== message.name">-->
<!--              {{ message.msg }}-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--      <div class="chat-textarea">-->
<!--        <el-input-->
<!--            v-model="text"-->
<!--            class="user-textarea"-->
<!--            type="textarea"-->
<!--            resize="none"-->
<!--            @keydown.enter="sendButton"-->
<!--        ></el-input>-->
<!--        <el-button type="primary" class="send-button" @click="sendButton"-->
<!--        >发送</el-button-->
<!--        >-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script lang="ts" setup>-->
<!--import { ref, onActivated } from "vue";-->
<!--import router from "@/router";-->

<!--let nickname = ref();-->
<!--let socket: WebSocket;-->

<!--onActivated(() => {-->
<!--  nickname.value = sessionStorage.getItem("name");-->
<!--  // 查询是否设置了昵称-->
<!--  if (nickname.value == null) {-->
<!--    router.push("/");-->
<!--    return;-->
<!--  }-->

<!--  // 查询浏览器是否支持 WebSocket-->
<!--  if (typeof WebSocket == "undefined") {-->
<!--    alert("您的浏览器不支持 WebSocket");-->
<!--    router.push("/");-->
<!--    return;-->
<!--  }-->

<!--  // 开启 WebSocket 服务-->
<!--  let socketHost = "localhost";-->
<!--  let socketPort = "8888";-->
<!--  let socketUrl =-->
<!--      "ws://" + socketHost + ":" + socketPort + "/socket/" + nickname.value;-->
<!--  socket = new WebSocket(socketUrl);-->

<!--  // 连接服务器-->
<!--  socket.onopen = () => {-->
<!--    console.log("已连接至服务器");-->
<!--  };-->

<!--  // 浏览器接收服务端发送的消息-->
<!--  socket.onmessage = (msg) => {-->
<!--    let data = JSON.parse(msg.data);-->
<!--    if (data.userlist) {-->
<!--      // 接收用户列表消息-->
<!--      userList.value = data.userlist;-->
<!--      userCount.value = data.userlist.length;-->
<!--    } else {-->
<!--      // 接收消息-->
<!--      messages.value.push(data);-->

<!--      // 获取节点-->
<!--      let chatHistory = document.getElementsByClassName("chat-message")[0];-->
<!--      if (chatHistory.scrollHeight >= chatHistory.clientHeight) {-->
<!--        setTimeout(function () {-->
<!--          //设置滚动条到最底部-->
<!--          chatHistory.scrollTop = chatHistory.scrollHeight;-->
<!--        }, 0);-->
<!--      }-->
<!--    }-->
<!--  };-->
<!--  // 关闭服务-->
<!--  socket.onclose = () => {-->
<!--    console.log("WebSocket 服务已关闭");-->
<!--  };-->
<!--  // 错误事件-->
<!--  socket.onerror = () => {-->
<!--    console.log("WebSocket 服务发生错误");-->
<!--  };-->
<!--});-->

<!--// 日期转换-->
<!--const formatTime = (date: Date) => {-->
<!--  const year = date.getFullYear();-->
<!--  const month = date.getMonth() + 1;-->
<!--  const day = date.getDate();-->
<!--  const hour = date.getHours();-->
<!--  const minute = date.getMinutes();-->
<!--  const second = date.getSeconds();-->

<!--  return (-->
<!--      [year, month, day].map(formatNumber).join("-") +-->
<!--      " " +-->
<!--      [hour, minute, second].map(formatNumber).join(":")-->
<!--  );-->
<!--};-->
<!--const formatNumber = (n: number) => {-->
<!--  const s = n.toString();-->
<!--  return s[1] ? s : "0" + s;-->
<!--};-->

<!--// 用户数量-->
<!--let userCount = ref(0);-->

<!--// 用户列表-->
<!--let userList = ref([]);-->

<!--// 信息框-->
<!--let text = ref("");-->

<!--// 信息列表-->
<!--let messages = ref([]);-->

<!--// 信息-->
<!--let message = {-->
<!--  name: "",-->
<!--  time: "",-->
<!--  msg: "",-->
<!--};-->

<!--// 发送信息-->
<!--const sendButton = (event: { preventDefault: () => void }) => {-->
<!--  event.preventDefault();-->

<!--  if (text.value != null && text.value !== "" && nickname.value != null) {-->
<!--    message.name = nickname.value;-->
<!--    message.time = formatTime(new Date());-->
<!--    message.msg = text.value;-->
<!--    socket.send(JSON.stringify(message));-->
<!--    message.msg = "";-->
<!--    text.value = "";-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style lang="scss">-->
<!--@import "../../assets/chat";-->
<!--</style>-->
