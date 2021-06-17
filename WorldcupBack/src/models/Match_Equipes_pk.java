package world.cup.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Match_Equipes_pk implements Serializable {
	
	
		private static final long serialVersionUID = 1L;
		@Column(name = "id_matche")
	    private Long matche_id;

	    @Column(name = "id_eq1")
	    private Long id_eq1;

}
