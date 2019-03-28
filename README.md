# histruts1

[TOC]

## 创建mvn项目

> mvn archetype:generate -DgroupId=com.microandroid -DartifactId=histruts1 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false -X -DarchetypeCatalog=local

## 加入Struts1依赖和servlet依赖

``` xml
<!--struts1框架-->
<dependency>
    <groupId>org.apache.struts</groupId>
    <artifactId>struts-core</artifactId>
    <version>1.3.10</version>
</dependency>

<!--servlet-->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
```

## 配置web.xml

``` xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
    <display-name>Archetype Created Web Application</display-name>

    <servlet>
        <servlet-name>action</servlet-name>
        <servlet-class>org.apache.struts.action.ActionServlet</servlet-class>
        <init-param>
            <param-name>config</param-name>
            <param-value>/WEB-INF/struts-config.xml</param-value>
        </init-param>
        <init-param>
            <param-name>debug</param-name>
            <param-value>3</param-value>
        </init-param>
        <init-param>
            <param-name>detail</param-name>
            <param-value>3</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>action</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
```

## 配置struts-config.xml

创建/WEB-INF/struts-config.xml

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts-config PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 1.2//EN"
        "http://jakarta.apache.org/struts/dtds/struts-config_1_2.dtd">

<struts-config>
    <form-beans>
        <form-bean name="empForm" type="EmpForm"/>
    </form-beans>
    <action-mappings>
        <action path="/emp" name="empForm" type="EmpAction">
            <forward name="index" path="/WEB-INF/views/emp/index.jsp"/>
            <forward name="success" path="/WEB-INF/views/emp/success.jsp"/>
            <forward name="error" path="/WEB-INF/views/emp/error.jsp"/>
        </action>
    </action-mappings>
</struts-config>
```

## 创建EmpAction

``` Java
package com.microandroid.moudle.emp.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LewJun
 * @version v0.1 2018/09/30 14:07 LewJun Exp $$
 */
public class EmpAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("execute");
        return mapping.findForward("success");
    }
}

```

## 创建EmpForm

``` Java
package com.microandroid.moudle.emp.bean;

import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * @author LewJun
 * @version v0.1 2018/09/30 14:07 LewJun Exp $$
 */
public class EmpForm extends ActionForm {
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Integer deptno;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "EmpForm{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", deptno=" + deptno +
                '}';
    }
}

```

## 配置views

创建文件，文件中暂时什么都没有

* /WEB-INF/views/emp/index.jsp
* /WEB-INF/views/emp/success.jsp
* /WEB-INF/views/emp/error.jsp

## 配置内置tomcat

``` xml
<plugins>
    <!--tomcat7插件-->
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.1</version>
        <configuration>
            <port>7070</port>
            <path>/histruts1</path>
            <uriEncoding>UTF-8</uriEncoding>
            <finalName>histruts1</finalName>
            <server>tomcat7</server>
        </configuration>
    </plugin>
</plugins>

访问 http://localhost:7070/histruts1/emp.do 将跳转到success对应的success.jsp页面
```

## 配置slf4j

* 添加依赖

``` xml
<!-- SLF4J (: -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.12</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.12</version>
    <exclusions>
        <exclusion>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<!-- SLF4J :) -->

<!-- log start -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
<dependency>
    <groupId>commons-logging</groupId>
    <artifactId>commons-logging</artifactId>
    <version>1.1.1</version>
</dependency>
<!-- log end -->
```

* 配置resources/log4j.properties

``` conf
### \u8BBE\u7F6ELogger\u8F93\u51FA\u7EA7\u522B\u548C\u8F93\u51FA\u76EE\u7684\u5730 ###
# log4j.rootLogger=DEBUG,info,warn,stdout,ALL,ERROR
log4j.rootLogger=debug,info,warn,stdout,ALL,ERROR

### console \u628A\u65E5\u5FD7\u4FE1\u606F\u8F93\u51FA\u5230\u63A7\u5236\u53F0 ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
#
#log4j.appender.stdout.Target=System.err
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[%5p]  %t  %d{yyyy-MM-dd HH:mm:ss,SSS}  %l  %m%n

### all information log ###
log4j.appender.ALL=org.apache.log4j.DailyRollingFileAppender
log4j.appender.ALL.File=${catalina.home}/logs/histruts1/all.log
log4j.appender.ALL.DatePattern='.'yyyy-MM-dd'.log'
#log4j.appender.ALL.Threshold=INFO
log4j.appender.ALL.layout=org.apache.log4j.PatternLayout
log4j.appender.ALL.layout.ConversionPattern=[%5p]  %t  %d{yyyy-MM-dd HH:mm:ss,SSS}  %l  %m%n

### info log ###
log4j.logger.info=info
log4j.appender.info=org.apache.log4j.DailyRollingFileAppender
log4j.appender.info.File=${catalina.home}/logs/histruts1/info.log
log4j.appender.info.DatePattern='.'yyyy-MM-dd'.log'
log4j.appender.info.Threshold=INFO
log4j.appender.info.layout=org.apache.log4j.PatternLayout
log4j.appender.info.layout.ConversionPattern=[%5p]  %t  %d{yyyy-MM-dd HH:mm:ss,SSS}  %l  %m%n
## \u53EA\u63A5\u53D7info
log4j.appender.info.filter.infoFilter=org.apache.log4j.varia.LevelRangeFilter
log4j.appender.info.filter.infoFilter.LevelMin=info
log4j.appender.info.filter.infoFilter.LevelMax=info

