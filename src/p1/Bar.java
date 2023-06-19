package p1;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JToolBar;

public class Bar extends JFrame {

	private JPanel contentPane;
	private final static int PORT = 5005;
	private final static String SERVER = "127.0.0.1";
	Socket client;
	private ObjectOutputStream outObjeto;
	private ProductManager pm = new ProductManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar frame = new Bar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bar () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 458, 267);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		//
		ImageIcon classicBurgerIcon = new ImageIcon("images/clasic.png");
		/*Image classicBurgerImage = classicBurgerIcon.getImage();
		Image resizedClassicBurgerImage = classicBurgerImage.getScaledInstance(Classic_BurgerB, buttonHeight, Image.SCALE_SMOOTH);
		ImageIcon resizedClassicBurgerIcon = new ImageIcon(resizedClassicBurgerImage);
		
		classicBurgerButton.setIcon(resizedClassicBurgerIcon);*/

		ImageIcon cheeseburgerIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon baconburgerIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon vegburgerIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon chickenburgerIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon friesIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon onionIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon sodaburgerIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon waterburgerIcon = new ImageIcon("ruta_de_la_imagen");
		ImageIcon desertburgerIcon = new ImageIcon("ruta_de_la_imagen");
		//

		JButton Classic_BurgerB = new JButton("Classic Burger");
		Classic_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Classic Burger");
				System.out.println(pm.getAl());
			}
		});
		panel.add(Classic_BurgerB);
		Image classicBurgerImage = classicBurgerIcon.getImage();
		Image resizedClassicBurgerImage = classicBurgerImage.getScaledInstance(120, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedClassicBurgerIcon = new ImageIcon(resizedClassicBurgerImage);
		
		Classic_BurgerB.setIcon(resizedClassicBurgerIcon);
		
		
		JButton CheeseburgerB = new JButton("Cheeseburger");
		CheeseburgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Cheeseburger");
				System.out.println(pm.getAl());
			}
		});
		panel.add(CheeseburgerB);


		JButton Bacon_BurgerB = new JButton("Bacon Burger");
		Bacon_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Bacon Burger");
				System.out.println(pm.getAl());
			}
		});
		panel.add(Bacon_BurgerB);

		JButton Vegetarian_BurgerB = new JButton("Vegetarian Burger");
		Vegetarian_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Vegetarian Burger");
				System.out.println(pm.getAl());
			}
		});
		panel.add(Vegetarian_BurgerB);

		JButton Chicken_BurgerB = new JButton("Chicken Burger");
		Chicken_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Chicken Burger");
				System.out.println(pm.getAl());
			}
		});
		panel.add(Chicken_BurgerB);

		JButton French_FriesB = new JButton("French Fries");
		French_FriesB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("French Fries");
				System.out.println(pm.getAl());
			}
		});
		panel.add(French_FriesB);

		JButton Onion_RingsB = new JButton("Onion Rings");
		Onion_RingsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Onion Rings");
				System.out.println(pm.getAl());
			}
		});
		panel.add(Onion_RingsB);

		JButton SodaB = new JButton("Soda");
		SodaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Soda");
				System.out.println(pm.getAl());
			}
		});
		panel.add(SodaB);

		JButton Mineral_WaterB = new JButton("Mineral Water");
		Mineral_WaterB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Mineral Water");
				System.out.println(pm.getAl());
			}
		});
		panel.add(Mineral_WaterB);

		JButton House_DessertB = new JButton("House Dessert");
		House_DessertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("House Dessert");
				System.out.println(pm.getAl());
			}
		});
		panel.add(House_DessertB);

		JButton btnNewButton_4 = new JButton("X");
		panel.add(btnNewButton_4);

		JButton btnNewButton_11 = new JButton("X");
		panel.add(btnNewButton_11);

		JButton Serverb = new JButton("Server");
		Serverb.setBounds(654, 11, 89, 23);
		Serverb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					//Server Socket to wait for network requests

					ServerSocket server = new ServerSocket(PORT);//
					System.out.println("Server started");   
					System.out.println("Server waiting for a client...");  
					client = server.accept();
					System.out.println("connected to client: " + client.getInetAddress());
					//setSoLinger closes the socket giving 10mS to receive the remaining data
					client.setSoLinger (true, 10);
					outObjeto = new ObjectOutputStream( client.getOutputStream());


				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}

			}
		});

		contentPane.add(Serverb);
		//

		JButton Sendb = new JButton("Send");
		Sendb.setBounds(484, 263, 71, 21);
		Sendb.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("syso "+pm.getAl());
					//		
					outObjeto.writeObject(pm.getAl());//esto lo manda al output, luego el socket lo xucla

					pm.getAl().clear();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(Sendb);

		//


	}


	public void ProdRep (String name) {

		boolean encontrado = false;

		for (int i = 0; i < pm.getAl().size(); i++) {
			System.out.println(i+pm.getAl().get(i).getName());

			if (name.equals(pm.getAl().get(i).getName())) {

				System.out.println("cantidad presuma "+pm.getAl().get(i).getQuantity());
				pm.getAl().get(i).setQuantity(pm.getAl().get(i).getQuantity() + 1);
				System.out.println("cantidad postsuma "+i+pm.getAl().get(i).getQuantity());
				encontrado = true;
				break; 
			}
		}
		if (!encontrado) {
			pm.addProductByName(name);
		}	
	}
}

