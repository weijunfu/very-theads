<script setup lang="ts">
defineProps({
  title: String
})

</script>

<template>
  <div class="chart-box">
    <dv-border-box12 class="chart-border">
      <div class="chart-title flex flex-center">{{ title }}</div>
      <div class="chart">
        <slot></slot>
      </div>
    </dv-border-box12>
  </div>
</template>

<style scoped lang="scss">
.chart-box {
  width: 100%;
  height: 100%;
  .chart-border {
    padding: 0 15px 40px 15px;
    .chart-title {
      width: 100%;
      height: 48px;
      font-size: 20px;
      color: #fff;
    }
    .chart {
      width: 100%;
      height: calc(100% - 48px);
    }
  }
}
</style>