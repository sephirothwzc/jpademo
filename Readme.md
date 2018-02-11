## 2018-02-11 吴占超
1. java命名规范
    1. 包名，使用网络地址倒置，小写，如com.myssh.action。
    2. 类名，大写开头，驼峰写法，如LoginAction。
    3. 方法名，小写开头，驼峰写法，如getUser()。
    4. 变量名，小写开头，驼峰写法，如userId。
    5. 常量名，大写开头，下划线分割，如MAX_LENGTH。
    6. final变量，用大写字母+下划线命名
2. 项目结构规范
    1. cntroller->service->jpadao
    2. model服务于service
    3. entity映射数据库对象
    4. interceptor拦截器
    5. iiteral字面量常量
    6. commtools通用组件
    7. base父类集合
    8. controller控制层
    9. service服务层
    10. jpadao数据持久层（DAO）

