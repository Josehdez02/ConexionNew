package vista;

import dao.DAOAlumno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
