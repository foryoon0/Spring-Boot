package hello.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //수동 등록
@ComponentScan( //자동 등록
		excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, classes=Configuration.class))
public class AutoAppConfig {
	
}
		