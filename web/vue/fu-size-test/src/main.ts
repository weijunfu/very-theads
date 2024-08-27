import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
app.use(ElementPlus)

import FuSize from 'fu-size'
app.directive('fu-size', FuSize)

import FuButtonFlowing from 'fu-button-flowing'
app.use(FuButtonFlowing);

import FuMediaImage5 from 'fu-media-image5';
app.use(FuMediaImage5);

app.mount('#app')
