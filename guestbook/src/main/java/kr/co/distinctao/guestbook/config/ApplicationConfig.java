package kr.co.distinctao.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"kr.co.distinctao.guestbook.dao", "kr.co.distinctao.guestbook.service"})
@Import (DBConfig.class)
public class ApplicationConfig {

}
