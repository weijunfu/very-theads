<script setup lang="ts">
import { getCurrentInstance } from 'vue'

import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'

const app = getCurrentInstance()

const Task = app.appContext.config.globalProperties.$Task

const execTask = () => {
  const timeout = (time: number) => new Promise((resolve) => setTimeout(resolve, time))

  // 创建 Task实例
  const task = new Task(2)

  const addTask = async (time: number, name: number) => {
    await task.add(() => timeout(time)).then(() => console.log(`任务${name}已完成`))
  }

  // 添加任务
  addTask(10000, 1) // 10后执行
  addTask(5000, 2) // 5s后执行
  addTask(3000, 3) // 8s后执行
  addTask(4000, 4) // 12s后执行
  addTask(5000, 5) // 15s后执行
}

execTask()
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="You did it!" />
    </div>
  </header>

  <main>
    <TheWelcome />
  </main>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
