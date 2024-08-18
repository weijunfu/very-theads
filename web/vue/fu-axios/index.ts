
class EventEmitter {

    private listeners: Record<string, Set<Function>>

    constructor() {
        this.listeners = {}
    }

    // 监听事件
   on(eventName: string, listener: Function){
        this.listeners[eventName].add(listener)
   }

   // 触发事件
   emit(eventName: string, ...args: any[]) {
        this.listeners[eventName].forEach((listener) => listener(...args))
   }

   // 移除事件
   off(eventName: string) {
        this.listeners[eventName] && delete this.listeners[eventName]
   }
}

export default new EventEmitter()
