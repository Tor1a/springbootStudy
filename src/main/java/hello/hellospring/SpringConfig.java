package hello.hellospring;
import hello.hellospring.aop.TimeTraceApp;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceApp TimeTraceApp(){
//        return new TimeTraceApp();
//    }
//    @Bean
//    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

}