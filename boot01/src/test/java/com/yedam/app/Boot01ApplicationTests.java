package com.yedam.app;

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
	
	@Test
	void contextLoads() {
		List<EmpVO> list = empMapper.selectEmpList();
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
	}
}
