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

