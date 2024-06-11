<template>
  <div>
    <div class="box box1"></div>
    <div class="box box2"></div>
    <div class="box box3"></div>
  </div>
</template>
<script setup lang="ts">

</script>
<style scoped lang="scss">
div {
  width: 100%;
  height: auto;
  min-height: 100vh;
  background-color: #f0f0f0;
  .box {
    height: 10px;
  }

  .box1 {
    width: 375px;
    background-color: yellow;
  }

  .box2 {
    width: 750px;
    background-color: red;
  }

  .box3 {
    width: 100%;
    background-color: blue;
  }
}
</style>
