
# CSS 预处理： Sass & Less

Sass、Less和stylus都属于CSS预处理器，就是我们常说的CSS框架。

CSS预处理器定义了一种新的语言，其基本思想是`用一种专门的编程语言，为CSS增加了一些编程的特性`。如：变量、语句、函数、继承等概念。将CSS作为目标生成文件，然后开发者就只需要使用这种语言进行CSS的编码工作。

<table>
    <tr>
        <th>序号</th>
        <th>语言</th>
        <th>官网</th>
        <th>VS Code插件</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Less</td>
        <td><a href="https://lesscss.org/">https://lesscss.org/</a></td>
        <td>Easy LESS</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Sass</td>
        <td><a href="https://sass-lang.com">https://sass-lang.com</a></td>
        <td>Easy Sass</td>
    </tr>
    <tr>
        <td>3</td>
        <td>stylus</td>
        <td><a href="https://stylus-lang.com">https://stylus-lang.com</a></td>
        <td></td>
    </tr>
</table>

## 一、语法

### 1.1 注释

#### 单行注释
> 编译时, 会被移除
```less
// 这是单行注释内容
```

#### 多行注释
> 编译时，会被编译
```less
/**
 * 这是多行注释内容 
 */
```

### 1.2 变量、插值、作用域

#### 变量
在Less中，变量以`@`开头，比如：`@color: #333;`
在Sass中，变量以`$`开头，比如：`$color: #333;`

```less
// less
@size: 100px;
@color: #333;

.box {
    width: @size;
    height: @size;
    background-color: @color;
}
```

```sass
// sasss
$size: 100px;
$color: #333;

.box {
    width: $size;
    height: $size;
    background-color: $color;
}

```

#### 插值

```less
//less

@size: 100px;
@color: #333;

@colorKey: color;

@i: 2;

.box@{i} {
    width: @size;
    height: @size;
    @{colorKey}: @color;
}

```

```sass
//sass

$size: 100px;
$color: #333;

$colorKey: color;

$i: 2;

.box#{$i} {
    width: $size;
    height: $size;
    #{$colorKey}: $color;
}

```

#### 作用域

+ `less`: 作用域变量会被提升

```less
@size: 100px;

.box {
    width: @size;   // 获取局部变量值 @size: 200px;
    @size: 200px;
    height: @size;  // 获取局部变量值 @size: 200px;
}
```


+ `scss`：作用域有变量不会提升

```scss
$size: 100px;

.box {
    width: $size;   // 获取全局变量值 $size: 100px;
    $size: 200px;
    height: $size; // 获取局部变量值 $size: 200px;
}
```

### 1.3 选择器嵌套，伪类嵌套
> less和scss写法一致，支持模块化开发
> 建议嵌套层级不超过4层

```
body {

    #app {
        background-color: red;

        &:hover {
            background-color: blue;
        }
    }

}
```

### 1.4 运算、单位、转义、颜色

#### 运算

##### Less

> 当两个单位不同时，会以第一个单位为准；颜色值也可以运算

```less
@size: 100px;

.box {
    width: @size;
    height: @size * 1.5;
    margin: 10em + @size;
    font-size: 20px / 1.5;
    padding: ~"20px / 1.5";
    color: #333 * 2;
}
```

编译后结果：
```css
.box {
  width: 100px;
  height: 150px;
  margin: 110em;
  font-size: 20px / 1.5;
  padding: 20px / 1.5;
  color: #666666;
}
```

##### Sass
> 如果单位不同时不能运算的

```scss
$size: 100px;

.box {
    width: $size;
    height: $size * 1.5;
    font-size: 20px / 1.5;
    // 默认 / 是分割的操作
    padding: (20px / 1.5);
    color: #333333 * 2;
}

```

### 1.5 函数

