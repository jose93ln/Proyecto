package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Kitchen extends JFrame {

	private JPanel contentPane;
	private final static int PORT = 5005;
	private final static String SERVER = "127.0.0.1";
	private Socket socket;
	private ThreadtoCli threadtocli;
	private ArrayList<ArrayList>alttc=threadtocli.getAlcm();
	private ObjectInputStream inObjeto;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblnpedidos;
	private JTextField textFnpedidos;
	private Tools tu= new Tools();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kitchen frame = new Kitchen();
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
	public Kitchen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Clientb = new JButton("Client");
		Clientb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {     
				try {            
					System.out.println("Client -> Start");  
					socket = new Socket(SERVER, PORT);//open socket 
					inObjeto = new ObjectInputStream( socket.getInputStream());
					threadtocli= new ThreadtoCli(inObjeto, table,textFnpedidos);
					threadtocli.start();//usar el comandmanager en el thread2 que vaya guardando ahi todo, luego con el boton hecho vas borrando la primera comanda y sale la siguiente y la vas a mandar a la barra para que se entregue en server habra esperando y para entregar
					
					
				}
				catch (IOException ex) {        
					System.err.println("Client -> " + ex.getMessage());   }
			}
		});
		Clientb.setBounds(656, 11, 105, 27);
		contentPane.add(Clientb);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 485, 255);
		contentPane.add(scrollPane);



		scrollPane.setViewportView(table);
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);
		
		lblnpedidos = new JLabel("Nº Orders");
		lblnpedidos.setBounds(538, 17, 59, 14);
		contentPane.add(lblnpedidos);
		
		textFnpedidos = new JTextField();
		textFnpedidos.setText("0");
		textFnpedidos.setBounds(541, 35, 39, 20);
		contentPane.add(textFnpedidos);
		textFnpedidos.setColumns(10);
		
		JButton OrderReadyB = new JButton("Order Ready");
		OrderReadyB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(alttc.size()>1) {
					alttc.remove(0);
				System.out.println(alttc.get(0).toString());
				int size2=alttc.size();
				textFnpedidos.setText(String.valueOf(size2));
				tu.ModTab(table, alttc.get(0));
				}
				else if(alttc.size()==1) {
					alttc.remove(0);
					int size2=alttc.size();
					textFnpedidos.setText(String.valueOf(size2));
					tu.ModTabEmpty(table);
				}
			}
		});
		OrderReadyB.setBounds(510, 66, 105, 23);
		contentPane.add(OrderReadyB);
		

	}
	
}
