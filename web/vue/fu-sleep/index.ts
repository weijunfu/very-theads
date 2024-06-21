
const sleep = (ms: number) => new Promise(resolve => setTimeout(resolve, ms))

export default {
    install(app) {
        app.config.globalProperties.$sleep = sleep
    }
}