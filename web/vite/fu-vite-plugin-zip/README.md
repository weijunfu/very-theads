# fu-vite-plugin-zip

> [vite plugin] 项目构建之后将指定目录打包成zip

## Install 安装

```
npm install fu-vite-plugin-zip
// or
yarn add fu-vite-plugin-zip
// or
pnpm install fu-vite-plugin-zip
```

## Use 使用

```
import fuVitePluginZip from 'fu-vite-plugin-zip'

// https://vitejs.dev/config/
export default defineConfig({
	
	plugins: [
		fuVitePluginZip(path.resolve(__dirname, 'dist'))    // 压缩dist目录
	],

})

```
