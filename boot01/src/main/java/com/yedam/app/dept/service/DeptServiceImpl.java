package com.yedam.app.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;

@Service	// @Transcational 사용 가능
public class DeptServiceImpl implements DeptService {
	// DB가 필요한 경우에만. Mapper는 여러개 가능
	private DeptMapper deptMapper;
	
	@Autowired
	DeptServiceImpl(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}
	
	@Override
	public List<DeptVO> findAllDept() {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptList();
	}

	@Override
	public DeptVO findDeptInfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int createDeptInfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		int result = deptMapper.insertDeptInfo(deptVO);
		if(result == 1) {
			return deptVO.getDepartmentId();
		}
		else {
			return -1;
		}
	}

	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		if(deptMapper.updateDeptInfo(deptVO) == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		
		// 항상 {"result": 결과부울값, "target": deptVO}을 리턴
		return map;
	}

	@Override
	public Map<String, Object> removeDeptInfo(int deptId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		
		if(deptMapper.deleteDeptInfo(deptId) == 1) {
			map.put("departmentId", deptId);
		}
		
		// {"departmentId": deptId} 또는 {}를 리턴
		return map;
	}

}
