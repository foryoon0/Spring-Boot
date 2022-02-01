package hello.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;
	
	@Autowired  // (ac.getBean(MemberRepository.class) �ڵ����� ���Ե�.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
		
	}

	@Override
	public Member findMember(Long memberId) {
		
		return memberRepository.findById(memberId);
	}
	
	//�׽�Ʈ �뵵
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}