#### 1.5.1 Less支持的函数
+ round：四舍五入
```
.box {
    width: round(1.6667px);     // 2px
    height: round(1.3333px);    // 1px
}

```
+ percentage：百分比
```
.box {
    width: percentage(0.5);
    height: percentage(0.2);
}
```
+ sqrt
```
.box {
    width: sqrt(25%);
}
```

#### 1.5.2 Sass支持的函数
+ round：四舍五入
```
.box {
    width: round(1.6667px);     // 2px
    height: round(1.3333px);    // 1px
}
```
+ percentage：百分比
```
.box {
    width: percentage(0.5);
    height: percentage(0.2);
}
```
+ random：随机数
```
.box {
    margin: random() * 20;
}
```
+ function：函数
```
@function column-width($col, $total) {
    @return percentage($col/$total);
}

.col-3 {
    width: column-width(3, 24);
}
```

### 1.6 混入、命名空间、继承

#### 1.6.1 Less混入
+ 如果带括号，定义的部分不会被单独解析
+ 如果不带括号，定义的部分也会解析
```
.show {
    display: block;
}

.text-center() {
    text-align: center;
}

.color(@color) {
    color: @color;
    &:hover {
        color: @color * 2;
    }
}

@size: 100px;
.box {
    width: @size;
    height: @size;

    .show;
    
    .text-center;

    .color(#666)
}
```

#### 1.6.2 Scss混入

```
@mixin show() {
    display: block;
}

@mixin color($color) {
    color: $color;

    &:hover {
        color: $color * 2;
    }
}

$size: 100px;
.box {
    width: $size;
    height: $size;
    @include show();
    @include color(#333);
}

```

#### 1.6.3 命名空间（Less）
> 只有Less有命名空间的概念，SCSS没有命名空间的概念

```
#test() {
    .show {
        display: block;
    }
}

.box {
    #test.show;
}
```

#### 1.6.4 Less继承

```
.center {
    text-align: center;
}

.box {
    &:extend(.center);
}

.header {
    &:extend(.center);
}
```

#### 1.6.5 Scss继承

+ `.`：会被单独解析
+ `%`: 不会被单独解析

```
.text-center {
    text-align: center;
}

%text-right {
    text-align: right;
}

.box1 {
    @extend .text-center;
}

.box2 {
    @extend %text-right;
}
```
编译结果：
```
.text-center, .box1 {
  text-align: center;
}
.box2 {
  text-align: right;
}

```

### 1.7 合并

#### 1.7.1 Less合并
```
.box {
    background+: url("a.png");
    background+: url("b.png");
    transform+_: scale(2);
    transform+_: rotate(30deg);
}
```
编译结果：
```
.box {
  background: url("a.png"), url("b.png");
  transform: scale(2) rotate(30deg);
}
```

#### 1.7.2 Scss合并
```
$background: (
    a: url("a.png"),
    b: url("b.png")
);

$transform: (
    a: scale(1.2),
    b: rotate(45deg)
);
.box {
    background: map-values($background);
    transform: zip(map-values($transform)...);
}
```
编译结果：
```
.box {
  background: url("a.png"), url("b.png");
  transform: scale(1.2) rotate(45deg);
}
```

### 1.8 条件判断、循环

#### 1.8.1 Less 条件判断、循环

```
.get(@cn) when (@cn > 4) {
    margin-right: 0;
}

.get(@cn) when (@cn <= 4) {
    margin-right: 1rem;
}

.box1 {
    .get(3);
}

.box2 {
    .get(4);
}

.box3 {
    .get(5);
}

```

#### 1.8.2 Scss 条件判断、循环

```
@mixin marginRight($count) {
    @if($count > 4) {
        margin-right: 0;
    }
    @else{
        margin-right: 1rem;
    }
}

.box1 {
    @include marginRight(3);
}

.box2 {
    @include marginRight(4);
}

.box3 {
    @include marginRight(5);
}
```

### 1.9 导入

> `less` 和 `scss`语法一致

```
//less
@import './reset.less';

//scss
@import './reset.scss';

```