### error log ###
log4j.logger.error=error
log4j.appender.ERROR=org.apache.log4j.DailyRollingFileAppender
log4j.appender.ERROR.File=${catalina.home}/logs/histruts1/error.log
log4j.appender.ERROR.DatePattern='.'yyyy-MM-dd'.log'
log4j.appender.ERROR.Threshold=ERROR
log4j.appender.ERROR.layout=org.apache.log4j.PatternLayout
log4j.appender.ERROR.layout.ConversionPattern=[%5p]  %t  %d{yyyy-MM-dd HH:mm:ss,SSS}  %l  %m%n
log4j.appender.error.filter.errorFilter.LevelMin=error
log4j.appender.error.filter.errorFilter.LevelMax=error

### warn log ###
log4j.logger.warn=warn
log4j.appender.warn=org.apache.log4j.DailyRollingFileAppender
log4j.appender.warn.File=${catalina.home}/logs/histruts1/warn.log
log4j.appender.warn.Append=true
log4j.appender.warn.Threshold=WARN
log4j.appender.warn.layout=org.apache.log4j.PatternLayout
log4j.appender.warn.layout.ConversionPattern=[%5p]  %t  %d{yyyy-MM-dd HH:mm:ss,SSS}  %l  %m%n
log4j.appender.warn.datePattern= '.'yyyy-MM-dd'.log'
log4j.appender.warn.filter.warnFilter=org.apache.log4j.varia.LevelRangeFilter
log4j.appender.warn.filter.warnFilter.LevelMin=WARN
log4j.appender.warn.filter.warnFilter.LevelMax=WARN

###\u663E\u793ASQL\u8BED\u53E5\u90E8\u5206
log4j.logger.com.ibatis=DEBUG
log4j.logger.com.ibatis.common.jdbc.SimpleDataSource=DEBUG
log4j.logger.com.ibatis.common.jdbc.ScriptRunner=DEBUG
log4j.logger.com.ibatis.sqlmap.engine.impl.SqlMapClientDelegate=DEBUG
log4j.logger.java.sql.Connection=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

* 使用

``` Java
private static final Logger LOGGER = LoggerFactory.getLogger(EmpAction.class);

LOGGER.info('msg');
```

## 额外配置

### 编译插件

``` xml
<!--编译插件-->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <executions>
        <execution>
            <id>compile</id>
            <phase>compile</phase>
            <goals>
                <goal>compile</goal>
            </goals>
        </execution>
        <execution>
            <id>testCompile</id>
            <phase>test-compile</phase>
            <goals>
                <goal>testCompile</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <source>${java.version}</source>
        <target>${java.version}</target>
        <encoding>utf-8</encoding>
    </configuration>
</plugin>
```

### env 配置

和build标签同级

``` xml
<!-- 环境管理 -->
<profiles>
    <!-- 开发环境 -->
    <profile>
        <id>dev</id>
        <properties>
            <env>dev</env>
        </properties>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
    </profile>
    <!-- 外网测试环境 -->
    <profile>
        <id>itest</id>
        <properties>
            <env>itest</env>
        </properties>
    </profile>
    <!-- 生产环境 -->
    <profile>
        <id>prod</id>
        <properties>
            <env>prod</env>
        </properties>
    </profile>
    <!-- 预发布环境 -->
    <profile>
        <id>pre</id>
        <properties>
            <env>pre</env>
        </properties>
    </profile>
    <!-- 外网测试环境 -->
    <profile>
        <id>otest</id>
        <properties>
            <env>otest</env>
        </properties>
    </profile>
</profiles>
```

activeByDefault 代表默认激活

位于build标签中，打包时，不包括env/*.properties

``` xml
<filters>
    <filter>env/${env}.properties</filter>
</filters>
```

#### 创建env/*.properties

* dev.properties
* itest.properties
* otest.properties
* pre.properties
* prod.properties
  
分别代表不同的环境，今后使用mvn命令打包的时候即可使用
> mvn clean install -Potest

### 资源配置

位于build标签中

``` xml
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*</include>
        </includes>
    </resource>
    <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
        <includes>
            <include>**/*.properties</include>
        </includes>
    </resource>
</resources>
```

## 加入Service和Mapper的空实现

* Service

``` Java
package com.microandroid.moudle.emp.service;

import EmpForm;

import java.util.List;

public interface IEmpService<T extends EmpForm> {

    int deleteByPrimaryKey(Integer id) throws Exception;

    int inserts(List<T> ts) throws Exception;

    int insert(T record) throws Exception;

    int insertSelective(T record) throws Exception;

    T selectByPrimaryKey(Integer id) throws Exception;

    List<T> selectAll() throws Exception;

    int updateByPrimaryKeySelective(T record) throws Exception;

    int updateByPrimaryKey(T record) throws Exception;
}


```

* Service 实现

``` Java
package com.microandroid.moudle.emp.service.impl;

import EmpForm;
import IEmpService;

import java.util.List;

public class EmpServiceImpl implements IEmpService<EmpForm> {
    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return 0;
    }

    @Override
    public int inserts(List<EmpForm> empForms) throws Exception {
        return 0;
    }

    @Override
    public int insert(EmpForm record) throws Exception {
        return 0;
    }

    @Override
    public int insertSelective(EmpForm record) throws Exception {
        return 0;
    }

    @Override
    public EmpForm selectByPrimaryKey(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<EmpForm> selectAll() throws Exception {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(EmpForm record) throws Exception {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(EmpForm record) throws Exception {
        return 0;
    }
}


```

* Mapper

``` Java
package com.microandroid.moudle.emp.mapper;

public interface IEmpMapper {

}
```

## 实现页面跳转

如果我想要执行指定方法例如 emp.do?save，emp.do?delete该怎么办呢？

### 方案1

通过req.getParameter("method");来得到method进行判断，然后执行指定的方法

``` Java
public class EmpAction extends Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("execute");
        String method = request.getParameter("method");
        String forwardName = "success";
        if ("save".equals(method)) {
            forwardName = save(mapping, form, request, response).getName();
        }
        LOGGER.info(forwardName);
        return mapping.findForward(forwardName);
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        return mapping.findForward("save");
    }


}
```

### 方案2

使用DispatchAction

1. 引用依赖

``` xml
        <!--struts1 extras-->
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts-extras</artifactId>
            <version>1.3.10</version>
        </dependency>
