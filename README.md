# fromzero
from zero to a project

## 第5步： 复杂SQL语句的编写
mybatis generator只能解决部分单表查询问题；当面对复杂业务时，经常需要学会mybatis的语法来编写复杂的SQL语句(也有可能是动态SQL语句。)

### 提出问题
现在前端需要一下的json数据来显示用户信息
```
{
    "userId": 1,
    "userName": "tom",
    "roleName": "管理者",
    "permissionList": [
        {
            "permissionId": 1,
            "permissionName": "write"
        },
        {
            "permissionId": 2,
            "permissionName": "read"
        }
    ]
}
```
### 分析问题和组织文件和代码结构
1. 我们可以发现这个json涉及了三张表[admin, role, permission]的数据, 所以首先我们要尝试编写获取这些数据的SQL语句。首先我可以通过联查admin和role两张表获取userId，userName，roleName和role_permission。其中，role_permission是存在mysql数据库中的json类型，因此需要特别处理。所以，我先做一次双表查询，获取数据后，根据role_permission再做多次单表查询获取permissionList的具体信息。 （单表查询可以利用mybatis generator生成的单表查询语句）
```
select 
  admin.`user_id`, 
  admin.`user_name`, 
  role.`role_name`, 
  role.`role_permission` 
from 
  admin 
  left join role on admin.`user_role` = role.`role_id` 
where 
  user_id = 1 # 以user_id=1为示例
```   
2. 因为这次请求的request和response都是自定义的实体类，所以需要编写新的java pojo类；在项目源文件添加model包，并新建次级包request和response来存放对应的实体类。(有的时候，这些实体类与orm层的entity结构一致，就不用再编写了)

3. idea Mybatis插件（https://plugins.jetbrains.com/plugin/10119-mybatisx）十分优秀，可以加快开发效率。

4. 在自动生成的包generated同级下创建customized包, 用来存放所有自定义内容，自定义实体类entity，自定义接口mapper，自定义配置xml文件。

5. 处理Json数据的时候所需要的方法可以重复使用，属于Util工具方法，新建common包来存放。

6. 完成service代码编写，组装需要的数据。

**java流写法：** 
**lombok builder**
  

