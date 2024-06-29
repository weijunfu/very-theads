<template>
  <div class="aside">
    <Tree
      :value="treeMenus"
      v-model:selectionKeys="selectedKey"
      :filter="true"
      filterMode="lenient"
      @nodeSelect="onNodeSelect"
    ></Tree>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'

const selectedKey = ref(null)

const treeMenus = [
  {
    key: '1',
    label: '首页',
    url: '/'
  },
  {
    key: '2',
    label: '组件',
    children: [
      {
        key: '2-1',
        label: '按钮'
      }
    ]
  }
]

const onNodeSelect = (node) => {
  console.log('node', node)
}
</script>
<style scoped lang="scss">
:deep(.p-tree .p-tree-container .p-treenode) {
  padding: 0.05rem;
}

:deep(.p-tree .p-treenode-children) {
  padding: 0 0 0 0.1rem;
}

:deep(.p-tree .p-tree-filter-container .p-tree-filter) {
  padding-right: 0.2rem;
}

:deep(.p-tree .p-tree-filter-container .p-tree-filter-icon) {
  right: 0.05rem;
  font-size: 0.1rem;
  transform: translateY(-50%);
}

// :deep(.p-tree .p-tree-container .p-treenode .p-treenode-content) {
//   border-left: 0.01rem solid #ddd;
//   &:hover {
//     border-left-color: #ccc;
//   }
// }

:deep(.p-tree .p-tree-container .p-treenode .p-treenode-content .p-tree-toggler) {
  width: 0.12rem;
  height: 0.12rem;
}

:deep(.p-treenode-icon) {
  margin-left: 0.05rem;
  margin-right: 0.05rem;
}

:deep(.p-inputtext:enabled:focus) {
  box-shadow: none;
}

:deep(.p-treenode-children .p-treenode) {
  border-left: 0.01rem solid #eee;
  &:hover {
    border-left-color: #ccc;
    cursor: pointer;
  }
}

:deep(.p-icon) {
  width: 0.2rem;
  height: 0.2rem;
}

:deep(.p-inputtext) {
  font-size: 0.12rem;
  padding: 0.05rem;
}

:deep(.pi) {
  font-size: 0.16rem;
}

.aside {
  width: 100%;
  height: 100%;
  .p-tree {
    width: 100%;
    height: 100%;
    padding: 0;
    border: none;
    font-size: 0.16rem;
  }
}
</style>
