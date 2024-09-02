package com.sp.controller;

import com.sp.dao.TeacherDao;
import com.sp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {

	private final TeacherDao teacherDao;

	@Autowired
	public TeacherController(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public String listTeachers(Model model) {
		List<Teacher> teachers = teacherDao.getAllTeachers();
		model.addAttribute("teachers", teachers);
		return "teachers"; // Corresponds to /WEB-INF/views/teachers.jsp
	}

	@RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
	public String showAddTeacherForm(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "addTeacher"; // Corresponds to /WEB-INF/views/addTeacher.jsp
	}

	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherDao.addTeacher(teacher);
		return "redirect:/teachers"; // Redirect to the list of teachers
	}

	@RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
	public String deleteTeacher(@RequestParam("teacherId") int teacherId) {
		teacherDao.deleteTeacher(teacherId);
		return "redirect:/teachers"; // Redirect to the updated list of teachers
	}

	@RequestMapping(value = "/teacherDetails", method = RequestMethod.GET)
	public String viewTeacherDetails(@RequestParam("teacherId") int teacherId, Model model) {
		Teacher teacher = teacherDao.getTeacherById(teacherId);
		model.addAttribute("teacher", teacher);
		return "teacherDetails"; // Corresponds to /WEB-INF/views/teacherDetails.jsp
	}

}
