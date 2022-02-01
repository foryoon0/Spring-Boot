package hello.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.AppConfig;
import hello.demo.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("������ ���� ������ DI �����̳�")
	void pureContatiner() {
		AppConfig appConfig = new AppConfig(); 
		//1. ��ȸ : ȣ�� �� �� ���� ��ü�� ����  -> JVM �޸𸮿� ��ü�� �����ż� ��� �ö�. -> ����û�� ���� �����ø����̼� ȸ�翡���� ȿ�������� �ʴ�.(�޸� �������)
		MemberService memberService1 = appConfig.memberService();
		
		//2. ��ȸ : ȣ�� �� �� ���� ��ü�� ����
		MemberService memberService2 = appConfig.memberService();
	
		// ���� ���� �ٸ� ���� Ȯ��
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		assertThat(memberService1).isNotSameAs(memberService2);
		
		
	}
	
	@Test
	@DisplayName("�̱��� ������ ������ ��ü ���")
	void singletonServiceTest() {
		
		// 1. ��ȸ : ȣ�� �� �� ���� ���� ��ü�� ��ȯ
		SingletonService singletonService1 = SingletonService.getInstance(); 
		// 2. ��ȸ : ȣ�� �� �� ���� ���� ��ü�� ��ȯ
		SingletonService singletonService2 = SingletonService.getInstance(); 
		
		//���� ���� ���� ���� Ȯ�� 
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
		
		// singletonService1 == singletonService2
		assertThat(singletonService1).isSameAs(singletonService2);
		// �ν��Ͻ��� ������ ���ϴ� ���̱� ������ isSameAs�� ����Ѵ�.
	}
	
	@Test
	@DisplayName("������ �����̳ʿ� �̱���")
	void springContainer() { //������ DI �����̳� ���п� �̹� ������� ��ü�� �����ؼ� ȿ�������� ���� �� �� �ִ�.
		
//		AppConfig appConfig = new AppConfig(); 
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
	
		// ���� ���� �ٸ� ���� Ȯ��
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		assertThat(memberService1).isSameAs(memberService2);
		
		
	}
	
	
	
}
