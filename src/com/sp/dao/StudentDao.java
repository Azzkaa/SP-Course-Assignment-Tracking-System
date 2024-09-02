package com.sp.dao;

import com.sp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Student getStudentByEmail(String email) {
		String sql = "SELECT * FROM students WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { email }, new StudentRowMapper());
	}

	public List<Student> getAllStudents() {
		String sql = "SELECT * FROM students";
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}

	public void addStudent(Student student) {
		String sql = "INSERT INTO students (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getEmail(),
				student.getPassword());
	}

	public void deleteStudent(int studentId) {
		String sql = "DELETE FROM students WHERE student_id = ?";
		jdbcTemplate.update(sql, studentId);
	}

	public Student getStudentById(int studentId) {
		String sql = "SELECT * FROM students WHERE student_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { studentId }, new StudentRowMapper());
	}

	private static final class StudentRowMapper implements RowMapper<Student> {
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setFirstName(rs.getString("first_name"));
			student.setLastName(rs.getString("last_name"));
			student.setEmail(rs.getString("email"));
			student.setPassword(rs.getString("password"));
			return student;
		}
	}
}
