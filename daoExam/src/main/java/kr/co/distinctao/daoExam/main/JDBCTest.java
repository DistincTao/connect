package kr.co.distinctao.daoExam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.distinctao.daoExam.config.ApplicationConfig;
import kr.co.distinctao.daoExam.dao.RoleDao;
import kr.co.distinctao.daoExam.dto.RoleDto;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		RoleDto dto = new RoleDto();
		dto.setRoleId(201);
		dto.setDescription("PROGRAMMER");
		
//		int count = roleDao.insert(dto);
//		System.out.println(count + " inserted");
		
		int count = roleDao.update(dto);
		System.out.println(count + " updated");
		
		RoleDto result = roleDao.selectById(201);
		System.out.println(result);
		
		int deleteCount = roleDao.deleteById(500);
		System.out.println(deleteCount + " deleted");

		RoleDto result2 = roleDao.selectById(500);
		System.out.println(result2);
		
	}

}
