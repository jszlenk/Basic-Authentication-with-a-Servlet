# Basic Authentication with a Servlet

Authentication within the web.xml

### Instruction

Create a mysql database:

````sql
create database cities;

use cities;

create table city (
    id int not null auto_increment primary key,
    name varchar(50) not null,
    countryCode varchar(50) not null,
    district varchar(120),
    population int
);

create table code (
    countryCode varchar(120)
);

insert into city (name, countryCode, district, population) values ('Poland', 'PL', 'EUR', '39000000');

insert into code (countryCode) values ('DE');
````

Add role information to the file tomcat-user.xml

````xml
<user name="tomcat" password="123" roles="manager-gui"/>

  <role rolename="Admin"/>
  <role rolename="Authorized_user"/>

<user username="Admin" password="password" roles="Admin"/>
<user username="Authorized_User" password="password" roles="Authorized_User"/>
````

Configure web.xml file:

````xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
<display-name>Authentication</display-name>
<listener>
    <listener-class>
        util.Setup
    </listener-class>
</listener>
<context-param>
    <param-name>baseURL</param-name>
    <param-value>http://localhost:8080/</param-value>
</context-param>
<context-param>
    <param-name>copyright</param-name>
    <param-value>2019</param-value>
</context-param>
<context-param>
    <param-name>weblink</param-name>
    <param-value>http://www.google.com</param-value>
</context-param>
<context-param>
    <param-name>user</param-name>
    <param-value>root</param-value>
</context-param>
<context-param>
    <param-name>password</param-name>
    <param-value>password</param-value>
</context-param>
<context-param>
    <param-name>db</param-name>
    <param-value>cities</param-value>
</context-param>
<error-page>
    <error-code>404</error-code>
    <location>/errorHandler.jsp</location>
</error-page>
<error-page>
    <error-code>500</error-code>
    <location>/errorHandler.jsp</location>
</error-page>
<welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
</welcome-file-list>
<security-constraint>
    <web-resource-collection>
        <web-resource-name>Access</web-resource-name>
        <url-pattern>/Protected/*</url-pattern>
        <http-method>GET</http-method>
        <http-method>POST</http-method>
    </web-resource-collection>
    <auth-constraint>
        <role-name>Admin</role-name>
        <role-name>Authorized_User</role-name>
    </auth-constraint>
</security-constraint>
<security-role>
    <role-name>Admin</role-name>
</security-role>
<security-role>
    <role-name>Authorized_User</role-name>
</security-role>
<login-config>
<!--    <auth-method>BASIC</auth-method>-->
    <auth-method>FORM</auth-method>
    <form-login-config>
        <form-login-page>/loginServer.jsp</form-login-page>
        <form-error-page>/loginError.jsp</form-error-page>
    </form-login-config>
</login-config>
</web-app>
````

Add dependencies:

1. jstl-1.2.jar
2. mysql-connector-java-8.0.18.jar