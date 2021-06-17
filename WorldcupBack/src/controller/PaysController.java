package world.cup.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import world.cup.models.Equipe;
import world.cup.models.Joueur;
import world.cup.models.Pays;
import world.cup.repositories.PaysRepository;
import world.cup.util.FileUploadUtil;

@RestController
@RequestMapping("pays")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PaysController {

	@Autowired
	PaysRepository paysRepository;

	@PostMapping("/add")
	@PreAuthorize("hasRole('MODERATOR')")
	// public BodyBuilder uplaodImage(@RequestParam("imageFile")MultipartFile file)
	// throws IOException {
	// public ImageModel uplaodImage(@RequestParam("imageFile")MultipartFile file)
	// throws IOException {
	public Pays uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("pays_name") String name)
			throws IOException {
		Pays p = new Pays();
		p.setName(name);
		p = paysRepository.save(p);
		Path path = FileUploadUtil.saveFile("uploads/" + p.getId_pays(), "" + ((new Date()).getTime()) + ".png", file);
		p.setPicture(path.toString());
		p = paysRepository.save(p);
		return p;

	}

	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Pays> Pays() {
		return paysRepository.findAll();
	}
	
	@GetMapping("/{id}") 
	@PreAuthorize("hasRole('MODERATOR')")
	public  Pays pays(@PathVariable(value="id")long id){
		return paysRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR')")
	public int deletePays(@PathVariable("id") long id) throws Exception {
		Pays p =  paysRepository.findById(id).get();
		File img = new File(p.getPicture());
		if(img.delete()) {
			paysRepository.delete(p);
			return 1;
		}
		else {
			throw new Exception("couldn't delete picture");
		}
	}
	
	//solution 2
	/*
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public int deletePays(@PathVariable("id") long id) throws Exception {
		Pays p =  paysRepository.findById(id).get();
		File img = new File(p.getPicture());
		System.out.println(img.toPath());
		if(Files.deleteIfExists(img.toPath())) {
			paysRepository.delete(p);
			return 1;
		}
		else {
			throw new Exception("couldn't delete picture");
		}
	}
*/
	@GetMapping("/picture/download")
	public ResponseEntity<byte[]> getImage(@RequestParam("url") String url) throws IOException {
		InputStream in = new FileInputStream(url);
		byte[] targetArray = new byte[in.available()];
		in.read(targetArray);
		System.out.println(url);
		in.close();
		return ResponseEntity.ok(targetArray);
		
	}

}