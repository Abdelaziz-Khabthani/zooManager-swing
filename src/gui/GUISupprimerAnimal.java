package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import main.*;
import javax.swing.JComboBox;

public class GUISupprimerAnimal extends JDialog {
	private static GUISupprimerAnimal dialog;
	private Label label;
	private JButton btnSupprimer;
	private JComboBox comboBox;
	private List<String> dropDownElements = new ArrayList<String>();

	public static void run() {
		if (ParcAnimalier.GetNombreAnimaux() == 0) {
			JOptionPane.showMessageDialog(GUIAccueil.frmGestionZoo,
					"Il n'y a pas des Animaux pour supprimer.");
		} else {
			dialog = new GUISupprimerAnimal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}

	public GUISupprimerAnimal() {
		setTitle("Supprimer Un Animal");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 600, 130);
		getContentPane().setLayout(
				new MigLayout("", "[grow]", "[][grow][][][]"));

		label = new Label("Selectionner Un Animal pour le Supprimer:");
		getContentPane().add(label, "cell 0 0");
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletSelected(comboBox.getSelectedIndex());
			}
		});
		getContentPane().add(btnSupprimer, "flowx,cell 0 2,alignx right");
		LoadInList();

	}

	public void LoadInList() {
		for (Animal a : ParcAnimalier.getListAnimaux()) {
			dropDownElements.add("<html><font color='red'>Matricule: </font>" + a.getMatricule()
					+ ", <font color='red'>Espéce: </font>" + a.getEspece() + ", <font color='red'>Age: </font>" + a.getAge()
				 + ", <font color='red'>Poids: </font></td>" + a.getPoids()+"</html>");

		}
		comboBox = new JComboBox(dropDownElements.toArray());
		getContentPane().add(comboBox, "cell 0 1,growx");
	}

	public void deletSelected(int i) {
		ParcAnimalier.SupprimerAnimal(ParcAnimalier.getListAnimaux().get(i));
		JOptionPane.showMessageDialog(dialog,
				"La supression a été effectuée avec succès, Merci.");
		comboBox.removeItemAt(i);
		if (ParcAnimalier.GetNombreAnimaux() == 0) {
			label.setText("Il n'y a pas d'animaux pour supprimer.");
			btnSupprimer.setEnabled(false);
			comboBox.setEnabled(false);
		}
		dialog.revalidate();
		dialog.repaint();
	}

}
