package gui;



import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.ParcAnimalier;
import main.Personne;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAjouterSalarie extends JDialog {
	private JTextField textFieldMatricule;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAge;

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldSalaire;
	private static GUIAjouterSalarie dialog;

	/**
	 * Launch the application.
	 */
	public static void run() {
		dialog = new GUIAjouterSalarie();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public GUIAjouterSalarie() {
		setTitle("Ajouter Un Salari\u00E9");
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 280, 200);
		getContentPane().setLayout(
				new MigLayout("", "[][][grow]", "[][][][][][][]"));
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
			JLabel lblNom = new JLabel("Nom:");
			getContentPane().add(lblNom, "cell 1 1");
		}
		{
			textFieldNom = new JTextField();
			textFieldNom.setToolTipText("");
			getContentPane().add(textFieldNom, "cell 2 1,growx");
			textFieldNom.setColumns(10);
		}
		{
			JLabel lblPrenom = new JLabel("Prénom:");
			getContentPane().add(lblPrenom, "cell 1 2");
		}
		{
			textFieldPrenom = new JTextField();
			textFieldPrenom.setToolTipText("");
			getContentPane().add(textFieldPrenom, "cell 2 2,growx");
			textFieldPrenom.setColumns(10);
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
			JLabel lblSalaire = new JLabel("Salaire:");
			getContentPane().add(lblSalaire, "cell 1 4");
		}
		{
			textFieldSalaire = new JTextField();
			getContentPane().add(textFieldSalaire, "cell 2 4,growx");
			textFieldSalaire.setColumns(10);
		}
		{
			JButton btnAjouter = new JButton("Ajouter");
			btnAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Check()) {
						Personne newPersonne = new Personne();
						newPersonne.fullSet(
								Integer.parseInt(textFieldAge.getText()),
								textFieldNom.getText(),
								textFieldPrenom.getText(),
								Integer.parseInt(textFieldMatricule.getText()),
								Float.parseFloat(textFieldSalaire.getText()));
						ParcAnimalier.AjouterPersonne(newPersonne);
						JOptionPane.showMessageDialog(dialog,
								"L'ajout a été effectué avec succès, Merci.");
						cancelAction();
					}
				}
			});
			getContentPane().add(btnAjouter, "flowx,cell 2 6,alignx right");
		}
		{
			JButton btnNewButtonAnnuler = new JButton("Annuler");
			btnNewButtonAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelAction();
				}
			});
			getContentPane().add(btnNewButtonAnnuler, "cell 2 6,alignx right");
		}
	}

	public boolean Check() // to check the inputs of the user
	{
		if (textFieldMatricule.getText().matches("[0-9]+")
				&& textFieldAge.getText().matches("[0-9]+")
				&& !textFieldMatricule.getText().isEmpty()
				&& !textFieldAge.getText().isEmpty()
				&& !textFieldNom.getText().isEmpty()
				&& !textFieldPrenom.getText().isEmpty()
				&& !textFieldSalaire.getText().isEmpty()
				&& isFloat(textFieldSalaire.getText()) != 0
				&& ParcAnimalier.GetPersonneParMatricule(Integer
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
		textFieldNom.setText(null);
		textFieldPrenom.setText(null);
		textFieldSalaire.setText(null);
	}

}
