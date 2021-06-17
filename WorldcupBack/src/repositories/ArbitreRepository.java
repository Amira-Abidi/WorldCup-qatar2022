package world.cup.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Arbitre;
import world.cup.models.Equipe;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre,Long>   {
	Arbitre findById(long id);
}
