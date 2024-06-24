import CodeRain from './src/CodeRain'

export default {
    install(app) {
        app.config.globalProperties.$CodeRain = CodeRain
    }
}