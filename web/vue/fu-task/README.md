
# fu-task

> [Vue Plugin] 并发任务

## Install 安装
```
npm install fu-task
// or
yarn add fu-task
// or
pnpm install fu-task
```

## Use 使用

```
import FuTask from 'fu-task'
app.use(FuTask)
```

## 示例

```
import { getCurrentInstance } from 'vue'

const app = getCurrentInstance()

const Task = app.appContext.config.globalProperties.$Task

// 模拟业务方法
const timeout = (time: number) => new Promise((resolve) => setTimeout(resolve, time))

// 创建 Task实例
const task = new Task(2)

const addTask = async (time: number, name: number) => {
await task.add(() => timeout(time)).then(() => console.log(`任务${name}已完成`))
}

// 添加任务
addTask(10000, 1) // 10后执行
addTask(5000, 2) // 5s后执行
addTask(3000, 3) // 8s后执行
addTask(4000, 4) // 12s后执行
addTask(5000, 5) // 15s后执行
```
