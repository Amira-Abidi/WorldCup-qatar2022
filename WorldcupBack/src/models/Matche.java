package world.cup.models;


import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Matche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="matcheid")
	private Long id;
	
	private String tour;
	private String resultat;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String heure;
	
	@OneToMany(mappedBy="matche",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Arbitre> arbitres =  new HashSet<>();
	
	@ManyToMany (cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable (name = "equipe_matches", joinColumns = @JoinColumn(name="matche_id"), inverseJoinColumns = @JoinColumn(name="equipe_id"))
	@JsonIgnore
	Set<Equipe> equipes =  new HashSet<>();
	
	
	public Matche() {
	}

	public Matche(Long id, String tour, String resultat, Date date, String heure, Set<Arbitre> arbitres,
			Set<Equipe> equipes) {
		super();
		this.id = id;
		this.tour = tour;
		this.resultat = resultat;
		this.date = date;
		this.heure = heure;
		this.arbitres = arbitres;
		this.equipes = equipes;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}


	public String getHeure() {
		return heure;
	}




	public void setHeure(String heure) {
		this.heure = heure;
	}




	public Object findById(Long idp) {
		// TODO Auto-generated method stub
		return null;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTour() {
		return tour;
	}


	public void setTour(String tour) {
		this.tour = tour;
	}


	public String getResultat() {
		return resultat;
	}


	public void setResultat(String resultat) {
		this.resultat = resultat;
	}


	public Set<Arbitre> getArbitres() {
		return arbitres;
	}


	public void setArbitres(Set<Arbitre> arbitres) {
		this.arbitres = arbitres;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}


	public Matche save(Matche matche) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	}
