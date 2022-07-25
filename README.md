# fromzero

from zero to a project

## 第2步：多人协作(代码风格Checkstyle)和lombok

1. 使用lombok来大量减少胶水代码  
https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.24
将依赖添加到`pom.xml`的`dependency`中
***如果注解报红，可以利用idea自动检查以解决**
2. 安装checkstyle插件，并配置java代码风格。  
https://checkstyle.sourceforge.io/google_style.html  
   ** 一般来说在团队合作中，代码风格统一不仅可以方便代码review，还可以减少很多不必要的麻烦。当设置好checkstyle和相应的
code Style之后可以利用idea的功能将idea的配置全部导出，以方便其它团队成员使用。双击shift,呼出快捷命令，输入`export`,找到
`export settings`以导出配置。双击shift,呼出快捷命令，输入`import`,找到`import settings`以导入配置。注意，checkstyle插件
需要额外下载.
