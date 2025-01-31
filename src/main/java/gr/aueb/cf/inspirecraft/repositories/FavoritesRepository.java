package gr.aueb.cf.inspirecraft.repositories;

import gr.aueb.cf.inspirecraft.model.Favorites;
import gr.aueb.cf.inspirecraft.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface FavoritesRepository extends JpaRepository<Favorites, Long>, JpaSpecificationExecutor<Favorites> {
    Optional<Favorites> findByMember(Member member);
}
