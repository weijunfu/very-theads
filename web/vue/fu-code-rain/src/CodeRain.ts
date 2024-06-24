
import { randomColor, randomString } from './utils/random'

export default class CodeRain {

    private ctx: CanvasRenderingContext2D
    /* Canvas宽度 */
    private width:number

    /* Canvas高度 */
    private height:number

    /* 字体大小 */
    private fontSize:number = 20 * devicePixelRatio
    
    /* 列宽 */
    private columnWidth:number

    /* 总列数 */
    private columns:number

    /* 下一次绘制列数坐标数组 */
    private nextChars:Array<number>

    constructor(canvas: HTMLCanvasElement) {
        this.width = canvas.width
        this.height = canvas.height

        let ctx = canvas.getContext('2d')
        if(ctx) {
            this.ctx = ctx
        }

        /* 默认列宽等于字体大小 */
        this.columnWidth = this.fontSize

        /* 计算总列数 */
        this.columns = Math.floor(this.width/this.columnWidth)

        /* 初始化下一次绘制列数坐标 */
        this.nextChars = new Array(this.columns).fill(0)
    }

    draw() {
        /* 绘制字符之前，先绘制一层遮罩，以达到渐隐效果 */
        this.ctx.fillStyle = 'rgba(0,0,0,.1)'
        this.ctx.fillRect(0, 0, this.width, this.height)

        for(let i=0; i<this.columns; i++) {

            /* 颜色 */
            this.ctx.fillStyle = randomColor()

            /* 字体 */
            this.ctx.font = `${this.fontSize}px "Roboto Mono"`

            /* 坐标 */
            const x = this.columnWidth * i
            const y = (this.nextChars[i] + 1) * this.fontSize

            /* 开始绘制字符 */
            this.ctx.fillText(randomString(1), x, y)

            /* 当绘制到底部时，回到起始位置 */
            if(y > this.height && Math.random() > 0.99) {
                this.nextChars[i] = 0
            } else {
                this.nextChars[i]++
            }
        }
    }

    /**
     * 定时绘制
     * @param time 时间间隔，单位：毫秒
     */
    autoDraw(time:number = 10) {
        setInterval(() => this.draw(), time)
    }
}
