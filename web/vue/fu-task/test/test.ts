import Task from '../src/task'

const timeout = (time:number) => new Promise((resolve) => {
    setTimeout(resolve, time)
})

const task = new Task(2)

const addTask = async (time:number, name:number) => {
    await task.add(() => timeout(time))
    .then(() => console.log(`任务${name}已完成`))
}

addTask(10000, 1)       // 10后执行
addTask(5000, 2)        // 5s后执行
addTask(3000, 3)        // 8s后执行
addTask(4000, 4)        // 12s后执行
addTask(5000, 5)        // 15s后执行

const execTask = async (func: Function) => {
    await task.add(func)
}

execTask(() => {
    console.log('Hello World!')
})

execTask(() => {
    console.log('My name is ijunfu!')
})