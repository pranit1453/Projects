package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Users;
import com.demo.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserServices userservices;

	@GetMapping("/loginuser") // login/loginuser
	public String showLoginPage() {
		return "loginpage";
	}

	@PostMapping("/authenticate") // login/authenticate
	public ModelAndView validateUser(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session, Model model) {
		Users user = userservices.validateUser(username, password);

		if (user != null && "USER".equals(user.getRole())) {
			session.setAttribute("user", user);
			// Redirect to to-do list after successful login
			return new ModelAndView("redirect:/todos/dashboard");
		} else {
			model.addAttribute("error", "Invalid Credentials!!!");
			return new ModelAndView("loginpage");
		}
	}

	@GetMapping("/logout") // login/logout
	public String logOut(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if (user != null)
			session.invalidate();
		return "loginpage";

	}
}
