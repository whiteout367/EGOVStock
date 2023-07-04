# EGOVStock

이 코드는 context-datasource.xml가 빠져 있습니다.

context-datasource.xml을 만드시고, 아래 내용을 추가해 주세요.

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/jdbc  http://www.springframework.org/schema/jdbc/spring-jdbc-4.0.xsd">
        
        
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="org.mariadb.jdbc.Driver"/>
        <property name="url" value="jdbc:mariadb://127.0.0.1:3306/DB"/>
        <property name="username" value="user"/>
        <property name="password" value="passwd"/>
    </bean>

    
</beans>

## Result

stockList.do
![index](https://github.com/whiteout367/EGOVStock/assets/75378861/38e04784-9593-4ff5-afad-c01939ddbb1e)

search
![search](https://github.com/whiteout367/EGOVStock/assets/75378861/ed9f1611-dc8c-46f1-9e63-9f93b3acd3d7)

excel_download
![excel_download](https://github.com/whiteout367/EGOVStock/assets/75378861/5ac2bc6d-4d21-4b4d-a122-c14eb7ea2d13)

