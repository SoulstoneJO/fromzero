# fromzero

from zero to a project

## 第4步： 持久化
1. 在pom中添加mybatis依赖和mybatis generator plugin插件。
```
<!--	SpringBoot 与 mybatis 整合依赖	-->
<!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
<dependency>
   <groupId>org.mybatis.spring.boot</groupId>
   <artifactId>mybatis-spring-boot-starter</artifactId>
   <version>2.1.3</version>
</dependency>

<!--	java 对 mysql 的数据库连接依赖 	-->
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>8.0.29</version>
</dependency>
```
```
<plugin>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-maven-plugin</artifactId>
      <version>1.4.1</version>
      <executions>
         <execution>
            <id>Generate MyBatis Artifacts</id>
            <goals>
                  <goal>generate</goal>
            </goals>
            <configuration>
                  <configurationFile>
                     src/main/resources/generator_configuration.xml
                  </configurationFile>
                  <overwrite>true</overwrite>
                  <verbose>true</verbose>
                  <includeCompileDependencies>true</includeCompileDependencies>
            </configuration>
         </execution>
      </executions>
</plugin>
```
2. 编写generator_configuration.xml，并在pom.xml的properties中添加需要的参数。 

3. 在代码中添加Service层，通过Spring框架特性(DI依赖注入 和 IOC控制反转)编写service层 

4. 删掉不必要的dao包，修改controller相关代码 

5. 更新docker中的数据库，启动docker模拟mysql数据库 

6. 在application.yaml中配置mybatis logger

7. postman文件夹包含http请求的测试文件 

8. 相关资料： https://docs.google.com/document/d/1W-WEgn_n6a072xrFNGE6DYNH5-4_k9inYU07_T2lTp4/edit?usp=sharing
