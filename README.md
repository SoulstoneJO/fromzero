# from zero
from zero to a project

## 综述
这是降龙十八掌的最后一掌✋，必须要将之前所有学到的知识融汇贯通方能施展，我们不再通过Spring boot初始化页面初始化单模块项目，而是通过idea的帮助，
利用maven建立一个多模块项目。（当然gradle也是同理）此次，我们将利用openapi(swagger)进行接口文档管理。

## 从零开始项目
1. 创建父模块maven项目(默认`next`到第二步,取名三要素，将不要的`src`包删去)  
![image](static/maven%201.png)
2. 再创建两个子模块`api`(存放接口代码)和`app`(存放spring项目和jar包)  
![image](static/maven%20api.png)   
![image](static/maven%20app.png)   
* 如果是从空文件夹开始，可以把parent也配置好
3. 检查Maven pom配置文件，使其满足父子结构。
`pom.xml(api)`:  
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--The identifier of the parent POM-->
    <parent>
        <groupId>learn.tytcc</groupId>
        <artifactId>fromzero</artifactId>
        <version>1.0</version>
    </parent>

    <artifactId>api</artifactId>

</project>
```
`pom.xml(app)`:  
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--The identifier of the parent POM-->
    <parent>
        <groupId>learn.tytcc</groupId>
        <artifactId>fromzero</artifactId>
        <version>1.0</version>
    </parent>

    <artifactId>app</artifactId>

</project>
```
`pom.xml(fromzero)`:  
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>learn.tytcc</groupId>
    <artifactId>fromzero</artifactId>
    <version>1.0</version>
    <packaging>pom</packaging>

    <modules>
        <module>api</module>
        <module>app</module>
    </modules>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

</project>
```
4. 将常用配置文件添加到项目根目录。
   - `.gitignore`: git文件上传规则配置文件
   - `environment`: 开发环境存放文件夹
   - `storage`: IDEA代码风格配置文件夹
   
5. 将openapi maven plugin集成到api子模块中。
   https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin

6. 编写openapi配置文件

7. 将Spring boot项目集成到app子模块中

8. 在APP模块中添加`API`模块

9. 改写controller



