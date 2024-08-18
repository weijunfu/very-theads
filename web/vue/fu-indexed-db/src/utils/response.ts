
interface Response<T> {
    code: number
    msg: string
    data: T | null
}

function createResponse<T>(code: number, msg: string, data: T | null): Response<T> {
    return {
        code,
        msg,
        data
    }
}

function ok<T>(msg: string, data: T | null): Response<T> {
    return {
        code: 0,
        msg,
        data
    }
}

function ok<T>(data: T | null): Response<T> {
    return {
        code: 0,
        msg: 'ok',
        data
    }
}


export default class Response {

    /* 响应码 */
    code: number

    /* 消息提示、备注、说明 */
    msg: string

    /* 响应数据 */
    data: any

    constructor() {

    }

    ok(code: number = 0, msg: string = 'ok', data: any) {
        this.code = code
        this.msg = msg
        this.data = data
    }

    fail(code: number = 1, msg: string = 'error', data: any) {
        this.code = code
        this.msg = msg
        this.data = data
    }

    setCode(code: number) {
        this.code = code
    }

    setMsg(msg: string) {
        this.msg = msg
    }

    setData(data: any) {
        this.data = data
    }
}

