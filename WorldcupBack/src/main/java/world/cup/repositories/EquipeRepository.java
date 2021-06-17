package world.cup.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Equipe;

@Repository

public interface EquipeRepository extends JpaRepository<Equipe,Long>  {
	Equipe findById(long id);

}
