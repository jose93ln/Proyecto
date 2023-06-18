package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Thread2 extends Thread{
	private ObjectInputStream inputobj;
	//private Productos p;
	private JTable table;
	private ArrayList <Products> alth= new ArrayList <Products>();

	public Thread2 (ObjectInputStream _imputobj, JTable _table) {
		this.inputobj=_imputobj;
		this.table=_table;	
	}

	@SuppressWarnings("unchecked")
	public void run () {
		while(true) {

			
				alth.clear();
				try {
					alth=(ArrayList<Products>) inputobj.readObject();
					System.out.println(alth);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setRowCount(0);
				for (int i = 0; i < alth.size(); i++) {
					Object[] fila = {alth.get(i).getNombre(), alth.get(i).getPrecio(), alth.get(i).getCantidad()};
					modelo.addRow(fila);
					
				}
			} */
			}		
		}	
	}