```

2. 类继承自DispatchAction

``` Java
public class EmpAction extends DispatchAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("execute");
        return mapping.findForward("success");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        return mapping.findForward("save");
    }
}

```

3. 配置action parameter="method"

这是必须的

``` Java
<action path="/emp"
        name="empForm"
        type="EmpAction"
        parameter="method"
>
```

4. 注意

一旦配置，今后的请求中就必须添加method作为参数，否则就要报错。
> javax.servlet.ServletException: Request[/emp] does not contain handler parameter named 'method'.  This may be caused by whitespace in the label text.

并且不能重写@Override public ActionForward execute方法，否则上面的配置都没有作用。

### 方案3

1. 继承自MappingDispatchAction

``` Java
public class EmpAction extends MappingDispatchAction {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpAction.class);

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("save");
        return mapping.findForward("success");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("delete");
        return mapping.findForward("error");
    }
}
```

2. 配置struts-config.xml

``` xml
    <action-mappings>
        <!--parameter必须对应到EmpAction中的实际方法，缺点就是配置的action特别多，
        实际工作中，我认为为了减少配置，最好还是使用DispatchAction-->
        <action path="/emp/save" type="EmpAction" parameter="save">
            <forward name="success" path="/WEB-INF/views/emp/success.jsp"/>
        </action>

        <action path="/emp/delete" type="EmpAction" parameter="delete">
            <forward name="error" path="/WEB-INF/views/emp/error.jsp"/>
        </action>
    </action-mappings>
```

3. 访问

``` html
<a href="emp/save.do">emp save</a>
<a href="emp/delete.do">emp delete</a>
```

4. 缺点

> 随着方法的增多，配置的action也就特别的多，实际工作中，我认为为了减少配置，最好还是使用DispatchAction

## 由action跳转到另一个action

``` xml
  <forward name="saveSuccess" path="/empAction.do?method=index"/>
  <forward name="index" path="/WEB-INF/views/emp/index.jsp"/>
```

``` Java
  public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) throws Exception {
      LOGGER.info("save");
      return mapping.findForward("saveSuccess");
  }

  public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse resp) throws Exception {
      LOGGER.info("delete");
      return mapping.findForward("index");
  }
```


## 整合spring
### 添加依赖
``` xml
    <spring.version>2.5.6</spring.version>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring</artifactId>
        <version>${spring.version}</version>
    </dependency>
    
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc-struts</artifactId>
        <version>${spring.version}</version>
    </dependency>
```

### 为需要注入的属性添加setter

EmpAction.java

``` java
    private IEmpService<EmpForm> empService;

    public void setEmpService(IEmpService<EmpForm> empService) {
        this.empService = empService;
    }
```

### 配置spring.xml

新建文件WEB-INF/spring/spring.xml

``` xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

    <bean name="empService" class="EmpServiceImpl"/>
    <bean name="/empAction" class="EmpAction">
        <property name="empService" ref="empService"/>
    </bean>
</beans>
```

### 配置struts-config.xml

``` xml
    <!--配置spring 将spring委托给struts-->
    <plug-in className="org.springframework.web.struts.ContextLoaderPlugIn">
        <set-property property="contextConfigLocation" value="/WEB-INF/spring/spring.xml" />
    </plug-in>
```

action的type也要改变成为org.springframework.web.struts.DelegatingActionProxy

```xml
<action path="/empAction"
    type="org.springframework.web.struts.DelegatingActionProxy"

```

这样就整合好spring了。

### 使用组件扫描配置和注解

如之前的spring.xml配置，将会很复杂。在spring2.5.6有component-scan能够自动扫描组件

1. 配置spring.xml 去掉之前所有的bean配置

``` xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-2.5.xsd">

    <!--自动扫描Action-->
    <context:component-scan base-package="com.microandroid.modules.**.action"/>

    <!--自动扫描Service-->
    <context:component-scan base-package="com.microandroid.modules.**.service"/>

</beans>
```

2. 为xxxAction配置@Controller("/xxxAction")，为属性添加@Autowired

```java
@Controller("/empAction")
public class EmpAction extends BaseAppAction {

    @Autowired
    private IEmpService<EmpForm> empService;
    
    // ...
}
```

3. 为xxxServiceImpl添加@Service
```java
@Service
public class EmpServiceImpl implements IEmpService {}
```

### 将spring的配置分配到不同的文件
* spring-action.xml
* spring-service.xml
* spring-dao.xml

spring.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
    <import resource="spring-action.xml"/>
    <import resource="spring-service.xml"/>
    <import resource="spring-dao.xml"/>
</beans>
```

## 整合mybatis

说明：之前使用的spring是2.5.6，整合的过程中发现很多问题，不能整合，于是切换到3.1.2.RELEASE版本整合成功

### 添加依赖

```xml

    <spring.version>3.1.2.RELEASE</spring.version>

    <!--struts 配置 开始-->
    <dependency>
        <groupId>org.apache.struts</groupId>
        <artifactId>struts-core</artifactId>
        <version>${struts.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-struts</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <!--struts 配置 结束-->

    <!--配置servlet 和 jstl 开始-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>
    <!--配置servlet 和 jstl 结束-->

    <!--mybatis 配置 开始-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.2.0</version>
    </dependency>

    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.2.8</version>
    </dependency>
    <!--mybatis 配置 结束-->

    <!--数据库驱动 配置 开始-->
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc14</artifactId>
        <version>10.2.0.4.0</version>
    </dependency>
    <!--数据库驱动 配置 结束-->

    <!--数据连接池 配置 开始-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.10</version>
    </dependency>
    <!--数据连接池 配置 结束-->

    <!--spring 配置 开始-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>${spring.version}</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <!--spring 配置 结束-->
```

