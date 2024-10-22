<script setup lang="ts">
import { ref, onMounted } from 'vue';

import * as echarts from 'echarts';

const { options } = defineProps({
  options: Object
})

const chartRef = ref<HTMLElement>();

onMounted(() => {
  if(chartRef.value) {
    const myChart = echarts.init(chartRef.value);
    myChart.setOption(options)
  }
})

</script>

<template>
  <div id="echarts-chart" ref="chartRef" :style="{width: '100%', height: '100%'}"></div>
</template>
