
import FuIcon from './components/Icon/FuIcon.vue'

import { App, Plugin } from 'vue';

const FuIconPlugin: Plugin = {
    install: (app: App) => {
        app.component('FuIcon', FuIcon)
    }
}

export default FuIconPlugin
