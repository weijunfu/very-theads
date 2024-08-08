/* 1分钟 */
const minute = 60 * 1000

/* 1小时 */
const hour = minute * 60

/* 1天 */
const day = hour * 24

/* 1周 */
const week = day * 7

/* 1月 */
const month = day * 30

enum TimeLabel {
    month   = '月前',
    week    = '周前',
    day     = '天前',
    hour    = '小时前',
    minute  = '分钟前',
    current = '刚刚'
}

/**
 * 发布日期格式化
 * @param timeStr yyyy-MM-dd HH:mm:ss 格式的日期字符串
 * @returns 
 */
export default function publishTimeFormat(timeStr: string): string {

    // 当前时间
    const currentTime = Date.now()

    // 目标时间-用户输入时间
    const targetTime = Date.parse(timeStr)

    // 当前时间与目标时间的时间差值
    const diffTime = currentTime - targetTime

    // 当前时间打印目标时间
    if(diffTime < 0) 
        throw new Error('参数日期不能大于当前日期')

    let time = diffTime/month
    // 时间差超过1年，直接显示用户输入的时间
    if(time > 12) {
        return timeStr;
    }

    // 时间差超过1个月
    if(time >= 1) {
        return Math.floor(time) + TimeLabel.month
    }

    time = diffTime/week
    // 时间超过1周
    if(time >= 1) {
        return Math.floor(time) + TimeLabel.week
    }

    time = diffTime/day
    // 时间超过1天
    if(time >= 1) {
        return Math.floor(time) + TimeLabel.day
    }

    time = diffTime/hour
    // 时间超过1周
    if(time >= 1) {
        return Math.floor(time) + TimeLabel.hour
    }

    time = diffTime/minute
    // 时间超过1分钟
    if(time >= 1) {
        return Math.floor(time) + TimeLabel.minute
    }
    
    return TimeLabel.current
}
