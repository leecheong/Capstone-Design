package Hospital.medic.Service;

import Hospital.medic.Dto.MemberDTO;
import Hospital.medic.Entity.MemberEntity;
import Hospital.medic.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //1. dto-> entity 변환
        //2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //repository의 save메소드 호출(조건. entity객체를 넘겨줘야함)

    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치해야함
         */
        Optional<MemberEntity> byNumber = memberRepository.findByNumber(memberDTO.getNumber());
        if (byNumber.isPresent()) {
            // 조회 결과에 있다면(해당 전화번호를 가진 정보가 있다.)
            MemberEntity memberEntity = byNumber.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                //비밀번호까지 일치
                //엔티티를 디티오로 변환 한 후에 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                //비밀번호가 불일치
                return  null;
            }
        } else{
            // 해당 전화번호를 가진 유저가 없을 떄
            return  null;
        }
    }
}
