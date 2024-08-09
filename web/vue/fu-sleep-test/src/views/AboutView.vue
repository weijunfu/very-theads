<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div>
      <FuNumeralIncr :count="200" />
    </div>
    <div>
      <FuNumeralIncr :count="400" unit="%" />
    </div>
    
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: calc(100vh * 3);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
}
</style>
