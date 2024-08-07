const map = new WeakMap()

const observer = new ResizeObserver((entries) => {
    for (const entry of entries) {
        const handler = map.get(entry.target)
        handler && handler({
            width: entry.borderBoxSize[0].inlineSize,
            height: entry.borderBoxSize[0].blockSize
        })
    }
})

export default {
    mounted(el, binding) {
        map.set(el, binding.value)

        observer.observe(el)
    },
    unmounted(el) {
        observer.unobserve(el)
    },
}