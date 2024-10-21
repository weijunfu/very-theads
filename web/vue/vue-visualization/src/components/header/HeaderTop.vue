<template>
<div class="header-top">
  <div small-bg>
    <dv-decoration8 style="width:300px;height:50px;" :color="['#B5D2F0', '#7AADE1']" />
  </div>
  <div small-bg>
    <h2>智能养护工程监管平台</h2>
    <dv-decoration5 :dur="2" style="width:300px;height:40px;" :color="['#B5D2F0', '#7AADE1']" />
  </div>
  <div small-bg>
    <dv-decoration8 :reverse="true" style="width:300px;height:50px;" :color="['#B5D2F0', '#7AADE1']" />
  </div>
</div>
</template>

<style scoped lang="scss">
.header-top {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;

  h2 {
    letter-spacing: 5px;
  }
}
</style>
<script setup lang="ts">

</script>