### 配置spring-dao.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">

    <!--第一步：配置dataSource-->
    <!-- **************** druid 监控连接池配置 ***************** -->
    <!-- 阿里 druid 数据库连接池 -->
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource" destroy-method="close">
        <!-- 数据库基本信息配置 -->
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="filters" value="${jdbc.filters}"/>
        <!-- 最大并发连接数 -->
        <property name="maxActive" value="${jdbc.maxActive}"/>
        <!-- 初始化连接数量 -->
        <property name="initialSize" value="${jdbc.initialSize}"/>
        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="${jdbc.maxWait}"/>
        <!-- 最小空闲连接数 -->
        <property name="minIdle" value="${jdbc.minIdle}"/>
        <!-- 配置间隔多久才进行一次检测,检测需要关闭的空闲连接,单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="${jdbc.timeBetweenEvictionRunsMillis}"/>
        <!-- 配置一个连接在池中最小生存的时间,单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="${jdbc.minEvictableIdleTimeMillis}"/>
        <property name="validationQuery" value="${jdbc.validationQuery}"/>
        <property name="testWhileIdle" value="${jdbc.testWhileIdle}"/>
        <property name="testOnBorrow" value="${jdbc.testOnBorrow}"/>
        <property name="testOnReturn" value="${jdbc.testOnReturn}"/>
        <property name="maxOpenPreparedStatements" value="${jdbc.maxOpenPreparedStatements}"/>
        <!-- 打开 removeAbandoned 功能 -->
        <property name="removeAbandoned" value="${jdbc.removeAbandoned}"/>
        <!-- 1800 秒,也就是 30 分钟 -->
        <property name="removeAbandonedTimeout" value="${jdbc.removeAbandonedTimeout}"/>
        <!-- 关闭 abanded 连接时输出错误日志 -->
        <property name="logAbandoned" value="${jdbc.logAbandoned}"/>
    </bean>
    <!-- 第二步：配置sessionFactory -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="druidDataSource"/>
        <property name="mapperLocations" value="classpath:mappers/**/*.xml"/>
    </bean>
    <!-- 第三步：配置DAO，这里使用 MapperScannerConfigurer扫描指定规则下的接口，根据Mapper自动生成DAO的实现 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.microandroid.moudle.**.mapper"/>
        <!-- 		<property name="annotationClass" value="org.springframework.stereotype.Repository" /> -->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>
    <!-- 第四步：配置spring事务 -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="druidDataSource"/>
    </bean>
    <!-- 第五步：基于注解的方式使用事务管理 -->
    <tx:annotation-driven proxy-target-class="true"/>
</beans>

```

### 配置jdbc.properties
新增文件conf/jdbc.properties
```properties
jdbc.type=oracle
jdbc.driverClassName=${jdbc.driverClassName}
jdbc.url=${jdbc.url}
jdbc.username=${jdbc.username}
jdbc.password=${jdbc.password}
jdbc.filters=stat
jdbc.maxActive=20
jdbc.initialSize=1
jdbc.maxWait=60000
jdbc.minIdle=10
jdbc.maxIdle=15
jdbc.timeBetweenEvictionRunsMillis=60000
jdbc.minEvictableIdleTimeMillis=300000
jdbc.validationQuery=SELECT 'x' FROM DUAL
jdbc.testWhileIdle=true
jdbc.testOnBorrow=false
jdbc.testOnReturn=false
jdbc.maxOpenPreparedStatements=20
jdbc.removeAbandoned=true
jdbc.removeAbandonedTimeout=1800
jdbc.logAbandoned=true
```

### 配置env/*.properties
```properties
jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
jdbc.url=jdbc\:oracle\:thin\:@0.0.0.0\:1521\:orcl
jdbc.username=scott
jdbc.password=scott
#\u5B9A\u4E49\u521D\u59CB\u8FDE\u63A5\u6570
jdbc.initialSize=0
#\u5B9A\u4E49\u6700\u5927\u8FDE\u63A5\u6570
jdbc.maxActive=20
#\u5B9A\u4E49\u6700\u5927\u7A7A\u95F2
jdbc.maxIdle=20
#\u5B9A\u4E49\u6700\u5C0F\u7A7A\u95F2
jdbc.minIdle=1
#\u5B9A\u4E49\u6700\u957F\u7B49\u5F85\u65F6\u95F4
jdbc.maxWait=60000

```

### spring.xml引入资源文件
```xml
<!-- 引入配置文件 -->
    <context:property-placeholder location="classpath:conf/*.properties"/>
