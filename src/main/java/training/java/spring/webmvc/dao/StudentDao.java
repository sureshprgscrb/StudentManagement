package training.java.spring.webmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import training.java.spring.webmvc.bean.StudentBean;
import training.java.spring.webmvc.exception.StudentNotFoundException;
import training.java.spring.webmvc.rowmapper.rowMapperImpl;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public int insertStudentData(StudentBean stdBean)
	{
		String query = "insert into mystudents values(?,?,?,?,?,?)";
		int result = template.update(query,stdBean.getId(),stdBean.getName(),stdBean.getDob(),stdBean.getGender(), stdBean.getType(),stdBean.getCity());
		return result;
	}
	
	public List<StudentBean> getAllStudents()
	{
		String query ="select * from mystudents";
		List<StudentBean>  students = template.query(query, new rowMapperImpl());
		return students;
	}
	
	public StudentBean getAnyStudent(Long studentId)
	{
		String query ="select * from mystudents where id=?";
		
		try {
		return template.queryForObject(query, new rowMapperImpl(), studentId);
		
		}
	 catch (EmptyResultDataAccessException e) {
        throw e; 
        }
           
		
	}
	
	public int updateStudentData(StudentBean stdBean)
	{
		String query = "UPDATE mystudents SET name=?,dob=?,gender=?,type=?,city=? WHERE id=?";
		int result = template.update(query,stdBean.getName(),stdBean.getDob(),stdBean.getGender(), stdBean.getType(),stdBean.getCity(),stdBean.getId());
		return result;
	}
	
	public int deleteStudentData(Long studentId)
	{
		String query = "DELETE from mystudents WHERE id=?";
		int result = template.update(query, studentId);
		return result;
	}
}
