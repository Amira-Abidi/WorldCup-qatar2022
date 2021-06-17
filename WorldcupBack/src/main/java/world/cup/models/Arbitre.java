package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Arbitre {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

@Column(name ="id_arbitre")
	private Long id;
	
	private String nom;
	private String prenom;
	private String filiere;
	
	@ManyToOne
	@JoinColumn(name = "matcheid")
	private Matche matche;

	public Arbitre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arbitre(String nom, String prenom, String filiere, Matche matche) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.matche = matche;
	}

	public Object findById(Long id2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public Matche getMatche() {
		return matche;
	}

	public void setMatche(Matche matche) {
		this.matche = matche;
	}

	public Arbitre(Long id, String nom, String prenom, String filiere, Matche matche) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.matche = matche;
	}

	public void save(Arbitre arbitre) {
		// TODO Auto-generated method stub
		
	}
	

}
