package p1;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tools {//puedo hacer esto padre de todas las clases que vayan a usar esto

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

	public void TextFColor() {//segun el size vaya cambiando el color de fondo

	}
}
