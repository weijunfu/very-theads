<template>
<div class="water-chart-box">
  <div class="chart-title">
    {{ title }}
  </div>
  <div class="chart-ext" v-html="subtitle">
  </div>
  <div class="chart-box">
    <dv-water-level-pond class="water-chart" :config="config"/>
  </div>
</div>
</template>

<style scoped lang="scss">
.water-chart-box {
  padding: 20px;
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  .chart-title,
  .chart-ext {
    padding: 5px;
    height: 10%;
    text-align: left;
  }
  .chart-title {
    font-size: 20px;
  }
  .chart-ext {
    font-size: 18px;
    color: #B5D2F0;
  }
  .chart-box {
    height: 80%;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    .water-chart {
      width: 200px;
      height: 200px;
    }
  }
}
</style>
<script setup lang="ts">
import { reactive } from 'vue';

defineProps({
  title: String,
  subtitle: String
})

const config = reactive({
  data: [55],
  shape: 'round',
})

</script>