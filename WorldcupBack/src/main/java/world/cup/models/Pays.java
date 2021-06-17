package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pays")
public class Pays {

	@Id
	@Column(name="id_pays")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pays;
	@Column(name="name")
	private String name;
	
	@Column(name="picture_url")
	private String picture;
	
	
	

	public Pays() {
		super();
	}

	public Pays(Long id_pays, String name, String picture) {
		super();
		this.id_pays = id_pays;
		this.name = name;
		this.picture = picture;
	}

	public Long getId_pays() {
		return id_pays;
	}

	public void setId_pays(Long id_pays) {
		this.id_pays = id_pays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	
}
