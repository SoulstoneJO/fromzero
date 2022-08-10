# fromzero
from zero to a project

## 第10步：网络请求
Spring作为客户端向外请求数据。

1. 添加webclient依赖
```
        <!--    web client    -->
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
            <version>2.7.1</version>
        </dependency>
```
如果是 mac m1， 需要额外依赖解决DNS问题。
```
        <!-- Unable to load io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider, fallback to system defaults. This may result in incorrect DNS resolutions on MacOS.-->
        <!-- https://mvnrepository.com/artifact/io.netty/netty-resolver-dns-native-macos -->
        <dependency>
            <groupId>io.netty</groupId>
            <artifactId>netty-resolver-dns-native-macos</artifactId>
            <version>4.1.72.Final</version>
            <classifier>osx-aarch_64</classifier>
        </dependency>
```
2. 利用postman做mock服务器。  
https://www.youtube.com/watch?v=n_7UUghLpco&t=228s  

3. 配置相应的环境参数，对于webclient的配置和所需要的远程访问参数分开配置可以使得配置文件更加清晰，配置代码详见项目。

4. 编写remoteclient，此处代码的抽象程度应具体问题具体分析，如果需要更高的抽象程度以减少冗余代码，可以利用泛型等技术。

5. `network`包下的子包`entity`存放需要远程调用的实体类。此处因为测试方便，网络实体类与前端需求的实体类数据结构一致，不再在`model`中继续编写实体类了。

6. 编写相应的`controller`层和`service`层代码并测试。




