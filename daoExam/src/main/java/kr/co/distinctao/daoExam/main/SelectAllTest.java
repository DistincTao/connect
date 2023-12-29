package kr.co.distinctao.daoExam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.distinctao.daoExam.config.ApplicationConfig;
import kr.co.distinctao.daoExam.dao.RoleDao;
import kr.co.distinctao.daoExam.dto.RoleDto;

public class SelectAllTest {
	
	public static void main (String [] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		List<RoleDto> list = roleDao.selectAll();
		
		for (RoleDto role : list) {
			System.out.println(role);
		}		
	}

}
