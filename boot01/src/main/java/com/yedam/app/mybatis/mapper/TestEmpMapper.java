package com.yedam.app.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.mybatis.service.EmpInfo;

// TestEmpMapper.xml을 참조하여 DOA클래스를 자동 생성
// @Mapper

public interface TestEmpMapper {
	// Mybatis : EmpDAO => Mapper
	// 전체조회
	public List<EmpInfo> empList();
}