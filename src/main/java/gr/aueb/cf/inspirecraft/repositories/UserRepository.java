package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.core.Role;
import gr.aueb.cf.inspirecraft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
   Optional<User> findByUsername(String username);
   List<User> findByFirstname(String firstname);
   List<User> findByLastname(String lastname);
   List<User> findByFirstnameAndLastname(String firstname, String lastname);
   List<User> findByRole(Role role);
}
