<script setup lang="ts">

import { ok, fail} from 'fu-response'

console.log(ok(0))

console.log(ok(0, "success"))

console.log(ok(0, {name: 'ijunfu'}))

console.log(ok(0, "success", {author: 'ijunfu'}))

console.log(fail(1))

console.log(fail(1, "err"))

console.log(fail(1, {name: 'ijunfu'}))

console.log(fail(1, "err", {author: 'ijunfu'}))

</script>

<template>
  
</template>

<style scoped>

</style>
