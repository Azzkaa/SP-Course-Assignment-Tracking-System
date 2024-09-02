package com.sp.controller;

import com.sp.dao.CourseDao;
import com.sp.dao.TeacherDao;
import com.sp.model.Course;
import com.sp.model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

	private final CourseDao courseDao;
	private final TeacherDao TeacherDao;

	@Autowired
	public CourseController(CourseDao courseDao, TeacherDao teacherDao) {
		this.courseDao = courseDao;
		this.TeacherDao = teacherDao;
	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String listCourses(Model model) {
		List<Course> courses = courseDao.getAllCourses();
		model.addAttribute("courses", courses);
		return "courses"; // Corresponds to /WEB-INF/views/courses.jsp
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String showAddCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "addCourse"; // Corresponds to /WEB-INF/views/addCourse.jsp
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("course") Course course) {
		courseDao.addCourse(course);
		return "redirect:/courses"; // Redirect to the list of courses
	}

	@RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
	public String deleteCourse(@RequestParam("courseId") String courseId) {
		courseDao.deleteCourse(courseId);
		return "redirect:/courses"; // Redirect to the updated list of courses
	}

	@RequestMapping(value = "/assignTeacher", method = RequestMethod.POST)
	public String assignTeacherToCourse(@RequestParam("courseId") String courseId,
			@RequestParam("teacherId") int teacherId) {
		courseDao.assignTeacherToCourse(courseId, teacherId);
		return "redirect:/courses"; // Redirect to the updated list of courses
	}

	@RequestMapping(value = "/showAssignTeacherForm", method = RequestMethod.GET)
	public String showAssignTeacherForm(@RequestParam("courseId") String courseId, Model model) {
		Course course = courseDao.getCourseById(courseId);
		List<Teacher> teachers = TeacherDao.getAllTeachers();
		model.addAttribute("course", course);
		model.addAttribute("teachers", teachers);
		return "assignTeacher"; // Corresponds to /WEB-INF/views/assignTeacher.jsp
	}
}