```

### EmpMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="IEmpMapper">
    <resultMap id="BaseResultMap" type="Emp">
        <id column="EMPNO" property="empno" jdbcType="INTEGER"/>
        <result column="ENAME" property="ename" jdbcType="VARCHAR"/>
        <result column="JOB" property="job" jdbcType="VARCHAR"/>
        <result column="MGR" property="mgr" jdbcType="INTEGER"/>
        <result column="HIREDATE" property="hiredate" jdbcType="DATE"/>
        <result column="DEPTNO" property="deptno" jdbcType="INTEGER"/>
        <collection property="empList" ofType="Emp">
            <result column="ENAME1" property="ename" jdbcType="VARCHAR"/>
            <result column="JOB1" property="job" jdbcType="VARCHAR"/>
            <result column="MGR1" property="mgr" jdbcType="INTEGER"/>
            <result column="HIREDATE1" property="hiredate" jdbcType="DATE"/>
            <result column="DEPTNO1" property="deptno" jdbcType="INTEGER"/>
        </collection>
    </resultMap>

    <sql id="Base_Column_List">
        EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO
    </sql>

    <sql id="queryAll">
        select
        <include refid="Base_Column_List"/>
        from emp
    </sql>

    <!-- 插入一个对象到数据库
    empno字段自增长
    -->
    <insert id="insert" parameterType="Emp">
        insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO)
        values (#{empno,jdbcType=NUMERIC},
                #{ename,jdbcType=VARCHAR},
                #{job,jdbcType=VARCHAR},
                #{mgr,jdbcType=NUMERIC},
                #{hiredate,jdbcType=DATE},
                #{deptno,jdbcType=NUMERIC})
    </insert>
    <!-- 批量插入数据 -->
    <insert id="inserts" parameterType="list">
        insert into emp (EMPNO,ENAME, JOB, MGR, HIREDATE, DEPTNO)
        values
        <foreach collection="list" item="item" separator=",">
            (#{item.empno},#{item.ename}, #{item.job}, #{item.mgr}, #{item.hiredate}, #{item.deptno})
        </foreach>
    </insert>
    <insert id="insertSelective" parameterType="Emp">
        insert into emp
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="empno != null">
                EMPNO,
            </if>
            <if test="ename != null">
                ENAME,
            </if>
            <if test="job != null">
                JOB,
            </if>
            <if test="mgr != null">
                MGR,
            </if>
            <if test="hiredate != null">
                HIREDATE,
            </if>
            <if test="deptno != null">
                DEPTNO,
            </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="empno != null">
                #{empno,jdbcType=NUMERIC},
            </if>
            <if test="ename != null">
                #{ename,jdbcType=VARCHAR},
            </if>
            <if test="job != null">
                #{job,jdbcType=VARCHAR},
            </if>
            <if test="mgr != null">
                #{mgr,jdbcType=NUMERIC},
            </if>
            <if test="hiredate != null">
                #{hiredate,jdbcType=DATE},
            </if>
            <if test="deptno != null">
                #{deptno,jdbcType=NUMERIC}
            </if>
        </trim>
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="Emp">
        update emp
        <set>
            <if test="ename != null">
                ENAME = #{ename,jdbcType=VARCHAR},
            </if>
            <if test="job != null">
                JOB = #{job,jdbcType=VARCHAR},
            </if>
            <if test="mgr != null">
                MGR = #{mgr,jdbcType=NUMERIC},
            </if>
            <if test="hiredate != null">
                HIREDATE = #{hiredate,jdbcType=DATE},
            </if>
            <if test="deptno != null">
                DEPTNO = #{deptno,jdbcType=NUMERIC}
            </if>
        </set>
        where EMPNO = #{empno}
    </update>
    <update id="updateByPrimaryKey" parameterType="Emp">
        update emp
        set ENAME    = #{ename,jdbcType=VARCHAR},
            JOB      = #{job,jdbcType=VARCHAR},
            MGR      = #{mgr,jdbcType=NUMERIC},
            HIREDATE = #{hiredate,jdbcType=DATE},
            DEPTNO   = #{deptno,jdbcType=NUMERIC}
        where EMPNO = #{empno}
    </update>
    <!-- 根据pk删除 -->
    <delete id="deleteByPrimaryKey" parameterType="object">
        delete
        from emp
        where empno = #{pk}
    </delete>

    <!-- 根据主键查询 -->
    <select id="selectByPrimaryKey" resultMap="BaseResultMap"
            parameterType="java.lang.Integer">
        <include refid="queryAll"/>
        where EMPNO = #{empno}
    </select>

    <!-- 查询所有记录 -->
    <select id="selectAll" resultMap="BaseResultMap">
        <include refid="queryAll"/>
    </select>

    <!-- 查询员工及其下属员工 -->
    <select id="selectEmpWithSubEmpByPrimaryKey" parameterType="object"
            resultMap="BaseResultMap">
        select e1.*, e3.ENAME as ENAME1,e3.JOB as JOB1,e3.MGR as
        MGR1,e3.HIREDATE as HIREDATE1,e3.DEPTNO as DEPTNO1
        from emp e1 LEFT JOIN emp e3 ON e1.EMPNO=e3.MGR
        where EXISTS (
        select * from emp e2 where e1.EMPNO = e2.mgr
        )
        <where>
            <if test=" _parameters != null and _parameter != '' ">
                AND e1.EMPNO=#{_parameter}
            </if>
        </where>
        ORDER BY e1.EMPNO
    </select>
</mapper>
```

### IEmpService
```java
package com.microandroid.moudle.emp.service;

import Emp;

import java.io.Serializable;
import java.util.List;

public interface IEmpService<T extends Emp> {

    /**
     * 根据pk删除
     *
     * @param pk
     * @return effect rows
     */
    int deleteByPrimaryKey(Serializable pk);

    /**
     * 插入一个对象到数据库，能得到主键值
     *
     * @param record 插入的对象
     * @return effect rows
     */
    int insert(Emp record);

    /**
     * 批量插入数据，但是不能得到主键值
     *
     * @param ts 批量插入的对象
     * @return effect rows
     */
    int inserts(List<Emp> ts);

    /**
     * 有选择的插入（插入不为空的字段）
     *
     * @param record 插入的对象
     * @return effect rows
     */
    int insertSelective(Emp record);

    /**
     * 更新
     *
     * @param record
     * @return effect rows
     */
    int updateByPrimaryKey(Emp record);

    /**
     * 有选择的更新
     *
     * @param record
     * @return effect rows
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     * 查询所有
     *
     * @return Emp
     */
    List<Emp> selectAll();

    /**
     * 根据主键查询数据
     *
     * @param pk 主键
     * @return Emp
     */
    Emp selectByPrimaryKey(Serializable pk);

    /**
     * 查询员工及其下属员工
     *
     * @param pk
     * @return
     */
    List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk);
}

```

