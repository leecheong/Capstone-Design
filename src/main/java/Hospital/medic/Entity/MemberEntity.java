package Hospital.medic.Entity;

import Hospital.medic.Dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    private Integer number;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    @Column
    private String classfic;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword((memberDTO.getMemberPassword()));
        memberEntity.setMemberName((memberDTO.getMemberName()));
        memberEntity.setNumber(memberDTO.getNumber());
        memberEntity.setClassfic((memberDTO.getClassfic()));
        return memberEntity;
    }
}
