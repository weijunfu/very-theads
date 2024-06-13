<template>
  <div class="layout">
    <div class="layout-header">
      <Header />
    </div>
    <Splitter class="layout-main">
      <SplitterPanel class="layout-aside" :size="15"><Aside /></SplitterPanel>
      <SplitterPanel class="layout-content" :size="85"><router-view></router-view></SplitterPanel>
    </Splitter>
  </div>
</template>
<script setup lang="ts">
import Header from './Header/index.vue'
import Aside from './Aside/index.vue'
</script>
<style scoped lang="scss">
$headerHeight: 0.8rem;
$mainHeight: calc(100% - $headerHeight);

.layout {
  width: 100%;
  height: 100%;

  &-header {
    width: 100%;
    height: $headerHeight;
  }

  &-main {
    width: 100%;
    height: auto;
    min-height: $mainHeight;
    display: flex;
    flex-direction: row;

    .layout-aside {
      padding: 0;
    }

    .layout-content {
      padding: 0.1rem;
    }
  }
}
</style>
