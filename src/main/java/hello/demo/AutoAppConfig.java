package hello.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //���� ���
@ComponentScan( //�ڵ� ���
		basePackages = "hello.demo", //Ž���� ��Ű���� ���� ��ġ�� ���� �� ��Ű���� �����Ͽ� ������Ű���� ��ȸ
		excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, classes=Configuration.class))
public class AutoAppConfig {
	
}
		