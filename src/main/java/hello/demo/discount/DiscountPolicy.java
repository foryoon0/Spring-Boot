package hello.demo.discount;

import hello.demo.member.Member;

public interface DiscountPolicy {
	
	/**
	 * @return ���� ��� �ݾ�
	 */
	int discount(Member member, int price);

}
