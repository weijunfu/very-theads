import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

import FuTask from 'fu-task'
app.use(FuTask)

app.mount('#app')
