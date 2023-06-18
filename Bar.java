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
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_11 = new JButton("New button");
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
					pm.addProductByName("Soda");
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
