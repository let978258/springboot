业务实现:
实现业务接口
1)我的购物车(查询where user_id=??)
2)加入商品到购物车(新增,提交方式post,(模拟post提交httpClient,带参提交))
  判断:(在后台查询此用户的此商品是否存在)
  a)如果此用户的此商品已经存在购物车,则进行修改记录num值
      a1)查询出来原来记录的数量,加上新提交的商品数量
  b)如果此用户的此商品不存在,则进行新增操作,
3)更新商品的数据(修改where user_id=?? and item_id=??? num=n 直接修改页面信息)
4)删除购物车中的商品(根据user_id item_id进行删除数据表信息)

通用Mapper与MybatisPlus的区别?
1)单表的CRUD操作无需SQL语句
2)基于拦截器实现,自动拼接SQL(Mapper 性能相对低,无效判断)
  a)select id,nam from user 关键字(selectList/selectOne)
    +字段(命名空间,传递参数User,User的属性(反射) @Field userName user_name)
    +表名(JPA注解 @Table(name="tb_user") 反射)
2)基于注解方式!(MybatisPlus)
  a)启动项目(初始化1次)性能高
3)JPA注解,J2E规范,@Table @Id @Field,
  MybatisPlus自定义一套注解规范 @TableName,@TableId @TableField

开发步骤:
1)创建SpringBoot Maven工程(let-cart)(STS IDEA)
2)修改pom.xml,增加付工程starter-parent,增加依赖starter-web Mybatis-plus mysql驱动 
3)编写pojo,没有JPA注解,使用MybatisPlus注解
4)创建持久层:接口文件CartMapper接口文件,使用Mybatis的注解方式.(继承BaseMapper接口)
5)创建业务层:接口+映射类
6)创建控制层:controller
7)调用:RESTFul+save用httpClient工具类
8)配置文件:application.yml
9)启动:RunApp

项目小结:
1)使用SpringBoot书写购物车,相对于SSM框架较为简洁,并且配置文件大幅度减少,依赖jar包冲突问题得到很大解决.
2)httpClient和dubbo和SpringBoot有什么区别?
  a)httpClient ajax提交,传递json串,不安全,同名,浏览器能截取,不够稳定,很容易造成超市异常,
  		httpClient不支持负载均衡.httpClient本质工具包.
  b)dubbo RPC远程过程调用,内部走的二进制方式,支持压缩,传递信息快,安全,支持负载均衡,实现多个"服务",
      	通过端口号,通过控制台,设置权重,可以动态停止,动态开启.
      依托与Zookeeper注册中心管理服务?
                优点:zk内部有心跳检测机制,并进行失败重试,当程序"复活"后,将其又加入列表中,而且zk集群,每个节点数据实时同步,
                缺点:集群中节点选举会阻塞使用,节点宕机一半会导致服务不可用,zk设计是强一致性
      为什么不用Redis替代Zookeeper?
  	  Redis ping是不"完整"心跳检测所有不能代替Zookeeper机制.
  c)SpringBoot基于json 
  	     优点:SpringBoot简化开发,三大框架文件与web.xml实现替代,衍生出application.yml,配置量大幅度减少,
  	     SpringBoot完全开源,dubbo有闭源风险,支持异构是比较好的,json通用,基于注解方式,开发和部署都有所变化,
  	   	    部署没有见到tomcat,易打war,快速,方便,依托Eureka注册中心,比Zookeeper强大许多.实现真正的高可用.
  	     缺点:,安全性较差,没有RPC性能高.    




