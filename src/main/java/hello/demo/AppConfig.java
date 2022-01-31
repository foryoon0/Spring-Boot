package hello.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.discount.DiscountPolicy;
import hello.discount.RateDiscountPolicy;
import hello.member.MemberRepository;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import hello.member.MemoryMemberRepository;
import hello.order.OrderService;
import hello.order.OrderServiceImpl;

// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.

@Configuration
public class AppConfig { //공연기획자 같은 느낌으로 생각하면된다. 배역에 맞는 배우를 선택해서 할당시켜준다.
	
	@Bean
	public MemberService memberService() { //생성자 주입
		return new MemberServiceImpl(memberRepository()); //반환된 객체
	} 
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() { 
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
