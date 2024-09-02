package com.sp.controller;

import com.sp.dao.StudentDao;
import com.sp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

	private final StudentDao studentDao;

	@Autowired
	public StudentController(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	// Handler method to display a list of students
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		List<Student> students = studentDao.getAllStudents();
		model.addAttribute("students", students);
		return "students"; // This corresponds to /WEB-INF/views/students.jsp
	}

	// Handler method to show the add student form
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String showAddStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent"; // This corresponds to /WEB-INF/views/addStudent.jsp
	}

	// Handler method to process the add student form
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, Model model) {
		studentDao.addStudent(student);
		return "redirect:/students"; // Redirect to the list of students to see the new addition
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public String deleteStudent(@RequestParam("studentId") int studentId) {
		studentDao.deleteStudent(studentId);
		return "redirect:/students"; // Redirect to the updated list of students
	}

	@RequestMapping(value = "/studentDetails", method = RequestMethod.GET)
	public String viewStudentDetails(@RequestParam("studentId") int studentId, Model model) {
		Student student = studentDao.getStudentById(studentId);
		model.addAttribute("student", student);
		return "studentDetails"; // Corresponds to /WEB-INF/views/studentDetails.jsp
	}

}
