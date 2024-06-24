<script setup lang="ts">
import { ref, onMounted, getCurrentInstance } from 'vue'

const app = getCurrentInstance()

const canvas = ref(null)

onMounted(() => {
  if(canvas.value) {
    const CodeRain = app.appContext.config.globalProperties.$CodeRain
    const codeRain = new CodeRain(canvas.value)
    codeRain.autoDraw(10)
  }
})

</script>

<template>
 <div class="wrapper">
  <canvas ref="canvas"></canvas>
 </div>
</template>

<style scoped>
.wrapper {
  width: 100vw;
  height: 100vh;
}

canvas {
  width: 100%;
  height: 100%;
}

</style>
