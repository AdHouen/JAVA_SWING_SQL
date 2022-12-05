package maquette;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonApp {

	private JFrame frame;
	private JTextField textPseudo;
	private JTextField textEchoPseudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonApp window = new MonApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public MonApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMonPseudo = new JLabel("Entrez votre pseudo");
		lblMonPseudo.setBounds(88, 86, 105, 14);
		frame.getContentPane().add(lblMonPseudo);
		
		textPseudo = new JTextField();
		textPseudo.setBounds(238, 83, 188, 20);
		frame.getContentPane().add(textPseudo);
		textPseudo.setColumns(10);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAnnuler.setBounds(71, 225, 105, 47);
		frame.getContentPane().add(btnAnnuler);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEchoPseudo.setText("");
				textPseudo.setText("");
			}
		});
		btnEffacer.setBounds(217, 225, 105, 47);
		frame.getContentPane().add(btnEffacer);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textEchoPseudo.setText(textPseudo.getText());
			}
		});
		btnOk.setBounds(363, 202, 138, 93);
		frame.getContentPane().add(btnOk);
		
		textEchoPseudo = new JTextField();
		textEchoPseudo.setBounds(236, 367, 190, 20);
		frame.getContentPane().add(textEchoPseudo);
		textEchoPseudo.setColumns(10);
		
		JLabel lblEchoPseudo = new JLabel("Voici votre pseudo");
		lblEchoPseudo.setBounds(88, 370, 125, 14);
		frame.getContentPane().add(lblEchoPseudo);
	}
	
	
}
