export class IDBStore {
    private dbName: string
    private version: number
    private db: null

    constructor(dbName, version) {
        this.dbName = dbName
        this.version = version
        this.db = null
    }

    async init() {
        const that = this
        return new Promise((resolve:any, reject:any) => {
            // Step 1 创建请求
            let request:IDBOpenDBRequest = indexedDB.open(that.dbName, that.version)

            request.onerror = (event: Event) => reject(event.target?.error)

            request.onsuccess = (event:Event) => {
                that.db = event.target?.result
                resolve()
            }

            request.onupgradeneeded = event => that.db = event.target?.result
        })
    }

    async createObjectStore(storeName: String, options: Object) {

        if(!this.db.objectStoreNames.contains(storeName)) {
            const that = this
            
            return new Promise((resolve, reject) => {
                try {
                    if(that.db) {
                        that.db.createObjectStore(storeName, options)
                    }
                    resolve()
                } catch(error) {
                    reject(error)
                }
            })
        }
    }

    async add(storeName: String, item: Object) {

    }

    async get(storeName: String, key: String) {

    }

    async update(storeName: String, item: Object) {

    }

    async delete(storeName: String, key: String) {

    }

    async list(storeName: String) {

    }
}