### EmpServiceImpl
```java
package com.microandroid.moudle.emp.service.impl;

import Emp;
import IEmpMapper;
import IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService<Emp> {

    @Autowired
    IEmpMapper empMapper;

    @Override
    public int insert(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int deleteByPrimaryKey(Serializable pk) {
        return empMapper.deleteByPrimaryKey(pk);
    }

    @Override
    public int inserts(List<Emp> ts) {
        return empMapper.inserts(ts);
    }

    @Override
    public int insertSelective(Emp record) {
        return empMapper.insertSelective(record);
    }

    @Override
    public Emp selectByPrimaryKey(Serializable pk) {
        return empMapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return empMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record) {
        return empMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk) {
        return empMapper.selectEmpWithSubEmpByPrimaryKey(pk);
    }
}

```

### IEmpMapper
```java
package com.microandroid.moudle.emp.mapper;

import Emp;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IEmpMapper {

    /**
     * 根据pk删除
     *
     * @param pk
     * @return effect rows
     */
    int deleteByPrimaryKey(Serializable pk);

    /**
     * 插入一个对象到数据库，能得到主键值
     *
     * @param record 插入的对象
     * @return effect rows
     */
    int insert(Emp record);

    /**
     * 批量插入数据，但是不能得到主键值
     *
     * @param ts 批量插入的对象
     * @return effect rows
     */
    int inserts(List<Emp> ts);

    /**
     * 有选择的插入（插入不为空的字段）
     *
     * @param record 插入的对象
     * @return effect rows
     */
    int insertSelective(Emp record);

    /**
     * 更新
     *
     * @param record
     * @return effect rows
     */
    int updateByPrimaryKey(Emp record);

    /**
     * 有选择的更新
     *
     * @param record
     * @return effect rows
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     * 查询所有
     *
     * @return Emp
     */
    List<Emp> selectAll();

    /**
     * 根据主键查询数据
     *
     * @param pk 主键
     * @return Emp
     */
    Emp selectByPrimaryKey(Serializable pk);

    /**
     * 查询员工及其下属员工
     *
     * @param pk
     * @return
     */
    List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk);
}

```

### Emp
```java
package com.microandroid.moudle.emp.dto;

import java.util.Date;
import java.util.List;

/**
 * @author LewJun
 * @version v0.1 2018/10/18 19:34 LewJun Exp $$
 */
public class Emp {
    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Integer deptno;

    private List<Emp> empList;

    public Integer getEmpno() {
        return empno;
    }

    // setter & getter

    @Override
    public String toString() {
        return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr
                + ", hiredate=" + hiredate + ", deptno=" + deptno + ", empList=" + empList + "]";
    }
}

```

### 去掉struts依赖
在spring-struts中已经包括了struts:struts:1.2.9和spring-webmvc，
所以在struts集成spring的时候可以去掉struts的dependency。

### 使用lombok简化pojo
* 安装插件

[github教程](https://github.com/mplushnikov/lombok-intellij-plugin)

* 添加依赖

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.16.6</version>
    <scope>provided</scope>
</dependency>
```

* 使用

常见的使用有在类上添加`@Getter`，`@Setter`，`@ToString` 。。。

* 常见问题
    - 找不到属性
        
        `Settings` -> `Build, Execution, Deployment` -> `Compiler` -> `Annotation Processors` Click `Enable Annotation 
        Processing` -> `checked`

        可能是编译插件版本过低，设置编译插件版本
        ```xml
            <plugin>
              <artifactId>maven-compiler-plugin</artifactId>
              <version>3.3</version>
        ```


### 集成 Quartz

* 添加依赖

```xml
<!--quartz-scheduler-->
<dependency>
    <groupId>org.quartz-scheduler</groupId>
    <artifactId>quartz</artifactId>
    <version>1.8.6</version>
</dependency>
```

* 添加job
```java
public class JobGreet extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobGreet.class);

    private TaskGreet taskGreet;

    public void setTaskGreet(TaskGreet taskGreet) {
        this.taskGreet = taskGreet;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        taskGreet.greet();
    }
}
```

* 添加task[可选]
```java
public class TaskGreet {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskGreet.class);

    @Autowired
    private IEmpService<Emp> empService;

    void greet() {
        LOGGER.info("hi buddy ~ {}", empService);
    }
}

```

* 配置spring-scheduler.xml
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-3.1.xsd">
    <bean name="taskGreet" class="com.microandroid.task.greet.TaskGreet"/>
    <!-- Scheduler job -->
    <bean name="schedulerJobGreet"
          class="org.springframework.scheduling.quartz.JobDetailBean">
        <property name="jobClass" value="com.microandroid.task.greet.JobGreet"/>
        <property name="jobDataAsMap">
            <map>
                <entry key="taskGreet" value-ref="taskGreet"/>
            </map>
        </property>
    </bean>

    <!-- Cron Trigger -->
    <bean id="cronTriggerGreet"
          class="org.springframework.scheduling.quartz.CronTriggerBean">
        <property name="jobDetail" ref="schedulerJobGreet"/>
        <!--每隔8秒执行-->
        <property name="cronExpression" value="0/8 * * * * ?"/>
    </bean>

    <!-- Scheduler -->
    <bean class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
        <property name="jobDetails">
            <list>
                <ref bean="schedulerJobGreet"/>
            </list>
        </property>

        <property name="triggers">
            <list>
                <ref bean="cronTriggerGreet"/>
            </list>
        </property>
    </bean>
</beans>

```

### 集成mybatis-plus

#### 添加依赖
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>2.3</version>
</dependency>
<!--mybatis-plus 需要cglib-->
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>2.2.2</version>
</dependency>
```

#### 配置sqlSessionFactory为MybatisSqlSessionFactoryBean
```xml
<bean id="sqlSessionFactory" 
class="com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean">
```

#### 使用注解配置主键
使用@TableId配置主键

#### 重新定义接口IEmpService

继承自IService

```java

