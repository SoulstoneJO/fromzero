# fromzero
from zero to a project

## 第9步：消息汇总和语言国际化
语言国际化处理

1. 在controller中添加`@RequestHeader`注解获取请求头里的变量。

2. 在`resources`文件夹下新建多个语言资源文件夹，由于`messages.properties`是Srpingboot的默认配置，因此不需要在application中额外配置。

3. 添加`MessageCode`以增加字符串代码复用。 

4. 在service中注入`MessageSource`并使用。 

5. 这种写法虽然实现了要求，但是有一些瑕疵；我更愿意在`common`包中多增加一个spring容器管理的组件并注入`Messagesource`,其中，要对前端传入的语言参数进行核对是否满足要求，例如传入了`language=ko`时需要报错，再优化方法，提供更简便的方法调用，消除`null`参数。
```
throw new FromZeroParameterException(
    messageSource.getMessage(MessageCode.PARAM_USERID_EMPTY, null, new Locale(language)));
```
