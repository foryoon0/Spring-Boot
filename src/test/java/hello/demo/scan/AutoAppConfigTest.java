package hello.demo.scan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.AutoAppConfig;
import hello.demo.member.MemberRepository;
import hello.demo.member.MemberService;
import hello.demo.order.OrderServiceImpl;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
	
			MemberService memberService = ac.getBean(MemberService.class);
			assertThat(memberService).isInstanceOf(MemberService.class);
			
			OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
			MemberRepository memberRepository = bean.getMemberRepository();
			System.out.println("memberRepository = " + memberRepository);
	}
	
}
  