package org.sopt.carrot.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.carrot.domain.Member;
import org.sopt.carrot.repository.MemberRepository;
import org.sopt.carrot.service.dto.MemberCreateDto;
import org.sopt.carrot.service.dto.MemberFindDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(
            MemberCreateDto memberCreate
    ){
        Member member = memberRepository.save(Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age()));
        return member.getId().toString();
    }

    public Member findMemberById(
            Long memberId
    ){
        return memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        );
    }

    public MemberFindDto getMemberById(
            Long memberId
    ){
        return MemberFindDto.of(findMemberById(memberId));
    }

    public List<MemberFindDto> getAllMembers(){
        return memberRepository.findAll().stream()
                .map(MemberFindDto::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteMember(
            Long memberId
    ){
        memberRepository.delete(findMemberById(memberId));
    }
}
