package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CreatorRepository extends JpaRepository<Creator, Long>, JpaSpecificationExecutor<Creator> {

    List<Creator> findByUserFirstname(String firstname);
    List<Creator> findByUserLastname(String lastname);
    List<Creator> findByUserFirstnameAndUserLastname(String firstname, String lastname);

}
