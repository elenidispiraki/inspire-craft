package gr.aueb.cf.inspirecraft.mapper;

import gr.aueb.cf.inspirecraft.dto.MemberInsertDTO;
import gr.aueb.cf.inspirecraft.dto.MemberReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.MemberUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    public Member mapToMemberEntity(MemberInsertDTO memberInsertDTO) {
        Member member = new Member();
        member.setUser(memberInsertDTO.getUser());
        return member;
    }

    public Member mapToMemberEntity(MemberUpdateDTO memberUpdateDTO) {
        Member member = new Member();
        member.setUser(memberUpdateDTO.getUser());
        return member;
    }

    public MemberReadOnlyDTO mapToMemberReadOnlyDTO(Member member) {
        MemberReadOnlyDTO memberReadOnlyDTO = new MemberReadOnlyDTO();
        memberReadOnlyDTO.setUser(member.getUser());
        memberReadOnlyDTO.setId(member.getId());
        memberReadOnlyDTO.setFavorites(member.getFavorites());
        return memberReadOnlyDTO;
    }

}
