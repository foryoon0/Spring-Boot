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

// ���ø����̼��� ���� ���ۿ� �ʿ��� ���� ��ü�� �����Ѵ�
// ������ ��ü �ν��Ͻ��� ����(���۷���)�� �����ڸ� ���ؼ� ����(����)���ش�.

@Configuration
public class AppConfig { //������ȹ�� ���� �������� �����ϸ�ȴ�. �迪�� �´� ��츦 �����ؼ� �Ҵ�����ش�.
	
	//@Bean memberService -> new MemoryMemberRepository()
	//@Bean orderService -> new MemoryMemberRepository() 
	//�� 2�� ȣ��Ǿ���. �̱����� �����°� �ƴұ�? ������ �����̳ʴ� �� ������ ��� �ذ��ұ�??
	
	// call AppConfig.memberService
	// call AppConfig.memberRepository
	// call AppConfig.memberRepository
	// call AppConfig.orderService
	// call AppConfig.memberRepository
	
	// call AppConfig.memberService
	// call AppConfig.memberRepository
	// call AppConfig.orderService
	// --> �������� �̱����� �������ش�.
	
	@Bean
	public MemberService memberService() { //������ ����
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository()); //��ȯ�� ��ü
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
