package world.cup.controller;
import java.util.HashMap;
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

import world.cup.models.Equipe;
import world.cup.models.Joueur;
import world.cup.models.Pays;
import world.cup.repositories.EquipeRepository;
import world.cup.repositories.PaysRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EquipeController {
	
	
		@Autowired
		 private EquipeRepository EquipeRepository ;
		@Autowired
		 private PaysRepository paysRepository ;
		@PostMapping("/equipe") 
		@PreAuthorize("hasRole('ADMIN')")
		public Equipe add(@RequestBody Map<String,Object> equipe )  {
			Pays pays = paysRepository.findById(((Number) equipe.get("id_pays")).longValue()).get();
			Equipe eq = new Equipe();
			eq.setNom(equipe.get("nom").toString());
	        eq.setPays(pays);
	        return EquipeRepository.save(eq);	
			}
		
		
		@GetMapping("/equipe")
		public List <Equipe> Equipe(){
			return EquipeRepository.findAll();
		}
		
		
		@GetMapping("/equipe/{id}")
		@PreAuthorize("hasRole('ADMIN')")
		public  Equipe equipe(@PathVariable(value="id")Long id){
			return EquipeRepository.findById(id).get();
		}
		
	    @PutMapping("/equipe/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Equipe> updateEquipe(
	            @PathVariable(value = "id") Long id_equipe,
	             @RequestBody Equipe EquipeDetails) throws Exception {
	        Equipe equipe = EquipeRepository.findById(id_equipe)
	                .orElseThrow(() -> new Exception("Equipe introuvable avec l'id = " + id_equipe));

	        equipe.setNom(EquipeDetails.getNom());
	        equipe.setPays(EquipeDetails.getPays());
	        final Equipe updatedEquipe = EquipeRepository.save(equipe);
	        return ResponseEntity.ok(updatedEquipe);
	    }
		
		 @DeleteMapping("/equipe/{id}")
		 @PreAuthorize("hasRole('ADMIN')")
		    public Map<String, Boolean> deleteEquipe(
		            @PathVariable(value = "id") Long id_equipe)
		            throws Exception {
		        Equipe equipe = EquipeRepository.findById(id_equipe).orElseThrow(() -> 
		                new Exception("Equipe introuvable avec l'id = " + id_equipe));

		        EquipeRepository.delete(equipe);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    
	}
}



