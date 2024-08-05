import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

import FuSize from 'fu-size'
app.directive('fu-size', FuSize)

app.mount('#app')
