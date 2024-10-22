<script setup lang="ts">

import Chart from './Chart.vue';
import EChart from './EChart.vue';

import random from '@/utils/random'

const data = []
for(let i=1; i<13; i++) {
  data.push({ name: `${i}月`, fans: random(600), visitors: random(600)})
}

const xAxisData = data.map((v) => v.name)
const seriesFansData = data.map((v) => v.fans)
const seriesVisitorsData = data.map((v) => v.visitors)

const options = {
  // title: {
  //   text: 'Temperature Change in the Coming Week'
  // },
  // tooltip: {
  //   trigger: 'axis',
  //   axisPointer: {
  //     type: 'cross',
  //     label: {
  //       backgroundColor: '#6a7985'
  //     }
  //   }
  // },
  legend: {
    top: 'top',
    right: '10px',
    textStyle: {
      color: '#fff'
    }
  },
  toolbox: {
    show: false,
    // feature: {
    //   dataZoom: {
    //     yAxisIndex: 'none'
    //   },
    //   dataView: { readOnly: false },
    //   magicType: { type: ['line', 'bar'] },
    //   restore: {},
    //   saveAsImage: {}
    // }
  },
  xAxis: {
    type: 'category',
    boundaryGap: false,
    data: xAxisData,
    axisLine: {
      lineStyle: {
        color: 'rgba(255,255,255,.4)'
      }
    }
  },
  yAxis: {
    type: 'value',
    axisLabel: {
      formatter: '{value}'
    },
    axisLine: {
      lineStyle: {
        color: 'rgba(255,255,255,.4)'
      }
    },
    splitLine: {
      lineStyle: {
        color: 'rgba(255, 255, 255, .2)'
      }
    }
  },
  series: [
    {
      name: '新增粉丝',
      type: 'line',
      smooth: true, // 折线是否平滑
      data: seriesFansData,
    },
    {
      name: '新增游客',
      type: 'line',
      smooth: true, // 折线是否平滑
      data: seriesVisitorsData,
    }
  ]
}

</script>

<template>
<chart title="人员变化">
  <EChart :options="options" />
</chart>
</template>

<style scoped lang="scss">

</style>