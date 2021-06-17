package world.cup.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Joueur implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

@Column(name ="id_joueur")
	private Long id_joueur;
	private String prenom;
	private String nom;
	private int num_maillot;
	private int age;
	private String img;
	private String filiere;
	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
	
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Joueur(Long id_joueur, String prenom, String nom, int num_maillot, int age, String img, String filiere,
			Equipe equipe) {
		super();
		this.id_joueur = id_joueur;
		this.prenom = prenom;
		this.nom = nom;
		this.num_maillot = num_maillot;
		this.age = age;
		this.img = img;
		this.filiere = filiere;
		this.equipe = equipe;
	}

	public Joueur() {
		
	}

	public Long getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(Long id_joueur) {
		this.id_joueur = id_joueur;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNum_maillot() {
		return num_maillot;
	}
	public void setNum_maillot(int num_maillot) {
		this.num_maillot = num_maillot;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	
	
}
