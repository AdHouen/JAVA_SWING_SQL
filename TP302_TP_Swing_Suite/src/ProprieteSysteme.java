import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ProprieteSysteme {

	private JFrame frmPropritesSystme;
	private JTextField textMachine;
	private JTextField textAdresse;
	private JTextField textUtilisateur;
	private JTextField textOs;
	private JTextField textMachineVirtuelle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProprieteSysteme window = new ProprieteSysteme();
					window.frmPropritesSystme.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProprieteSysteme() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPropritesSystme = new JFrame();
		frmPropritesSystme.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPropritesSystme.setTitle("Propriétes système");
		frmPropritesSystme.setBounds(100, 100, 562, 245);
		frmPropritesSystme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPropritesSystme.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom de la machine");
		lblNom.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblNom.setBounds(116, 43, 136, 14);
		frmPropritesSystme.getContentPane().add(lblNom);
		
		JLabel lblAdresseIP = new JLabel("Adressse IP");
		lblAdresseIP.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblAdresseIP.setBounds(116, 68, 136, 14);
		frmPropritesSystme.getContentPane().add(lblAdresseIP);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblUtilisateur.setBounds(116, 93, 136, 14);
		frmPropritesSystme.getContentPane().add(lblUtilisateur);
		
		JLabel lblNomOs = new JLabel("Nom de l'OS");
		lblNomOs.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblNomOs.setBounds(116, 118, 136, 14);
		frmPropritesSystme.getContentPane().add(lblNomOs);
		
		JLabel lblMachineVirtuelle = new JLabel("Machine Virtuelle");
		lblMachineVirtuelle.setFont(new Font("Calibri Light", Font.BOLD, 13));
		lblMachineVirtuelle.setBounds(116, 143, 136, 14);
		frmPropritesSystme.getContentPane().add(lblMachineVirtuelle);
		
		textMachine = new JTextField();
		textMachine.setBounds(259, 38, 273, 20);
		frmPropritesSystme.getContentPane().add(textMachine);
		textMachine.setColumns(10);
		
		textAdresse = new JTextField();
		textAdresse.setBounds(259, 63, 273, 20);
		frmPropritesSystme.getContentPane().add(textAdresse);
		textAdresse.setColumns(10);
		
		textUtilisateur = new JTextField();
		textUtilisateur.setBounds(259, 88, 273, 20);
		frmPropritesSystme.getContentPane().add(textUtilisateur);
		textUtilisateur.setColumns(10);
		
		textOs = new JTextField();
		textOs.setBounds(259, 113, 273, 20);
		frmPropritesSystme.getContentPane().add(textOs);
		textOs.setColumns(10);
		
		textMachineVirtuelle = new JTextField();
		textMachineVirtuelle.setBounds(259, 138, 273, 20);
		frmPropritesSystme.getContentPane().add(textMachineVirtuelle);
		textMachineVirtuelle.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		String chemin = "javaLogo.jpg";
		String ressource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(ressource));
		lblNewLabel.setBounds(0, 24, 110, 140);
		frmPropritesSystme.getContentPane().add(lblNewLabel);
		
		// Methode pour avoir Nom de la machine et IP
		
		try {
			InetAddress inetAdresse = InetAddress.getLocalHost();
			
			textMachine.setText(inetAdresse.getHostName());
			  
			textAdresse.setText(inetAdresse.getHostAddress());
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		// Methode pour l'utilisateur
		String utilisateur = System.getProperty("user.name");
		textUtilisateur.setText(utilisateur);
		
		// Methode pour le nom de l'OS
		String SE = System.getProperty("os.name");
		textOs.setText(SE);
		
		// Methode pour le nom de la machine virtuelle
		String machineVirtuelle = System.getProperty("java.vm.name");
		textMachineVirtuelle.setText(machineVirtuelle);
		
		
	}

}
