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

// ���ø����̼��� ���� ���ۿ� �ʿ��� ���� ��ü�� �����Ѵ�
// ������ ��ü �ν��Ͻ��� ����(���۷���)�� �����ڸ� ���ؼ� ����(����)���ش�.

@Configuration
public class AppConfig { //������ȹ�� ���� �������� �����ϸ�ȴ�. �迪�� �´� ��츦 �����ؼ� �Ҵ�����ش�.
	
	@Bean
	public MemberService memberService() { //������ ����
		return new MemberServiceImpl(memberRepository()); //��ȯ�� ��ü
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
