package hello.demo.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import hello.demo.member.Member;

public class AutowiredTest {

	
	@Test
	void AutowiredOption() {
			ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}
	
	static class TestBean{
		
		//�ڵ� ������ ����� ������ ������ �޼��� ��ü�� ȣ�� �ȵ� 
		@Autowired(required = false)
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1= " + noBean1);
		}
		
		
	
		//�ڵ� ������ ����� ������ NULL �� �Էµȴ�.
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean2= " + noBean2);
		}
		
		
		
		//�ڵ� ������ ����� ������ Optional.empty�� �Է� �ȴ�.
		
		@Autowired
		public void setNoBean3(Optional<Member> noBean3) {
			System.out.println("noBean3= " + noBean3);
		}
		
		
	}
	
}
