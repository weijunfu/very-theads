
import FuButton from './component/FuButton/index.vue'
import FuSwiper from './component/FuSwiper/index.vue'

// 组件
const components = { FuButton, FuSwiper }

export default {
    install: (app, options) => {

        // 批量注册组件
        Object.getOwnPropertyNames(components).map((item) => {
            app.component(item, components[item])
        })
    }
}
