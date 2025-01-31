package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.dto.MemberInsertDTO;
import gr.aueb.cf.inspirecraft.dto.MemberUpdateDTO;
import gr.aueb.cf.inspirecraft.model.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    Member saveMember (MemberInsertDTO memberInsertDTO);
    Member updateMember (MemberUpdateDTO memberUpdateDTO);
    void deleteMember (Long id);
    Optional<Member> getMemberByUsername(String Username);
    Optional<Member> getMemberById(Long id);
    List<Member> getMembersByLastname(String lastname);
    List<Member> getAllMembers();
}
