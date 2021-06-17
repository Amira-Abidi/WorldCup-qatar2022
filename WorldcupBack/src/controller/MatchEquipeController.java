
/*
package world.cup.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Arbitre;
import world.cup.models.Matche;
import world.cup.models.Matche_Equipes;
import world.cup.models.Tournoi;
import world.cup.repositories.ArbitreRepository;
import world.cup.repositories.MatchEquipeRepository;
import world.cup.repositories.MatcheRepository;
import world.cup.repositories.TournoiRepository;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatchEquipeController {

	@Autowired
	 private MatchEquipeRepository MatcheEquipeRepository ;
	
	@PostMapping("/matcheequipes") 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Matche_Equipes add(@RequestBody  Matche_Equipes matcheequipes )  {	
	    return MatcheEquipeRepository.save(matcheequipes);
}
	
	@GetMapping("/matcheequipes")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List <Matche_Equipes> Matche_Equipes(){
		return MatcheEquipeRepository.findAll();
	}		
	
	@GetMapping("/matcheequipes/{id}") 
	public  Matche_Equipes matche_equipes(@PathVariable(value="id")Long id){
		return MatcheEquipeRepository.findById(id).get();
	}
	
	
// @PutMapping("/matcheequipes/{id}")
   @PreAuthorize("hasRole('ROLE_ADMIN')")
   public ResponseEntity<world.cup.models.Matche> update(@RequestBody Map<String,Object> matches,@PathVariable(value = "id") long id  )  {
		Arbitre arbitre = arbitreRepository.findById(((Number) matches.get("id_arbitre")).longValue()).get();
		Tournoi tournoi = tournoiRepository.findById(((Number) matches.get("id_tournoi")).longValue()).get();
		Matche m = MatcheRepository.findById(id).get();
		m.setArbitres(arbitre);
		m.setTournoi(tournoi);
		m.setDate_match((Date) matches.get("date_match"));
       m.setHeure_match(((Matche) matches).getHeure_match().toString());
       final Matche updatedMatche = MatcheRepository.save((Matche) matches);
       return ResponseEntity.ok(updatedMatche);
   }//
	
	 @DeleteMapping("/matcheequipes/{id}")
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public Map<String, Boolean> deleteMatcheEquipe(
	            @PathVariable(value = "id") Long id)
	            throws Exception {
	        Matche_Equipes matche_equipes = MatcheEquipeRepository.findById(id).orElseThrow(() -> 
	                new Exception("Matche_Equipe introuvable avec l'id = " + id));

	        MatcheEquipeRepository.delete(matche_equipes);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    
}

}
*/