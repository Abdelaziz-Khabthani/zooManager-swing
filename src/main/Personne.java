package main;

public class Personne {
	private int matricule;
	private String nom;
	private String prenom;
	private int age;
	private float salaire;

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	
	public void fullSet(int ageUser, String nomUser, String prenomUser, int matriculeUser, float salairesUser)
	{
		this.setAge(ageUser);
		this.setNom(nomUser);
		this.setPrenom(prenomUser);
		this.setMatricule(matriculeUser);
		this.setSalaire(salairesUser);
		this.setAge(ageUser);
	}

}
