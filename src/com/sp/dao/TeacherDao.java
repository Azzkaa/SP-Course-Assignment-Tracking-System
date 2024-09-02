package com.sp.dao;

import com.sp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TeacherDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Teacher> getAllTeachers() {
		String sql = "SELECT * FROM teachers";
		return jdbcTemplate.query(sql, new TeacherRowMapper());
	}

	public void addTeacher(Teacher teacher) {
		String sql = "INSERT INTO teachers (first_name, last_name, email) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, teacher.getFirstName(), teacher.getLastName(), teacher.getEmail());
	}

	public void deleteTeacher(int teacherId) {
		String sql = "DELETE FROM teachers WHERE teacher_id = ?";
		jdbcTemplate.update(sql, teacherId);
	}

	public Teacher getTeacherById(int teacherId) {
		String sql = "SELECT * FROM teachers WHERE teacher_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { teacherId }, new TeacherRowMapper());
	}

	private static final class TeacherRowMapper implements RowMapper<Teacher> {
		@Override
		public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
			Teacher teacher = new Teacher();
			teacher.setTeacherId(rs.getInt("teacher_id"));
			teacher.setFirstName(rs.getString("first_name"));
			teacher.setLastName(rs.getString("last_name"));
			teacher.setEmail(rs.getString("email"));
			return teacher;
		}
	}
}
