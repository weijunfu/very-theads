<template>
<div class="main">
  <div class="main-content">
    <div class="main-map">
      <MapChart />
    </div>
    <div class="main-chart">
      <dv-border-box1 class="chart-water" :dur="5" :color="['#B5D2F0', '#7AADE1']">
        <WaterChart title="计划资金完成情况" subtitle="累计完成<span style='color: #7AADE1;font-size:18px;font-weight:bold;'>690431</span>元" />
      </dv-border-box1>
      <dv-border-box9 class="chart-rose" :color="['#B5D2F0', '#7AADE1']">
        <RosePieChart title="累计计量资金分布" />
      </dv-border-box9>
    </div>
  </div>
  <div class="main-ring">
    <dv-decoration2 class="ring-line" :dur="5" style="width:100%;height:5px;"  :color="['#B5D2F0', '#7AADE1']" />
    <div class="ring-list">
      <RingChart class="ring-item" title="测试路段1" :value="42" />
      <RingChart class="ring-item" title="测试路段2" :value="58" />
      <RingChart class="ring-item" title="测试路段3" :value="30" />
      <RingChart class="ring-item" title="测试路段4" :value="44" />
      <RingChart class="ring-item" title="测试路段5" :value="58" />
    </div>
  </div>
</div>
</template>

<style scoped lang="scss">

:deep(.dv-water-pond-level canvas) {
  margin-left: 0;
}

.main {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  .main-content {
    width: 100%;
    height: 70%;
    display: flex;
    .main-map {
      height: 100%;
      width: 70%;
      //background: blueviolet;
    }
    .main-chart {
      width: 30%;
      height: 100%;
      display: grid;
      grid-template-rows: repeat(2, 1fr);

      .chart-water,
      .chart-rose {
        //padding: 20px;
        height: 100%;
        box-sizing: border-box;
      }
      .chart-water {
        width: 100%;
        height: 100%;
      }

      .chart-rose {
        height: 100%;
        width: 100%;
        padding: 20px;
      }
    }
  }
  .main-ring {
    height: 30%;
    position: relative;

    .ring-line,
    .ring-list {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
    }
    .ring-line {
      height: 5px;
    }
    .ring-list {
      box-sizing: border-box;
      padding: 20px;
      height: 100%;
      display: grid;
      grid-template-columns: repeat(5, 1fr);

      .ring-item {
        border-right: 2px solid var(--line-color);
        &:nth-last-child(1) {
          border-right: none;
        }
      }
    }
  }
}
</style>
<script setup lang="ts">
import { reactive } from 'vue';

import MapChart from '@/components/chart/MapChart.vue';

import WaterChart from '@/components/chart/WaterChart.vue';
import RosePieChart from '@/components/chart/RosePieChart.vue';
import RingChart from '@/components/chart/RingChart.vue';

const waterConfig = reactive({
  data: [55],
  shape: 'round',
})

const ringOption1 = {
  series: [
    {
      type: 'pie',
      radius: ['50%', '70%'],
      avoidLabelOverlap: false,
      label: {
        show: true,
        position: 'center'
      },
      labelLine: {
        show: false
      },
      emphasis: {
        label: {
          show: true,
          fontSize: '30',
          fontWeight: 'bold'
        }
      },
      data: [
        { value: 50, name: 'A' },
        { value: 50, name: 'B' }
      ]
    }
  ]
}

</script>