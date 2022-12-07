import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Item1_MDP {

	private JFrame frame;
	private JPasswordField textSource;
	private JTextField textDest;
	private JButton btnVisualiser;
	private JButton btnEffacer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item1_MDP window = new Item1_MDP();
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
	public Item1_MDP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					btnEffacer.doClick();

				}
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 433, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_Center = new JPanel();
		frame.getContentPane().add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(null);

		textSource = new JPasswordField();
		textSource.setEchoChar('*');

		textSource.setBounds(10, 64, 216, 20);
		panel_Center.add(textSource);

		JLabel lblTapez = new JLabel("Tapez votre mot de passe");
		lblTapez.setBounds(10, 21, 158, 15);
		lblTapez.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTapez.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Center.add(lblTapez);

		textDest = new JTextField();
		textDest.setBackground(new Color(255, 255, 255));
		textDest.setEditable(false);
		textDest.setBounds(10, 111, 216, 20);
		panel_Center.add(textDest);
		textDest.setColumns(10);

		btnVisualiser = new JButton("Visualiser");
		btnVisualiser.setEnabled(false);
		btnVisualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDest.setText(new String(textSource.getPassword()));
				btnEffacer.setEnabled(true);
				frame.requestFocus();

			}
		});
		btnVisualiser.setMnemonic('v');
		btnVisualiser.setBounds(269, 62, 89, 22);
		panel_Center.add(btnVisualiser);

		btnEffacer = new JButton("Effacer");
		btnEffacer.setEnabled(false);
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textDest.setText("");
				textSource.setText("");
				textSource.requestFocus(); // Donner le focus a une fenetre
				btnEffacer.setEnabled(false);
				btnVisualiser.setEnabled(false);

			}
		});
		btnEffacer.setMnemonic('e');
		btnEffacer.setBounds(269, 110, 89, 23);
		panel_Center.add(btnEffacer);

		JPanel panel_West = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_West.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_West, BorderLayout.WEST);

		textSource.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (new String(textSource.getPassword()).equals("")) {
					btnVisualiser.setEnabled(false);
					//btnEffacer.setEnabled(false);
				} else {
					btnVisualiser.setEnabled(true);
					//btnEffacer.setEnabled(true);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnVisualiser.doClick();
					frame.requestFocus();
					btnEffacer.setEnabled(true);
				}

			}
		});
	}
}
