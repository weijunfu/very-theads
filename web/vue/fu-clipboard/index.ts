
const clipboard = async (text: string) => {
    if(!navigator.clipboard) {
        throw new Error('No clipboard support!')
    }

    await navigator.clipboard.writeText(text)
}

export default {
    install(app) {
        app.config.globalProperties.$clipboard = clipboard
    }
}
