import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

import Button from './plugin/Button'
app.use(Button)


app.use(createPinia())
app.use(router)

app.mount('#app')
