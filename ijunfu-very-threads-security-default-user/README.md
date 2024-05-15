
# Spring Security 实战 - 基于默认用户

## 创建项目
```xml
<dependencies>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <dependency>
        <groupId>com.ijunfu</groupId>
        <artifactId>ijunfu-very-threads-common</artifactId>
        <version>${project.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <scope>provided</scope>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-undertow</artifactId>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 创建IndexController

```java
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
```

## 创建页面
```html
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Hello Security | ijunfu</title>
</head>
<body>
<h1>Hello Security</h1>
<a th:href="@{/logout}">退出 2</a>
<a href="/logout">退出 2</a>
</body>
</html>
```

## 项目配置
```yaml
# application.yml
server:
  port: 7200
  name: 权限管理

spring:
  main:
    banner-mode: off
  thymeleaf:
    cache: off
    mode: HTML
    prefix: classpath:/templates/
    suffix: .html
    encoding: UTF-8
    enabled: on
  profiles:
    active: dev
```

## 启动项目

Spring Security默认用户为`user`, 密码会被打印在控制台，例如：`Using generated security password: fdd4340d-e100-4952-a804-7283644e7ebe`，其中`fdd4340d-e100-4952-a804-7283644e7ebe`为用户密码。

访问：`http://localhost:7200/`，会跳转至SpringSecurity默认的登录页面


