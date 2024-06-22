
/**
 * 任务类型
 * @author ijunfu
 */
type TaskInfo = {

    /* 任务 */
    task: Function

    /* Promise resolve */
    resolve: any

    /* Promise reject */
    reject: any
}

/**
 * 任务
 * @author ijunfu
 */
export default class Task {

    /* 并发数量 */
    private quantity: number

    /* 任务列表 */
    private taskList: Array<TaskInfo>

    /* 正在运行的任务数量 */
    private runningCount: number

    /* 构造函数 */
    constructor(quantity = 2) {
        this.quantity = quantity
        this.taskList = []
        this.runningCount = 0
    }

    /**
     * 添加任务
     * @param task 待执行任务 
     * @returns Promise
     */
    add(task:Function) {
        return new Promise((resolve, reject) => {
            this.taskList.push({
                task,
                resolve,
                reject
            })

            // 【场景一】添加任务之后，立即执行一次任务；
            this._run()
        })
    }

    /**
     * 运行任务
     * 执行场景：
     * 1. 没有在执行中的任务
     * 2. 任务已执行完成
     */
    _run() {
        // 当正在运行任务数量小于总任务数，并且任务列表中存在任务
        while(this.runningCount < this.quantity && this.taskList.length>0) {
            
            // 抓取任务
            const taskInfo = this.taskList.shift();

            if(taskInfo) {
                
                // 获取任务信息
                const { task, resolve, reject } = taskInfo

                // 执行中任务数+1
                this.runningCount++

                // 执行任务
                Promise.resolve(task())
                        .then(resolve, reject)
                        .finally(() => {
                            // 任务执行完毕后，执行中任务数-1
                            this.runningCount--

                            // 【场景二】 任务执行完毕后，继续执行下一个任务
                            this._run()
                        })
                }
        }
    }
}