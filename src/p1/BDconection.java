package p1;

import java.sql.*;
import java.util.ArrayList;

public class BDconection {
    private Connection connection;

    public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/hamburgers";
        String user = "root";
        String password = "alumnoalumno";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("The connection to the database has been established.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void desconectar() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
