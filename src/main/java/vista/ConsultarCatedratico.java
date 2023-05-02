package vista;
import conexion.Conexion;
import modelo.ModeloCatedratico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarCatedratico extends JFrame{
    private JPanel panelPrincipal;
    public JTable tableCatedratico;

    public ConsultarCatedratico(){
        super("Catedratico");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setVisible(true);
    }
}

