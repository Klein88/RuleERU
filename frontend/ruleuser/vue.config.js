const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,//取消严格模式
  devServer: {
    // 设置主机地址
    host: 'localhost',
    // 设置默认端口
    port: 5173,
    // 设置代理
    // proxy: {
    //   '/api': {
    //     // 目标 API 地址
    //     target: 'http://127.0.0.1:3000/',
    //     // 如果要代理 websockets
    //     ws: false,
    //     // 将主机标头的原点更改为目标URL
    //     changeOrigin: true,
    //     pathRewrite: {
    //       // 路径重写
    //       "/api": "" // 这个意思就是以api开头的，定向到哪里, 如果你的后边还有路径的话， 会自动拼接上
    //     }
    //   }
    // }
  }
})
