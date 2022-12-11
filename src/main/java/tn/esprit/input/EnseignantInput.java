package tn.esprit.input;



import tn.esprit.persistance.Departement;

public class EnseignantInput{
	  
    private Integer idEnseignant; // Clé primaire
    private String nomEnseignant;
    private String prenomEnseignant;
    private String cin;
   	private DepartementInput departement;
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
	public DepartementInput getDepartement() {
		return departement;
	}
	public void setDepartement(DepartementInput departement) {
		this.departement = departement;
	} 
   	
   	
}
