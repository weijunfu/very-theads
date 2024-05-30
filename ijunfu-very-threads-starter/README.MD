
# 自定义Starter

## 1. 引入依赖
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```
## 2. 定义业务处理类

父类：
```java
/**
 * @Title : Ip计数器服务类接口
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 14:56
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
public interface IpCounterService {

    /**
     * @Title  : 根据IP记录访问次数
     *
     * @Param	:
     * @Return : void
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:00
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    void record();

}
```
子类：
```java
@Slf4j
public class IpCounterServiceImpl implements IpCounterService {
    
    @Resource
    private HttpServletRequest request;

    @Resource
    private IpConfiguration ipConfiguration;
    
    private Map<String, Integer> map = new HashMap<>();
    
    @Override
    public void record() {
        // ip
        String ip = request.getRemoteAddr();

        // 访问次数
        Integer counter = map.getOrDefault(ip, 0);

        // 更新
        map.put(ip, counter + 1);

        // 输出
        map.forEach((key, value) -> {
            if(ipConfiguration.getDisplay().equals(IpConfiguration.Display.SIMPLE.getValue())) {
                log.info("ip: {}\tcount:{}", key, value);
            } else {
                log.info("\t\tIp访问监控");
                log.info("+------------------------------------+");
                log.info("|{}\t\t{}", key, value);
                log.info("+------------------------------------+");
            }

        });
    }
}
```

## 3. 定义自动配置类
```java
/**
 * @Title : 自动配置类
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 15:03
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
@ComponentScan("com.ijunfu.starter.config")     // 扫描自定义配置类
public class IpAutoConfiguration {

    /**
     * @Title  : 注册业务类
     *
     * @Param	:
     * @Return : com.ijunfu.starter.service.IpCounterService
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:02
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public IpCounterService ipCounterService() {
        return new IpCounterServiceImpl();
    }

    /**
     * @Title  : 注册拦截器类
     *
     * @Param	: ipCounterService
     * @Return : com.ijunfu.starter.interceptor.IpCounterInterceptor
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:02
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public IpCounterInterceptor interceptor(IpCounterService ipCounterService) {
        return new IpCounterInterceptor(ipCounterService);
    }

    /**
     * @Title  : 注入拦截器
     *
     * @Param	: interceptor
     * @Return : com.ijunfu.starter.config.SpringMvcConfig
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:03
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    @Bean
    public SpringMvcConfig springMvcConfig(IpCounterInterceptor interceptor) {
        return new SpringMvcConfig(interceptor);
    }
}
```


## 3. 定义配置文件

在`resources`下创建文件`META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`
添加如下内容：
```text
com.ijunfu.starter.config.IpAutoConfiguration
```