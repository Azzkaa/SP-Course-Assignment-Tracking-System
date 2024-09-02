package com.sp.model;

public class Course {
	private String courseId;
	private String courseName;
	private String courseCode;
	private Integer teacherId;
	private String teacherName;

	// Constructors
	public Course() {
	}

	public Course(String courseId, String courseName, String courseCode, Integer teacherId) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.teacherId = teacherId;
	}

	// Getters and Setters
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
