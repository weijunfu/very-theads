import { createApp } from 'vue';

import './assets/style/font.scss';
import './assets/style/global.scss';
import './assets/style/scrollbar.scss';
import './assets/style/layout.scss';

import App from './App.vue';

const app = createApp(App);

// Vue Router
import router from './router';
app.use(router);

import DataVVue3 from '@kjgl77/datav-vue3';
app.use(DataVVue3);

app.mount('#app')
