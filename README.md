# fromzero
from zero to a project

## 第8步：异常处理
每当后台发生错误时，前端就会收到各种各样的网络状态码，但是这些状态码繁多且不实用；所以我们倾向与管理所有异常，并且返回一个自定义的错误处理码和信息。

1. 自定义需要的返回码(`ResultCode`)和想定的异常(`FromZeroXXXXException`)
2. 编写发生异常时需要的dto和ExceptionHandler异常处理器来处理突发的异常。  
3. 编写切面(AOP 需要依赖)打印日志，异常发生是需要及时处理的错误，为了把所有参数信息打印出来，使用了反射。  

* 有的时候单单打印出异常发生的日志并不能及时通知程序员，通常情况下需要与logback联合使用，通过发送邮件或者Webhook，迅速让程序员调查。

https://github.com/maricn/logback-slack-appender Slack    
https://www.cnblogs.com/lsysy/p/9935551.html Mail   
https://github.com/napstr/logback-discord-appender Discord 


