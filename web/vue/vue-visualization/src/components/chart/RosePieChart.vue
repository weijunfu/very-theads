<template>
  <div class="rose-chart-box">
    <div class="title">{{ title }}</div>
    <div ref="roseRef" class="rose-chart"></div>
  </div>

</template>
<script setup lang="ts">
import { ref, onMounted } from 'vue'

import * as echarts from 'echarts';

const roseRef = ref<HTMLElement>()

defineProps({
  title: String,
})

onMounted(() => {
  if(roseRef.value) {
    const myChart = echarts.init(roseRef.value);
    myChart.setOption({
      series: [
        {
          type: 'pie',
          roseType: 'area',
          data: [
            { value: 50, name: '除雪' },
            { value: 38, name: '路基' },
            { value: 22, name: '交通设施' },
            { value: 36, name: '桥通' },
            { value: 28, name: '绿化' },
            { value: 18, name: '日常养护' }
          ],
          label: {
            show: true,
            formatter: '{b} {c}%',
            textStyle: {
              color: '#646cff'
            }
          }
        }
      ]
    })
  }
})
</script>
<style scoped lang="scss">
.rose-chart-box {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  .title {
    height: 20%;
    font-size: 20px;
  }

  .rose-chart {
    height: 80%;
  }
}
</style>