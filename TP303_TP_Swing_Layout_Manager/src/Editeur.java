import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.security.cert.TrustAnchor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;


import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JScrollBar;




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
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		
		JTextArea txtrDansLePlancher = new JTextArea();
		txtrDansLePlancher.setLineWrap(true);
		txtrDansLePlancher.setWrapStyleWord(true);
		String texteDroite = "Dans le plancher pour savoir si quelqu'un marchait et quel poids il faisait. Le cœur pouvait alors déterminer de quelle personne il s'agissait."
				+ " Dans les murs, des cellules photosensibles, des micro-caméras et tout un réseau de détecteurs divers (magnétique, pression, infrarouge...) "
				+ "permettait de déterminer la position exacte de chaque personne et objet dans la maison, de ventiler ou chauffer en conséquence, d'allumer ou d'éteindre la lumière..."
				+ "David comprenait très bien où voulait en venir Prélude. Lorsqu’il l’avait créé, il détestait ce monde. "
				+ "S’il avait eu la possibilité de le changer, il l’aurait certainement fait. Il l’aurait fait en pensé, mais pas en geste. "
				+ "David n’était pas du genre méchant. Jamais il n’aurait fait de mal à qui que ce soit, mais il avait certainement mis cette idée dans la programmation de "
				+ "Prélude sans le vouloir. Ce n’est pas une blague David, ton programme a réellement fonctionné et je suis là. » Dit Prélude. Et suivit une longue "
				+ "explication de Prélude quant à son existence. Comment avait-il fait pour sortir de l’ordinateur de David pour s’installer sur Internet, et de ce fait "
				+ "sur tous les ordinateurs reliés à Internet. Les explications continuèrent pendant une bonne heure. David laissait parler Prélude. "
				+ "Personne n’intervenait. Tout le monde présent, généraux, informaticiens, simples gardes, tous étaient stupéfiaient. "
				+ "Mais ils étaient beaucoup plus rapides et plus grands. Le peu de voitures qui circulaient encore étaient ultra sécurisées. "
				+ "C'est pourquoi la vitesse maximum autorisée avait été portée à 230km/h. Les gens pouvaient commencer à travailler à l’aide de leur ordinateur "
				+ "portables relié au réseau par leur téléphone mobile. Ils auraient pu travailler de chez eux, mais le contact humain restait une priorité. "
				+ "Voir les collègues, prendre un café ensemble à midi et ce dire 'À demain'. Telle était la vie de l’homme 'moderne'. "
				+ "Florence venait d’avouer quelque chose qu’elle n’osait même pas dire à la personne concernée : David. « Son » David. "
				+ "Oui, elle l’aimait. Depuis qu’il avait emménagé à côté de chez elle, il y a de ça cinq ans. "
				+ "Depuis le premier regard, elle savait que c’était lui. Et à chaque fois la même chose : dès qu’elle parlait de lui, dès qu’elle pensait à lui, ses yeux brillaient.";
		txtrDansLePlancher.setText(texteDroite);
		scrollPane.setViewportView(txtrDansLePlancher);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
//		JList list_1 = new JList();
		
		
	
		
		
		
//		String[] tabStrings=texteDroite.split("[ ,\\\"'« »:?;.’]");
//		for (String string : tabStrings) {
//			System.out.println(string);
//		}
		
		
		Pattern p = Pattern.compile("[a-z0-9A-ZàáâãäåçèéêëìíîïñòóôõöùúûüýÿÀÁÂÃÄÅÇÈÉÊËÌÍÎÏÑÒÓÔÕÖÙÚÛÜÝ]*");
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
