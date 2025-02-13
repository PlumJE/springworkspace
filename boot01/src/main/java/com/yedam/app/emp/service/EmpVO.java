package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId;		// 사원번호
	private String firstName;		// 이름
	private String lastName;		// 성
	private String email;			// 이메일 주소
	private String phoneNumber;		// 전화번호
	private Date hireDate;			// 근무시작일
	private String jobId;			// 업무번호
	private Double salary;			// 급여
	private Double commissionPct;	// 뽀너스
	private Integer managerId;		// 관리자번호
	private Integer departmentId;	// 부서번호
}
