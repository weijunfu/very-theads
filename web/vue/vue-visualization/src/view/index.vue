<template>
<div class="layout">
  <div class="item item1">
    <HeaderTop />
  </div>
  <div class="item item2">
    <header-bottom />
  </div>
  <div class="item item3">
    <BarChart />
    <ScrollTable />
  </div>
  <div class="item item4">
    <Main />
  </div>
</div>
</template>
<style scoped lang="scss">
.layout {
  width: 100%;
  height: 100%;
  display: grid;
  grid-template-rows: 1fr 1fr 8fr;
  grid-template-columns: 1fr 3fr;
  //gap: 10px 10px;
  .item {
    height: 100%;
    &1,&2 {
      grid-column: span 2;
    }
  }
}
</style>
<script setup lang="ts">
import HeaderTop from '@/components/header/HeaderTop.vue';
import HeaderBottom from '@/components/header/HeaderBottom.vue';

import BarChart from '@/components/chart/BarChart.vue';
import ScrollTable from '@/components/table/ScrollTable.vue';

import Main from '@/components/Main.vue';

</script>