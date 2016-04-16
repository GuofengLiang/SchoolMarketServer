# SchoolMarketServer

##校园便利店后台
###开发环境：
  Myeclipse10.0   
  tomcat7.0   
  mysql5.5.2.0 
##什么是框架？
  也就是没有涉及到具体的代码的实现（控制层（需要基础框架的支持），逻辑层，持久层（需要基础框架的支持））。  
  但为具体的代码的实现提供了最基本的环境支持。 
##使用的框架:
  后台框架:Spring+springmvc+jpa+hibernate  
  前端：bootstrap+jQuery
##怎么使用框架？
###Spring：基于spring容器对网站进行管理。

####Web.xml中的配置：
```
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>
			classpath*:/applicationContext.xml
		</param-value>
	  </context-param>
	  <listener>
		 <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	  </listener>
```

####applicationContext.xml中的配置：
```
	<context:property-placeholder location="classpath*:/application.properties" ignore-resource-not-found="true" ignore-unresolvable="true" />
```
该标签引入属性跟值的配置。
启用注解： 
```
<context:component-scan base-package="com.nsoft.qoes">
		<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
	</context:component-scan>
```
  @resource(name=”bean的名称”)注入bean
####为什么 @Repository 只能标注在 DAO 类上呢?
  这是因为该注解的作用不只是将类识别为 Bean，同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。        Spring 本身提供了一个丰富的并且是与具体的数据访问技术无关的数据访问异常结构，用于封装不同的持久层框架抛出的异常，使得异常独立于底层的框架。
