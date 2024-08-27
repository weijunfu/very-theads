import { App, Plugin } from 'vue';

import MediaImage5 from './components/MediaImage5.vue'

const FuMediaImage5: Plugin = {
    install: (app: App) => {
        app.component('FuMediaImage5', MediaImage5)
    }
}

export default FuMediaImage5