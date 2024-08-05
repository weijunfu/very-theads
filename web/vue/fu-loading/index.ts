import { ElLoading } from 'element-plus'

let globalLoading: ReturnType<typeof ElLoading.service>;
let counter: number = 0

/**
 * 开启Loading
 * @param loadingText 显示的Loading文本
 */
export function startLoading(loadingText: string = 'Loading...') {
  if (!globalLoading) {
    globalLoading = ElLoading.service({
      fullscreen: true,
      text: loadingText,
      lock: true,
      spinner: 'el-icon-loading',
      background: 'rgba(0, 0, 0, 0.7)',
      zIndex: 999999,
    })
  }

  counter++
}

/**
 * 结束Loading
 * @returns 
 */
export function endLoading() {
    if(!globalLoading) {
        return
    }

    counter--

    if(counter === 0) {
        globalLoading.close()
    }
}