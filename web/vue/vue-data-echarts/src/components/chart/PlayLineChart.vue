<script setup lang="ts">
import Chart from './Chart.vue';
import EChart from './EChart.vue';

import random from '@/utils/random';

const playData = [
    random(100),
    random(100),
    random(100),
    random(100),
    random(100),
    random(100),
    random(100),
]

const forwordData = [
    random(100),
    random(100),
    random(100),
    random(100),
    random(100),
    random(100),
    random(100),
]

const options = {
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'cross',
      label: {
        backgroundColor: 'blue'
      }
    }
  },
  xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
    axisLine: {
      show: true,
      lineStyle: {
        color: '#f0f0f0'
      }
    },
    axisLabel: {
      color: '#f0f0f0'
    }
  },
  yAxis: {
    type: 'value',
    axisLine: {
      show: true,
      lineStyle: {
        color: '#f0f0f0'
      }
    },
    axisTick: {
      show: true
    },
    splitLine: {  // 分割线
      show: true,  // 不展示分割线
      lineStyle: {
        color: 'rgba(255, 255, 255, .2)',
      }
    },
  },
  series: [
    {
      name: '播放量',
      type: 'line',
      data: playData,
      smooth: true, // 折线是否平滑
      showSymbol: true,
      symbol: 'circle',
      symbolSize: 6,
      lineStyle: {
        color: '#5470C6',
        width: 1,
        // type: 'dashed'
      },
      itemStyle: {
        borderWidth: 3,
        borderColor: '#EE6666',
        color: 'yellow'
      },
      areaStyle: {
        color: {
          type: 'linear',
          x: 0,
          y: 0,
          x2: 0,
          y2: 1,
          colorStops: [{
            offset: 0, color: 'rgba(255, 120, 0, 0.5)' // 0% 处的颜色
          }, {
            offset: 0.7, color: 'rgba(255, 120, 0, 0)' // 100% 处的颜色
          }],
          global: false // 缺省为 false
        }
      }
    },{
      name: '转发量',
      type: 'line',
      data: forwordData,
      smooth: true, // 折线是否平滑
      showSymbol: true,
      symbol: 'triangle',
      symbolSize: 6,
      lineStyle: {
        color: '#EE6666',
        width: 1,
        // type: 'dashed'
      },
      itemStyle: {
        borderWidth: 3,
        borderColor: '#5470C6',
        color: 'yellow'
      },
      areaStyle: {
        color: {
          type: 'linear',
          x: 0,
          y: 0,
          x2: 0,
          y2: 1,
          colorStops: [{
            offset: 0, color: 'rgba(255, 0, 120, 0.5)' // 0% 处的颜色
          }, {
            offset: 0.7, color: 'rgba(255, 0, 120, 0)' // 100% 处的颜色
          }],
          global: false // 缺省为 false
        }
      }
    }
  ]
}

</script>

<template>
<chart title="播放量">
  <EChart :options="options" />
</chart>
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