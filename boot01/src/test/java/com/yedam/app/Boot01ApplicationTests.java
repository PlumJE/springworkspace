package com.yedam.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;
import com.yedam.app.mybatis.mapper.TestEmpMapper;
import com.yedam.app.mybatis.service.EmpInfo;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired	// 필드 주입 => 단순 테스트 용도로만 사용해야 한다!!!
	private EmpMapper empMapper;
	
	//@Test
	void contextLoads() {
		List<EmpVO> list = empMapper.selectEmpList();
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	void infoTest() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		assertEquals("King", findVO.getLastName());
		// 첫번째 매개변수 : 기대값
		// 두번째 매개변수 : 실제값
		// => 두 개가 같으면 테스트 성공, 다르면 실패
	}
	
	//@Test
	void insertTest() throws ParseException {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Lee");
		empVO.setEmail("lje64257@gmail.com");
		empVO.setJobId("IT_PROG");
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//		Date date = sdf.parse("240501");
//		empVO.setHireDate(date);
		
		int result = empMapper.insertEmpInfo(empVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void updateTest() {
		// 1) 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		// 2) 수정할 데이터
		findVO.setLastName("Han");
		findVO.setJobId(null);
		
		// 3) 수정
		int result = empMapper.updateEmpInfo(findVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void deleteTest() {
		int result = empMapper.deleteEmpInfo(207);
		assertEquals(1, result);
	}
	
	@Test
	void selectKeyTest() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("Hong@google.com");
		empVO.setJobId("IT_PROG");
		
		// employee_id = null
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println("====" + empVO.getEmployeeId());
		
		assertEquals(1, result);
	}
}
