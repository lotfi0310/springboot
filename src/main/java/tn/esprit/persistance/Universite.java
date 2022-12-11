package tn.esprit.persistance;

import java.io.Serializable;
//
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="University")
public class Universite implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idUniveriste")
	private int idUniv ; 
	private String imageUniv;
	public String getImageUniv() {
		return imageUniv;
	}
	public void setImageUniv(String imageUniv) {
		this.imageUniv = imageUniv;
	}
	private String nomUniv  ;
	@OneToMany
	private Set<Departement> departments ;
	
	
	public Universite() {
	}
	public Universite(int idUniv, String nomUniv, Set<Departement> departments) {
		this.idUniv = idUniv;
		this.nomUniv = nomUniv;
		this.departments = departments;
	}
	public int getIdUniv() {
		return idUniv;
	}
	public void setIdUniv(int idUniv) {
		this.idUniv = idUniv;
	}
	public String getNomUniv() {
		return nomUniv;
	}
	public void setNomUniv(String nomUniv) {
		this.nomUniv = nomUniv;
	}
	public Set<Departement> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Departement> departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Universite [idUniv=" + idUniv + ", imageUniv=" + imageUniv + ", nomUniv=" + nomUniv + ", departments="
				+ departments + "]";
	}
	
	
	

}
