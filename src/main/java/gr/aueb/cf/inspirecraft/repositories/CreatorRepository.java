package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CreatorRepository extends JpaRepository<Creator, Long>, JpaSpecificationExecutor<Creator> {

    List<Creator> findByFirstname(String firstname);
    List<Creator> findByLastname(String lastname);
    List<Creator> findByFirstnameAndLastname(String firstname, String lastname);

}
