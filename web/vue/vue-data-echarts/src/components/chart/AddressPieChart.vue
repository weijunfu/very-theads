<script setup lang="ts">
import Chart from './Chart.vue';
import EChart from './EChart.vue';

const options = {
  legend: {
    show: true,
    top: 'bottom',
    textStyle: {
      color: '#fff'
    }
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  series: [
    {
      name: 'Nightingale Chart',
      type: 'pie',
      radius: [5, 50],   // 设置饼图的半径: 20-内半径 80-外半径
      center: ['50%', '50%'],
      roseType: 'area',
      itemStyle: {
        borderRadius: 8
      },
      data: [
        { value: 40, name: '北京' },
        { value: 38, name: '云南' },
        { value: 32, name: '山东' },
        { value: 30, name: '河北' },
        { value: 28, name: '江苏' },
        { value: 26, name: '浙江' },
        { value: 22, name: '深圳' },
        { value: 18, name: '广东' }
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
}

</script>

<template>
  <Chart title="地区分布">
    <EChart :options="options" />
  </Chart>
</template>

<style scoped lang="scss">

</style>