import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

import FuParticleEffects from 'fu-particle-effects'
app.use(FuParticleEffects)

app.mount('#app')