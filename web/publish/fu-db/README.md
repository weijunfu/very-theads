# fu-db
> 基于IndexedDB进行封装的简易库

## Install 安装
```
npm install @weijunfu/fu-db@latest
// or
yarn add @weijunfu/fu-db@latest
// or
pnpm install @weijunfu/fu-db@latest
```

## Use 使用

```
import FuDB from '@weijunfu/fu-db'
```

### 创建数据库、表和索引
```
const db = new FuDB('fu-db', "table1")
await db.init({
    storeOptions: {
        keyPath: 'id',
        autoIncrement: true
    },
    index: [
        { indexName: "name", indexOption: { unique: false } }
    ]
}).then(res => console.log('db init', res)).catch(err => console.error('db init', err));
db.close()
```

### 多个索引
```
const db = new FuDB('fu-db', "user")
await db.init({
    storeOptions: {
        keyPath: 'id',
        autoIncrement: true
    },
    index: [
        { indexName: "name", indexOption: { unique: false } },
        { indexName: "email", indexOption: { unique: false } }
    ]
}).then(res => console.log('db init', res)).catch(err => console.error('db init', err));
db.close()
```

### 添加数据
```
db.add({
    name: 'ijunfu', 
    email: 'ijunfu@163.com', 
    age: Math.floor(Math.random()*100), 
    gender: Math.random() < 0.5 ? 1 : 0
})
```

### 批量添加数据
```
await db.addBatch([
    { name: 'ijunfu', email: 'ijunfu@163.com', age: 18, gender: 1 },
    { name: 'wei', email: 'ijunfu@qq.com', age: 16, gender: 1 },
    { name: 'junfu', email: 'ijunfv@gmail.com', age: 20, gender: 0 }
])
```

### 根据id获取数据
```
const user = await db.get(1)
```

### 修改数据
```
await db.update({
    id: 1,
    name: 'weiijunfu', 
    email: 'ijunfu@qq.com', 
    age: Math.floor(Math.random()*100), 
    gender: Math.random() < 0.5 ? 1 : 0
})
```

### 删除数据
```
await db.delete(1)
```

### 获取所有数据
```
const data = await db.getAll()
```

### 根据索引查询数据
```
const data = await db.queryByIndex('name', 'ijunfu');
```

### 获取版本信息
> 获取数据库版本信息
> 若数据库不存在，则创建数据库，返回版本号为1
> 若数据库存在，则直接返回当前版本号
```
await FuDB.getVersion('fu-db').then(res => console.log('db version', res)).catch(err => console.error('db version', err));
```

### 删除数据库
> 根据数据库名称删除指定数据库
```
FuDB.deleteDatabase('fu-db')
```

### 删除存储
```
await FuDB.deleteStore('fu-db', 'user', 2)
```

### 批量创建存储
```
await FuDB.createStore(
    'fu-db',
    1,
    [
        { storeName: 'user', storeOption: { keyPath: 'uid', autoIncrement: true }, indexOption: [{ indexName: "name", indexOption: { unique: false } }] },
        { storeName: 'role', storeOption: { keyPath: 'rid', autoIncrement: true }, indexOption: [{ indexName: "name", indexOption: { unique: false } }] },
        { storeName: 'menu', storeOption: { keyPath: 'mid', autoIncrement: true }, indexOption: [{ indexName: "name", indexOption: { unique: false } }] }
    ]
)
```

若基于上述再创建存储`dept`, 数据库版本应该变为`2`
```
await FuDB.createStore(
    'fu-db',
    2,
    [
        { storeName: 'dept', storeOption: { keyPath: 'dept_id', autoIncrement: true }, indexOption: [{ indexName: "name", indexOption: { unique: false } }] },
    ]
)
```