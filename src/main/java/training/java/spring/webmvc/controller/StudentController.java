package training.java.spring.webmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import training.java.spring.webmvc.bean.StudentBean;
import training.java.spring.webmvc.service.StudentService;

@EnableWebMvc
@Controller
public class StudentController {

	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	 
	@Autowired
	private StudentService stdService;
	
	@RequestMapping("/register_student")
	public String showRegisterStudent()
	{
		return "register";
	}
	@RequestMapping("/register")
	public String studentRegistration(@ModelAttribute("student") StudentBean std,  Model m)
	{
		int r = stdService.insertData(std);
		
		if (r>0) {
           
            m.addAttribute("msg", "Student Registered Successfully");
			return "success";
        }
		else
		
		{
			 return "register";
		}
		
	}
	
	@RequestMapping("/update")
	public String studentUpdateProcess(@ModelAttribute("student") StudentBean std, Model m)
	{
		int r = stdService.updateData(std);
		if(r>0)
		{
			m.addAttribute("msg", "Student Updated Successfully");
			return "success";
		}
		else
		{
			return "error";
		}
		
	}
	
	
	
	
	@RequestMapping("/update_student")
	public String showUpdateStudent(HttpServletRequest request)
	{
		List<StudentBean> allStudetnsData = stdService.getAllStudetnsData();
		request.setAttribute("StudentData",allStudetnsData);
		return "show-update";
	}
	
	@RequestMapping("/fetch_all")
	public String getAllStudents(HttpServletRequest request)
	{
		List<StudentBean> allStudetnsData = stdService.getAllStudetnsData();
		request.setAttribute("StudentData",allStudetnsData);
		return "show-students";
	}
	
	@RequestMapping("/get_any")
	public String getAnyStudent()
	{
		
		return "show-student";
	}
	
	@RequestMapping("/fetchStudent")
	public String showStudent(@ModelAttribute("std") StudentBean std, HttpServletRequest request, Model model)
	{
		StudentBean student = stdService.getAnyStudentData(std.getId());
	 request.setAttribute("StudentInfo",student);
		model.addAttribute("studentDetails", student);
		return "show-studentDetails";
	}
	
	@RequestMapping("/updateProcess/{id}")
	public String updateStudentProcessing(@PathVariable("id") Long id, Model model, HttpServletRequest request)
	{
		StudentBean anyStudentData = stdService.getAnyStudentData(id);
		model.addAttribute("stdData", anyStudentData);
		request.setAttribute("studData", anyStudentData);
		return "process-update";
	}
	
	@RequestMapping("/delete_student")
	public String showDelete(HttpServletRequest request)
	{
		List<StudentBean> allStudetnsData = stdService.getAllStudetnsData();
		request.setAttribute("StudentData",allStudetnsData);
		return "show-delete";
	}
	@RequestMapping("/deleteProcess/{id}")
	public String deleteStudentProcessing(@PathVariable("id") Long id, Model model, HttpServletRequest request)
	{
		int deleteData = stdService.deleteData(id);
		if(deleteData>0)
		{
			model.addAttribute("msg", "Student details deleted successfully");
			return "success";
		}
		else
		{
			return "error";
		}
		
	}
	
	/*
	 * @ExceptionHandler(value=Exception.class) public String
	 * exceptionHandlerMethod(Model m, Exception e) { m.addAttribute("msg",
	 * e.getMessage()); return "error"; }
	 */
}
