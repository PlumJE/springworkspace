package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${file.upload.path}")
	private String uploadPath;
	
	// 리소스 핸들링
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**") // URL주소
				.addResourceLocations("file:///" + uploadPath, "하나의 URL에 여러 경로를 매핑하는 게 가능함");  // file:///D:/upload/ 폴더 주소 
				// http://서버주소/images/ ============> file:///D:/upload/
	}

	
}
