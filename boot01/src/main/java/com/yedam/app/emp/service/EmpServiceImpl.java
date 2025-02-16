package com.yedam.app.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;

@Service	// @Transcational 사용 가능
public class EmpServiceImpl implements EmpService {
	// DB가 필요한 경우. Mapper는 여러개 가능
	private EmpMapper empMapper;
	
	@Autowired
	EmpServiceImpl(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	@Override
	public List<EmpVO> findAllEmp() {
		// TODO Auto-generated method stub
		return empMapper.selectEmpList();
	}

	@Override
	public EmpVO findEmpInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int createEmpInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		int result = empMapper.insertEmpInfo(empVO);
		
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		
		// 항상 {"result": 결과부울값, "target": empVO}을 리턴
		return map;
	}

	@Override
	public Map<String, Object> removeEmpInfo(int employeeId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(employeeId);
		
		if(result == 1) {
			map.put("employeeId", employeeId);
		}
		
		// {"employeeId": employeeId} 또는 {}를 리턴
		return map;
	}
}
