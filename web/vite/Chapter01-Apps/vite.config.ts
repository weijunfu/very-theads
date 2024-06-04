import { defineConfig } from 'vite'

import path from 'path'

export default defineConfig({
    build: {
        rollupOptions: {
            input: {
                pc: path.resolve(__dirname, './pc/index.html'),
                h5: path.resolve(__dirname, './h5/index.html'),
            }
        }
    }
})
