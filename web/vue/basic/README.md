
# Vue 入门

[官网](https://cn.vuejs.org/)

## 目录

1. <a href="#first">创建一个vue应用程序</a>
2. 模块化开发
3. `ref`和`reactive`
4. 绑定事件`v-on`, 简写`@`
5. 显示和隐藏`v-show`
6. 条件渲染`v-if`
7. 动态属性绑定`v-bind`,简写`:`
8. 遍历数组或对象`v-for`
9. 双向数据绑定`v-model`
10. 渲染数据`v-text`和`v-html`
11. 表单修饰符
12. 计算属性`computed`
13. 侦听器`watch`
14. 自动侦听器`watchEffect`

## <h2 id="first">1. 创建一个vue应用程序</h2>

> Vue.js是一个渐进式JavaScript框架
> "渐进式"是指可以按需引入Vue.js的部分功能，而不必全量引入整个框架

示例：
```html

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="ijunfu<ijunfu@163.com>">
    <title>ijunfu|创建第一个vue应用</title>
</head>
<body>
    <!-- 第三步：创建模板 #app，并渲染msg -->
    <div id="app">
        {{ msg }}
    </div>

    <!-- 第一步：引入vuejs -->
    <script src="../libs/vue.global.js"></script>
    <script>
        // 第二步：创建Vue App并挂载到app
        Vue.createApp({
            setup() {
                return {
                    msg: 'Hello, World!'
                }
            }
        }).mount('#app')
    </script>
</body>
</html>
```

`{{}}`差值表达式，可以将Vue实例中定义的数据在视图中进行渲染。

上述，Vue示例中定义一个`msg`变量，值为`Hello, World!`。
在模板中，若使用差值表达式`{{ msg }}`, 则会被渲染成`Hello, World!`。

`响应式数据`是指当数据发生变化时，模板中依赖于该数据的部分会自动更新。



