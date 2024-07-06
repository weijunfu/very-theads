import { randomInteger, randomRgba } from './utils/Random'
export default class Point {
    context: CanvasRenderingContext2D
    width: any
    height: any
    radius: number
    xSpeed: number
    ySpeed: number
    lastDrawTime: number | null
    x: number
    y: number

    constructor(context, width, height, radius = 2) {
        this.context = context
        this.width = width
        this.height = height
        this.radius = radius
        this.x = Math.floor(Math.random()*width - this.radius/2)
        this.y = Math.floor(Math.random()*height - this.radius/2)
        this.xSpeed = randomInteger(-50, 50)
        this.ySpeed = randomInteger(-50, 50)
        this.lastDrawTime = null
    }

    draw() {
        // 更新坐标
        if(this.lastDrawTime) {
            const duration = (Date.now() - this.lastDrawTime)/1000

            if(this.x < 0) {
                this.x = 0
                this.xSpeed = -this.xSpeed
            } else if(this.x > this.width - this.radius/2) {
                this.x = this.width - this.radius/2
                this.xSpeed = -this.xSpeed
            }

            if(this.y < 0) {
                this.y = 0
                this.ySpeed = -this.ySpeed
            } else if(this.y > this.height - this.radius/2) {
                this.y = this.height - this.radius/2
                this.ySpeed = -this.ySpeed
            }

            this.x += duration * this.xSpeed
            this.y += duration * this.ySpeed
        }

        // 绘制圆点
        this.context.beginPath()
        this.context.arc(this.x, this.y, this.radius, 0, Math.PI * 2)
        this.context.fillStyle = randomRgba()
        this.context.fill()
        this.context.closePath()
        this.lastDrawTime = Date.now()
    }
}