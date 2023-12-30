package kr.or.distinctao.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.distinctao.mvcexam.dto.UserDto;

@Controller
public class UserController {
	@RequestMapping (path="/userform", method=RequestMethod.GET)
	public String userform() {
		return "userForm";
	}
	
	@RequestMapping (path="regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute UserDto dto) {
		System.out.println("사용자가 입력한 User 정보입니다. 해당 정보를 이용하는 코드가 와야 합니다.");
		System.out.println(dto);
		return "regist";
	}
}
