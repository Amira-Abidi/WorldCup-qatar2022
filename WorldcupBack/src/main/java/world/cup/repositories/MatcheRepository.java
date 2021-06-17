package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Matche;
@Repository
public interface MatcheRepository extends JpaRepository<Matche,Long> {
	Matche findById(long id);	
}
