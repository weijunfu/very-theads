
# fu-response
> 统一响应体

## 安装

```
npm install fu-response
// or
yarn add fu-response
// or
pnpm install fu-response
```

## 使用
```
import { ok, fail} from 'fu-response'
```

## 示例
```
console.log(ok(0))                                  // ok(code)

console.log(ok(0, "success"))                       // ok(code, msg)

console.log(ok(0, {name: 'ijunfu'}))                // ok(code, data)

console.log(ok(0, "success", {author: 'ijunfu'}))   // ok(code, msg, data)

console.log(fail(1))                                // fail(code)

console.log(fail(1, "err"))                         // fail(code, msg)

console.log(fail(1, {name: 'ijunfu'}))              // fail(code, data)

console.log(fail(1, "err", {author: 'ijunfu'}))     // fail(code, msg, data)
```
