package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_tournoi")
	private Long id_tournoi;
	
	private Etournoi name;


	public Tournoi(Long id_tournoi, Etournoi name) {
		super();
		this.id_tournoi = id_tournoi;
		this.name = name;
	}

	public Tournoi() {
		super();
	}

	public Long getId_tournoi() {
		return id_tournoi;
	}

	public void setId_tournoi(Long id_tournoi) {
		this.id_tournoi = id_tournoi;
	}

	public Etournoi getName() {
		return name;
	}

	public void setName(Etournoi name) {
		this.name = name;
	}
	

	

}
