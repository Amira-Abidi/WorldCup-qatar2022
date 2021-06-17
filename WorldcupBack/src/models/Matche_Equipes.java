package world.cup.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
/*import javax.persistence.Table;

@Entity
public class Matche_Equipes  implements Serializable{

		private static final long serialVersionUID = 1L;
		@EmbeddedId
		private Match_Equipes_pk id;
		
		@ManyToOne
	    @MapsId("id_matche")
	    @JoinColumn(name = "id_matche")
	    private Matche matche;
		
		@ManyToOne
	    @MapsId("id_equipe")
	    @JoinColumn(name = "id_eq1")
	    private Equipe equipe1;
		
		@ManyToOne
	    @MapsId("id_equipe")
	    @JoinColumn(name = "id_eq2")
	    private Equipe equipe2;
		
		private int nbrButsEq1;
		private int nbrButsEq2;
		public Matche_Equipes(Match_Equipes_pk id, Matche matche, Equipe equipe1, Equipe equipe2, int nbrButsEq1,
				int nbrButsEq2) {
			super();
			this.id = id;
			this.matche = matche;
			this.equipe1 = equipe1;
			this.equipe2 = equipe2;
			this.nbrButsEq1 = nbrButsEq1;
			this.nbrButsEq2 = nbrButsEq2;
		}
		public Matche_Equipes() {
			super();
		}
		public Match_Equipes_pk getId() {
			return id;
		}
		public void setId(Match_Equipes_pk id) {
			this.id = id;
		}
		public Matche getMatche() {
			return matche;
		}
		public void setMatche(Matche matche) {
			this.matche = matche;
		}
		public Equipe getEquipe1() {
			return equipe1;
		}
		public void setEquipe1(Equipe equipe1) {
			this.equipe1 = equipe1;
		}
		public Equipe getEquipe2() {
			return equipe2;
		}
		public void setEquipe2(Equipe equipe2) {
			this.equipe2 = equipe2;
		}
		public int getNbrButsEq1() {
			return nbrButsEq1;
		}
		public void setNbrButsEq1(int nbrButsEq1) {
			this.nbrButsEq1 = nbrButsEq1;
		}
		public int getNbrButsEq2() {
			return nbrButsEq2;
		}
		public void setNbrButsEq2(int nbrButsEq2) {
			this.nbrButsEq2 = nbrButsEq2;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		

}*/
