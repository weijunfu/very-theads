<template>
    <div class="outer">
        外层：{{ modelValue }}

        <Inner v-model="currentValue" />

        <button @click="click">修改值</button>
    </div>
</template>
<script setup lang="ts">

import { computed, ref } from 'vue'

import Inner from './Inner.vue'

const emitLabel = 'update:modelValue'

const emit = defineEmits([emitLabel])

const props = defineProps({
    modelValue: Number
})

const currentValue = computed({
    get: () => props.modelValue,
    set: (val) =>emit(emitLabel, val)
})

const click = () => {
    const time = Date.now()
    console.log('outer click', time)
    emit(emitLabel, time)
}

</script>
<style scoped lang="scss">

</style>