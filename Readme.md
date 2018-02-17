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

## 2018-02-12 吴占超
1. Spring Data Jpa 分页
    @RequestMapping(value = "/manager")
    public BaseResult cutUserPage(InCutUsePage param) {
        Pair<List<EntitySysUser>,Long> pair = serviceSysUser.cutPage(param);
        BaseResult baseResult = new BaseResult();
        baseResult.setData(new Runnable(){
            public List<EntitySysUser> rows = pair.getKey();
            public Long total = pair.getValue();
            public void run(){
            }
        });
        return baseResult;
    }
    // 此方法被再次应用的可能性几乎为零
    public Pair<List<EntitySysUser>,Long> cutPage(BasePagination param) {
        PageRequest pageRequest = param.getPageRequest();
        //执行分页
        Page page = jpaSysUser.findAll(pageRequest);
        return new Pair<List<EntitySysUser>,Long>(page.getContent(),page.getTotalElements());
    }

## 2018-02-14 吴占超
1. 引入jpa-scpe支持动态查询（参考地址：https://github.com/wenhao/jpa-spec）
2. 多表复杂联查根据业务创建视图对象 也可采用 QueryDSL进行查询（建议）
3. 依然保留了QueryDSL 便于进行聚合处理
    service
    
    //实体管理对象
    @Autowired
    private EntityManager entityManager;
    //queryDSL,JPA查询工厂
    private JPAQueryFactory queryFactory;

    //实例化查询工厂
    @PostConstruct
    public void init()
    {
        queryFactory = new JPAQueryFactory(entityManager);
    }
    
        /**
         * count聚合函数
         * @return
         */
        public long countExample()
        {
            //用户查询实体
            QUserBean _Q_user = QUserBean.userBean;
            return queryFactory
                    .select(_Q_user.id.count())//根据主键查询总条数
                    .from(_Q_user)
                    .fetchOne();//返回总条数
        }
    
    /**
     * group by & having聚合函数
     * @return
     */
    public List<UserBean> groupByExample()
    {
        //用户查询实体
        QUserBean _Q_user = QUserBean.userBean;
        return queryFactory
                .select(_Q_user)
                .from(_Q_user)
                .groupBy(_Q_user.socre)//根据积分分组
                .having(_Q_user.age.gt(22))//并且年龄大于22岁
                .fetch();//返回用户列表
    }
4. Entity-Validation
    以下是对hibernate-validator中部分注解进行描述：
    
    @AssertTrue	用于boolean字段，该字段只能为true  
    @AssertFalse	该字段的值只能为false
    @CreditCardNumber	对信用卡号进行一个大致的验证
    @DecimalMax	只能小于或等于该值
    @DecimalMin	只能大于或等于该值
    @Digits(integer=,fraction=)	检查是否是一种数字的整数、分数,小数位数的数字
    @Email	检查是否是一个有效的email地址
    @Future	检查该字段的日期是否是属于将来的日期
    @Length(min=,max=)	检查所属的字段的长度是否在min和max之间,只能用于字符串
    @Max	该字段的值只能小于或等于该值
    @Min	该字段的值只能大于或等于该值
    @NotNull	不能为null
    @NotBlank	不能为空，检查时会将空格忽略
    @NotEmpty	不能为空，这里的空是指空字符串
    @Null	检查该字段为空
    @Past	检查该字段的日期是在过去
    @Pattern(regex=,flag=)	被注释的元素必须符合指定的正则表达式
    @Range(min=,max=,message=)	被注释的元素必须在合适的范围内
    @Size(min=, max=)	检查该字段的size是否在min和max之间，可以是字符串、数组、集合、Map等
    @URL(protocol=,host,port)	检查是否是一个有效的URL，如果提供了protocol，host等，则该URL还需满足提供的条件
    @Valid	该注解主要用于字段为一个包含其他对象的集合或map或数组的字段，或该字段直接为一个其他对象的引用，这样在检查当前对象的同时也会检查该字段所引用的对象

## 2018-02-15 吴占超
1. 