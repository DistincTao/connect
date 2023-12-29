package kr.co.distinctao.daoExam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.co.distinctao.daoExam.dao"})
@Import({DBconfig.class})
public class ApplicationConfig {

}
