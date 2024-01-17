package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // static 설정 -> new MemberRepository 많아도 하나만 생성
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    private static final MemberRepository instance = new MemberRepository(); //싱글톤 만들기(Spring사용안함, Tomcat띄울때만 사용)

    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤 만들기->private생성자로 막기
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store를 보호가기 위해 ArrayList 사용
    }

    public void clearStore() {
        store.clear();
    }





}
