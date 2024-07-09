<script setup lang="ts">
import { ref } from 'vue'
import Inner from './components/Inner.vue'
import Outer from './components/Outer.vue'

const time = ref(1)

</script>

<template>
  <div class="container">
    <h2>嵌套组件传值</h2>

    <Inner v-model="time" />

    <hr />
    
    <Outer v-model="time" />
  </div>
</template>

<style scoped>
</style>
