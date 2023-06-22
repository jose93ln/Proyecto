package p1;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ThreadtoCli extends Thread{
	private ObjectInputStream inputobj;
	//private Productos p;
	private JTable table;
	private JTextField textFnpedidos;
	private ProductManager pm2=new ProductManager();
	private ArrayList<Products> alth=pm2.getAl();
	private CommandManager cm= new CommandManager();
	private ArrayList<ArrayList> alcm=cm.getAlcm();
	private Tools tu= new Tools();
	

	public ThreadtoCli (ObjectInputStream _imputobj, JTable _table, JTextField _textFnpedidos) {
		this.inputobj=_imputobj;
		this.table=_table;	
		this.textFnpedidos=_textFnpedidos;
	}

	public ArrayList<ArrayList> getAlcm() {
		return alcm;
	}

	@SuppressWarnings("unchecked")
	public void run () {
		while(true) {

			try {
				alth=(ArrayList<Products>) inputobj.readObject();
				System.out.println(alth.toString());
				System.out.println("ant "+alcm.size());
				alcm.add(alth);
				System.out.println("dsp "+alcm.size()); 
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int size2=alcm.size();
			textFnpedidos.setText(String.valueOf(size2));
			tu.ModTab(table, alcm.get(0));
		} 
	}		
}	


