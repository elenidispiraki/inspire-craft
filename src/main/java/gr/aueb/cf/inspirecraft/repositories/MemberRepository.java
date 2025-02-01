package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

    @Override
    Optional<Member> findById(Long Long);
    List<Member> findByUserFirstname(String firstname);
    List<Member> findByUserLastname(String lastname);
    List<Member> findByUserFirstnameAndUserLastname(String firstname, String lastname);

}
