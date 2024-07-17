
import { ok, fail } from 'fu-response'

interface FuDBOptions {
    storeOptions: object,
    index: Array<IndexOption>
}

interface StoreOption {
    storeName: string
    storeOption: object
    indexOption: Array<IndexOption>
}

interface IndexOption {
    indexName: string
    indexOption: object
}

export default class FuDB {
    dbName: string
    storeName: string
    version: number
    db: any
    constructor(dbName: string, storeName: string, version: number=1) {

        this.isFalse(dbName, 'dbName cannot be empty')
        
        this.isFalse(storeName, 'storeName cannot be empty')
        
        this.dbName = dbName
        this.storeName = storeName
        this.version = version
        this.db = null
    }

    /**
     * 如果conditions条件为false，则抛出异常
     * @param conditions 条件
     * @param tips 提示信息
     */
    isFalse(conditions: any, tips: string) {
        if(!conditions) {
            throw new Error(tips)
        }
    }

    /**
     * 初始化
     * @param indexName 索引名称
     * @param unique 是否为唯一索引
     * @returns 
     */
    init() {
        return new Promise((resolve, reject) => {
            // 创建数据库
            const request = indexedDB.open(this.dbName, this.version)

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
     * 校验DB
     * @param reject 
     */
    checkDB(reject) {
        if(!this.db) {
            reject(fail(1, 'not initialized!'))
        }
    }

    /**
     * 插入数据
     * @param data 数据
     * @returns 
     */
    add(data) {
        return new Promise((resolve, reject)  => {
            this.checkDB(reject)

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

    addBatch(data) {
        return new Promise((resolve, reject)  => {
            this.checkDB(reject)

            if(!Array.isArray(data)) {
                reject(fail(1, '参数格式错误'))
            }

            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)

            data.forEach(item => {
                store.add(item)
            })

            transation.onsuccess = () => {
                resolve(ok(0, "ok"))
            }

            transation.onerror = (event) => {
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
            this.checkDB(reject)

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
            this.checkDB(reject)

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
            this.checkDB(reject)

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
            this.checkDB(reject)

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
     * @param indexName     索引名称
     * @param indexValue    索引列中的值
     * @returns 
     */
    queryByIndex(indexName: string, indexValue: any) {
        return new Promise((resolve, reject) => {
            
            this.checkDB(reject)

            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)
            const index = store.index(indexName)

            const request = index.getAll(indexValue)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 复合查询
     * 1. 先根据索引查询数据
     * 2. 针对查询的数据，再根据属性名和属性值进一步筛选
     * @param indexName     索引名称 
     * @param indexValue    索引列中的值
     * @param attr          属性名
     * @param attrValue     属性值
     * @returns 符合条件的数据集
     */
    queryByCondition(indexName: string, indexValue: any, attr: string, attrValue: any) {
        return new Promise((resolve, reject) => {
            
            this.checkDB(reject)

            const transation = this.db.transaction([this.storeName], 'readwrite')
            const store = transation.objectStore(this.storeName)
            const index = store.index(indexName)

            const request = index.getAll(indexValue)

            request.onsuccess = () => {
                resolve(ok(0, "ok", request.result.filter(e => e[attr] === attrValue)))
            }

            request.onerror = (event) => {
                reject(fail(1, "err", event.target?.error))
            }
        })
    }

    /**
     * 查询指定范围的数据
     * @param indexName 索引名称
     * @param min 最小值
     * @param max 最大值
     * @returns 
     */
    queryByRang(indexName: string, min:number, max: number) {
        return new Promise((resolve, reject) => {
            this.checkDB(reject)

            const store = this.db.transaction([this.storeName], 'readonly')
                .objectStore(this.storeName)
            
            const index = store.index(indexName)
            const range = IDBKeyRange.bound(min, max)

            const request = index.openCursor(range)
            let result = []
            request.onsuccess = (event) => {
                let cursor = event.target.result

                if(cursor) {
                    result.push(cursor.value)

                    cursor.continue()
                } else {
                    resolve(ok(0, result))
                }
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
    static deleteDatabase(dbName: string) {
        if(dbName) {
            indexedDB.deleteDatabase(dbName)
        }
    }

    /**
     * 创建存储和索引
     * @param dbName 数据库名称
     * @param version 版本号
     * @param stores 存储相关配置，包含索引配置
     * @returns code=0 成功 code=1 失败
     */
    static createStore(dbName: string, version: number = 1, stores: Array<StoreOption>) {
        return new Promise((resolve, reject) => {

            if(!dbName) {
                reject(fail(1,'数据库不能为空'))
            }
    
            if(!Array.isArray(stores)) {
                reject(fail(1,'配置内容不能为空'))
            }

            const request = indexedDB.open(dbName, version)

            request.onupgradeneeded = (event) => {
                const db = event.target?.result
    
                stores.forEach(e => {
    
                    const { storeName, storeOption, indexOption } = e
                    
                    if(!storeName) {
                        reject(fail(1,'存储名称不能为空'))
                    }

                    if(!Array.isArray(indexOption)) {
                        reject(fail(1,'索引配置应该为数组'))
                    }
    
                    // 创建 Store, 类似数据库中的表
                    let store
                    if(!db.objectStoreNames.contains(storeName)) {
                        store = db.createObjectStore(storeName, storeOption)
                    } else {
                        store = request.transaction?.objectStore(storeName)
                    }
    
                    // 创建索引
                    indexOption.forEach(index => {
                        const { indexName,  indexOption } = index
    
                        if(indexName && !store.indexNames.contains(indexName)) {
                            store.createIndex(indexName, indexName, { ...indexOption })
                        }
                    })
    
                })
            }
    
            request.onsuccess = () => {
                resolve(ok(0, 'ok'))
            }
    
            request.onerror = (event) => {
                reject(fail(1, 'err', event.target?.error))
            }
        })
    }

    /**
     * 删除存储
     * @param dbName 数据库名称
     * @param storeName 存储名称/表名
     * @param version 版本号
     * @returns 
     */
    static deleteStore(dbName: string, storeName: string, version: number = 1) {
        return new Promise((resolve, reject) => {
            const request = indexedDB.open(dbName, version)

            request.onupgradeneeded = (event) => {
                const db = event.target?.result
                if(db) {
                    db.deleteObjectStore(storeName)
                }
            }

            request.onsuccess = () => {
                resolve(ok(0))
            }

            request.onerror = (event) => {
                reject(fail(1, 'err', event.target?.error));
            }
        })
    }

    /**
     * 获取数据库版本号
     * @param dbName 数据库名称
     * @returns 数据库版本信息
     */
    static getVersion(dbName: string) {

        return new Promise((resolve, reject) => {
            const request  = indexedDB.open(dbName)

            request.onsuccess = (event) => {
                resolve(ok(0, 'ok', event.target?.result.version))
            }

            request.onerror = (event) => {
                reject(fail(1, 'open db error: ' + event.target?.error))
            }
        })

    }
}