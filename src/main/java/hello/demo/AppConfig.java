package hello.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.demo.discount.DiscountPolicy;
import hello.demo.discount.RateDiscountPolicy;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;
import hello.demo.member.MemoryMemberRepository;
import hello.demo.order.OrderService;
import hello.demo.order.OrderServiceImpl;

// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.

@Configuration
public class AppConfig { //공연기획자 같은 느낌으로 생각하면된다. 배역에 맞는 배우를 선택해서 할당시켜준다.
	
	//@Bean memberService -> new MemoryMemberRepository()
	//@Bean orderService -> new MemoryMemberRepository() 
	//총 2번 호출되었음. 싱글톤이 깨지는게 아닐까? 스프링 컨테이너는 이 문제를 어떻게 해결할까??
	
	// call AppConfig.memberService
	// call AppConfig.memberRepository
	// call AppConfig.memberRepository
	// call AppConfig.orderService
	// call AppConfig.memberRepository
	
	// call AppConfig.memberService
	// call AppConfig.memberRepository
	// call AppConfig.orderService
	// --> 스프링이 싱글톤을 보장해준다.
	
	@Bean
	public MemberService memberService() { //생성자 주입
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository()); //반환된 객체
	} 
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() { 
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
