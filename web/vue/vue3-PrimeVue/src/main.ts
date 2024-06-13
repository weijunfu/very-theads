import './assets/main.css'

// PrimeVue 相关
import PrimeVue from 'primevue/config'
import 'primevue/resources/themes/saga-purple/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(PrimeVue)

app.use(router)

app.mount('#app')
