import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

import CodeRain from 'fu-code-rain'
app.use(CodeRain)

app.mount('#app')
