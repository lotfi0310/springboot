package tn.esprit.persistance;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Stade")
public class Stade implements Serializable{
	//
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name="idStade")
	private int idStade ;
	private String nomStade ; 
	private String imageStade;
	@OneToOne(mappedBy = "stade")
	@JsonIgnore
	private Equipe equipe ;
	public int getIdStade() {
		return idStade;
	}
	public void setIdStade(int idStade) {
		this.idStade = idStade;
	}
	public String getNomStade() {
		return nomStade;
	}
	public void setNomStade(String nomStade) {
		this.nomStade = nomStade;
	}
	public String getImageStade() {
		return imageStade;
	}
	public void setImageStade(String imageStade) {
		this.imageStade = imageStade;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Stade() {
		super();
	}
	public Stade(int idStade, String nomStade, String imageStade, Equipe equipe) {
		super();
		this.idStade = idStade;
		this.nomStade = nomStade;
		this.imageStade = imageStade;
		this.equipe = equipe;
	} 



}
