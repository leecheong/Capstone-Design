package Hospital.medic.Dto;

import Hospital.medic.Entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Integer number;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String classfic;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setNumber(memberEntity.getNumber());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setClassfic(memberEntity.getClassfic());
        return memberDTO;
    }
}
