
import fs from 'fs'
import archiver from 'archiver'
import path from 'path'
import { fileURLToPath } from 'url'

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

function zipDirectory(source, out) {
    const archive = archiver('zip', { zlib: { level: 9 } })
    const stream = fs.createWriteStream(out);

    return new Promise((resolve, reject) => {
        archive.directory(source, false)
        .on('error', err => reject(err))
        .pipe(stream)

        stream.on('close', () => resolve())

        archive.finalize()
    })
}

export default function fuVitePluginZip(dist = 'dist')  {
    return {
        name:'fu-vite-plugin-zip',
        closeBundle() {
            const outputPath = path.resolve(__dirname, dist)
            const zipPath = path.resolve(__dirname, dist + '.zip')

            zipDirectory(outputPath, zipPath)
            .then(() => {
                console.log(outputPath +' 目录已被压缩为'+zipPath)
            })
            .catch(err => {
                console.error('压缩'+outputPath + '目录时出错：', err)
            })
        }
    }
}


