package kr.co.distinctao.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.distinctao.guestbook.argumentresolver.HeaderInfo;
import kr.co.distinctao.guestbook.argumentresolver.HeaderMapArgumentResolver;
import kr.co.distinctao.guestbook.dto.Guestbook;
import kr.co.distinctao.guestbook.service.GuestbookService;

@Controller
public class GuesbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")
//	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
//					   ModelMap model,
//					   HttpServletRequest request,
//					   HttpServletResponse response) {
		
	public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
			   		   ModelMap model,
			   		   @CookieValue(value="count", defaultValue = "0", required = true) String value,
			   		   HttpServletResponse response,
			   		   HeaderInfo headerInfo) {
		
		System.out.println("---------------------------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("---------------------------------------------------");
		
//		// 쿠키의 저장 여부를 확인
//		String value = null;
//		boolean find = false; // 원하는 쿠키를 찾았는지 여부를 반환 해주는 값
//		// request 객체 내의 모든 쿠키를 배열로 저장
//		Cookie[] cookies = request.getCookies();
//		//저장된 쿠키 배열 중 원하는 쿠키를 확인
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if ("count".equals(cookie.getName())) {
//					find = true;
//					value = cookie.getValue();
//					break;
//				}
//			}
//		}
//		// 원하는 쿠키가 없다면 값을 "1" 로 저장
//		if (!find) {
//			value = "1";
//		} else {
		// 원하는 쿠키를 찾았다면 수행할 내용을 작성
			try {
				int i = Integer.parseInt(value);
				value = Integer.toString(++i);
			} catch (Exception e) {
				e.printStackTrace();
				value = "1";
			}
//		}

		// 수행 후 저장된 값을 Cookie에 저장
		Cookie cookie = new Cookie ("count", value);
		cookie.setMaxAge(60 * 60 * 24 * 356);
		// 하위 모든 Path에 적용하기 위하여 Path 설정
		cookie.setPath("/");
		response.addCookie(cookie);
		
		// start로 시작하는 방명록 목록 구하기
		List<Guestbook> list = guestbookService.getGuestbooks(start);

		// 전체 페이지수 구하기
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;

		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를 들면 페이지수가 3이면
		// 0, 5, 10 이렇게 저장된다.
		// list?start=0 , list?start=5, list?start=10 으로 링크가 걸린다.
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value);
		return "list";
	}

	@PostMapping(path="/write")
	public String write(@ModelAttribute Guestbook guestbook,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
	
	@GetMapping(path="/delete")
	public String delete(@RequestParam(name="id", required = true) Long id,
						 @SessionAttribute("isAdmin") String isAdmin,
						 HttpServletRequest request,
						 RedirectAttributes redirectAttr) {
		if (isAdmin == null || !"true".equals(isAdmin)) {
			redirectAttr.addFlashAttribute("errorMessage", "로그인을 하지 않았습니다.");
			return "redirect:/loginform";
		} 
		
		String clientIp = request.getRemoteAddr();
		guestbookService.deleteGuestbook(id, clientIp);
		return "redirect:/list";
		
						 
						 
	}
}
