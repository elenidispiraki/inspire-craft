package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

    Optional<Member> findByUsername(String username);
    List<Member> findByFirstname(String firstname);
    List<Member> findByLastname(String lastname);
    List<Member> findByFirstnameAndLastname(String firstname, String lastname);

}
