
const OK = 'ok'
const ERROR = 'error'

/**
 * 统一响应体结构
 */
interface IResponse<T = any> {
    code: number
    msg: string | null | undefined
    data: T | null
}
 
/**
 * @param code 响应码
 * @param msg 备注、说明、提示
 * @param data 响应数据
 * @returns 成功响应体
 */
export function ok<T>(code: number): IResponse<T>;
export function ok<T>(code: number, msg: string | null | undefined): IResponse<T>;
export function ok<T>(code: number, data: T | null): IResponse<T>;
export function ok<T>(code: number, msg: string | null | undefined, data: T | null): IResponse<T>;

export function ok<T>(code: number, msg?: string | null, data?: T | null): IResponse<T | undefined> {
    return handle(code, msg, data, true)   
}

/**
 * @param code 响应码
 * @param msg 备注、说明、提示
 * @param data 响应数据
 * @returns 失败（错误）响应体
 */
export function fail<T>(code: number): IResponse<T>;
export function fail<T>(code: number, msg: string | null): IResponse<T>;
export function fail<T>(code: number, data: T | null): IResponse<T>;
export function fail<T>(code: number, msg: string | null, data: T | null): IResponse<T>;

export function fail<T>(code: number, msg?: string | undefined | null, data?: T | null): IResponse<T | undefined> {
    return handle(code, msg, data, false)
}

/**
 * 
 * @param code 响应码
 * @param msg 备注、说明、提示
 * @param data 响应数据
 * @param isOk 
 * @returns 响应体
 */
function handle<T>(code: number, msg: string | undefined | null, data: T | null, isOk: boolean): IResponse<T> {
    if(typeof msg === 'string') {
        return {
            code,
            msg,
            data: data || null,
        }
    }

  return {
    code,
    msg: isOk ? OK : ERROR,
    data: msg || null,
  };
}