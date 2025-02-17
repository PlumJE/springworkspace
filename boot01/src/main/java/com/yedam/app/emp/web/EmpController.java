package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller	// route : 사용자의 요청(endpoint)와 그에 대한 처리
			// : URL + METHOD => Service => View
public class EmpController {
	// 해당 컨트롤러에서 제공하는 서비스
	private EmpService empService;
	
	@Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	// GET	: 조회, 빈페이지
	// POST : 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회 : GET
	// 1) URL + METHOD
	@GetMapping("empList")		// Model = Request + Response
	public String empList(Model model) {
		// 2) Service
		List<EmpVO> list = empService.findAllEmp();
		// 2-1) Service의 결과를 View의 전달
		model.addAttribute("emps", list);
		// 3) View
		return "emp/list";
	}
	
	// 단건조회 : GET + 전달받을 데이터 => QueryString
	// 1) URL + METHOD
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		// 2) Service
		EmpVO findVO = empService.findEmpInfo(empVO);
		// 2-1) Service의 결과를 View의 전달
		model.addAttribute("emp", findVO);
		// 3) View
		return "emp/info";
	}
	
	// 등록 - 페이지 : GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	// 등록 - 처리 : POST => form 태그를 통한 Submit
	//					=> 이미지가 있으면 multipart/form-data
	//					=> 이미지가 없으면 application/x-www-form-urlencoded
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.createEmpInfo(empVO);
		String url;
		if(eid > -1) {
			// 정상적 등록
			url = "redirect:empInfo?employeeId=" + eid;
		}
		else {
			// 등록되지 않은 경우
			url = "redirect:empList";
		}
		return url;
	}
	
	// 수정 - 페이지 : GET == 단건조회
	// 1) URL + METHOD
	@GetMapping("empUpdate")
	public String empUpdate(EmpVO empVO, Model model) {
		// 2) Service
		EmpVO findVO = empService.findEmpInfo(empVO);
		// 2-1) Service의 결과를 View의 전달
		model.addAttribute("emp", findVO);
		// 3) View
		return "emp/update";
	}
	
	// 수정 - 처리 : POST / AJAX => JSON(@RequestBody) 
	@PostMapping("empUpdate")
	@ResponseBody // <===== AJAX					V====== JSON
	public Map<String, Object> empUpdateAJAXJSON(@RequestBody EmpVO empVO) {
		return empService.modifyEmpInfo(empVO);
	}
	
	// 삭제 - 처리 : GET + 전달받을 데이터 1건
	//			   => QueryString(@RequestParam)
	@GetMapping("empDelete")
	public String empDelete(Integer employeeId) {
		empService.removeEmpInfo(employeeId);
		return "redirect:empList";
	}
}
