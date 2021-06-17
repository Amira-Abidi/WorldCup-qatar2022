package world.cup.controller;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.repositories.ArbitreRepository;
import world.cup.repositories.MatcheRepository;
import world.cup.repositories.TournoiRepository;
import world.cup.models.Arbitre;
import world.cup.models.ERole;
import world.cup.models.Equipe;
import world.cup.models.Etournoi;
import world.cup.models.Joueur;
import world.cup.models.Matche;
import world.cup.models.Role;
import world.cup.models.Tournoi;
import world.cup.models.User;
import world.cup.payload.response.MessageResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatcheController {
	
	
		@Autowired
		 private MatcheRepository MatcheRepository ;
		
		@PostMapping("/matche") 
		@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		public Matche add(@RequestBody Matche matche )  {
			matche.setEquipes(matche.getEquipes());
			return MatcheRepository.save(matche);
			}
		
		@GetMapping("/matche")
		public List<Matche> GetMatche(){
			List<Matche> liste = (List<Matche>) MatcheRepository.findAll();
		       return liste;
		}
		
		
		@GetMapping("/matche/{id}")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public  Matche Matche(@PathVariable(value="id")long id){
			return MatcheRepository.findById(id).get();
		}
		
		
		
	    @PutMapping("/matche/{id}")
	    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	    public ResponseEntity<Matche> updateMatche(
	            @PathVariable(value = "id") long id,
	             @RequestBody Matche matcheDetails){
		          Matche matche = MatcheRepository.findById(id).get();
		
		    matche.setDate(matcheDetails.getDate());
	        matche.setHeure(matcheDetails.getHeure());
	        matche.setTour(matcheDetails.getTour());
	        matche.setResultat(matcheDetails.getResultat());
	        matche.setEquipes(matcheDetails.getEquipes());
	        final Matche updatedMatche = MatcheRepository.save(matche);
	        return ResponseEntity.ok(updatedMatche);
	    
	    }
		
		 @DeleteMapping("/matche/{id}")
		 @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		 public String deleteUser(@PathVariable("id") long id, Model model) {
			  Matche Matche = MatcheRepository.findById(id).get();
			    MatcheRepository.delete(Matche);
			    return "redirect:/index";
			}
		    
	
}



