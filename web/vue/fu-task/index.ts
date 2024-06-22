import Task from "./src/task"

export default {

    install(app) {
        app.config.globalProperties.$Task = Task
    }

}
