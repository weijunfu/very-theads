<script setup lang="ts">

import FuDB from '@weijunfu/fu-db'
import { onMounted } from 'vue';

onMounted(async () => {
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

  // await db.add({name: 'wei'})
  // await db.add({name: 'fu'})
  // await db.add({name: 'ijunfu'})
  // await db.add({name: 'lisi'})

  // const data = await db.getAll()
  // console.log(data)

  // const data = await db.queryByIndex('name', 'ijunfu');
  // console.log(data)
  db.deleteDatabase()
  
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
