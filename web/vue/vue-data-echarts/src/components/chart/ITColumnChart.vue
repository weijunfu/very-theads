<script setup lang="ts">
import Chart from './Chart.vue';
import EChart from './EChart.vue';

import random from '@/utils/random'

const airplane = 'path://M999.82 494.522c-6.341-45.7-85.663-66.026-117.68-72.025-20.486-3.844-85.727-5.639-191.327-4.657-6.96-12.16-24.822-43.277-47.34-82.36 11.662-10.475 44.62-40.453 55.886-54.632 20.643-25.983-7.1-38.27-26.347-38.232-19.53399999 0.025-74.447 0-83.19 0-41.183-71.00299999-82.377-141.404-97.99-165.939-35.39-55.61099999-104.158-29.31800001-101.116 0 2.74 26.372 71.706 292.382 85.545 345.574-2.951 0.09-5.732 0.15099999-8.703 0.246-80.854 2.394-149.065 11.654-204.36 22.787-16.957-18.161-72.932-78.323-106.084-115.816-40.314-45.596-62.112-10.208-59.662 5.054 7.03 43.798 34.86 137.783 37.157 145.494-15.28800001 3.801-24.915 9.184-25.00599999 15.181-0.055 0.024-0.102 0.064-0.15400001 0.09 0.052 0.026 0.10599999 0.076 0.156 0.108 0.114 5.988 9.735 11.363 25.005 15.156-2.288 7.698-30.126 101.695-37.157 145.498-2.44999999 15.26 19.348 50.65 59.662 5.056 33.152-37.49699999 89.126-97.658 106.084-115.818 55.295 11.137 123.506 20.395 204.36 22.79 2.971 0.091 5.752 0.153 8.703 0.243-13.839 53.193-82.805 319.204-85.545 345.573-3.042 29.322 65.727 55.613 101.115 0 15.616-24.53099999 56.808-94.933 97.99199999-165.935 8.742 0 63.655-0.027 83.189 0 19.248 0.036 46.99-12.25 26.34700001-38.234-11.267-14.178-44.224-44.153-55.886-54.635a39920.788 39920.788 0 0 0 47.34-82.355c105.6 0.98 170.84-0.817 191.326-4.659 32.017-5.999 112.96-31.01 117.68-73.553'

// data: ['Java', 'Python', 'C', 'Vue', 'go', 'Rust'],
let data = [
  {name: 'Java', value: random(100)},
  {name: 'Python', value: random(100)},
  {name: 'C', value: random(100)},
  {name: 'Vue', value: random(100)},
  {name: 'go', value: random(100)},
  {name: 'Rust', value: random(100)},
]

data = data.sort((a, b) => a.value - b.value)

let total = data.reduce((a, b) => a + b.value, 0)

let color = { 0: '#ff5676', 1: '#ffD83E', 2: '#FBFF94', 3: '#7DAEFF'}

// y轴数据
let yAxisData = data.map(item => item.name)

// x轴数据
let seriesData = data.map((item, index) => ({
  value: +item.value,
  itemStyle: {
    color: {
      type: 'linear',
      x: 1,
      y: 0,
      x2: 0,
      y2: 0,
      colorStops: [
        { offset: 0, color: data.length - index - 1 < 3 ? '#FFDAE1':'#ECF3FF' },
        { offset: 0.07, color: data.length - index - 1 < 3 ? color[data.length - index - 1]:color['3'] },
        { offset: 1, color: data.length - index - 1 < 3 ? 'rgba(255,86,118.1)': 'rgba(125,174,255,.1' }
      ],
      global: false
    },
    barBorderRadius: [0, 20, 20, 0]
  },
  symbol: `${data.length - index - 1 < 3 ? `${airplane}`: 'none' }`,  // 小飞机
  symbolPosition: 'end',  // 柱状图尾部显示
  symbolSize: [30, 25],   // 大小
  symbolOffset: [35, 0],  // 柱状图尾部偏移
}))


const options = {
  background: 'rgba(0,0,0,.8)',
  // title: {
  //   text: 'World Population',
  //   color: '#fff'
  // },
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'shadow'
    },
    formatter: v => `${v[0].name}:${v[0].value}`,
    // textStyle: {
    //   color: 'red'
    // }
  },
  grid: {
    top: 0,
    left: '5%',
    right: '10%',
    bottom: 0,
    containLabel: true, // 避免标签超出容器
  },
  xAxis: {
    splitLine: { show: false },
    axisLine: {
      show: false
    },
    axisTick: {
      show: false
    },
    axisLabel: {
      show: false,
    }
  },
  yAxis: [
    {
      type: 'category',
      data: yAxisData,
      axisLine: {
        show: false,
      },
      axisTick: {
        show: false
      },
      axisLabel: {
        formatter: (v) => `{a|${v}}`,
        rich: {
          a: {
            width: 160,
            fontSize: 16,
            color: '#fff',
            padding: [5,4,5,0],
            align: 'right'
          }
        }
      }
    },
    {
      type: 'category',
      data: seriesData,
      axisLabel: {
        formatter: (v, i) => {
          let percent = ((v/total)*100).toFixed(0)
          let result = `{a${data.length - i < 4 ? data.length - i : ''}|${percent}}{b${data.length - i < 4 ? data.length - i : ''}|%}`
          return result
        },
        rich: {
          a: { fontSize: 24, color: '#98BFFF', verticalAlign: 'bottom' },
          a1: { fontSize: 24, color: '#FF7F97', verticalAlign: 'bottom' },
          a2: { fontSize: 24, color: '#FFCE64', verticalAlign: 'bottom' },
          a3: { fontSize: 24, color: '#E8ED66', verticalAlign: 'bottom' },
          b: { fontSize: 12, color: '#98BFFF', verticalAlign: 'bottom' },
          b1: { fontSize: 12, color: '#FF7F97', verticalAlign: 'bottom' },
          b2: { fontSize: 12, color: '#FFCE64', verticalAlign: 'bottom' },
          b3: { fontSize: 12, color: '#E8ED66', verticalAlign: 'bottom' },
        }
      },
      axisTick: {
        show: false
      },
      axisLine: {
        show: false
      },
      splitLine: {
        show: false
      }
    }
  ],
  series: [
    {
      type: 'pictorialBar',
      data: seriesData,
      z: 6
    },
    {
      type: 'bar',
      barWidth: 25,
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(255,255,255,.1)',
        borderRadius: [0, 20, 20, 0]
      },
      data: seriesData
    }
  ]
}
</script>

<template>
  <chart title="热门技术">
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