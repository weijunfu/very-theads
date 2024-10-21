import { createApp } from 'vue'
import '@/assets/style/global.scss'
import App from './App.vue'

const app = createApp(App);

import router from '@router/index';
app.use(router);

import DataVVue3 from '@kjgl77/datav-vue3';
app.use(DataVVue3);

app.mount('#app');
