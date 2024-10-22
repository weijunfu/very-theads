<script setup lang="ts">
import { ref, onMounted } from 'vue';

import * as echarts from 'echarts'

import Chart from './Chart.vue';

const chartRef = ref<HTMLElement>(null);

const options = {
  title: {
    show: true,
    text: '行业招聘',
    link: 'https://weijunfu.github.com',
    textStyle: {
      color: '#eee'
    }
  },
  grid: { // 布局
    // top: '5%',
    left: '5%',
    right: '13%',
    bottom: '0',
    containLabel: true, // 避免标签超出容器
  },
  tooltip: {
    show: true,
    textStyle: {
      color: '#f8f8f8',
    }
  },
  xAxis: {
    type: 'category',
    name: '星期（天）',
    nameGap: 10,
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
    axisLine: { // 轴线
      show: true,
      lineStyle: {
        color: '#f0f0f0',   // X轴线颜色
      }
    },
    axisTick: { // 轴刻度
      show: true,
      alignWidthLabel: true,  // 刻度线与标签对齐
    },
    splitLine: {  // 分割线
      show: false,  // 不展示分割线
    },
    axisLabel: {
      fontSize: 14, // 标签字体大小
      color: '#f8f8f8', // 标签颜色
    }
  },
  yAxis: {
    type: 'value',
    name: '本周就业人数（人）',
    nameGap: 10,
    interval: 50, // Y轴刻度间隔
    min: 0,
    max: 200,
    axisLabel: {
      show: true,
      color: '#f0f0f0',
      fontSize: 14
    },
    splitLine: {  // 分割线
      show: true,
      lineStyle: {
        type: 'dashed',
        opacity: 0.2,
        color: '#f0f0f0',   // Y轴分割线颜色
      }
    },
    axisLine: {
      show: false,  // 不展示y轴轴线
    },
    axisTick: {
      show: false,  // 不展示y轴刻度
    }
  },
  series: [
    {
      data: [120, 200, 150, 80, 70, 110, 130],
      type: 'bar',
      label: {
        show: true,
        position: 'top',
        formatter: '{c}',
        color: 'white',   // 值颜色
        fontSize: 16      // 值字体大小
      },
      itemStyle: {
        color: '#4A80D5'
      },
      showBackground: true, // 背景
      backgroundStyle: {
        opacity: .5,
      }
    }
  ]
}

onMounted(() => {
  if(chartRef.value) {
    const myChart = echarts.init(chartRef.value);
    myChart.setOption(options)
  }
})

</script>

<template>
<chart title="就业行业">
  <div id="industry-chart" ref="chartRef"></div>
</chart>
</template>

<style scoped lang="scss">
#industry-chart {
 width: 100%;
  height: 100%;
}
</style>