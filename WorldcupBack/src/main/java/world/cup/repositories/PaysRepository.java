package world.cup.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import world.cup.models.Joueur;
import world.cup.models.Pays;
public interface PaysRepository extends JpaRepository<Pays, Long> {
	Optional<Pays> findByName(String name);
	Optional<Pays> findById(long  id);
	boolean existsByName(String originalFilename);
	
}
