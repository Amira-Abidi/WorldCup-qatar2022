package world.cup.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import world.cup.models.Arbitre;
import world.cup.models.Equipe;
import world.cup.models.Joueur;
import world.cup.models.Pays;
import world.cup.repositories.EquipeRepository;
import world.cup.repositories.JoueurRepository;
import world.cup.service.*;
import world.cup.util.FileUploadUtil;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class JoueurController {
	
	
		@Autowired
		 private JoueurRepository joueurRepository ;
		@PostMapping("/joueur") 
		@PreAuthorize("hasRole('ADMIN')")
		public Joueur add(@RequestParam("imageFile") MultipartFile file,  @RequestParam("nom") String nom,
		 @RequestParam("prenom") String prenom,  @RequestParam("age") int age,  @RequestParam("filiere") String filiere,
		 @RequestParam("num_maillot") int num_maillot,  @RequestParam("id_equipe") Equipe id_equipe)
		 throws IOException  {	
		Joueur j = new Joueur();
		j.setNom(nom);
		j.setPrenom(prenom);
		j.setAge(age);
		j.setFiliere(filiere);
		j.setNum_maillot(num_maillot);
		j.setEquipe(id_equipe);
        j = joueurRepository.save(j);
        Path path = FileUploadUtil.saveFile("playerImage/" + j.getId_joueur(), "" + ((new Date()).getTime()) + ".png", file);
		j.setImg(path.toString());
		j = joueurRepository.save(j);
        return j;	
        
		}
		
		@GetMapping("joueur/img/download")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public ResponseEntity<byte[]> getImage(@RequestParam("url") String url) throws IOException {
			InputStream in = new FileInputStream(url);
			byte[] targetArray = new byte[in.available()];
			in.read(targetArray);
			System.out.println(url);
			in.close();
			return ResponseEntity.ok(targetArray);
			
		}
		
		@GetMapping("/joueur")
		public List <Joueur> Joueur(){
			return joueurRepository.findAll();
		}
		
		@GetMapping("/joueur/{id}") 
		public  Joueur joueur(@PathVariable(value="id")int id){
			return joueurRepository.findById(id);
		}
		
	    @PutMapping("/joueur/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Joueur> updateJoueur(
	            @PathVariable(value = "id") long id,
	             @RequestBody Joueur JoueurDetails){
		          Joueur joueur = joueurRepository.findById(id);
	        joueur.setNom(JoueurDetails.getNom());
	        joueur.setPrenom(JoueurDetails.getPrenom());
	        joueur.setAge(JoueurDetails.getAge());
	        joueur.setFiliere(JoueurDetails.getFiliere());
	        joueur.setNum_maillot(JoueurDetails.getNum_maillot());
	        joueur.setEquipe(JoueurDetails.getEquipe());
	        final Joueur updatedJoueur = joueurRepository.save(joueur);
	        return ResponseEntity.ok(updatedJoueur);}

		
		 @DeleteMapping("/joueur/{id}")
		 @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		 public int deletePays(@PathVariable("id") long id) throws Exception {
				Joueur j =  joueurRepository.findById(id);
				File img = new File(j.getImg());
				if(img.delete()) {
					joueurRepository.delete(j);
					return 1;
				}
				else {
					throw new Exception("couldn't delete picture");
				}
	}
		 
}



