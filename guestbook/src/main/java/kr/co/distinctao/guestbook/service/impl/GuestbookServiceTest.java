package kr.co.distinctao.guestbook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.distinctao.guestbook.config.ApplicationConfig;
import kr.co.distinctao.guestbook.dto.Guestbook;
import kr.co.distinctao.guestbook.service.GuestbookService;

public class GuestbookServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);

		Guestbook guestbook = new Guestbook();
		guestbook.setName("Cho");
		guestbook.setContent("어렵다리어렵.......");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);

	}

}
