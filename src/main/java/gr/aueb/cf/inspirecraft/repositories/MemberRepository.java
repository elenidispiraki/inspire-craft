package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {


    List<Member> findByFirstname(String firstname);
    List<Member> findByLastname(String lastname);
    List<Member> findByFirstnameAndLastname(String firstname, String lastname);

}
