<template>
<div class="card-number">
  <div class="card-title">{{ title }}</div>
  <div class="card-content">
    <div class="card-number" :style="{'--text-color': color}">{{ number }}</div>
    <div class="card-number-unit">{{ unit }}</div>
  </div>
</div>
</template>

<style scoped lang="scss">
.card-number {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  .card-content {
    height: 100%;
    display: flex;
    flex-direction: row;
    .card-number {
      height: 100%;
      font-size: 2rem;
      font-weight: bold;
      color: var(--text-color);
      &-unit {
        margin-left: 5px;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: flex-end;
        height: 100%;
      }
    }
  }
}
</style>

<script setup lang="ts">

defineProps({
  title: String,
  number: Number,
  unit: String,
  color: String
})

</script>