package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import main.*;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GUIAccueil {

	public int x;
	static JFrame frmGestionZoo;
	private JButton btnSupprimerAnml;
	private JButton btnAjouterSlr;
	private JButton btnSupprimerSlr;
	private JButton btnChercher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUIAccueil window = new GUIAccueil();
				window.frmGestionZoo.setVisible(true);
			}
		});

	}

	/**
	 * Create the application.
	 */
	public GUIAccueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionZoo = new JFrame();
		frmGestionZoo
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								GUIAccueil.class
										.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frmGestionZoo.setResizable(false);
		frmGestionZoo.setTitle("Zoo");
		frmGestionZoo.setBounds(100, 100, 200, 270);
		frmGestionZoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnShowAnml = new JButton("Num\u00E9ro d'Animaux");
		btnShowAnml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ParcAnimalier.GetNombreAnimaux() == 0)
					JOptionPane.showMessageDialog(frmGestionZoo,
							"Il n'y a pas d'animaux.");
				else if (ParcAnimalier.GetNombreAnimaux() == 1)
					JOptionPane.showMessageDialog(frmGestionZoo,
							"Il y a un seul animal.");
				else
					JOptionPane.showMessageDialog(frmGestionZoo, "Il y a "
							+ ParcAnimalier.GetNombreAnimaux() + " animaux.");
			}
		});
		frmGestionZoo.getContentPane().setLayout(
				new MigLayout("", "[188px]",
						"[27px][27px][27px][27px][27px][27px][27px][27px]"));
		btnShowAnml.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnShowAnml,
				"cell 0 0,growx,aligny top");

		JButton btnShowSlr = new JButton("Num\u00E9ro des salari\u00E9s");
		btnShowSlr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ParcAnimalier.GetNombrePersonnes() == 0)
					JOptionPane.showMessageDialog(frmGestionZoo,
							"Il n'y a pas de salairés.");
				else if (ParcAnimalier.GetNombrePersonnes() == 1)
					JOptionPane.showMessageDialog(frmGestionZoo,
							"Il y a un seul salarié.");
				else
					JOptionPane.showMessageDialog(frmGestionZoo, "Il y a "
							+ ParcAnimalier.GetNombrePersonnes()
							+ " personnes.");
			}
		});
		btnShowSlr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnShowSlr,
				"cell 0 1,growx,aligny top");

		JButton btnAjouterAnml = new JButton("Ajouter un animal");
		btnAjouterAnml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIAjouterAnimal.run();
			}
		});
		btnAjouterAnml.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnAjouterAnml,
				"cell 0 2,growx,aligny top");

		btnSupprimerAnml = new JButton("Supprimer un animal");
		btnSupprimerAnml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUISupprimerAnimal.run();
			}
		});
		btnSupprimerAnml.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnSupprimerAnml,
				"cell 0 3,growx,aligny top");

		btnAjouterSlr = new JButton("Ajouter un salari\u00E9");
		btnAjouterSlr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIAjouterSalarie.run();
			}
		});
		btnAjouterSlr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnAjouterSlr,
				"cell 0 4,growx,aligny top");

		btnSupprimerSlr = new JButton("Supprimer un salari\u00E9");
		btnSupprimerSlr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUISupprimerSalarie.run();
			}
		});
		btnSupprimerSlr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnSupprimerSlr,
				"cell 0 5,growx,aligny top");

		btnChercher = new JButton("Chercher par matricule");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIChercher.run();

			}
		});
		btnChercher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmGestionZoo.getContentPane().add(btnChercher,
				"cell 0 6,growx,aligny top");
	}
}
