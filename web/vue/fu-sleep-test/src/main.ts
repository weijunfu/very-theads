import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)

import FuSleep from 'fu-sleep'
app.use(FuSleep)

import FuNumeralIncr from 'fu-numeral-incr'
app.use(FuNumeralIncr)

import MavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
app.use(MavonEditor)

app.use({
  install(app) {
    app.config.globalProperties.$author = () => {
      return 'ijunfu<ijunfu@163.com>'
    }
  }
})

app.mount('#app')
