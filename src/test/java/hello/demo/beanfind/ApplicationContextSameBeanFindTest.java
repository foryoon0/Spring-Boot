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
	@DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByTypeDuplicate() { //동일한 타입이 있으므로 NoUnique 예외발생, aseertThrows 예외발생시 성공 메서드로 처리해줌.
		assertThrows(NoUniqueBeanDefinitionException.class, 
				() -> ac.getBean(MemberRepository.class));
	}

	@Test
	@DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
	void fineBeanByName() {
		MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("특정 타입을 모두 조회하기")
	void findAllBeanByTypr() {
		//  key,     value
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		for(String key : beansOfType.keySet()) {
			System.out.println("key = " + key + "value = " + beansOfType.get(key));
		}
		System.out.println("beansOfType = " + beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2); //검증 : beansoftype의 size가 2개여야된다.
		
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
