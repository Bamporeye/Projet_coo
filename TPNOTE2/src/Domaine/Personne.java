package Domaine;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String evaluation;
	
	public Personne(){}
	public Personne(int id, String n, String p){
		this.id=id;
		this.nom=n;
		this.prenom=p;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	
	
}
