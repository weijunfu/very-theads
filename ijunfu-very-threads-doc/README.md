
# 集成 SpringDoc

## 引入依赖

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

## 编辑配置文件
```yaml
server:
  port: 7200

springdoc:
  swagger-ui:
    enabled: true
    path: /swagger-ui
  api-docs:
    enabled: false
```

## 新增配置类

```java
@Configuration
public class DocConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("system")
                .pathsToMatch("/system/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("gen")
                .pathsToMatch("/gen/**")
//                .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(
                                new License().name("Apache 2.0").url("http://springdoc.org")
                        )
                        .contact(new Contact().name("ijunfu").email("ijunfu@gmail.com"))
                )
                        .externalDocs(
                                new ExternalDocumentation()
                                    .description("SpringShop Wiki Documentation")
                                    .url("https://springshop.wiki.github.org/docs")
                        );
    }
}
```

## 启动项目

访问 http://localhost:7200/swagger-ui/index.html