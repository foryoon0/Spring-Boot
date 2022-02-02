package hello.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //수동 등록
@ComponentScan( //자동 등록
		basePackages = "hello.demo", //탐색할 패키지의 시작 위치를 지정 이 패키지를 포함하여 하위패키지를 조회
		excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, classes=Configuration.class))
public class AutoAppConfig {
	
}
		