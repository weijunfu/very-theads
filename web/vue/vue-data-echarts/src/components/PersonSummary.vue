<script setup lang="ts">

</script>

<template>
<div class="box">
  <dv-border-box7 :style="{height: '60%'}">
      <div class="border-row grid">
        <div class="cell flex flex-center">125811</div>
        <div class="cell flex flex-center">104563</div>
      </div>
  </dv-border-box7>
  <div class="row grid">
    <div class="cell flex flex-center">前端需求人数</div>
    <div class="cell flex flex-center">市场供应人数</div>
  </div>
</div>
</template>

<style scoped lang="scss">
.box {
  padding: 10px;
  width: 100%;
  height: 100%;
  background-color: rgba(101, 132, 226, .1);
  .row {
    height: 40%;
    color: #9892c0;
    grid-template-columns: repeat(2, 1fr);
  }
}

.border-row {
  width: 100%;
  height: 100%;
  grid-template-columns: repeat(2, 1fr);
  .cell {
    color: #FEE67A;
    font-size: 32px;
    font-weight: bold;
    font-family: 'DS-DIGI', sans-serif;
    &:nth-of-type(1) {
      border-right: 1px solid rgba(25, 186, 139, .17);
    }
  }
}
</style>