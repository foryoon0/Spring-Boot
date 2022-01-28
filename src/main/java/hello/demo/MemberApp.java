package hello.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {

//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();

		// 스프링 컨테이너 객체들을 관리해줌(@bean)
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find Member =" + findMember.getName());

	}

}