import com.baomidou.mybatisplus.service.IService;
import com.microandroid.modules.emp.dto.Emp;

import java.io.Serializable;
import java.util.List;

public interface IEmpService extends IService<Emp> {

    /**
     * 查询员工及其下属员工
     *
     * @param pk
     * @return
     */
    List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk);
}

```

#### 重新定义EmpServiceImpl

继承自ServiceImpl，实现自己的接口

```java

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microandroid.modules.emp.dto.Emp;
import com.microandroid.modules.emp.mapper.IEmpMapper;
import com.microandroid.modules.emp.service.IEmpService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EmpServiceImpl extends ServiceImpl<IEmpMapper, Emp> implements IEmpService {

    @Override
    public List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk) {
        return baseMapper.selectEmpWithSubEmpByPrimaryKey(pk);
    }
}
```

#### 重新定义IEmpMapper

继承自BaseMapper

```java

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.microandroid.modules.emp.dto.Emp;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IEmpMapper extends BaseMapper<Emp> {

    /**
     * 查询员工及其下属员工
     *
     * @param pk 主键
     * @return
     */
    List<Emp> selectEmpWithSubEmpByPrimaryKey(Serializable pk);
}

```

### 集成redis
#### 添加依赖
```xml
<!--redis
其它版本可能会出现java.lang.NoSuchMethodError: org.springframework.core.serializer.support.DeserializingConverter.<init>(Ljava/lang/ClassLoader;)V
-->
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-redis</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>

<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>2.6.2</version>
</dependency>
<!--redis end-->
```

#### 配置redis.properties

```properties
#redis.host=192.168.1.191, 192.168.26.200
redis.host=${redis.host}
redis.port=6379
redis.timeout=3000
redis.password=${redis.password}
# select redis database test-env 0 publish-env 1
redis.database=${redis.database}
redis.pool.maxActive=${redis.pool.maxActive}
redis.pool.maxIdle=${redis.pool.maxIdle}
redis.pool.minIdle=${redis.pool.minIdle}
redis.pool.maxWait=${redis.pool.maxWait}
redis.pool.testOnBorrow=${redis.pool.testOnBorrow}
redis.pool.testOnReturn=${redis.pool.testOnReturn}
redis.pool.maxTotal=${redis.pool.maxTotal}
redis.pool.blockWhenExhausted=${redis.pool.blockWhenExhausted}
redis.pool.maxWaitMillis=${redis.pool.maxWaitMillis}
```

dev.properties

```properties

##########################################################
#redis.host=192.168.1.191, 192.168.26.200
redis.host=192.168.1.191
redis.port=6379
redis.timeout=3000
redis.password=
# select redis database test-env 0 publish-env 1
redis.database=0
redis.pool.maxActive=300
redis.pool.maxIdle=20
redis.pool.minIdle=5
redis.pool.maxWait=3000
# true开启后可能会出现Could not get a resource from the pool https://blog.csdn.net/only1994/article/details/52785306
redis.pool.testOnBorrow=false
redis.pool.testOnReturn=true
redis.pool.maxTotal=6000
redis.pool.blockWhenExhausted=true
redis.pool.maxWaitMillis=1000
##########################################################

```

#### 配置spring-redis.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 自动扫描(自动注入)，扫描这个包以及它的子包的所有使用注解标注的类 -->
    <context:component-scan base-package="com.microandroid.cache.redis"/>

    <!-- jedis 配置 -->
    <bean id="poolConfig" class="redis.clients.jedis.JedisPoolConfig">
        <property name="minIdle" value="${redis.pool.minIdle}"/>
        <!-- 最大空闲数 -->
        <property name="maxIdle" value="${redis.pool.maxIdle}"/>
        <!-- 最大空连接数 -->
        <property name="maxTotal" value="${redis.pool.maxTotal}"/>
        <!-- 最大等待时间 -->
        <property name="maxWaitMillis" value="${redis.pool.maxWaitMillis}"/>
        <!-- 连接超时时是否阻塞，false时报异常,ture阻塞直到超时, 默认true -->
        <property name="blockWhenExhausted" value="${redis.pool.blockWhenExhausted}"/>
        <!-- 返回连接时，检测连接是否成功 -->
        <property name="testOnBorrow" value="${redis.pool.testOnBorrow}"/>
    </bean>

    <!-- redis服务器中心 -->
    <bean id="connectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
        <!-- IP地址 -->
        <property name="hostName" value="${redis.host}"/>
        <!-- 端口号 -->
        <property name="port" value="${redis.port}"/>
        <!-- 密码 -->
        <property name="password" value="${redis.password}"/>
        <!-- 超时时间 默认2000-->
        <property name="timeout" value="${redis.timeout}"/>
        <!-- usePool：是否使用连接池 -->
        <property name="usePool" value="true"/>
        <!-- 连接池配置引用 -->
        <property name="poolConfig" ref="poolConfig"/>
    </bean>

    <!-- redis操作模板，面向对象的模板 -->
    <bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate">
        <property name="connectionFactory" ref="connectionFactory"/>
        <property name="keySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <property name="valueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>
        <property name="hashKeySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <property name="hashValueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>
        <!--开启事务  -->
        <property name="enableTransactionSupport" value="true"/>
    </bean>
</beans>

```

#### 添加RedisCacheManager.java

```java
@Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TIMEUNIT);
            }
```

#### 使用
    @Autowired
    private RedisCacheManager redisCacheManager;
    redisCacheManager.hasKey("key")


#### redis配合spring cache一起使用

