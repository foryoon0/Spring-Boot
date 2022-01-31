package hello.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest { //���� �ʵ�� �����ؾ� �Ѵ�!! �������� �׻� ������(stateless)�� ��������!!

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);

		//ThreadA : A����� 10000�� �ֹ�
		int userAprice = statefulService1.order("userA", 10000);
		//ThreadB : B����� 20000�� �ֹ�
		int userBprice = statefulService2.order("userB", 20000);
		
		//ThreadA : �����A �ֹ� �ݾ� ��ȸ
//		int price = statefulService1.getPrice();
		System.out.println("Aprice = " + userAprice);
		System.out.println("Bprice = " + userBprice);
	
	}

	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
			
		}
		
	}

}
