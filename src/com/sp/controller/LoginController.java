package com.sp.controller;

import com.sp.dao.StudentDao;
import com.sp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login"; // Corresponds to /WEB-INF/views/login.jsp
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam("username") String email, @RequestParam("password") String password,
			Model model) {
		try {
			Student student = studentDao.getStudentByEmail(email);
			if (student != null && student.getPassword().equals(password)) {
				return "redirect:/students"; // Redirect to the list of students
			} else {
				model.addAttribute("error", "Invalid username or password");
				return "login";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}
}
