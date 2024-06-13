const sprites = require('postcss-sprites')
module.exports = {
  plugins: [
    // require('autoprefixer'),  // 添加浏览器厂商前缀
    require('postcss-import'),  // 合并CSS样式
    // require('cssnano'),       // CSS压缩
    require('postcss-cssnext'), // 兼容低版本浏览器，降级处理
    sprites({
      spritePath: './dist/images',
      stylesheetPath: './src/demo.css'
    }), // 小图片合并成雪碧图
  ]
}