package hello.discount;

import hello.member.Member;

public interface DiscountPolicy {
	
	/**
	 * @return ���� ��� �ݾ�
	 */
	int discount(Member member, int price);

}
