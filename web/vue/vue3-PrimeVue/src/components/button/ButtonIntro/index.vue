<template>
  <div class="button-intro">
    <h1>按钮</h1>
    <div class="info">按钮是带有图标和主题的标准输入元素的扩展。</div>
    <h2>导入</h2>
    <div class="info">
      <code>import Button from 'primevue/button';</code>
    </div>
    <h2>基础</h2>
    <div class="info">
      <div class="row flex justify-content-center top2">
        <Toast />
        <Button label="提交" @click="showToast()" />
      </div>
    </div>
    <h2>链接</h2>
    <div class="info row flex justify-content-center top2">
      <Button class="button" label="Link" link />
      <!-- <NuxtLink class="button" to="https://weijunfu.github.io" target="_blank" rel="noopener">
        <Button label="外链接" />
      </NuxtLink> -->
      <router-link class="button" to="/" target="_blank" rel="noopener">
        <Button label="Go Home(Router)" />
      </router-link>
    </div>
    <h2>带有图标的按钮</h2>
    <div class="info top2">
      <Button class="button" icon="pi pi-check" aria-label="Submit" />
      <Button class="button" icon="pi pi-check" label="Submit" />
      <Button class="button" icon="pi pi-check" label="Submit" iconPos="right" />
    </div>
    <h2>带有加载状态的按钮</h2>
    <div class="info top2">
      <Button type="button" label="Search" icon="pi pi-search" :loading="loading" @click="load" />
    </div>
    <h2>带有加载状态的按钮</h2>
    <div class="info top2">
      <Button class="button" label="主要的" />
      <Button class="button" label="次要的" severity="secondary" />
      <Button class="button" label="成功" severity="success" />
      <Button class="button" label="信息" severity="info" />
      <Button class="button" label="警告" severity="warning" />
      <Button class="button" label="帮助" severity="help" />
      <Button class="button" label="危险" severity="danger" />
      <Button class="button" label="比较/对比" severity="contrast" />
    </div>
    <h2>禁用的按钮</h2>
    <div class="info top2">
      <Button label="提交" disabled />
    </div>
    <h2>圆角按钮</h2>
    <div class="info top2">
      <Button class="button" label="主要的" raised></Button>
      <Button class="button" label="次要的" raised severity="secondary"></Button>
      <Button class="button" label="成功" raised severity="success"></Button>
      <Button class="button" label="信息" raised severity="info"></Button>
      <Button class="button" label="警告" raised severity="warning"></Button>
      <Button class="button" label="帮助" raised severity="help"></Button>
      <Button class="button" label="危险" raised severity="danger"></Button>
      <Button class="button" label="比较/对比" raised severity="contrast"></Button>
      <Button class="button" label="禁用" raised disabled></Button>
    </div>
    <h2>圆边按钮</h2>
    <div class="info top2">
      <Button class="button" label="主要的" rounded></Button>
      <Button class="button" label="次要的" rounded severity="secondary"></Button>
      <Button class="button" label="成功" rounded severity="success"></Button>
      <Button class="button" label="信息" rounded severity="info"></Button>
      <Button class="button" label="警告" rounded severity="warning"></Button>
      <Button class="button" label="帮助" rounded severity="help"></Button>
      <Button class="button" label="危险" rounded severity="danger"></Button>
      <Button class="button" label="比较/对比" rounded severity="contrast"></Button>
      <Button class="button" label="禁用" rounded disabled></Button>
    </div>
    <h2>文本按钮</h2>
    <div class="info top2">
      <Button class="button" label="主要的" text></Button>
      <Button class="button" label="次要的" text severity="secondary"></Button>
      <Button class="button" label="成功" text severity="success"></Button>
      <Button class="button" label="信息" text severity="info"></Button>
      <Button class="button" label="警告" text severity="warning"></Button>
      <Button class="button" label="帮助" text severity="help"></Button>
      <Button class="button" label="危险" text severity="danger"></Button>
      <Button class="button" label="比较/对比" text severity="contrast"></Button>
      <Button class="button" label="禁用" text disabled></Button>
    </div>
    <h2>凸起的文本按钮</h2>
    <div class="info top2">
      <Button class="button" label="主要的" text raised></Button>
      <Button class="button" label="次要的" text raised severity="secondary"></Button>
      <Button class="button" label="成功" text raised severity="success"></Button>
      <Button class="button" label="信息" text raised severity="info"></Button>
      <Button class="button" label="警告" text raised severity="warning"></Button>
      <Button class="button" label="帮助" text raised severity="help"></Button>
      <Button class="button" label="危险" text raised severity="danger"></Button>
      <Button class="button" label="比较/对比" text raised severity="contrast"></Button>
      <Button class="button" label="禁用" text raised disabled></Button>
    </div>
    <h2>带有边框的按钮</h2>
    <div class="info top2">
      <Button class="button" label="主要的" outlined></Button>
      <Button class="button" label="次要的" outlined severity="secondary"></Button>
      <Button class="button" label="成功" outlined severity="success"></Button>
      <Button class="button" label="信息" outlined severity="info"></Button>
      <Button class="button" label="警告" outlined severity="warning"></Button>
      <Button class="button" label="帮助" outlined severity="help"></Button>
      <Button class="button" label="危险" outlined severity="danger"></Button>
      <Button class="button" label="比较/对比" outlined severity="contrast"></Button>
      <Button class="button" label="禁用" outlined disabled></Button>
    </div>
    <h2>图标按钮</h2>
    <div class="info top2">
      <Button class="icon-button" icon="pi pi-heart" aria-label="爱心" />
      <Button class="icon-button" icon="pi pi-heart" aria-label="爱心" rounded />
      <Button class="icon-button" icon="pi pi-heart" aria-label="爱心" rounded outlined />
      <Button class="icon-button" icon="pi pi-heart" aria-label="爱心" rounded text raised />
      <Button class="icon-button" icon="pi pi-heart" aria-label="爱心" rounded text />
    </div>
    <h2>徽章</h2>
    <div class="info top2">
      <Button class="button" type="button" label="消息" badge="2" badge-severity="danger" />
      <Button
        class="button"
        icon="pi pi-users"
        type="button"
        label="通知"
        badge="5"
        badge-severity="warning"
        outlined
      />
    </div>
    <h2>按钮组</h2>
    <div class="info top2">
      <ButtonGroup>
        <Button icon="pi pi-check" label="保存" />
        <Button icon="pi pi-trash" label="删除" />
        <Button icon="pi pi-times" label="关闭" />
      </ButtonGroup>
    </div>
    <h2>自定义按钮内容</h2>
    <div class="info top2">
      <Button outlined :style="{ height: '0.5rem' }">
        <svg
          width="35"
          height="40"
          viewBox="0 0 35 40"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M25.87 18.05L23.16 17.45L25.27 20.46V29.78L32.49 23.76V13.53L29.18 14.73L25.87 18.04V18.05ZM25.27 35.49L29.18 31.58V27.67L25.27 30.98V35.49ZM20.16 17.14H20.03H20.17H20.16ZM30.1 5.19L34.89 4.81L33.08 12.33L24.1 15.67L30.08 5.2L30.1 5.19ZM5.72 14.74L2.41 13.54V23.77L9.63 29.79V20.47L11.74 17.46L9.03 18.06L5.72 14.75V14.74ZM9.63 30.98L5.72 27.67V31.58L9.63 35.49V30.98ZM4.8 5.2L10.78 15.67L1.81 12.33L0 4.81L4.79 5.19L4.8 5.2ZM24.37 21.05V34.59L22.56 37.29L20.46 39.4H14.44L12.34 37.29L10.53 34.59V21.05L12.42 18.23L17.45 26.8L22.48 18.23L24.37 21.05ZM22.85 0L22.57 0.69L17.45 13.08L12.33 0.69L12.05 0H22.85Z"
            fill="var(--primary-color)"
          />
          <path
            d="M30.69 4.21L24.37 4.81L22.57 0.69L22.86 0H26.48L30.69 4.21ZM23.75 5.67L22.66 3.08L18.05 14.24V17.14H19.7H20.03H20.16H20.2L24.1 15.7L30.11 5.19L23.75 5.67ZM4.21002 4.21L10.53 4.81L12.33 0.69L12.05 0H8.43002L4.22002 4.21H4.21002ZM21.9 17.4L20.6 18.2H14.3L13 17.4L12.4 18.2L12.42 18.23L17.45 26.8L22.48 18.23L22.5 18.2L21.9 17.4ZM4.79002 5.19L10.8 15.7L14.7 17.14H14.74H15.2H16.85V14.24L12.24 3.09L11.15 5.68L4.79002 5.2V5.19Z"
            fill="var(--text-color)"
          />
        </svg>
      </Button>
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'

