import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class Loto {

	private JFrame frmFrancaiseDesJeux;
	private JTextField textDate;
	private JTextField textNum2;
	private JTextField textNum3;
	private JTextField textNum4;
	private JTextField textNum5;
	private JTextField textNum6;
	private JTextField textNum7;
	private JTextField textNum1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loto window = new Loto();
					window.frmFrancaiseDesJeux.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrancaiseDesJeux = new JFrame();
		frmFrancaiseDesJeux.setTitle("Francaise des jeux");
		frmFrancaiseDesJeux.setBounds(100, 100, 586, 425);
		frmFrancaiseDesJeux.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrancaiseDesJeux.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		String chemin = "loto.jpg";
		String ressource = getClass().getClassLoader().getResource(chemin).getPath();
		lblNewLabel.setIcon(new ImageIcon(ressource));
		lblNewLabel.setBounds(40, 11, 500, 100);
		frmFrancaiseDesJeux.getContentPane().add(lblNewLabel);

		JCheckBox chckbxPremierTour = new JCheckBox("Premier Tour");
		buttonGroup.add(chckbxPremierTour);
		chckbxPremierTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxPremierTour.isSelected()) {
					tourUn();
				} else {
					tourNull();
				}
			}
		});
		chckbxPremierTour.setBounds(97, 191, 97, 23);
		frmFrancaiseDesJeux.getContentPane().add(chckbxPremierTour);

		JCheckBox chckbxDeuxiemeTour = new JCheckBox("Deuxieme Tour");
		buttonGroup.add(chckbxDeuxiemeTour);
		chckbxDeuxiemeTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxDeuxiemeTour.isSelected()) {
					tourDeux();
				} else {
					tourNull();
				}
			}
		});
		chckbxDeuxiemeTour.setBounds(361, 191, 97, 23);
		frmFrancaiseDesJeux.getContentPane().add(chckbxDeuxiemeTour);

		JLabel lblNewLabel_1 = new JLabel("Tirage du ");
		lblNewLabel_1.setBounds(200, 261, 81, 29);
		frmFrancaiseDesJeux.getContentPane().add(lblNewLabel_1);

		textDate = new JTextField();
		textDate.setBounds(291, 265, 86, 20);
		frmFrancaiseDesJeux.getContentPane().add(textDate);
		textDate.setColumns(10);

		textNum1 = new JTextField();
		textNum1.setHorizontalAlignment(SwingConstants.CENTER);
		textNum1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum1.setColumns(10);
		textNum1.setBounds(117, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum1);

		textNum2 = new JTextField();
		textNum2.setHorizontalAlignment(SwingConstants.CENTER);
		textNum2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum2.setBounds(178, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum2);
		textNum2.setColumns(10);

		textNum3 = new JTextField();
		textNum3.setHorizontalAlignment(SwingConstants.CENTER);
		textNum3.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum3.setColumns(10);
		textNum3.setBounds(244, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum3);

		textNum4 = new JTextField();
		textNum4.setHorizontalAlignment(SwingConstants.CENTER);
		textNum4.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum4.setColumns(10);
		textNum4.setBounds(304, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum4);

		textNum5 = new JTextField();
		textNum5.setHorizontalAlignment(SwingConstants.CENTER);
		textNum5.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum5.setColumns(10);
		textNum5.setBounds(361, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum5);

		textNum6 = new JTextField();
		textNum6.setHorizontalAlignment(SwingConstants.CENTER);
		textNum6.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum6.setColumns(10);
		textNum6.setBounds(418, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum6);

		textNum7 = new JTextField();
		textNum7.setHorizontalAlignment(SwingConstants.CENTER);
		textNum7.setBackground(new Color(223, 98, 101));
		textNum7.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNum7.setColumns(10);
		textNum7.setBounds(479, 301, 40, 43);
		frmFrancaiseDesJeux.getContentPane().add(textNum7);

		// Methode pour la date

		LocalDate date = LocalDate.now();
		textDate.setText(date.toString());

	}

	// Methode Tour 1

	public void tourUn() {
		textNum1.setText("13");
		textNum2.setText("02");
		textNum3.setText("21");
		textNum4.setText("25");
		textNum5.setText("01");
		textNum6.setText("30");
		textNum7.setText("89");

	}

	public void tourDeux() {
		textNum1.setText("31");
		textNum2.setText("20");
		textNum3.setText("12");
		textNum4.setText("52");
		textNum5.setText("10");
		textNum6.setText("03");
		textNum7.setText("98");
	}

	public void tourNull() {

		textNum1.setText(null);
		textNum2.setText(null);
		textNum3.setText(null);
		textNum4.setText(null);
		textNum5.setText(null);
		textNum6.setText(null);
		textNum7.setText(null);

	}

	// Methode Tour 2

}
