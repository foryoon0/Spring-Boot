package hello.demo.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.member.MemberRepository;
import hello.member.MemoryMemberRepository;


public class ApplicationContextSameBeanFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("Ÿ������ ��ȸ �� ���� Ÿ���� �� �̻� ������, �ߺ� ������ �߻��Ѵ�")
    void findBeanByTypeDuplicate() { //������ Ÿ���� �����Ƿ� NoUnique ���ܹ߻�, aseertThrows ���ܹ߻��� ���� �޼���� ó������.
		assertThrows(NoUniqueBeanDefinitionException.class, 
				() -> ac.getBean(MemberRepository.class));
	}

	@Test
	@DisplayName("Ÿ������ ��ȸ �� ���� Ÿ���� �� �̻� ������, �� �̸��� �����ϸ� �ȴ�")
	void fineBeanByName() {
		MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("Ư�� Ÿ���� ��� ��ȸ�ϱ�")
	void findAllBeanByTypr() {
		//  key,     value
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		for(String key : beansOfType.keySet()) {
			System.out.println("key = " + key + "value = " + beansOfType.get(key));
		}
		System.out.println("beansOfType = " + beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2); //���� : beansoftype�� size�� 2�����ߵȴ�.
		
	}
	
	

	@Configuration
	static class SameBeanConfig{
	
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
		
		
	}
	
	
	
}
