package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BDproductosDAO extends BDconection {
	
    public Products getProduct(String nproduct) {
      
    	Connection connection =conectar();  
        Products p=null;

        if (connection != null) {
            try {
            	PreparedStatement stmt = connection.prepareStatement("SELECT * FROM products p WHERE p.name=?");
            	stmt.setString(1, nproduct);
            	
            	ResultSet resultSet = stmt.executeQuery();
            	if (resultSet.next()) {
            	    
            	    String name = resultSet.getString("name");
            	    double price = resultSet.getDouble("price");
            	    int stock = resultSet.getInt("stock");
            	    p = new Products(name, price, stock);
            	}
                
            } catch (SQLException e) {
                e.printStackTrace();
            } 
                desconectar();
            
        }

        return p;
    }
    public void dinButton (JTable table) {

		Connection connection = conectar(); 
		Products p=null;

		if (connection != null) {
			try {
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM products");
				ResultSet resultSet;
				
					resultSet = stmt.executeQuery();
				
				
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    				modelo.setRowCount(0);
				while (resultSet.next()) {

					 String name = resultSet.getString("name");
	            	    double price = resultSet.getDouble("price");
	            	    int stock = resultSet.getInt("stock");
	            	    p = new Products(name, price, stock);
	            	    System.out.println(p);
	    					Object[] fila = {name, price};
	    					modelo.addRow(fila);
	    					
	    				}
	    			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			desconectar();
		}
    
}
