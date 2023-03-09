package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }




    public Long join(Member member){
        Long start = System.currentTimeMillis();

        try {
            //같은 이름이 있는 중복 회원x
            extracted(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        }finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish - start;
            System.out.println("join =" + timeMs + "ms");
        }

    }

    private void extracted(Member member) {
        Long start = System.currentTimeMillis();
        try {
            memberRepository.findByName(member.getName())
                    .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다");
                    });
        }finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish - start;
            System.out.println("findMembers" + timeMs + "ms");

        }


    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
