
import Point from './Point'

import { randomColor } from './utils/Random'

export default class Graph {
    
    points: Point[]
    maxPath: number
    context: any
    width: any
    height: any
    radius: number
    
    constructor(context, width, height, radius = 2, pointNumber = 30, maxPath = 200) {
        this.context = context
        this.width = width
        this.height = height
        this.radius = radius
        this.points = new Array(pointNumber).fill(0).map(() => new Point(context, width, height, radius) )
        this.maxPath = maxPath
    }

    draw() {
        requestAnimationFrame(() => {
            this.draw()
        })

        this.context.clearRect(0, 0, this.width / window.devicePixelRatio, this.height / window.devicePixelRatio);

        for(let point of this.points) {
            point.draw()
        }

        for(let i=0; i<this.points.length; i++) {
            const p1 = this.points[i]
            p1.draw()

            for(let j=i+1; j<this.points.length; j++) {
                const p2 = this.points[j]
                p2.draw()

                const a = Math.sqrt((p1.x - p2.x)**2 + (p1.y-p2.y)**2)
                // console.log(this.points.length, a)
                if(a > this.maxPath) {
                    continue
                }


                this.context.beginPath();
                this.context.moveTo(p1.x, p1.y); // 起点
                this.context.lineTo(p2.x, p2.y); // 终点

                const r = randomColor()
                const g = randomColor()
                const b = randomColor()
                
                this.context.strokeStyle = `rgba(${r}, ${g}, ${b}, ${(this.maxPath-a)/this.maxPath})`
                
                this.context.lineWidth = 1;
                this.context.stroke();
            }

        }

    }
}