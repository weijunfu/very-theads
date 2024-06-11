import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

// Vant适配桌面端，自动将mouse事件转为touch事件
import '@vant/touch-emulator';

createApp(App).mount('#app')
