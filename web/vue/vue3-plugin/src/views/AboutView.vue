<template>
  <div class="about">
    <h1>This is an about page</h1>
    <MyButton></MyButton>
    <h2>自定义UI</h2>
    <fu-button></fu-button>
    <fu-swiper></fu-swiper>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
    flex-direction: column;
    justify-content: flex-start;
  }
}
</style>
