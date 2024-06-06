
# iText 7

## 概述

+ iText 7 is a library for creating and manipulating PDF files in `Java` and `.Net`.
+ iText was written by Bruno Lowagie.
+ iText 7 Core is available under open source(AGPL) as well as a commercial license.

## 引入依赖
```xml
<properties>
    <java.version>21</java.version>
    <encoding>UTF-8</encoding>
    <project.build.sourceEncoding>${encoding}</project.build.sourceEncoding>
    <project.reporting.outputEncoding>${encoding}</project.reporting.outputEncoding>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>
    <itext.version>8.0.4</itext.version>
</properties>

<dependencies>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>kernel</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>io</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>layout</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>forms</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>pdfa</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>sign</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>barcodes</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>font-asian</artifactId>
        <version>${itext.version}</version>
    </dependency>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>hyph</artifactId>
        <version>${itext.version}</version>
    </dependency>
</dependencies>
```

## 一、Hello World
```java
// step 1: 创建PdfWriter，文件目录必须存在
PdfWriter pdfWriter = new PdfWriter("E:/itext/test.pdf");

// step 2: 创建PdfDocument
PdfDocument pdfDocument = new PdfDocument(pdfWriter);
pdfDocument.addNewPage();   // 新增一个页面

// step 3: 创建Document
Document document = new Document(pdfDocument);

// step 4: 创建Paragraph
Paragraph paragraph = new Paragraph("Hello, World!");
document.add(paragraph);

// step 5: 关闭Document
document.close();
```

## 二、添加图片

```java
// 添加图片
ImageData imageData = ImageDataFactory.create(new URL("https://yt3.ggpht.com/yti/ANjgQV9sRd7-Zi9uW0656uLzYl-2AkZDfvrnkG2BlrcUh-zAPg=s88-c-k-c0x00ffffff-no-rj-mo"));
Image image = new Image(imageData);
document.add(image);
```

## 三、添加列表

这里需要使用`import com.itextpdf.layout.element.List`：

```java
List languages = new List();
languages.add("Java");
languages.add("C");
languages.add("Go");
languages.add("Python");
document.add(languages);
```
## 四、添加字体