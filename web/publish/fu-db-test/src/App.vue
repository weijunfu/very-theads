<script setup lang="ts">

import FuDB from '@weijunfu/fu-db'
import { onMounted, version } from 'vue';

onMounted(async () => {
  const dbName = 'fu-db'
  const storeName = 'user'

  FuDB.getVersion(dbName).then(res => {
    const version = res.data

    console.log(version)

    FuDB.deleteStore(dbName, storeName, version+1)
    .then(res => console.log('delete store', res))
    .catch(err => console.log('delete store', err))
  })
})

</script>

<template>
  <header>
    <h1>fu-db-test</h1>
  </header>
</template>

<style scoped>

</style>
