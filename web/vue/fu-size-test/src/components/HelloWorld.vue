<script setup lang="ts">

import { ref } from 'vue'

import FuNumeralIncr from './FuNumeralIncr.vue'


const author = ref('ijunfu')

defineProps<{
  msg: string
}>()
</script>

<template>
  <div class="greetings">
    <h1 class="green">{{ msg }}</h1>
    <fu-button-flowing :text="author" />
    <fu-numeral-incr :count="200" />
    <fu-numeral-incr :count="400" unit="$" />
  </div>
</template>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
