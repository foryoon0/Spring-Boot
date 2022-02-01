package hello.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import hello.demo.member.MemberService;
import hello.demo.order.Order;
import hello.demo.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
//		//�ϼ� �� orderservice ��ü�� ��ȯ
		
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
		// �̸��� memberService Ÿ���� MemberService 
		OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
		
		Long memberId = 1L;
		Member member = new Member(memberId,"memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId,"itemA",10000);
		
		System.out.println("order= " + order);
		System.out.println("order.calculatePrice= " + order.calculatePrice());
		
	}
}
