package kr.co.distinctao.daoExam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBconfig {
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/connectDB?serverTimezone=Asia/Seoul&useSSL=false&characterEncoding=utf8";
    
    private String userName = "root";
    private String password = "Akdlrod1320!";
    
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    	
    }

}
