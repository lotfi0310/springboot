
package tn.esprit.persistance;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Enseignant")
public class Enseignant implements Serializable{
	    @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    @Column(name="idEnseignant")
	    private Integer idEnseignant; // Clé primaire
	    private String nomEnseignant;
	    private String prenomEnseignant;
	    private String cin;
	      
	    @ManyToOne
		private Departement departement; 
	     //
		public Enseignant() {
		}

		

		public Integer getIdEnseignant() {
			return idEnseignant;
		}



		public void setIdEnseignant(Integer idEnseignant) {
			this.idEnseignant = idEnseignant;
		}



		public String getNomEnseignant() {
			return nomEnseignant;
		}



		public void setNomEnseignant(String nomEnseignant) {
			this.nomEnseignant = nomEnseignant;
		}



		public String getPrenomEnseignant() {
			return prenomEnseignant;
		}



		public void setPrenomEnseignant(String prenomEnseignant) {
			this.prenomEnseignant = prenomEnseignant;
		}



		public String getCin() {
			return cin;
		}



		public void setCin(String cin) {
			this.cin = cin;
		}



		public Departement getDepartement() {
			return departement;
		}



		public void setDepartement(Departement departement) {
			this.departement = departement;
		}



		
	    
}
