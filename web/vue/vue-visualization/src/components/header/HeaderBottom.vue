<template>
<div class="header-bottom">
  <div class="card-list">
    <NumberCard class="card-item" title="今日新增确诊" :number="1" unit="例" color="#ff9c6e" />
    <NumberCard class="card-item" title="今日新增疑似" :number="2" unit="例" color="#ffc53d" />
    <NumberCard class="card-item" title="今日新增死亡" :number="3" unit="例" color="#6ec7ff" />
    <NumberCard class="card-item" title="今日新增治愈" :number="4" unit="例" color="#6effc7" />
    <NumberCard class="card-item" title="累计确诊" :number="5" unit="例" color="#ff9c6e" />
    <NumberCard class="card-item" title="累计疑似" :number="6" unit="例" color="#ffc53d" />
    <NumberCard class="card-item" title="累计死亡" :number="7" unit="例" color="#6ec7ff" />
    <NumberCard class="card-item" title="累计治愈" :number="8" unit="例" color="#6effc7" />
  </div>
  <dv-decoration2 class="card-line" :dur="5" style="width:100%;height:5px;"  :color="['#B5D2F0', '#7AADE1']" />
</div>
</template>

<style scoped lang="scss">
.header-bottom {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  position: relative;
  padding: 20px 0;

  .card-list,
  .card-line {
    position: absolute;
    left: 0;
    width: 100%;
  }

  .card-list {
    padding: 10px;
    top: 0;
    height: 100%;
    display: grid;
    grid-template-columns: repeat(8, 1fr);
    .card-item {
      border-right: 2px solid var(--line-color);
      &:nth-last-child(1) {
        border-right: none;
      }
    }
  }

  .card-line {
    bottom: 0;
  }
}
</style>
<script setup lang="ts">
import NumberCard from '@/components/card/NumberCard.vue'
</script>