* 参考[注释驱动的 Spring cache 缓存介绍](https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/index.html)
* 参考[spring @Cacheable @CachePut... 使用redis缓存详细步骤](https://blog.csdn.net/u013041642/article/details/80370156)

- 实体类实现Serializable
```java
public class Emp implements Serializable {}
```

- 配置cacheManager
spring-redis完整配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:cache="http://www.springframework.org/schema/cache"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/cache
	http://www.springframework.org/schema/cache/spring-cache.xsd">
    <!-- 自动扫描(自动注入)，扫描这个包以及它的子包的所有使用注解标注的类 -->
    <context:component-scan base-package="com.microandroid.cache.redis"/>

    <cache:annotation-driven cache-manager="cacheManager"/>

    <!-- jedis 配置 -->
    <bean id="poolConfig" class="redis.clients.jedis.JedisPoolConfig">
        <property name="minIdle" value="${redis.pool.minIdle}"/>
        <!-- 最大空闲数 -->
        <property name="maxIdle" value="${redis.pool.maxIdle}"/>
        <!-- 最大空连接数 -->
        <property name="maxTotal" value="${redis.pool.maxTotal}"/>
        <!-- 最大等待时间 -->
        <property name="maxWaitMillis" value="${redis.pool.maxWaitMillis}"/>
        <!-- 连接超时时是否阻塞，false时报异常,ture阻塞直到超时, 默认true -->
        <property name="blockWhenExhausted" value="${redis.pool.blockWhenExhausted}"/>
        <!-- 返回连接时，检测连接是否成功 -->
        <property name="testOnBorrow" value="${redis.pool.testOnBorrow}"/>
    </bean>

    <!-- redis服务器中心 -->
    <bean id="connectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory">
        <!-- IP地址 -->
        <property name="hostName" value="${redis.host}"/>
        <!-- 端口号 -->
        <property name="port" value="${redis.port}"/>
        <!-- 密码 -->
        <property name="password" value="${redis.password}"/>
        <!-- 超时时间 默认2000-->
        <property name="timeout" value="${redis.timeout}"/>
        <!-- usePool：是否使用连接池 -->
        <property name="usePool" value="true"/>
        <!-- 连接池配置引用 -->
        <property name="poolConfig" ref="poolConfig"/>
    </bean>

    <!-- redis操作模板，面向对象的模板 -->
    <bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate">
        <property name="connectionFactory" ref="connectionFactory"/>
        <!--
        如果不使用StringRedisSerializer对key进行序列化，会造成产生的key形如emp?keys，所以必须keySerializer和hashKeySerializer
        -->
        <property name="keySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <property name="hashKeySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <!--
        会报类转换异常
        <property name="valueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>

        <property name="hashValueSerializer">
            <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"/>
        </property>-->
        <!--开启事务  -->
        <property name="enableTransactionSupport" value="true"/>
    </bean>

    <bean id="simpleCacheManager" class="org.springframework.cache.support.SimpleCacheManager">
        <property name="caches">
            <set>
                <!--使用redis-->
                <bean class="org.springframework.data.redis.cache.RedisCache">
                    <constructor-arg name="name" value="cache_emp"/>
                    <constructor-arg name="prefix" value="emp:"/>
                    <constructor-arg name="template" ref="redisTemplate"/>
                    <!--过期时间 s-->
                    <constructor-arg name="expiration" value="300"/>
                </bean>

                <!--使用redis-->
                <bean class="org.springframework.data.redis.cache.RedisCache">
                    <constructor-arg name="name" value="default"/>
                    <constructor-arg name="prefix" value="DEF:"/>
                    <constructor-arg name="template" ref="redisTemplate"/>
                    <constructor-arg name="expiration" value="60"/>
                </bean>

                <!--如果不想使用redis，可以配其它，也可以使用ConcurrentMap
                <bean class="org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean" name="default"/>
                <bean class="org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean" name="cache_emp"/>
                -->
            </set>
        </property>
    </bean>

    <bean id="cacheManager" class="org.springframework.cache.support.CompositeCacheManager">
        <property name="cacheManagers">
            <list>
                <ref bean="simpleCacheManager"/>
            </list>
        </property>
        <!--当没有可用的cache时，不会报错。-->
        <property name="fallbackToNoOpCache" value="false"/>
    </bean>
</beans>
```

- 使用

```java

    @Cacheable(value = "cache_emp", key = "#id")
    @Override
    public Emp selectById(Serializable id) {
        return super.selectById(id);
    }
```

### 升级spring版本

#### spring-struts 配置

* spring-struts使用3.x 例如最新版本 3.2.18.RELEASE
* 排除spring-struts中的spring和struts，单独配置
```xml
<!--struts 配置 开始-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-struts</artifactId>
            <version>${spring-struts.version}</version>
            <exclusions>
                <exclusion>
                    <artifactId>commons-logging</artifactId>
                    <groupId>commons-logging</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>commons-beanutils</artifactId>
                    <groupId>commons-beanutils</groupId>
                </exclusion>

                <exclusion>
                    <artifactId>spring-webmvc</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>struts</artifactId>
                    <groupId>struts</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-web</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-core</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-context</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>spring-beans</artifactId>
                    <groupId>org.springframework</groupId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <artifactId>struts</artifactId>
            <groupId>struts</groupId>
            <version>1.2.9</version>
            <exclusions>
                <exclusion>
                    <artifactId>commons-beanutils</artifactId>
                    <groupId>commons-beanutils</groupId>
                </exclusion>
                <exclusion>
                    <artifactId>commons-logging</artifactId>
                    <groupId>commons-logging</groupId>
                </exclusion>
            </exclusions>
        </dependency>
```

**注意**
* quartz 需要spring-context-support 3.x版本的依赖支持
* 为了避免dependency依赖其它版本的spring，因此需要使用exclusion进行排除。
