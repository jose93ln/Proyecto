package p1;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tools {

	public void ModTab (JTable table, ArrayList<Products> al) {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (int i = 0; i < al.size(); i++) {
			Object[] fila = {al.get(i).getQuantity(), al.get(i).getName(), al.get(i).getpTotal()};
			modelo.addRow(fila);

		}

	}
	public void ModTabEmpty (JTable table) {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
	}

	public void TextFColor(int n, JTextField txtf) {//usar una cosas de esas de opciones en vez de tantos ifs
		
		if(n==0) {
			txtf.setBackground(null);
		}
		if(n==1||n==2) {
			txtf.setBackground(new Color(0, 128, 0));
		}
		if(n==2||n==3) {
			txtf.setBackground(new Color(255, 255, 0));
		}
		if(n==4) {
			txtf.setBackground(new Color(255, 128, 0));
		}
		if(n>4) {
			txtf.setBackground(new Color(255, 0, 0));
		}
	}
}
