package gui;

import javax.swing.JDialog;

import main.Animal;
import main.ParcAnimalier;
import main.Personne;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.*;
import javax.swing.JSeparator;

public class GUIChercher extends JDialog {
	private JTextField textFieldMatricule;
	private Personne personneChercher;
	private Animal animalChercher;
	private static GUIChercher dialog;

	public static void run() {
		dialog = new GUIChercher();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public GUIChercher() {
		setTitle("Chercher");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 431, 102);
		getContentPane().setLayout(
				new MigLayout("", "[grow]", "[][][][grow][][][]"));

		JLabel lblChercher = new JLabel("Matricule: ");
		getContentPane().add(lblChercher, "flowx,cell 0 0");

		JButton btnAnimal = new JButton("Chercher un animal");
		btnAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					if (ParcAnimalier.GetAnimalParMatricule(Integer
							.parseInt(textFieldMatricule.getText())) != null) {
						animalChercher = ParcAnimalier.GetAnimalParMatricule(Integer
								.parseInt(textFieldMatricule.getText()));
						JOptionPane.showMessageDialog(dialog,chercherFoundLabel(animalChercher));

					} else {
						JOptionPane.showMessageDialog(dialog,
								"Cet animal n'existe pas.");
						textFieldMatricule.setText(null);
					}
				} else {
					JOptionPane.showMessageDialog(dialog,
							"Matricule erroné, veuillez retaper.");
					textFieldMatricule.setText(null);
				}
			}
		});

		JButton btnSalarie = new JButton("Chercher un salari\u00E9");
		btnSalarie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					if (ParcAnimalier.GetPersonneParMatricule(Integer
							.parseInt(textFieldMatricule.getText())) != null) {
						personneChercher = ParcAnimalier.GetPersonneParMatricule(Integer
								.parseInt(textFieldMatricule.getText()));
						JOptionPane.showMessageDialog(dialog,chercherFoundLabel(personneChercher));

					} else {
						JOptionPane.showMessageDialog(dialog,
								"Ce salarié n'existe pas.");
						textFieldMatricule.setText(null);
					}
				} else {
					JOptionPane.showMessageDialog(dialog,
							"Matricule erroné, veuillez retaper.");
					textFieldMatricule.setText(null);
				}
			}
		});
		getContentPane().add(btnSalarie, "flowx,cell 0 1,alignx right");
		getContentPane().add(btnAnimal, "cell 0 1,alignx right");

		textFieldMatricule = new JTextField();
		getContentPane().add(textFieldMatricule, "cell 0 0,growx");
		textFieldMatricule.setColumns(10);
	}

	private boolean check() {
		if ((!textFieldMatricule.getText().isEmpty())
				&& (textFieldMatricule.getText().matches("[0-9]+")))
			return true;
		else
			return false;
	}

	public JLabel chercherFoundLabel(Object toTakeAction) {
		if (toTakeAction.getClass().equals(Personne.class)) {
			Personne toTakeActionCasted = (Personne) toTakeAction;
			String message = "<html><table border='1'><tr><td><font color='red'>Matricule</font></td><td><font color='red'>Nom</font></td><td><font color='red'>Prenom</font></td><td><font color='red'>Age</font></td><td><font color='red'>Salaire</font></td></tr>"
					+ "<tr><td>"
					+ toTakeActionCasted.getMatricule()
					+ "</td><td>"
					+ toTakeActionCasted.getNom()
					+ "</td><td>"
					+ toTakeActionCasted.getPrenom()
					+ "</td><td>"
					+ toTakeActionCasted.getAge()
					+ "</td><td>"
					+ toTakeActionCasted.getSalaire()
					+ "</td></tr>"
					+ "</table></html>";
			JLabel lbl1 = new JLabel(message);
			lbl1.setVerticalAlignment(SwingConstants.TOP);
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			return lbl1;

		} else {
			Animal toTakeActionCasted = (Animal) toTakeAction;
			String message = "<html><p>Resultat du Recherche: </p><table border='1'><tr><td><font color='red'>Matricule</font></td><td><font color='red'>Espéce</font></td><td><font color='red'>Poids</font></td><td><font color='red'>Age</font></td></tr>"
					+ "<tr><td>"
					+ toTakeActionCasted.getMatricule()
					+ "</td><td>"
					+ toTakeActionCasted.getEspece()
					+ "</td><td>"
					+ toTakeActionCasted.getPoids()
					+ "</td><td>"
					+ toTakeActionCasted.getAge()
					+ "</td></tr>"
					+ "</table></html>";
			JLabel lbl1 = new JLabel(message);
			lbl1.setVerticalAlignment(SwingConstants.TOP);
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			return lbl1;
		}
	}
}
