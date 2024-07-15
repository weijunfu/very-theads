
import { ok, fail } from 'fu-response'

interface FuDBOptions {
    storeOptions: object,
    indexName: string
    indexOptions: object
}

export default class FuDB {
    dbName: string
    storeName: string
    version: number
    db: any
    constructor(dbName: string, storeName: string, version: number=1) {
        this.dbName = dbName
        this.storeName = storeName
        this.version = version
        this.db = null
    }

    /**
     * 初始化
     * @param indexName 索引名称
     * @param unique 是否为唯一索引
     * @returns 
     */
    init(
        options: FuDBOptions = {
            storeOptions: {
                keyPath: 'id',
                autoIncrement: true
            }, 
            indexName: '',
            indexOptions: {
                unique: false
            }
        }
    ) {
        return new Promise((resolve, reject) => {
            // 创建数据库
            const request = indexedDB.open(this.dbName, this.version)

            let store;

            request.onupgradeneeded = (event) => {
                this.db = event.target?.result

                const { storeOptions, indexName, indexOptions } = options
                
                // 创建存储，类似后端数据库中的表
                if(!this.db.objectStoreNames.contains(this.storeName)) {
                    store = this.db.createObjectStore(this.storeName, storeOptions);
                } else {
                    store = request.transaction?.objectStore(this.storeName)
                }

                // 创建索引
                if(indexName && !store.indexNames.contains(indexName)) {
                    store.createIndex(indexName, indexName, { indexOptions })
                }
            }

            request.onsuccess = (event) => {
                this.db = event.target?.result
                resolve(ok(0))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 插入数据
     * @param data 数据
     * @returns 
     */
    add(data) {
        return new Promise((resolve, reject)  => {
            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)
            const request = store.add(data)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 获取数据
     * @param keyPath 
     * @returns 
     */
    get(keyPath) {
        return new Promise((resolve, reject) => {
            const transation = this.db.transaction([this.storeName])
            const store = transation.objectStore(this.storeName)
            const request = store.get(keyPath)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 
     * @returns 所有数据
     */
    getAll() {
        return new Promise((resolve, reject) => {
            const transation = this.db.transaction([this.storeName])
            const store = transation.objectStore(this.storeName)
            const request = store.getAll()

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 更新数据
     * @param data 待更新的数据
     * @returns 
     */
    update(data) {
        return new Promise((resolve, reject) => {
            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)
            const request = store.put(data)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 删除数据
     * @param keyPath  
     * @returns 
     */
    delete(keyPath) {
        return new Promise((resolve, reject) => {
            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)
            const request = store.delete(keyPath)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 查询数据
     * @param indexName 
     * @param value 
     * @returns 
     */
    queryByIndex(indexName: string, value: any) {
        return new Promise((resolve, reject) => {
            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)
            const index = store.index(indexName)

            const request = index.getAll(value)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 关闭数据库
     */
    close() {
        if(this.db) {
            this.db.close()
        }
    }

    /**
     * 删除数据库
     */
    deleteDatabase() {
        if(this.dbName) {
            indexedDB.deleteDatabase(this.dbName)
        }
    }
}