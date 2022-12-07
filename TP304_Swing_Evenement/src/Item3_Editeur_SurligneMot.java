import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.BoxLayout;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Item3_Editeur_SurligneMot {

	private JFrame frame;

	private JList list;
	private JList list_1;
	private JButton btnChercher;

	private String texteAffiche = "";

	private String texteDroite = "";

	private JTextArea txtrDansLePlancher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Item3_Editeur_SurligneMot window = new Item3_Editeur_SurligneMot();
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
	public Item3_Editeur_SurligneMot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblRechercheMot = new JLabel("Recherche du mot");
		lblRechercheMot.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblRechercheMot);

		btnChercher = new JButton("Chercher");

		btnChercher.setEnabled(false);

		btnChercher.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnChercher);

		JPanel panelCenter = new JPanel();
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);

		JLabel lblURL = new JLabel("New label");
		panel_2.add(lblURL);

		txtrDansLePlancher = new JTextArea();
		String fichier = "shadock.txt";
		String way = getClass().getClassLoader().getResource(fichier).getPath().replaceAll("^/", "");
		Path path = Paths.get(way);

		try (BufferedReader r = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			String line = null;
			try {
				while ((line = r.readLine()) != null) {
					texteDroite += line;
					texteAffiche += line + "\n";
				}
			} finally {
				r.close();
			}
			/* Texte du label URL (si OK) */
			lblURL.setForeground(Color.black);
			lblURL.setText(way);
		} catch (NoSuchFileException e) {
			/* Texte du label URL (si NOK) */
			lblURL.setForeground(Color.red);
			lblURL.setText("Fichier inconnu");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		txtrDansLePlancher.setLineWrap(true);
		txtrDansLePlancher.setWrapStyleWord(true);
		txtrDansLePlancher.setText(texteAffiche);
		scrollPane.setViewportView(txtrDansLePlancher);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);

		Pattern p = Pattern.compile("[a-z0-9A-ZàáâãäåçèéêëìíîïñòóôõöùúûüýÿÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝ'-]*");
		Matcher m = p.matcher(texteDroite);
		TreeSet<String> coucou = new TreeSet<>();
		while (m.find()) {
			if (!m.group().isEmpty()) {
				coucou.add((texteDroite.substring(m.start(), m.end())).toLowerCase());

			}

		}

		String[] tab = new String[coucou.size()];
		int i = 0;
		for (String s : coucou) {
			tab[i] = s;
			i++;
		}
		panel_1.setLayout(new BorderLayout(0, 0));

		list_1 = new JList(tab);
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					surlignerSouris(e);

				}

			}
		});
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_1.getSelectedValue() != "") {
					btnChercher.setEnabled(true);

				}
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		scrollPane_1.setViewportView(list_1);
		list_1.setLayoutOrientation(JList.VERTICAL);

		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				surlignerBouton(e);

			}
		});

	}

	public String getContenu() {

		return null;

	}

	public ArrayList<String> getMot() {

		return null;

	}

	private void surlignerBouton(ActionEvent e) {
		Highlighter highlighter = txtrDansLePlancher.getHighlighter();
		highlighter.removeAllHighlights();
		getHighlight((String) list_1.getSelectedValue());
	}

	private void surlignerSouris(MouseEvent e) {
		Highlighter highlighter = txtrDansLePlancher.getHighlighter();
		highlighter.removeAllHighlights();
		getHighlight((String) list_1.getSelectedValue());
	}

	private void getHighlight(String mot) {
		Pattern p = Pattern.compile("(?i)\\b" + mot + "\\b");
		Matcher m = p.matcher(texteAffiche);
		while (m.find()) {
			if (!m.group().isEmpty()) {
				Highlighter highlighter = txtrDansLePlancher.getHighlighter();
				HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
				try {
					highlighter.addHighlight(m.start(), m.end(), painter);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
