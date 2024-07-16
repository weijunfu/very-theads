<script setup lang="ts">

import FuDB from '@weijunfu/fu-db'
import { onMounted, version } from 'vue';

onMounted(async () => {
    await FuDB.createStore(
      'fu-db',
      2,
      [
        { storeName: 'dept', storeOption: { keyPath: 'dept_id', autoIncrement: true }, indexOption: [{ indexName: "name", indexOption: { unique: false } }] },
      ]
    )
})

</script>

<template>
  <header>
    <h1>fu-db-test</h1>
  </header>
</template>

<style scoped>

</style>
