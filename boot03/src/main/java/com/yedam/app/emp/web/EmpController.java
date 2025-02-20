package com.yedam.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	private EmpService empService;
	
	@Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("employees", empService.findAllEmp());
		return "emp/list";
	}
	
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		model.addAttribute("employee", empService.findEmpInfo(empVO));
		return "emp/info";
	}
	
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);
		String url;
		if(eid > -1) {
			url = "redirect:empInfo?employeeId=" + eid; 
		}
		else {
			url = "redirect:empList";
		}
		return url;
	}
}
