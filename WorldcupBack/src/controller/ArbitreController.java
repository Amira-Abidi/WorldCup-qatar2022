package world.cup.controller;
import java.util.List;
import java.util.Map;


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
import world.cup.models.Arbitre;
import world.cup.models.Equipe;
import world.cup.models.Joueur;
import world.cup.models.Matche;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArbitreController {
	
		@Autowired
		 private ArbitreRepository ArbitreRepository ;
		
		@PostMapping("/arbitre") 
		@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public Arbitre add(@RequestBody Arbitre Arbitre) {
				return ArbitreRepository.save(Arbitre);
			}
		
		
		
		@GetMapping("/arbitre")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public List<Arbitre> Arbitres() {
			return ArbitreRepository.findAll();
		}
		
		@GetMapping("/arbitre/{id}")
		@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		public Arbitre Arbitre(@PathVariable(value = "id") int id) {
			return ArbitreRepository.findById(id);
		}
		
		
	    @PutMapping("/arbitre/{id}")
	    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")   
	     public ResponseEntity<Arbitre> updateArbitre(
	            @PathVariable(value = "id") long id,
	             @RequestBody Arbitre arbitreDetails){
		          Arbitre existingArbitre = ArbitreRepository.findById(id);
		
		    existingArbitre.setNom(arbitreDetails.getNom());
	        existingArbitre.setPrenom(arbitreDetails.getPrenom());
	        existingArbitre.setFiliere(arbitreDetails.getFiliere());
	        existingArbitre.setMatche(arbitreDetails.getMatche());
	        final Arbitre updatedArbitre = ArbitreRepository.save( existingArbitre);
	        return ResponseEntity.ok(updatedArbitre);
	    }
		
		 @DeleteMapping("/arbitre/{id}")
		 @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		 public String deleteUser(@PathVariable("id") long id, Model model) {
				Arbitre Arbitre = ArbitreRepository.findById(id);
				ArbitreRepository.delete(Arbitre);
				return "redirect:/index";
			}
}



