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

### 创建数据库和表 1
```
const db = new FuDB('demo', "table1")
await db.init();
db.close()
```

### 创建数据库和表 2
```
const db = new FuDB('demo2', "table2")
await db.init({
    storeOptions: {
        keyPath: 'id',
        autoIncrement: true
    }, 
    indexName: 'name',
    indexOptions: {
        unique: false
    }
});
db.close()
```

### 添加数据
```
db.add({
    name: 'ijunfu', age: Math.floor(Math.random()*100), birthday: '2000-10-12', gender: 0
})
```

### 根据id获取数据
```
const user = await db.get(1)
```

### 修改数据
```
await db.update({
    id: 1, name: 'ijunfu', gender: 1
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

### 删除数据库
```
db.deleteDatabase()
```