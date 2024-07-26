package training.java.spring.webmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import training.java.spring.webmvc.bean.StudentBean;
import training.java.spring.webmvc.dao.StudentDao;
import training.java.spring.webmvc.exception.StudentNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentDao stdDao;
	public int insertData(StudentBean stdbean)
	{
		return stdDao.insertStudentData(stdbean);
	}
	
	public List<StudentBean> getAllStudetnsData()
	{
		return stdDao.getAllStudents();
	}
	
	public StudentBean getAnyStudentData(Long studentId)
	{
		
		 try {
			 return	stdDao.getAnyStudent(studentId) ;
	        } catch (EmptyResultDataAccessException e) {
	            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
	        }
				 
	}
	
	public int updateData(StudentBean stdbean)
	{
		return stdDao.updateStudentData(stdbean);
	}
	
	public int deleteData(Long studentId)
	{
		return stdDao.deleteStudentData(studentId);
	}
	
	
}
