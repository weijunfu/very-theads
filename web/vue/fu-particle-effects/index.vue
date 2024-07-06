<template>
    <canvas ref="canvas"></canvas>
</template>
<script setup lang="ts">

import { ref, onMounted } from 'vue'

import Graph from './src/Graph';

const canvas = ref<HTMLCanvasElement>(null)

const resizeCanvas = () => {
    if(canvas.value) {
        const dpr = window.devicePixelRatio || 1
        
        // canvas实际尺寸
        canvas.value.width = window.innerWidth * dpr
        canvas.value.height = window.innerHeight * dpr

        // canvas CSS尺寸
        canvas.value.style.width = window.innerWidth + 'px'
        canvas.value.style.height = window.innerHeight + 'px'

        const context = canvas.value.getContext('2d')
        // 缩放
        context.scale(dpr, dpr)

        new Graph(
            context,
            canvas.value.width,
            canvas.value.height
        ).draw()
    }
}

onMounted(() => {
    resizeCanvas()
})

window.addEventListener('resize', () => {
    resizeCanvas()
})

</script>
<style scoped lang="scss">

</style>