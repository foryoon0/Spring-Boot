package hello.demo.beanfind;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.demo.AppConfig;
import hello.demo.member.MemberService;
import hello.demo.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("�� �̸����� ��ȸ")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	

	@Test
	@DisplayName("�̸� ���� Ÿ�����θ� ��ȸ")
	void findBeanByType() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("��ü Ÿ������ ��ȸ")
	void findBeanByName2() { //��ü Ÿ������ ��ȸ�� �������� �������Ƿ� ����.. ���Ұ� ������ �����ؾߵǱ� ������!
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	

	@Test
	@DisplayName("�� �̸����� ��ȸX")
	void findBeanByNameX() { //��ü Ÿ������ ��ȸ�� ����.. ���Ұ� ������ �����ؾߵǱ� ������!
		assertThrows(NoSuchBeanDefinitionException.class,  //asserThrows�� �ݵ�� ���ܰ� �߻��ؾ� �����ϴ� �޼���
				() -> ac.getBean("xxxx", MemberService.class));
	}
}
	