<script setup lang="ts">

// 左侧图表
import IndustryColumnChart from '@components/chart/IndustryColumnChart.vue';
import JobLineChart from '@components/chart/JobLineChart.vue';
import AgePieChart from '@components/chart/AgePieChart.vue';

// 中间
import PersonSummary from '@components/PersonSummary.vue';
import MapChart from '@/components/chart/MapChart.vue';


// 右侧图表
import ITColumnChart from '@components/chart/ITColumnChart.vue';
import PlayLineChart from '@components/chart/PlayLineChart.vue';
import AddressPieChart from '@components/chart/AddressPieChart.vue';
</script>

<template>
  <header class="header flex flex-row flex-between flex-col-bottom">
    <dv-decoration8 class="header-left" style="width:300px;height:50px;" />
    <div class="header-center flex flex-col flex-center">
      <div class="header-title">学生信息监控平台</div>
      <dv-decoration5 class="header-border" :dur="2" style="width:300px;height:40px;" />
    </div>
    <dv-decoration8 class="header-right" :reverse="true" style="width:300px;height:50px;" />
  </header>
  <main class="main grid">
    <div class="main-item main-item1 grid">
      <IndustryColumnChart />
      <JobLineChart />
      <AgePieChart />
    </div>
    <div class="main-item main-item2 grid">
      <div class="main-summary">
        <PersonSummary />
      </div>
      <div class="main-map">
        <MapChart />
      </div>
    </div>
    <div class="main-item main-item3 grid">
      <ITColumnChart />
      <PlayLineChart />
      <AddressPieChart />
    </div>
  </main>
</template>

<style scoped lang="scss">
.header {
  width: 100%;
  height: 100px;
  text-align: center;
  &-center {
    font-size: 36px;
    font-weight: bold;
    letter-spacing: 5px;
  }
}
main {
  width: 100%;
  height: calc(100% - 100px);
  padding: 10px 10px 0;
  grid-template-columns: repeat(11, 1fr);

  .main-item {

    &1, &3 {
      grid-column: span 3;
      grid-template-rows: repeat(3, 1fr);
    }

    &2 {
      height: 100%;
      grid-column: span 5;
      grid-template-rows: repeat(8, 1fr);
      .main-summary {
        //background: blue;
      }
      .main-map {
        grid-row: span 7;
        //background: red;
      }
    }

  }
}
</style>