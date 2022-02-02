package hello.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.demo.annotation.MainDiscountPolicy;
import hello.demo.discount.DiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy DiscountPolicy) 
	{
		this.memberRepository = memberRepository;
		this.discountPolicy = DiscountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}



