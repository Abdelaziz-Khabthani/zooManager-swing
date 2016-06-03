package main;

public class Animal {
	private int matricule;
	private String espece;
	private float poids;
	private int age;

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void fullSet(int ageUser, String especeUser, int matriculeUser, float poidsUser)
	{
		this.setAge(ageUser);
		this.setEspece(especeUser);
		this.setMatricule(matriculeUser);
		this.setPoids(poidsUser);
	}
}
