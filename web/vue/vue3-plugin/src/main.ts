import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

import Button from './plugin/Button'
app.use(Button)

// 引用自定义插件
import FuCustomUI from 'fu-custom-ui'
app.use(FuCustomUI)

app.use(createPinia())
app.use(router)

app.mount('#app')
