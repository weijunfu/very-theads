<template>
<svg :class="svgClass" aria-hidden="true">
    <use :xlink:href="iconName"></use>
</svg>
</template>
<script setup lang="ts">
import { computed } from 'vue'

const props = defineProps({
    iconClass: {
        type: String,
        required: true
    }
})

const svgClass = computed(() => `icon-svg ${props.iconClass}`)
const iconName = computed(() => `#${props.iconClass}`)

</script>
<style scoped lang="scss">
.icon-svg {
    width: 1em;
    height: 1em;
    fill: currentColor;
    overflow: hidden;
}
</style>