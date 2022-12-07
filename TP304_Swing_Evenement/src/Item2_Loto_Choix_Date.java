import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;


public class Item2_Loto_Choix_Date {

	private JFrame frame;
	private JTextField textNumero1;
	private JTextField textNumero6;
	private JTextField textNumero5;
	private JTextField textNumero4;
	private JTextField textNumero3;
	private JTextField textNumero2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item2_Loto_Choix_Date window = new Item2_Loto_Choix_Date();
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
	public Item2_Loto_Choix_Date() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 410, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		String chemin = "NewLogoFDJ.png";
		String ressource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(ressource));
		lblNewLabel.setBounds(10, 11, 385, 116);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 195, 369, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 15, 0));
		
		textNumero1 = new JTextField();
		textNumero1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textNumero1);
		textNumero1.setColumns(10);
		
		textNumero2 = new JTextField();
		textNumero2.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero2.setColumns(10);
		panel.add(textNumero2);
		
		textNumero3 = new JTextField();
		textNumero3.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero3.setColumns(10);
		panel.add(textNumero3);
		
		textNumero4 = new JTextField();
		textNumero4.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero4.setColumns(10);
		panel.add(textNumero4);
		
		textNumero5 = new JTextField();
		textNumero5.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero5.setColumns(10);
		panel.add(textNumero5);
		
		textNumero6 = new JTextField();
		textNumero6.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero6.setColumns(10);
		panel.add(textNumero6);
		
		JLabel lblNewLabel_1 = new JLabel("Tirage du :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(22, 154, 100, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 160, 218, 22);
		frame.getContentPane().add(comboBox);
		
	}
}
