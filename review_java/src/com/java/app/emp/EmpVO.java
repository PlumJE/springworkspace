package com.java.app.emp;

import java.util.Date;

// com.java.app.emp.EmpVO
public class EmpVO {			
    // 필드 : 객체가 가져야 하는 정보
	private Integer employeeId; //Wrapper 대응되는 클래스 널값가짐
	private String lastName;
	private Date hireDate;
	private double salary;
	
	// 생성자 : 클래스 -> 인스턴스를 생성할때 초기화
	public EmpVO(){}
	
	public EmpVO(Integer employeeId, String lastName){
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.hireDate = new Date();
		this.salary = 1000.0;
	}
	
	// 메소드 : 객체가 동작하는 부분
	public void setEmployeeId(Integer employeeId) { // get set 겟터 셋터
		this.employeeId = employeeId; 				// 
	}
	
	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override // 우클릭 Source Generate to String 로 만듬
	public String toString() {
		return "EmpVO [employeeId=" + employeeId + ", lastName=" + lastName + ", hireDate=" + hireDate + ", salary="
				+ salary + "]";
	}

	
}
