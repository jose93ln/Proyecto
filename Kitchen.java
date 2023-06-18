package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;





public class Kitchen extends JFrame {

	private JPanel contentPane;
	private final static int PORT = 5005;
	private final static String SERVER = "127.0.0.1";
	Socket socket;
	private Thread2 thread;
	private ObjectInputStream inObjeto;
	private JTable table;
	private JScrollPane scrollPane;
	private String matrizInfo[][];
	String[] columnas = {"Nombre", "Precio", "Cantidad"};

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
					thread= new Thread2(inObjeto, table);
					thread.start();
					
				}
				catch (IOException ex) {        
					System.err.println("Client -> " + ex.getMessage());   }
					/*} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/ 

	
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
				"Nombre", "Precio", "Cantidad"
			}
		));
		scrollPane.setViewportView(table);

	}

}
