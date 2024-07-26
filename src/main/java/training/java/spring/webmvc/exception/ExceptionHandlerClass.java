package training.java.spring.webmvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException ex, Model model) {
        System.out.println("error code");
        model.addAttribute("msg", ex.getMessage());
        return "error";
    }
}
