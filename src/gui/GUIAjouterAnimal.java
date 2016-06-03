package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import main.*;

public class GUIAjouterAnimal extends JDialog {
	private JTextField textFieldMatricule;
	private JTextField textFieldEspece;
	private JTextField textFieldPoids;
	private JTextField textFieldAge;
	static GUIAjouterAnimal dialog;

	/**
	 * Launch the application.
	 */
	public static void run() {
		dialog = new GUIAjouterAnimal();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public GUIAjouterAnimal() {
		setTitle("Ajouter Un Animal");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 280, 180);
		getContentPane().setLayout(
				new MigLayout("", "[][][grow]", "[][][][][][]"));
		{
			JLabel lblMat = new JLabel("Matricule:");
			getContentPane().add(lblMat, "cell 0 0 2 1");
		}
		{
			textFieldMatricule = new JTextField();
			textFieldMatricule.setToolTipText("");
			getContentPane().add(textFieldMatricule, "cell 2 0,growx");
			textFieldMatricule.setColumns(10);
		}
		{
			JLabel lblEsp = new JLabel("Esp\u00E9ce:");
			getContentPane().add(lblEsp, "cell 1 1");
		}
		{
			textFieldEspece = new JTextField();
			textFieldEspece.setToolTipText("Esp\u00E9ce...");
			getContentPane().add(textFieldEspece, "cell 2 1,growx");
			textFieldEspece.setColumns(10);
		}
		{
			JLabel lblPoids = new JLabel("Poids:");
			getContentPane().add(lblPoids, "cell 1 2");
		}
		{
			textFieldPoids = new JTextField();
			getContentPane().add(textFieldPoids, "cell 2 2,growx");
			textFieldPoids.setColumns(10);
		}
		{
			JLabel lblAge = new JLabel("Age:");
			getContentPane().add(lblAge, "cell 1 3");
		}
		{
			textFieldAge = new JTextField();
			getContentPane().add(textFieldAge, "cell 2 3,growx");
			textFieldAge.setColumns(10);
		}
		{
			JButton btnAjouter = new JButton("Ajouter");
			btnAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Check()) {
						Animal newAnimal = new Animal();
						newAnimal.fullSet(
								Integer.parseInt(textFieldAge.getText()),
								textFieldEspece.getText(),
								Integer.parseInt(textFieldMatricule.getText()),
								Float.parseFloat(textFieldPoids.getText()));
						ParcAnimalier.AjouterAnimal(newAnimal);
						JOptionPane.showMessageDialog(dialog,
								"L'ajout a été effectué avec succès, Merci.");
						cancelAction();
					}
				}
			});
			getContentPane().add(btnAjouter, "flowx,cell 2 5,alignx right");
		}
		{
			JButton btnNewButtonAnnuler = new JButton("Annuler");
			btnNewButtonAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelAction();
				}
			});
			getContentPane().add(btnNewButtonAnnuler, "cell 2 5,alignx right");
		}
	}

	public boolean Check() // to check the inputs of the user
	{
		if (textFieldMatricule.getText().matches("[0-9]+")
				&& textFieldAge.getText().matches("[0-9]+")
				&& !textFieldMatricule.getText().isEmpty()
				&& !textFieldAge.getText().isEmpty()
				&& !textFieldEspece.getText().isEmpty()
				&& !textFieldPoids.getText().isEmpty()
				&& isFloat(textFieldPoids.getText()) != 0
				&& ParcAnimalier.GetAnimalParMatricule(Integer
						.parseInt(textFieldMatricule.getText())) == null) {
			return true;
		} else {
			JOptionPane
					.showMessageDialog(dialog,
							"Une erreur s'est produite, veuillez retaper les champs nécessaires.");
			cancelAction();
			return false;
		}
	}

	float isFloat(String s) { // returns 0 if the string is not a float(xx.xx)
								// else returns the number itself
		try {
			return Float.parseFloat(s);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	void cancelAction() // the behavior of the Annuler button
	{
		textFieldMatricule.setText(null);
		textFieldAge.setText(null);
		textFieldEspece.setText(null);
		textFieldPoids.setText(null);
	}

}
