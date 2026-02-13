package edu.cjc.sma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sma.app.model.Student;
import edu.cjc.sma.app.service.StudentserviceInt;

@Controller
public class AdminController {
	
	@Autowired
	StudentserviceInt ssi;
	
	
	@RequestMapping("/")
	public String preLogin() {
		return "login";
		
	}
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password")String password,Model m) {
		
		if(username.equals("Admin")&& password.equals("Admin"))
		{
			List<Student> list = ssi.paging(0,2);
			m.addAttribute("data",list);
		return "adminscreen";
		}else {
			m.addAttribute("login_fail","Enter valid Details");
			return "login";
		}
	}
	
	@RequestMapping("/enroll_student")
	public String saveData(@ModelAttribute Student s ,Model m) {
		
		ssi.saveData(s);
		List<Student> list = ssi.getAllStudent();
		m.addAttribute( "data",list);
		return "adminscreen";
		
	}
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int studentId ,Model m) {
		
		ssi.removeStudent(studentId);
		List<Student> list=ssi.getAllStudent();
		m.addAttribute("data",list);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String searchByBatchStudents(@RequestParam("batchNumber") String batchNumber,Model m) {
		
		List<Student> list =ssi.getStudentsByBatch(batchNumber);
		if(list.size()>0) {
			m.addAttribute("data",list);
			
		}else {
			List<Student>list1 = ssi.getAllStudent();
			m.addAttribute("data",list1);
			m.addAttribute("message","No records Found for this Batch" +batchNumber);
		}
		
		return "adminscreen";
	}
	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo") int pageNo,Model m) {
		int size =2;
		List<Student> list =ssi.paging(pageNo,size);
		m.addAttribute("data",list);
		return "adminscreen";
	}
	
	@RequestMapping("/fees")
	public String onFees(@RequestParam("id") int StudentId,Model m) {
		Student st =ssi.getSingleStudent(StudentId);
		m.addAttribute("st",st);
		return "fees";
	}
	@RequestMapping("/payfees")
	public String payfees(@RequestParam("studentid") int studentId,@RequestParam("ammount") double ammount,Model m) {
		ssi.updateStudentFees(studentId,ammount);
		 List<Student> list =ssi.getAllStudent();
		 m.addAttribute("data",list);
		 return "adminscreen";
	}
	
	@RequestMapping("/shiftBatch")
	public String shiftBatch(@RequestParam("id") int studentId,Model m) {
		Student st=ssi.shiftingBatch(studentId);
		m.addAttribute("st",st);
		return "shiftBatch";
	}
	@RequestMapping("/changeBatch")
	public String batchShifted(@RequestParam("studentId")int studentId,@RequestParam("batchNumber") String batchNumber,Model m) {
		ssi.saveBatch(studentId, batchNumber);
		List<Student> list =ssi.getAllStudent();
		m.addAttribute("data",list);
		return "adminscreen";
	}
}
