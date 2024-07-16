<script setup lang="ts">

import FuDB from '@weijunfu/fu-db'
import { onMounted, version } from 'vue';

onMounted(async () => {
  const db = new FuDB('fu-db', "user", 2)
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

  await db.addBatch([
    { name: 'ijunfu', email: 'ijunfu@163.com', age: 18, gender: 1 },
    { name: 'wei', email: 'ijunfu@qq.com', age: 16, gender: 1 },
    { name: 'junfu', email: 'ijunfv@gmail.com', age: 20, gender: 0 },
  ])
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
