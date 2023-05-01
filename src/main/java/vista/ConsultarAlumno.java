package vista;

import conexion.Conexion;
import dao.DAOAlumno;
import modelo.ModeloEspecialidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarAlumno extends JFrame{
    private JPanel panel1;
    public JTable tableAlumno;


    public ConsultarAlumno(){
        super("Alumno");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);

    }

}
//A
