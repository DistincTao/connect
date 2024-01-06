package kr.co.distinctao.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GuestbookAdminController {
	@GetMapping (path="/loginform")
	public String loginform () {
		return "loginform";
	}
	
	@PostMapping (path="/login")
	public String login (@RequestParam (name="password", required = true) String password, 
						 HttpSession session,
						 RedirectAttributes redirectAttr) {
		
		if ("1234".equals(password)) {
			session.setAttribute("isAdmin", "true");
		} else {
			redirectAttr.addFlashAttribute("errorMessage", "비밀번호가 틀렸습니다."); // redirect는 딱한번 요청을 유지할 목적으로 사용
			return "redirect:/loginform";
		}
		return "redirect:/list";
	}
	
	@GetMapping (path="/logout")
	public String login (HttpSession session) {
		session.removeAttribute("isAdmin");
		return "redirect:/list";
	}
	
}