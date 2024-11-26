import { createApp } from 'vue'
// @ts-ignore
import App from './App.vue'
import router from './router'

import axios from "axios";

// import './assets/index.css'

import './assets/tailwind.css'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import * as echarts from 'echarts'

import Particles from 'particles.vue3'

// @ts-ignore
import Markdown from "vue3-markdown-it";

import "@icon-park/vue-next/styles/index.css";
import "highlight.js/styles/dark.css";

// import './assets/element.scss'
// import './assets/var.css'
// import './assets/tailwind.css'



// import './assets/main.css'

// @ts-ignore
const debounce = (fn, delay) => {
    // @ts-ignore
    let timer = null;
    return function () {
        // @ts-ignore
        let context = this;
        let args = arguments;
        // @ts-ignore
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}

const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
    // @ts-ignore
    constructor(callback) {
        callback = debounce(callback, 16);
        super(callback);
    }
}

const app = createApp(App)
app.use(router)
app.use(Markdown)
app.use(Particles)
app.use(ElementPlus)
app.config.globalProperties.$axios = axios
app.config.globalProperties.$echarts = echarts
app.config.globalProperties.loginPwd = '123456'
app.config.globalProperties.hasLogin = true
app.config.globalProperties.AIBody = {
    model: 'gpt-3.5-turbo',
    Temperatures: 0.8,
    Top_p: 1
}
for (const [key,component] of Object.entries(ElementPlusIconsVue)){
    app.component(key,component)
}
app.mount('#app')
