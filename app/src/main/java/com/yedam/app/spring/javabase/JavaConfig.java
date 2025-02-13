package com.yedam.app.spring.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 설정 -> Spring이 내부 자동으로 실행 = 스프링이 자동으로 실행하고 실행결과를 빈으로 등록
public class JavaConfig {
	
	public JavaConfig(){
		System.out.println("java Bean Configuration");
	}

	@Bean // 메서드를 실행한 결과를 Bean으로 등록 = 메서드를 실행해서 인스턴스를 만듬
	public User user() {
		System.out.println("User Bean Create");
		return new User();
	}
	
	@Bean                        // 매개변수를 선언 -> Ioc컨테이너 안 Bean을 호출
	public NHCard nhCard(User user) {
		System.out.println("NHCard Bean Create");
		return new NHCard(user); // DI : 생성자 주입
	}
	
	@Bean 
	public KBCard kbChrd(User user) {
		KBCard kbCard = new KBCard();
		kbCard.setOwner(user); // DI : 세터 주입
		System.out.println("KBCard Bean Create");
		return kbCard;
	}
}
