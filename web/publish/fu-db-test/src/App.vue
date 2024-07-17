<script setup lang="ts">

import FuDB from '@weijunfu/fu-db'
import { onMounted, version } from 'vue';

onMounted(async () => {
  const dbName = 'fu-db'
  const storeName = 'user'

  // FuDB.deleteDatabase(dbName)

  // await FuDB.createStore(
  //     dbName,
  //     1,
  //     [
  //       { 
  //         storeName: storeName, 
  //         storeOption: { keyPath: 'uid', autoIncrement: true }, 
  //         indexOption: [
  //           { indexName: "name", indexOption: { unique: true } },
  //           { indexName: "age", indexOption: { unique: false } },
  //           { indexName: "gender", indexOption: { unique: false } }
  //         ] 
  //       }
  //     ]
  // ).then((res) => console.log(res)).catch(err => console.error(err))

  let version = 0
  await FuDB.getVersion(dbName).then(async (res) => {
    version = res.data
  })

  console.log(version)

  const db = new FuDB(dbName, storeName, version);
  
  await db.init()

  // db.addBatch([
  //   {uid: 1, name: '张三', age: 6, birthday: '2012-09-28', gender: 1},
  //   {uid: 2, name: '李四', age: 10, birthday: '2010-09-28', gender: 0 },
  //   {uid: 3, name: '王五', age: 18, birthday: '2014-01-28', gender: 1},
  //   {uid: 4, name: '赵六', age: 12, birthday: '2016-05-02', gender: 1}
  // ])

  await db.queryByIndex('name', '王五').then(res => console.log(res)).catch(err=>console.error(err))

  await db.queryByRang('age', 10, 20).then(res => console.log(res)).catch(err=>console.error(err))

  await db.queryByCondition('gender', 1, 'name', '王五').then(res => console.log(res)).catch(err=>console.error(err))

  db.close()
})

</script>

<template>
  <header>
    <h1>fu-db-test</h1>
  </header>
</template>

<style scoped>

</style>
