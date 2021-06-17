package world.cup.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipe implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	

    @Column(name ="id_equipe")
	private Long id_equipe;
	private String nom;
	
	@ManyToOne 
    @JoinColumn(name="id_pays")
	private Pays pays;


	public Equipe() {
		super();
	}



	public Equipe(Long id_equipe, String nom, Pays pays) {
		super();
		this.id_equipe = id_equipe;
		this.nom = nom;
		this.pays = pays;
	}



	public Long getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(Long id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

}
