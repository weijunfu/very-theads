// 随机函数工具类

/**
 * 
 * @returns 随机颜色值
 */
export function randomColor() {
    return '#' + Math.floor(Math.random()*16777215).toString(16)
}

/**
 * 
 * @param  len 字符长度
 * @param charSet 字符集
 * @returns 从指定字符集中随机生成长度为len的字符串
 */
export function randomString(len:number, charSet:string = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789') {
    var randomString = '';
    for (var i = 0; i < len; i++) {
        var randomPoz = Math.floor(Math.random() * charSet.length);
        randomString += charSet.substring(randomPoz,randomPoz+1);
    }
    return randomString;
}


