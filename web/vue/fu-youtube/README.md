
# Youtube 视频播放插件

> [Vue Plugin] 便捷的Youtube视频播放插件

## Install 安装

```
npm install fu-youtube
// or
yarn add fu-youtube
// or
pnpm install fu-youtube
```

## Use 使用

```
// 自定义Youtube视频播放插件
import FuYoutubePlayer from 'fu-youtube'
app.use(FuYoutubePlayer)

```

## 示例
```
<FuYoutubePlayer :videoId="videoId" :options="videoOptions" @onReady="playerOnReady"></FuYoutubePlayer>

const videoId = '8yEgbvTD45c'
const videoOptions = {
	controls: 0,    // 是否显示控制条
	mute: 1,        // 是否静音
	loop: 1,        // 是否循环播放
	autoplay: 1,    // 是否自动播放；开启自动播放时，同时开启静音
	playlist: videoId   // 若是循环播放，必须设置
}

const playerOnReady = () => {
	console.log('youtube ready...')
}
```

## 去除黑边示例
```
.youtube-player {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  transform: scale(2);
  object-fit: cover;
}

```

