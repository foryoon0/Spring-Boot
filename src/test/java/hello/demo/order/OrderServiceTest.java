package hello.demo.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.demo.AppConfig;
import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import hello.order.Order;
import hello.order.OrderService;

public class OrderServiceTest {

		MemberService memberService;
		OrderService orderService;
		
		@BeforeEach
		public void beforeEach() {
			AppConfig appConfig = new AppConfig();
			memberService = appConfig.memberService();
			orderService = appConfig.orderService();
		}
		
		
		@Test
		void createOrder() {
			Long memberId = 1L;
			Member member = new Member(memberId, "memberA", Grade.VIP);
			memberService.join(member);
			
			Order order = orderService.createOrder(memberId, "itemA", 10000);
			Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
		}
		 
}
