package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	public List<EmpVO> findAllEmp();
	
	public EmpVO findEmpInfo(EmpVO empVO);
	
	public int addEmpInfo(EmpVO empVO);
	
	public int changeEmpInfo(EmpVO empVO);
	
	public int deleteEmpInfo(int empId);
}
