package com.sp.dao;

import com.sp.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CourseDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Course> getAllCourses() {
		String sql = "SELECT c.course_id, c.course_name, c.course_code, c.teacher_id, t.first_name, t.last_name "
				+ "FROM courses c LEFT JOIN teachers t ON c.teacher_id = t.teacher_id";
		return jdbcTemplate.query(sql, new CourseRowMapper());
	}

	public Course getCourseById(String courseId) {
		String sql = "SELECT * FROM courses WHERE course_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { courseId }, new CourseRowMapper());
	}

	public void addCourse(Course course) {
		String sql = "INSERT INTO courses (course_id, course_name, course_code, teacher_id) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, course.getCourseId(), course.getCourseName(), course.getCourseCode(),
				course.getTeacherId());
	}

	public void deleteCourse(String courseId) {
		String sql = "DELETE FROM courses WHERE course_id = ?";
		jdbcTemplate.update(sql, courseId);
	}

	public void assignTeacherToCourse(String courseId, int teacherId) {
		String sql = "UPDATE courses SET teacher_id = ? WHERE course_id = ?";
		jdbcTemplate.update(sql, teacherId, courseId);
	}

	private static final class CourseRowMapper implements RowMapper<Course> {
		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course course = new Course();
			course.setCourseId(rs.getString("course_id"));
			course.setCourseName(rs.getString("course_name"));
			course.setCourseCode(rs.getString("course_code"));
			course.setTeacherId((Integer) rs.getObject("teacher_id"));
			String teacherName = rs.getString("first_name") != null
					? rs.getString("first_name") + " " + rs.getString("last_name")
					: "None";
			course.setTeacherName(teacherName);
			return course;
		}
	}
}
