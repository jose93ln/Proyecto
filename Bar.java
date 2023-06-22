package p1;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import py2pruebas.Prueba;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bar extends JFrame {

	private JPanel contentPane;
	private final static int PORT = 5005;
	Socket client;
	private ObjectOutputStream outObjeto;
	private ProductManager pm = new ProductManager();
	private BDproductosDAO bdDAO=new BDproductosDAO();
	private JTable tableped;
	private JTable tableprod;
	private JTextField textFTprice;
	private Tools tu= new Tools();
	

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

		//
		/*ImageIcon classicBurgerIcon = new ImageIcon("images/clasic.png");
		Image classicBurgerImage = classicBurgerIcon.getImage();
		Image resizedClassicBurgerImage = classicBurgerImage.getScaledInstance(Classic_BurgerB, buttonHeight, Image.SCALE_SMOOTH);
		ImageIcon resizedClassicBurgerIcon = new ImageIcon(resizedClassicBurgerImage);

		classicBurgerButton.setIcon(resizedClassicBurgerIcon);

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
		 */
		JButton Classic_BurgerB = new JButton("+");
		Classic_BurgerB.setBounds(440, 34, 58, 15);
		Classic_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Classic Burger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Classic_BurgerB);


		JButton CheeseburgerB = new JButton("+");
		CheeseburgerB.setBounds(440, 50, 58, 15);
		CheeseburgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Cheeseburger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(CheeseburgerB);


		JButton Bacon_BurgerB = new JButton("+");
		Bacon_BurgerB.setBounds(440, 66, 58, 15);
		Bacon_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Bacon Burger");
				System.out.println(pm.getAl());
			}
		});

		contentPane.add(Bacon_BurgerB);

		JButton Vegetarian_BurgerB = new JButton("+");
		Vegetarian_BurgerB.setBounds(440, 82, 58, 15);
		Vegetarian_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Vegetarian Burger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Vegetarian_BurgerB);

		JButton Chicken_BurgerB = new JButton("+");
		Chicken_BurgerB.setBounds(440, 98, 58, 15);
		Chicken_BurgerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Chicken Burger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Chicken_BurgerB);

		JButton French_FriesB = new JButton("+");
		French_FriesB.setBounds(440, 114, 58, 15);
		French_FriesB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("French Fries");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(French_FriesB);

		JButton Onion_RingsB = new JButton("+");
		Onion_RingsB.setBounds(440, 130, 58, 15);
		Onion_RingsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Onion Rings");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Onion_RingsB);

		JButton SodaB = new JButton("+");
		SodaB.setBounds(440, 146, 58, 15);
		SodaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Soda");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(SodaB);

		JButton Mineral_WaterB = new JButton("+");
		Mineral_WaterB.setBounds(440, 162, 58, 15);
		Mineral_WaterB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("Mineral Water");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Mineral_WaterB);

		JButton House_DessertB = new JButton("+");
		House_DessertB.setBounds(440, 178, 58, 15);
		House_DessertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdRep("House Dessert");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(House_DessertB);

		//*******************************************************************/

		JButton Classic_BurgerBM = new JButton("-");
		Classic_BurgerBM.setBounds(497, 34, 58, 15);
		Classic_BurgerBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Classic Burger");
				TotalP();
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Classic_BurgerBM);


		JButton CheeseburgerBM = new JButton("-");
		CheeseburgerBM.setBounds(497, 50, 58, 15);
		CheeseburgerBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Cheeseburger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(CheeseburgerBM);


		JButton Bacon_BurgerBM = new JButton("-");
		Bacon_BurgerBM.setBounds(497, 66, 58, 15);
		Bacon_BurgerBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Bacon Burger");
				System.out.println(pm.getAl());
			}
		});

		contentPane.add(Bacon_BurgerBM);

		JButton Vegetarian_BurgerBM = new JButton("-");
		Vegetarian_BurgerBM.setBounds(497, 82, 58, 15);
		Vegetarian_BurgerBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Vegetarian Burger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Vegetarian_BurgerBM);

		JButton Chicken_BurgerBM = new JButton("-");
		Chicken_BurgerBM.setBounds(497, 98, 58, 15);
		Chicken_BurgerBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Chicken Burger");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Chicken_BurgerBM);

		JButton French_FriesBM = new JButton("-");
		French_FriesBM.setBounds(497, 114, 58, 15);
		French_FriesBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("French Fries");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(French_FriesBM);

		JButton Onion_RingsBM = new JButton("-");
		Onion_RingsBM.setBounds(497, 130, 58, 15);
		Onion_RingsBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Onion Rings");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Onion_RingsBM);

		JButton SodaBM = new JButton("-");
		SodaBM.setBounds(497, 146, 58, 15);
		SodaBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Soda");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(SodaBM);

		JButton Mineral_WaterBM = new JButton("-");
		Mineral_WaterBM.setBounds(497, 162, 58, 15);
		Mineral_WaterBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("Mineral Water");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(Mineral_WaterBM);

		JButton House_DessertBM = new JButton("-");
		House_DessertBM.setBounds(497, 178, 58, 15);
		House_DessertBM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdSubst("House Dessert");
				System.out.println(pm.getAl());
			}
		});
		contentPane.add(House_DessertBM);


		//////////***********************/////



		JButton Serverb = new JButton("Server");
		Serverb.setBounds(654, 11, 89, 23);
		Serverb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {


					ServerSocket server = new ServerSocket(PORT);//
					System.out.println("Server started");
					bdDAO.dinButton(tableprod);
					System.out.println("Server waiting for a client...");  
					client = server.accept();
					System.out.println("connected to client: " + client.getInetAddress());
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
		Sendb.setBounds(672, 241, 71, 21);
		Sendb.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("syso "+pm.getAl());
					//	

					outObjeto.writeObject(pm.getAl());//esto lo manda al output, luego el socket lo xucla

					outObjeto.flush();
					outObjeto.reset();
					pm.getAl().clear();
					DefaultTableModel modelo = (DefaultTableModel) tableped.getModel();
					modelo.setRowCount(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(Sendb);

		JScrollPane scrollPaneped = new JScrollPane();
		scrollPaneped.setBounds(590, 48, 153, 171);
		contentPane.add(scrollPaneped);

		tableped = new JTable();
		scrollPaneped.setViewportView(tableped);
		tableped.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
						"Quantity", "Name", "Price"
				}
				));

		JScrollPane scrollPaneprod = new JScrollPane();
		scrollPaneprod.setBounds(22, 11, 421, 189);
		contentPane.add(scrollPaneprod);

		tableprod = new JTable();
		tableprod.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
						"Name", "Price"
				}
				));
		scrollPaneprod.setViewportView(tableprod);
		
		textFTprice = new JTextField();
		textFTprice.setBounds(565, 241, 86, 20);
		contentPane.add(textFTprice);
		textFTprice.setColumns(10);
		
	

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
				pm.getAl().get(i).setpTotal(pm.getAl().get(i).getPrice()*pm.getAl().get(i).getQuantity());
				encontrado = true;
				tu.ModTab(tableped, pm.getAl());
				TotalP();
				break; 
			}
		}
		if (!encontrado) {

			pm.addProductByName(name);
			tu.ModTab(tableped, pm.getAl());
			TotalP();
		}	
	}
	public void ProdSubst (String name) {

		for (int i = 0; i < pm.getAl().size(); i++) {
			System.out.println(i+pm.getAl().get(i).getName());

			if (name.equals(pm.getAl().get(i).getName())) {

				System.out.println("cantidad preresta "+pm.getAl().get(i).getQuantity());
				pm.getAl().get(i).setQuantity(pm.getAl().get(i).getQuantity() -1);
				System.out.println("cantidad postresta "+i+pm.getAl().get(i).getQuantity());
				pm.getAl().get(i).setpTotal(pm.getAl().get(i).getPrice()*pm.getAl().get(i).getQuantity());
				if(pm.getAl().get(i).getQuantity()<1){
					pm.getAl().remove(i);
				}
			}

		}	
		tu.ModTab(tableped, pm.getAl());
		TotalP();
	}
	
	public void TotalP () {
		double tp=0;
		String newtp="";
		DecimalFormat formato = new DecimalFormat("#.00");
		for (int i = 0; i < pm.getAl().size(); i++) {
			tp+=pm.getAl().get(i).getpTotal();
			
			newtp = formato.format(tp);
		}
		textFTprice.setText(newtp);
	}
}

