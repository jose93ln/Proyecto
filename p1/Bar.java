package p1;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
		
		JButton Classic_BurgerB = new JButton("Classic Burger");
		Classic_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Classic Burger");
			}
		});
		panel.add(Classic_BurgerB);
		
		JButton CheeseburgerB = new JButton("Cheeseburger");
		CheeseburgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Cheeseburger");
			}
		});
		panel.add(CheeseburgerB);
		
		JButton Bacon_BurgerB = new JButton("Bacon Burger");
		Bacon_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Bacon Burger");
			}
		});
		panel.add(Bacon_BurgerB);
		
		JButton Vegetarian_BurgerB = new JButton("Vegetarian Burger");
		Vegetarian_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Vegetarian Burger");
			}
		});
		panel.add(Vegetarian_BurgerB);
		
		JButton Chicken_BurgerB = new JButton("Chicken Burger");
		Chicken_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Chicken Burger");
			}
		});
		panel.add(Chicken_BurgerB);
		
		JButton French_FriesB = new JButton("French Fries");
		French_FriesB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("French Fries");
			}
		});
		panel.add(French_FriesB);
		
		JButton Onion_RingsB = new JButton("Onion Rings");
		Onion_RingsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Onion Rings");
			}
		});
		panel.add(Onion_RingsB);
		
		JButton SodaB = new JButton("Soda");
		SodaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Soda");
			}
		});
		panel.add(SodaB);
		
		JButton Mineral_WaterB = new JButton("Mineral Water");
		Mineral_WaterB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("Mineral Water");
			}
		});
		panel.add(Mineral_WaterB);
		
		JButton House_DessertB = new JButton("House Dessert");
		House_DessertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pm.addProductByName("House Dessert");
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
					System.out.println("syso "+pm.getAl().toString());
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
	}
}
