<template>
<svg :class="svgClass" aria-hidden="true" fill="currentColor">
    <use :xlink:href="iconName" :fill="color"></use>
</svg>
</template>
<script setup lang="ts">
import { computed } from 'vue'

const props = defineProps({
    iconClass: {
        type: String,
        required: true
    },
    color: {
        type: String,
        required: false,
        default: '#222'
    }
})

const svgClass = computed(() => `icon-svg ${props.iconClass}`)
const iconName = computed(() => `#${props.iconClass}`)

</script>
<style scoped lang="scss">
.icon-svg {
    width: 1em;
    height: 1em;
    overflow: hidden;
}
</style>