

<template>
<div class="ring-chart-box">
  <div class="ring-title">
    {{ title }}
  </div>
  <div class="ring">
    <dv-charts :option="option" />
  </div>
</div>
</template>

<style scoped lang="scss">
.ring-chart-box {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;

  .ring-title {
    height: 20%;
  }

  .ring {
    height: 80%;
    .chart {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
<script setup lang="ts">
import { ref } from 'vue'

const { title, value } = defineProps({
  title: String,
  value: Number
})

const option = ref({
  series: [
    {
      type: 'gauge',
      startAngle: -Math.PI / 2,
      endAngle: Math.PI * 1.5,
      arcLineWidth: 6,
      data: [
        { name: 'itemA', value: value, gradient: ['#646cff', '#646cff', '#2fded6'] }
      ],
      axisLabel: {
        show: false
      },
      axisTick: {
        show: false
      },
      pointer: {
        show: false
      },
      dataItemStyle: {
        lineCap: 'round'
      },
      details: {
        show: true,
        formatter: '{value}%',
        style: {
          fill: '#646cff',
          fontSize: 20
        }
      }
    }
  ]
})
</script>