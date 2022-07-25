# fromzero
from zero to a project

## 第0步：创建一个项目
### 在GitHub上创建一个空仓库(repository)
1. 登录`GitHub`，点击绿色的`new`按钮，跳转到仓库新建页面  

![new repo](/static/pic1.png)

***gitignore文件存放git不需要管理的文件目录，稍后设置**

2. 创建成功后利用`Open with Github desktop`打开。<br/>

![download project](/static/pic2.png)

***`github desktop`下载地址** https://desktop.github.com/

### 初始化一个Spring项目
1. 前往Spring初始化页面配置项目并点击`GENERATE`生成按钮下载。
![new spring projcet](/static/pic3.png)

***`spring initializr`地址** https://start.spring.io/

2. 解压缩下载的文件  <br/>

![spring project](/static/pic4.png)

3. 在Github Desktop菜单栏上，点击`Show in Exployer`打开文件目录  <br/>

![spring project](/static/pic5.png)

4. 将所有解压缩后的文件拷贝到项目根目录中。
```
FROMZERO
└───.mvn # mvn依赖管理， mvn wrapper
│   │  
│   └─── ...
└───src # 源代码目录
│   │  
│   └─── ...
└───.gitignore # 排除git托管的配置文件
└───mvnw # linux mvn脚本
└───mvnw.cmd # windows mvn脚本
└───pom.xml # mvn的依赖配置文件
└───README.md # 项目说明文件(markdown标记语言)
```
