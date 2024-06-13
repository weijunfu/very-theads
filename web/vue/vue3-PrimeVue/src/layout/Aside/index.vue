<template>
  <div class="aside">
    <Tree :value="treeMenus" :filter="true" filterMode="lenient"></Tree>
  </div>
</template>
<script setup lang="ts">
// import TreeNode from 'primevue/treenode'

const treeMenus = [
  {
    key: '1',
    label: 'Document',
    icon: 'pi pi-facebook'
  },
  {
    key: '2',
    label: 'Events',
    icon: 'pi pi-twitter'
  },
  {
    key: '3',
    label: '爱心',
    icon: 'pi pi-heart',
    children: [
      {
        key: '3-1',
        label: 'Document'
      },
      {
        key: '3-2',
        label: 'Events'
      }
    ]
  },
  {
    key: '4',
    label: '爱心',
    icon: 'pi pi-check',
    children: [
      {
        key: '4-1',
        label: 'Document'
      },
      {
        key: '4-2',
        label: 'Events',
        children: [
          {
            key: '4-2-1',
            label: '文档'
          }
        ]
      }
    ]
  }
]
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
