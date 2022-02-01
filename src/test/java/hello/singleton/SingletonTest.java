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
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContatiner() {
		AppConfig appConfig = new AppConfig(); 
		//1. 조회 : 호출 할 때 마다 객체를 생성  -> JVM 메모리에 객체가 생성돼서 계속 올라감. -> 고객요청이 많은 웹애플리케이션 회사에서는 효율적이지 않다.(메모리 낭비심함)
		MemberService memberService1 = appConfig.memberService();
		
		//2. 조회 : 호출 할 때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();
	
		// 참조 값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		assertThat(memberService1).isNotSameAs(memberService2);
		
		
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		
		// 1. 조회 : 호출 할 때 마다 같은 객체를 반환
		SingletonService singletonService1 = SingletonService.getInstance(); 
		// 2. 조회 : 호출 할 때 마다 같은 객체를 반환
		SingletonService singletonService2 = SingletonService.getInstance(); 
		
		//참조 값이 같은 것을 확인 
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
		
		// singletonService1 == singletonService2
		assertThat(singletonService1).isSameAs(singletonService2);
		// 인스턴스가 같은지 비교하는 것이기 때문에 isSameAs를 사용한다.
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer() { //스프링 DI 컨테이너 덕분에 이미 만들어진 객체를 공유해서 효율적으로 재사용 할 수 있다.
		
//		AppConfig appConfig = new AppConfig(); 
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
	
		// 참조 값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);
		
		assertThat(memberService1).isSameAs(memberService2);
		
		
	}
	
	
	
}
