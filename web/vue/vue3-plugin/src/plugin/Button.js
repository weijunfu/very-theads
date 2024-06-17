
import MyButton from '../components/Button/index.vue'

export default {
    install: (app, options) => {
        app.component('MyButton', MyButton)
    }
}