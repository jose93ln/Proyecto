package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BDproductosDAO {
	
    public Products getProduct(String nproduct) {
        
        BDconection bdConexion = new BDconection();
        Connection connection = bdConexion.conectar();
        Products p=new Products();

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
                bdConexion.desconectar();
            
        }

        return p;
    }
}