import ButtonGroup from 'primevue/buttongroup'
import Toast from 'primevue/toast'

import { useToast } from 'primevue/usetoast'

const toast = useToast()

const showToast = function () {
  toast.add({
    severity: 'success',
    summary: 'Hello',
    detail: 'ijunfu',
    life: 2000
  })
}

// 带有加载状态的按钮
const loading = ref(false)
const load = () => {
  loading.value = true

  setTimeout(() => {
    loading.value = false
  }, 2000)
}
</script>
<style scoped lang="scss">
:deep(.pi) {
  font-size: 0.14rem;
  &::before {
    font-size: 0.12rem;
  }
}

:deep(.p-icon) {
  font-size: 0.12rem;
  width: 0.12rem;
  height: 0.12rem;
}

:deep(.p-button .p-badge) {
  width: 0.16rem !important;
  min-width: 0.16rem !important;
  height: 0.16rem !important;
  font-size: 0.08rem;
  padding: 0;
  color: #fff;
}

.button-intro {
  h2 {
    margin-top: 0.2rem;
  }

  .info {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    font-size: 0.14rem;
    .p-button {
      font-size: 0.12rem;
      height: 0.2rem;
      padding: 0.1rem 0.2rem;
    }
    .button + .button {
      margin-left: 0.2rem;
    }

    .icon-button {
      width: 0.2rem;
      height: 0.2rem;
      margin: 0;
      padding: 0;
    }

    .icon-button + .icon-button {
      margin-left: 0.2rem;
    }
  }
}
</style>
