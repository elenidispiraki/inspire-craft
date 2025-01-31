package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface CreatorRepository extends JpaRepository<Creator, Long>, JpaSpecificationExecutor<Creator> {

    Optional<Creator> findByUsername(String username);
    List<Creator> findByFirstname(String firstname);
    List<Creator> findByLastname(String lastname);
    List<Creator> findByFirstnameAndLastname(String firstname, String lastname);

}
