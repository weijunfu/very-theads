
# Vite 多页面应用模式

## 环境配置&安装

### 初始化项目
```shell
npm init -y
```

### 安装vite

```shell
npm i vite -D
npm i @types/node -D
npm i -g http-server    # 安装本地服务，已安装请忽略
```

## 新增以下文件

```ts
// common/token.ts
export const token = 'Token'
```

```html
<!-- h5/index.html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>手机端</title>
</head>
<body>
    <h2>手机端</h2>

    <script type="module" src="main.ts"></script>
</body>
</html>
```

```ts
// h5/main.ts

import { token } from "../common/token"

console.log('Html5', token)

```

```html
<!-- pc/index.html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>电脑端</title>
</head>
<body>
    <h2>电脑端</h2>

    <script type="module" src="main.ts"></script>
</body>
</html>
```

```ts
// pc/main.ts

import { token } from "../common/token"

console.log('PC', token)

```

## vite.config.ts

```ts
import { defineConfig } from 'vite'

import path from 'path'

export default defineConfig({
    build: {
        rollupOptions: {
            input: {
                pc: path.resolve(__dirname, './pc/index.html'),
                h5: path.resolve(__dirname, './h5/index.html'),
            }
        }
    }
})

```

## package.json
修改`script`
```json
"scripts": {
    "build": "vite build"
}
```

## 目录结构
```text
│  package-lock.json
│  package.json
│  README.md
│  vite.config.ts
│  
├─common
│      token.ts
│      
├─h5
│      index.html
│      main.ts
│      
└─pc
        index.html
        main.ts
```

## 打包

```shell
npm run build
```
默认生成`dist`目录

### 打包后的目录结构

```text
dist
├─assets
│      h5-CWdRFoUi.js
│      pc-Bqn0tfJl.js
│      token-C2G7Cvoa.js
│
├─h5
│      index.html
│
└─pc
        index.html
```

## 运行

```shell
cd dist
http-server -p 9000
```

访问：
+ pc端：http://localhost:9000/pc
+ Html5端：http://localhost:9000/h5