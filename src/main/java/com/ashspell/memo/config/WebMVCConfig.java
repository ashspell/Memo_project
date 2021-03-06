package com.ashspell.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ashspell.memo.common.FileManagerService;

@Configuration
public class WebMVCConfig {

	public class webMVCConfig implements WebMvcConfigurer {
		
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
			// /images~
			
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH);
		
	}
}
}
