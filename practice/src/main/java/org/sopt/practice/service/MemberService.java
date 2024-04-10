package org.sopt.practice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.transaction.annotation.Transactional;
import org.sopt.practice.domain.Member;
import org.sopt.practice.repository.MemberRepository;
import org.sopt.practice.service.dto.MemberCreateDto;
import org.sopt.practice.service.dto.MemberFindDto;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional // jakarta 말고 spring에서 제공하는 걸로 사용해야함.
    // 영속성 어쩌고 - 변경사항을 DB에 반영하기 위해서 적어주는 annotation
    public String createMember(
            // tip : 인자로 받아오는 값에 final을 붙여준다고 함
            final MemberCreateDto memberCreateDto
    ){
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    //이번에는 @Transactional이 필요 없겠지? 그냥 데이터를 받아오기만하는거라서 DB에 변화가 안 생기기 때문에
    // 또는 @Transactional(readonly) 우리는 디비를 변경하지 않을거라는 어노테이션을 적어줘도 됨
    private Member findMemberById(
            Long memberId
    ) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        );
    }

    public MemberFindDto getMemberById(
            Long memberId
    ) {
        return MemberFindDto.of(findMemberById(memberId));
    }

    @Transactional
    public void deleteMemberById(Long memberId){
        Member member = memberRepository.findById(memberId).
                orElseThrow(()->new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
    }
}