Spring 2.5 在 @Repository 的基础上增加了功能类似的额外三个注解：@Component、@Service、@Constroller，它们分别用于软件系统的不同层次：
- @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次。
-  @Service 通常作用在业务层，但是目前该功能与 @Component 相同。
-  @Constroller 通常作用在控制层，但是目前该功能与 @Component 相同。
  通过在类上使用 @Repository、@Component、@Service 和 @Constroller 注解，Spring 会自动创建相应的 BeanDefinition 对象，并注册到   ApplicationContext 中。这些类就成了 Spring 受管组件。这三个注解除了作用于不同软件层次的类，其使用方式与 @Repository 是完全相同的。  
  可以参考[相关博客](http://blog.csdn.net/xyh820/article/details/7303330/)的具体介绍
### Spring注解详解
#### 使用spring需要引入的jar包：

- spring-beans-3.2.2.RELEASE.jar
- spring-context-3.2.2.RELEASE.jar
- spring-context-support-3.2.2.RELEASE.jar
- spring-core-3.2.2.RELEASE.jar
- spring-expression-3.2.2.RELEASE.jar
- spring-jdbc-3.2.2.RELEASE.jar
- spring-orm-3.2.2.RELEASE.jar
- spring-test-3.2.2.RELEASE.jar
- spring-tx-3.2.2.RELEASE.jar
- spring-web-3.2.2.RELEASE.jar

##控制层：spring MVC
###Web.xml中的配置：
```
<servlet>
		<servlet-name>springmvc</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath*:/applicationContext-mvc.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>springmvc</servlet-name>
		<url-pattern>*.jhtml</url-pattern>
	</servlet-mapping>
```
###applicationContext-mvc.xml配置文件中
```
  <context:property-placeholder location="classpath*:/application.properties" ignore-resource-not-found="true"  
  ignore-unresolvable="true" />
```
该标签引入属性跟值的配置。
```
	<context:component-scan base-package="com.nsoft.qoes">
		<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
	</context:component-scan>
<mvc:annotation-driven />
```
####这样设置应该是考虑到性能的问题。
在SpringMVC中Controller不需要继承什么类，也不需要实现什么接口，一切使用了@Controller进行标记的类都是Controller  
有了Controller之后，那么到底是怎样请求一个Controller具体的方法的呢，那是通过@RequestMapping来标记的，   @RequestMapping可以标记在类上面，也可以标记在方法上，当方法上和类上都标记了@RequestMapping的时候，那么对应的方   法对应的Url就是类上的加方法上的，如下面的index方法，其对应的URL应为类上的/blog加上index方法上的/index，所以应为   /blog/index，所以当请求/blog/index.do的时候就会访问BlogController的index方法。加在类上的@RequestMapping不是必须的，   当Controller类上加上了@RequestMapping的时候，那么Controller方法上的@RequestMapping就是相对于类上的@RequestMapping而  言的，也就是前面说的请求映射的时候是类上的地址加方法上的地址，而当Controller类上没有加@RequestMapping的时候，方法上  的@RequestMapping就是绝对路径了。  
可以参考[基于注解的SpringMVC简单介绍](http://haohaoxuexi.iteye.com/blog/1343761/)

####关于视图的返回：
Jsp:
Xml代码 
```
<bean  id="viewResolver"
    class="org.springframework.web.servlet.view.InternalResourceViewResolver">  
    <property name="prefix" value="/WEB-INF/" />  
    <property name="suffix" value=".jsp" />  
</bean>  
``` 
在上述视图解析器中，如果Controller返回的是blog/index，那么通过视图解析器解析之后的视图就是/WEB-INF/blog/index.jsp。


#### 使用spring mvc需要引入的jar：

- spring-webmvc-3.2.2.RELEASE.jar

##持久层：jpa+hibernate
###ApplicationContext.xml中的配置：
```
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
		<property name="driverClass" value="${jdbc.driver}" />
		<property name="jdbcUrl" value="${jdbc.url}" />
		<property name="user" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
		<property name="initialPoolSize" value="${connection_pools.initial_pool_size}" />
		<property name="minPoolSize" value="${connection_pools.min_pool_size}" />
		<property name="maxPoolSize" value="${connection_pools.max_pool_size}" />
		<property name="maxIdleTime" value="${connection_pools.max_idle_time}" />
		<property name="acquireIncrement" value="${connection_pools.acquire_increment}" />
		<property name="checkoutTimeout" value="${connection_pools.checkout_timeout}" />
	</bean>

	<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="persistenceXmlLocation" value="classpath*:/persistence.xml" />
		<property name="persistenceUnitName" value="persistenceUnit" />
		<property name="jpaVendorAdapter">
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
				<property name="showSql" value="false" />
				<property name="generateDdl" value="true" />
			</bean>
		</property>
		<property name="jpaProperties">
			<props>
				<prop key="hibernate.dialect">${hibernate.dialect}</prop>
				<prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
				<prop key="hibernate.cache.use_second_level_cache">${hibernate.cache.use_second_level_cache}</prop>
				<prop key="hibernate.cache.region.factory_class">${hibernate.cache.region.factory_class}</prop>
				<prop key="hibernate.cache.use_query_cache">${hibernate.cache.use_query_cache}</prop>
				<prop key="hibernate.jdbc.fetch_size">${hibernate.jdbc.fetch_size}</prop>
				<prop key="hibernate.jdbc.batch_size">${hibernate.jdbc.batch_size}</prop>
				<prop key="hibernate.connection.isolation">3</prop>
				<prop key="javax.persistence.validation.mode">none</prop>
				<prop key="hibernate.search.default.directory_provider">org.hibernate.search.store.FSDirectoryProvider</prop>
				<prop key="hibernate.search.default.indexBase">${java.io.tmpdir}/${system.project_name}/index</prop>
				<prop key="hibernate.show_sql">true</prop>
			</props>
		</property>
	</bean>

	<bean id="sessionFactory"	factory-bean="entityManagerFactory"	factory-method="getSessionFactory" />
	
	<bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">
		<property name="sessionFactory" ref="sessionFactory"></property>
	</bean>
```
也就是说这些配置文件都没有涉及到具体的实现类.

#### 使用hibernate和jpa需要引入的jar包：

- antlr-2.7.7.jar
- asm-4.0.jar
- cglib-3.0.jar
- hibernate-core-3.6.0.Final.jar       hibernate核心包
- hibernate-commons-annotations-3.2.0.Final.jar   注解
- hibernate-entitymanager-3.6.0.Final.jar
- hibernate-jpa-2.0-api-1.0.0.Final.jar
- hibernate-search-3.4.2.Final.jar
- hibernate-search-analyzers-3.4.2.Final.jar  
- hibernate-validator-4.2.0.Final.jar  对字段校验
- jta-1.1.jar  事务
- mysql-jdbc-5.1.25.jar
- dom4j-1.6.1.jar
- commons-collections-3.2.1.jar
- commons-logging-1.1.1.jar

#### 使用连接池需要引入的jar包：

- c3p0-0.9.2.1.jar
- mchange-commons-java-0.2.3.4.jar

### Application.properties中的配置：
```
system.name=SchoolMarket
system.version=1.0
system.description=SchoolMarket By 602Room
system.show_powered=true
system.project_name=SchoolMarke

#-------------JDBC -------------
jdbc.url=jdbc\:mysql\://localhost\:3306/dms_dev?useUnicode\=true&characterEncoding\=UTF-8
jdbc.username=root
jdbc.password=admin
jdbc.driver=com.mysql.jdbc.Driver

#------------ Hibernate ------------
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.cache.use_second_level_cache=false
hibernate.cache.region.factory_class=org.hibernate.cache.impl.NoCachingRegionFactory
hibernate.cache.use_query_cache=false
hibernate.jdbc.fetch_size=50
hibernate.jdbc.batch_size=30

#------------ ConnectionPools ------------
connection_pools.initial_pool_size=5
connection_pools.min_pool_size=5
connection_pools.max_pool_size=100
connection_pools.max_idle_time=600
connection_pools.acquire_increment=5
connection_pools.checkout_timeout=60000

#------------ Common ------------
locale=zh_CN
url_escaping_charset=UTF-8
```
###persistence.xml中的配置：
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
			 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
			 http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd" version="2.0">

	<persistence-unit name="persistenceUnit" transaction-type="RESOURCE_LOCAL"></persistence-unit>

</persistence>
```
##怎么验证框架？
####1.	涉及到对请求的处理的（验证springmvc）
####2.	涉及到表的生成跟数据库数据的交互的（验证Jpa+hibernate）

框架可以分开来验证，也可以同时验证。
###Ajax与springmvc的整合
####jsp页面
```
$.post("getimages.jhtml",function(data){
             $.each(data,function(i,item){
               $("<img/>").attr("src","uploadDir/"+item.filename).appendTo("#images");
             });})
```           
####控制层
```
@Controller
public class ReadJsonController {
    @ResponseBody
    @RequestMapping(value="/getimages")
	public List<Images> getImages(HttpServletRequest request){
    	String basePath = request.getSession().getServletContext()
				.getRealPath("/")+"uploadDir/";
    	List<Images> list=new ArrayList<Images>();
		Images images1=new Images();
		images1.setDescripe("tupian");
		images1.setFilename(basePath+"fruits.jpg");
		Images images2=new Images();
		images2.setDescripe("tu");
		images2.setFilename(basePath+"xigua.jpg");
		list.add(images1);
		list.add(images2);
		return list;
	}
```
###在applicationContext-mvc.xml中的配置：
```
	<mvc:annotation-driven/>
```
@ResponseBody
这时，这个标签才其效果。
这个标签的作用就是使返回去的数据自动封装成json数据。
可以参考[spring mvc和ajax异步交互完整实例](http://m.blog.csdn.net/article/details?id=43193183)


将数据自动封装成json数据需要引入的jar包:
 
#### 使用json数据需要引入的6个标准的jar包：

- json-lib-2.4-jdk15.jar
- ezmorph-1.0.6.jar
- commons-beanutils-1.8.3.jar
- commons-collections-3.2.1.jar
- commons-lang-2.6.jar
- commons-logging-1.1.1.jar

#### 网站所需要的基本jar包：
- dom4j-1.6.1.jar  解析xml文件
- javassist-3.12.1.GA.jar 动态编写字节码文件
- log4j-1.2.16.jar 打印日志
- lucene-analyzers-3.1.0.jar  检索关键字段
- lucene-core-3.5.0.jar
- commons-io-2.2.jar  涉及到流的操作
- commons-fileupload-1.2.2.jar 文件上传

