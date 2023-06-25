package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
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
	private ObjectInputStream inObjeto;
	private DataOutputStream output;
	private JTable tableOrd;
	private JScrollPane sPOrd;
	private JLabel lblnpedidos;
	private JTextField textFnpedidos;
	private Tools tu= new Tools();
	private JTable tableLastOrd;
	private int count=0;
	

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
		setTitle("Kitchen");
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
				Clientb.setEnabled(false);
				try {            
					System.out.println("Client -> Start");  
					socket = new Socket(SERVER, PORT);//open socket 
					inObjeto = new ObjectInputStream( socket.getInputStream());
					output = new DataOutputStream(socket.getOutputStream());//to send
					threadtocli= new ThreadtoCli(inObjeto, tableOrd,textFnpedidos);
					threadtocli.start();
				
					
				}
				catch (IOException ex) {        
					System.err.println("Client -> " + ex.getMessage());   }
			}
		});
		Clientb.setBounds(656, 11, 105, 27);
		contentPane.add(Clientb);
		sPOrd = new JScrollPane();
		sPOrd.setBounds(10, 11, 485, 255);
		contentPane.add(sPOrd);



		sPOrd.setViewportView(tableOrd);
		tableOrd = new JTable();
		tableOrd.setModel(new DefaultTableModel(
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
		sPOrd.setViewportView(tableOrd);
		
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
				if(threadtocli.getAlcm().size()>1) {
					tu.ModTab(tableLastOrd, threadtocli.getAlcm().get(0));
					threadtocli.getAlcm().remove(0);
					tu.TextFColor(threadtocli.getAlcm().size(), textFnpedidos);
				System.out.println(threadtocli.getAlcm().get(0).toString());
				int size2=threadtocli.getAlcm().size();
				textFnpedidos.setText(String.valueOf(size2));
				tu.ModTab(tableOrd, threadtocli.getAlcm().get(0));
				
				}
				else if(threadtocli.getAlcm().size()==1) {
					tu.ModTab(tableLastOrd, threadtocli.getAlcm().get(0));
					threadtocli.getAlcm().remove(0);
					tu.TextFColor(threadtocli.getAlcm().size(), textFnpedidos);
					int size2=threadtocli.getAlcm().size();
					textFnpedidos.setText(String.valueOf(size2));
					tu.ModTabEmpty(tableOrd);
				}
				System.out.println("cunt antes "+count);
				count++;
				try {
					output.writeInt(count);
					output.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				System.out.println("count despues "+count);
			}
		});
		OrderReadyB.setBounds(510, 66, 105, 23);
		contentPane.add(OrderReadyB);
		
		JScrollPane sPLastOrd = new JScrollPane();
		sPLastOrd.setBounds(613, 117, 135, 137);
		contentPane.add(sPLastOrd);
		
		tableLastOrd = new JTable();
		tableLastOrd.setModel(new DefaultTableModel(
			new Object[][] {
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
		sPLastOrd.setViewportView(tableLastOrd);
		
		JLabel lblNewLabel = new JLabel("Last Order");
		lblNewLabel.setBounds(648, 96, 59, 14);
		contentPane.add(lblNewLabel);
		

	}
}
