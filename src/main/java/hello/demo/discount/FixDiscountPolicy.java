package hello.demo.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.demo.member.Grade;
import hello.demo.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

	private int discountFixAmount = 1000; //1000¿ø ÇÒÀÎ
	
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}else {
		return 0;
		}
	}

}
