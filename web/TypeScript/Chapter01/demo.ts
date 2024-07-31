namespace Utils {
    export function func() {
        console.log(1)
    }

    function func2() {
        console.log(2)
    }

    export const a=1
}

Utils.func()
Utils.a

namespace My {
    export namespace Helper {
        export function func() {
            console.log(1)           
        }
    }

    export interface Person { name: string}

    export type Animal = { name: string }
}

My.Helper.func()

let c:My.Animal = {
    name: '旺仔'
}