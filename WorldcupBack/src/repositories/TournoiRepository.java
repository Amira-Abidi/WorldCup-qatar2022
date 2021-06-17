package world.cup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Etournoi;
import world.cup.models.Tournoi;


@Repository
public interface TournoiRepository extends JpaRepository<Tournoi,Long>  {
	Optional<Tournoi> findByName(Etournoi name);
}
