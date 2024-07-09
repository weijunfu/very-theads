const canvas = document.getElementById('canvas');
const context = canvas.getContext('2d');

function resizeCanvas() {
    // 获取设备像素比
    const dpr = window.devicePixelRatio || 1;
    
    // 设置Canvas的实际尺寸
    canvas.width = window.innerWidth * dpr;
    canvas.height = window.innerHeight * dpr;

    // 设置Canvas的CSS尺寸
    canvas.style.width = window.innerWidth + 'px';
    canvas.style.height = window.innerHeight + 'px';

    // 缩放Canvas的绘图上下文
    context.scale(dpr, dpr);
}

// 初始化
resizeCanvas();

// 当窗口大小改变时，调整Canvas的尺寸
window.addEventListener('resize', resizeCanvas);

const randomNumber = (min, max) => Math.floor(Math.random() * (max - min + 1)) + min

const randomColor = () => 'rgba('+Math.floor(Math.random()*256)+', '+Math.floor(Math.random()*256)+','+ Math.floor(Math.random()*256)+','+ Math.random()+')' 

class Point {
    constructor() {
        this.r = 2
        this.x = Math.floor(Math.random()*canvas.width - this.r/2)
        this.y = Math.floor(Math.random()*canvas.height - this.r/2)
        // 每秒移动速度
        this.xSpeed = randomNumber(-50, 50)
        this.ySpeed = randomNumber(-50, 50)
        // 上一次绘制时间
        this.lastDrawTime = null
    }

    draw() {

        // 更新坐标
        if(this.lastDrawTime) {
            const duration = (Date.now() - this.lastDrawTime)/1000

            if(this.x < 0) {
                this.x = 0
                this.xSpeed = -this.xSpeed
            } else if(this.x > canvas.width - this.r/2) {
                this.x = canvas.width - this.r/2
                this.xSpeed = -this.xSpeed
            }

            if(this.y < 0) {
                this.y = 0
                this.ySpeed = -this.ySpeed
            } else if(this.y > canvas.height - this.r/2) {
                this.y = canvas.height - this.r/2
                this.ySpeed = -this.ySpeed
            }

            this.x += duration * this.xSpeed
            this.y += duration * this.ySpeed
            
        }

        // 绘制圆点
        context.beginPath();
        context.arc(this.x, this.y, this.r, 0, Math.PI * 2);
        context.fillStyle = randomColor();
        context.fill();
        context.closePath();
        this.lastDrawTime = Date.now()
    }
}
// new Point().draw()
// new Point().draw()


class Graph {

    constructor(pointNumber = 30, maxPath = 200) {
        this.points = new Array(pointNumber).fill(0).map(() => new Point())
        this.maxPath = maxPath
        
    }

    draw() {
        requestAnimationFrame(() => {
            this.draw()
        })

        context.clearRect(0, 0, canvas.width / window.devicePixelRatio, canvas.height / window.devicePixelRatio);

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


                context.beginPath();
                context.moveTo(p1.x, p1.y); // 起点
                context.lineTo(p2.x, p2.y); // 终点

                const r = Math.floor(Math.random()*256)
                const g = Math.floor(Math.random()*256)
                const b = Math.floor(Math.random()*256)
                
                const rgba = `rgba(${r}, ${g}, ${b}, ${(this.maxPath-a)/this.maxPath})`
                console.log(rgba)
                context.strokeStyle = rgba
                
                context.lineWidth = 1;
                context.stroke();
            }

        }

    }
}



new Graph(60).draw()

window.addEventListener('resize', () => {
    resizeCanvas();
    // drawCircle();
});
