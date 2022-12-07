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

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;


import javax.swing.BoxLayout;
import javax.swing.JList;




public class Editeur {

	private JFrame frame;
	
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editeur window = new Editeur();
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
	public Editeur() {
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
		
		JButton btnChercher = new JButton("Chercher");
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
		
		
		
		JTextArea txtrDansLePlancher = new JTextArea();
		String fichier="shadock.txt";
		String way=getClass().getClassLoader().getResource(fichier).getPath().replaceAll("^/","");
		Path path=Paths.get(way);
		String texteDroite="",texteGauche="";
		try (BufferedReader r=Files.newBufferedReader(path,StandardCharsets.UTF_8)) {
	        String line=null;
	        try {
		        while ((line=r.readLine())!=null) {
		        	texteDroite+=line;
		        	texteGauche+=line+"\n";
		        }
	        }
	        finally {
				r.close();
			}
	        /* Texte du label URL (si OK) */
	        lblURL.setForeground(Color.black);
			lblURL.setText(way);
	    } 
	    catch (NoSuchFileException e) {
	    	/* Texte du label URL (si NOK) */
	    	lblURL.setForeground(Color.red);
			lblURL.setText("Fichier inconnu");
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		txtrDansLePlancher.setLineWrap(true);
		txtrDansLePlancher.setWrapStyleWord(true);
		txtrDansLePlancher.setText(texteGauche);
		scrollPane.setViewportView(txtrDansLePlancher);
		
	
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		
		
//		JList list_1 = new JList();
		
		
	
		
		
		
//		String[] tabStrings=texteDroite.split("[ ,\\\"'« »:?;.’]");
//		for (String string : tabStrings) {
//			System.out.println(string);
//		}
		
		
		Pattern p = Pattern.compile("[a-z0-9A-ZàáâãäåçèéêëìíîïñòóôõöùúûüýÿÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝ-]*");
		Matcher m = p.matcher(texteDroite);
		TreeSet<String> coucou = new TreeSet<>();
		while ( m.find() ) {
			if (!m.group().isEmpty()) {
				coucou.add((texteDroite.substring(m.start(), m.end())).toLowerCase());
				
			
//				System.out.println(texteDroite.substring(m.start(), m.end()));
			}
		    
		}
		
		String [] tab = new String[coucou.size()]; 
		int i=0;
		for(String s:coucou) {
			tab[i]=s;i++;
		}
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
//		coucou.forEach(x->list.add(x, panel_1));
		
		JList list_1 = new JList(tab);
//		panel_1.add(list_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		scrollPane_1.setViewportView(list_1);
		list_1.setLayoutOrientation(JList.VERTICAL);
		
		
		
		
//		panel_1.add(list);
		
		
		
		
		
		
		
	}
	
	
	
}
