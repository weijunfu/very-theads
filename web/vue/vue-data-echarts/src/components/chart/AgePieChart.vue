<script setup lang="ts">
import Chart from './Chart.vue';
import EChart from './EChart.vue';

const options = {
  tooltip: {
    trigger: 'item'
  },
  legend: {
    top: 'bottom',
    left: 'center',
    textStyle: {
      color: '#fff'
    }
  },
  series: [
    {
      name: '年龄',
      type: 'pie',
      radius: ['40%', '70%'],
      avoidLabelOverlap: false,
      label: {
        show: false,
        position: 'center',
        textStyle: {
          color: '#fff',
          fontSize: 12
        }
      },
      emphasis: {
        label: {
          show: false,
          fontSize: 12,
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data: [
        { value: 1048, name: '18岁以下' },
        { value: 735, name: '18-29岁' },
        { value: 580, name: '30-30岁' },
        { value: 484, name: '40-49岁' },
        { value: 300, name: '50岁及以上' }
      ]
    }
  ]
}

</script>

<template>
  <Chart title="年龄分布">
    <EChart :options="options" />
  </Chart>
</template>

<style scoped lang="scss">
.chart-box {
  width: 100%;
  height: 100%;
  .chart-border {
    padding: 10px;
  }
}
</style>