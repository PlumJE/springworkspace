package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {
	private EmpMapper empMapper;

	@Autowired
	public EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}
	
	@Override
	public List<EmpVO> findAllEmp() {
		// TODO Auto-generated method stub
		return empMapper.selectAllEmp();
	}

	@Override
	public EmpVO findEmpInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int addEmpInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.insertEmpInfo(empVO);
	}

	@Override
	public int changeEmpInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.updateEmpInfo(empVO);
	}

	@Override
	public int deleteEmpInfo(int empId) {
		// TODO Auto-generated method stub
		return empMapper.deleteEmpInfo(empId);
	}

}
