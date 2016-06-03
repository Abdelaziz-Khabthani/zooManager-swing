package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

public class ParcAnimalier {
	private static List<Animal> animaux = new ArrayList<Animal>();
	private static List<Personne> personnes = new ArrayList<Personne>();

	public static void AjouterAnimal(Animal animal) {
		animaux.add(animal);
	}

	public static boolean SupprimerAnimal(Animal animal) {
		return animaux.remove(animal);
	}

	public static void AjouterPersonne(Personne personne) {
		personnes.add(personne);
	}

	public static boolean SupprimerPersonne(Personne personne) {
		return personnes.remove(personne);
	}

	public static int GetNombreAnimaux() {
		return animaux.size();
	}

	public static int GetNombrePersonnes() {
		return personnes.size();
	}

	public static Animal GetAnimalParMatricule(int matricule) { //lambda expressions JDK8
		if (animaux.stream().filter(a -> a.getMatricule() == matricule)
				.collect(Collectors.toList()).size() > 0) {
			return animaux.stream()
					.filter(a -> a.getMatricule() == matricule)
					.collect(Collectors.toList()).get(0);
		}
		else return null;
	}

	public static Personne GetPersonneParMatricule(int matricule) {
		if (personnes.stream().filter(a -> a.getMatricule() == matricule)
				.collect(Collectors.toList()).size() > 0) {
			return personnes.stream()
					.filter(a -> a.getMatricule() == matricule)
					.collect(Collectors.toList()).get(0);
		}
		else return null;
	}

	public static List<Animal> getListAnimaux() {
		return animaux;
	}

	public static List<Personne> getListPersonnes() {
		return personnes;
	}
}
