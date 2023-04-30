package conexion;

import java.sql.Connection;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String bd = "TOPICOS_BD";
    private static final String usuario = "root";
    private static final String password = "Mamita-2002";
    private static final String host = "localhost";
    private static final String puerto = "3306";
    private final String url;
    private Connection conexion;

    public Conexion(){
        url="jdbc:mysql://"+host+":"+puerto+"/"+bd;
    }
    public boolean abrir(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
            return true;
        }catch (ClassNotFoundException | SQLException e){
            return false;
        }
    }
    public Connection obtener(){
        return conexion;
    }
    public boolean cerrar() {
        try {
            conexion.close();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }
}
//dd