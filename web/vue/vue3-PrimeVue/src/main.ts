import './assets/main.scss'

// PrimeVue 相关
import PrimeVue from 'primevue/config'
import ToastService from 'primevue/toastservice'

import 'primevue/resources/themes/saga-purple/theme.css' // theme
import 'primevue/resources/primevue.min.css' // core
import 'primeicons/primeicons.css' // icon

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(PrimeVue).use(ToastService)

app.use(router)

app.mount('#app')
