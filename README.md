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
        <form-bean name="empForm" type="com.microandroid.moudle.emp.bean.EmpForm"/>
    </form-beans>
    <action-mappings>
        <action path="/emp" name="empForm" type="com.microandroid.moudle.emp.action.EmpAction">
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

import com.microandroid.moudle.emp.bean.EmpForm;

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

import com.microandroid.moudle.emp.bean.EmpForm;
import com.microandroid.moudle.emp.service.IEmpService;

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
        type="com.microandroid.moudle.emp.action.EmpAction"
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
        <action path="/emp/save" type="com.microandroid.moudle.emp.action.EmpAction" parameter="save">
            <forward name="success" path="/WEB-INF/views/emp/success.jsp"/>
        </action>

        <action path="/emp/delete" type="com.microandroid.moudle.emp.action.EmpAction" parameter="delete">
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

    <bean name="empService" class="com.microandroid.moudle.emp.service.impl.EmpServiceImpl"/>
    <bean name="/empAction" class="com.microandroid.moudle.emp.action.EmpAction">
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

这样就整合好spring了。
