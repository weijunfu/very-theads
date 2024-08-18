
const DB_NAME = 'demo_ijunfu'

const request = indexedDB.open(DB_NAME, 2)

request.onerror = (event) => {
    console.error('indexed db error', event)
}

request.onupgradeneeded = (event) => {
    const db = event.target.result

    const userStore = db.createObjectStore('user', { keyPath: 'user' })

    userStore.createIndex('name', 'name', { unique: true })
    userStore.createIndex('email', 'email', { unique: true })

    userStore.transaction.oncomplete = (event) => {
        // 将数据保存到新创建的对象存储中
        const store = db.transaction('user', 'readwrite')
            .objectStore('user');

        store.forEach((user) => {
            
        })
    }
}

