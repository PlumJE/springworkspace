package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId;	// 사원번호
	private String firstName;	// 이름
	private String lastName;	// 성씨
	private String email;		// 이메일주소
	private String phoneNumber;	// 휴대폰번호
	private Date hireDate;		// 입사일자
	private Integer jobId;		// 업무번호
	private Integer salary;		// 급여
	private Double commissionPct;	// 기여보너스
	private Integer managerId;		// 관리자번호
	private Integer departmentId;	// 부서번호
}
