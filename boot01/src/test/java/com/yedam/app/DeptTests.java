package com.yedam.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
class DeptTests {
	@Autowired	// 필드 주입 => 단순 테스트 용도로만 사용해야 한다!!!
	private DeptMapper deptMapper;
	
	//@Test
	void contextLoads() {
		List<DeptVO> list = deptMapper.selectDeptList();
		for(DeptVO dept : list) {
			System.out.println(dept);
		}
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	void infoTest() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(10);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		
		assertEquals("Administration", findVO.getDepartmentName());
		// 첫번째 매개변수 : 기대값
		// 두번째 매개변수 : 실제값
		// => 두 개가 같으면 테스트 성공, 다르면 실패
	}
	
	//@Test
	void insertTest() throws ParseException {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(555);
		deptVO.setDepartmentName("Kamen Rider");
		deptVO.setManagerId(100);
		deptVO.setLocationId(100);
		
		int result = deptMapper.insertDeptInfo(deptVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void updateTest() {
		// 1) 단건조회
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(555);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		
		// 2) 수정할 데이터
		findVO.setDepartmentName("Nichi asa");
		
		// 3) 수정
		int result = deptMapper.updateDeptInfo(findVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void deleteTest() {
		int result = deptMapper.deleteDeptInfo(555);
		assertEquals(1, result);
	}
}
