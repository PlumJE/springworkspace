package com.yedam.app.common.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	// Content-type : application/x-www-form-urlencoded
	// QueryString(질의문자열) : key=value&key=value&...
	// Method 상관없음
	
	// QueryString => 커맨드 객체(어노테이션 X) : 객체형
	@RequestMapping(path="comobj", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "Path : /comobj \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}
	
	// QueryString => @RequestParam : 기본자료형, 단일값
	@RequestMapping(path="reqparm", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(
		@RequestParam Integer employeeId,	// 필수 
		String lastName, 					// 생략가능
		@RequestParam(name="message",		// 클라이언트는 message로만 접근 가능
			defaultValue="No message",		// 통신의 모든 값은 문자열 형식으로
			required=true) String msg) {
		String result = "Path : /comobj \n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " + lastName;
		result += "\t message : " + msg;
		return result;
	}
	
	// @PathVariable : 경로를 값으로 하는 방식, 단일 값
	// Content-type도 상관없음
	// Method도 상관없음
	// 보안상 선호되는 방식
	@RequestMapping("path/{id} ") // path/Hong, path/1234
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "id is " + id;
		return result;
	}
	
	// Content-type : application/json
	// JSON 포맷 => @RequestBody배열 xor 객체
	// Method : POST, PUT
	// JSON => 객체 1개
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = "path : /resbody \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}
	
	// JSON => 배열 1개
	@PostMapping("resbodylist")
	@ResponseBody
	public String requestBodyList(@RequestBody List<EmpVO> empList) {
		String result = "path : /resbodylist \n";
		for(EmpVO empVO : empList) {
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " + empVO.getLastName();
		}
		return result;
	}
	
}
