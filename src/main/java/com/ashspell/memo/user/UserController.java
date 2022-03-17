package com.ashspell.memo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@GetMapping("/signup_view")
	public String signupview() {
		return "user/signup";
	}
	
	@GetMapping("/signin_view")
	public String signinview() {
		return "user/signin";
	}
	
	@GetMapping("sign_out") 
		public String signOut(HttpServletRequest request) {
			
			//로그아웃
			// 세션에 저장한 사용자 정보 지우기
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userID");
		session.removeAttribute("userLoginID");
		session.removeAttribute("userName");
		
		return "redirect:/user/signin_view";
		
		}
	}
