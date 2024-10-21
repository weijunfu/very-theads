<template>
<div class="bar-chart" ref="barChart"></div>
</template>

<style scoped lang="scss">
.bar-chart {
  padding: 10px 5px;
  width: 100%;
  height: 300px;
}
</style>
<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts';

const barChart = ref<HTMLElement>();

onMounted(() => {

  if(barChart.value) {
    const myChart = echarts.init(barChart.value);

    myChart.setOption({
      title: {
        text: 'ECharts 入门示例'
      },
      tooltip: {},
      xAxis: {
        type: 'value',
        axisLine: {
          lineStyle: {
            color: '#646cff'
          }
        }
      },
      yAxis: {
        type: 'category',
        axisLine: {
          lineStyle: {
            color: '#646cff'
          }
        },
        data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
      },
      series: [
        {
          name: '销量',
          type: 'bar',
          data: [5, 20, 36, 10, 10, 20],
          // barWidth: 40,
          itemStyle: {
            color: (params) => {
              const colorList = ['#37a2da', '#9fe6b8', '#ffdb5c', '#fb7293', '#96bfff', '#9d96f5'];

              return colorList[params.dataIndex]
            }
          }
        }
      ],
      toolbox: {
        show: true,
        feature: {
          dataView: { show: true, readOnly: false },
          magicType: { show: true, type: ['line', 'bar'] },
          restore: { show: true },
          saveAsImage: { show: true }
        }
      }
    });
  }
})

</script>
