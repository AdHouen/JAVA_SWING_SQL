import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;

public class ProprieteLayout {

	private JFrame frmPropretesSysteme;
	private JTextField textNomMachine;
	private JTextField textAdresseIp;
	private JTextField textUtilisateur;
	private JTextField textNomOs;
	private JTextField textMachineVirtuelle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProprieteLayout window = new ProprieteLayout();
					window.frmPropretesSysteme.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProprieteLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPropretesSysteme = new JFrame();
		frmPropretesSysteme.setTitle("Propretes Systeme");
		frmPropretesSysteme.getContentPane().setBackground(new Color(255, 255, 255));
		frmPropretesSysteme.setBounds(100, 100, 450, 300);
		frmPropretesSysteme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPropretesSysteme.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(128, 128, 255));
		frmPropretesSysteme.getContentPane().add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentreCentre = new JPanel();
		panelCentreCentre.setBackground(new Color(240, 240, 240));
		panelCentre.add(panelCentreCentre, BorderLayout.CENTER);
		panelCentreCentre.setLayout(new GridLayout(0, 1, 5, 12));
		
		textNomMachine = new JTextField();
		textNomMachine.setHorizontalAlignment(SwingConstants.LEFT);
		textNomMachine.setBackground(new Color(240, 240, 240));
		panelCentreCentre.add(textNomMachine);
		textNomMachine.setColumns(10);
		
		textAdresseIp = new JTextField();
		textAdresseIp.setBackground(new Color(240, 240, 240));
		panelCentreCentre.add(textAdresseIp);
		textAdresseIp.setColumns(10);
		
		textUtilisateur = new JTextField();
		textUtilisateur.setBackground(new Color(240, 240, 240));
		panelCentreCentre.add(textUtilisateur);
		textUtilisateur.setColumns(10);
		
		textNomOs = new JTextField();
		textNomOs.setBackground(new Color(240, 240, 240));
		panelCentreCentre.add(textNomOs);
		textNomOs.setColumns(10);
		
		textMachineVirtuelle = new JTextField();
		textMachineVirtuelle.setBackground(new Color(240, 240, 240));
		panelCentreCentre.add(textMachineVirtuelle);
		textMachineVirtuelle.setColumns(10);
		
		JPanel panelCentreGauche = new JPanel();
		panelCentre.add(panelCentreGauche, BorderLayout.WEST);
		panelCentreGauche.setLayout(new GridLayout(5, 1, 10, 5));
		
		JLabel lblNomMachine = new JLabel("  Nom de la machine  ");
		lblNomMachine.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomMachine.setBackground(new Color(255, 255, 255));
		panelCentreGauche.add(lblNomMachine);
		
		JLabel lblAdresseIp = new JLabel("  Adresse IP  ");
		lblAdresseIp.setHorizontalAlignment(SwingConstants.LEFT);
		panelCentreGauche.add(lblAdresseIp);
		
		JLabel lblUtilisateur = new JLabel("  Utilisateur");
		lblUtilisateur.setHorizontalAlignment(SwingConstants.LEFT);
		panelCentreGauche.add(lblUtilisateur);
		
		JLabel lblNomOs = new JLabel("  Nom de l'OS");
		lblNomOs.setHorizontalAlignment(SwingConstants.LEFT);
		panelCentreGauche.add(lblNomOs);
		
		JLabel lblMachineVirtuelle = new JLabel("  Machine Virtuelle");
		lblMachineVirtuelle.setHorizontalAlignment(SwingConstants.LEFT);
		panelCentreGauche.add(lblMachineVirtuelle);
		
		JPanel paneEast = new JPanel();
		FlowLayout fl_paneEast = (FlowLayout) paneEast.getLayout();
		fl_paneEast.setHgap(10);
		frmPropretesSysteme.getContentPane().add(paneEast, BorderLayout.EAST);
		
		JPanel panelWest = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelWest.getLayout();
		flowLayout_2.setHgap(10);
		panelWest.setBackground(new Color(64, 0, 128));
		frmPropretesSysteme.getContentPane().add(panelWest, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("");
		String chemin = "javaLogo.jpg";
		String ressource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(ressource));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		frmPropretesSysteme.getContentPane().add(lblNewLabel, BorderLayout.WEST);
		
		// Methode pour avoir Nom de la machine et IP
		
				try {
					InetAddress inetAdresse = InetAddress.getLocalHost();
					
					textNomMachine.setText(inetAdresse.getHostName());
					  
					textAdresseIp.setText(inetAdresse.getHostAddress());
				} catch (UnknownHostException e) {
					
					e.printStackTrace();
				}
				
				// Methode pour l'utilisateur
				String utilisateur = System.getProperty("user.name");
				textUtilisateur.setText(utilisateur);
				
				// Methode pour le nom de l'OS
				String SE = System.getProperty("os.name");
				textNomOs.setText(SE);
				
				// Methode pour le nom de la machine virtuelle
				String machineVirtuelle = System.getProperty("java.vm.name");
				textMachineVirtuelle.setText(machineVirtuelle);
				
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setVgap(15);
				flowLayout.setHgap(10);
				frmPropretesSysteme.getContentPane().add(panel, BorderLayout.NORTH);
				
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
				flowLayout_1.setVgap(15);
				frmPropretesSysteme.getContentPane().add(panel_1, BorderLayout.SOUTH);
	}

}
