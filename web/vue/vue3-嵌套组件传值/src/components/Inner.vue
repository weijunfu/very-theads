<template>
    <div>
        <div>当前值：</div>
        <div>{{ modelValue }}</div>

        <button @click="change">Change</button>
    </div>
</template>
<script setup lang="ts">
import { time } from 'console'
import { ref } from 'vue'

const emitLabel = 'update:modelValue'
const emit = defineEmits([emitLabel])

defineProps({
    modelValue: Number
})

const change = () => {
    let time = Date.now()
    console.log('inner change', time)
    emit(emitLabel, time)
}

</script>
<style scoped lang="scss">

</style>