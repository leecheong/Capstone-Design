package Hospital.medic.Repository;

import Hospital.medic.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    // 휴대폰번호로 회원 정보 조회

    Optional<MemberEntity> findByNumber(Integer number);

}
