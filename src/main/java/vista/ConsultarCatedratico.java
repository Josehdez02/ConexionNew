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
    Conexion conexion=new Conexion();
    public List<ModeloCatedratico> consultar() {
        List<ModeloCatedratico> lista= new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("RFC");
        modelo.addColumn("Nombre");
        if (conexion.abrir()){
            String sql = "SELECT * FROM catedratico";
            Connection enlace= conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados= stnt.executeQuery(sql);
                while (resultados.next()){
                    ModeloCatedratico catedratico=new ModeloCatedratico();
                    catedratico.setRfc(resultados.getString("rfc"));
                    catedratico.setNombre(resultados.getString("nombre"));
                    lista.add(catedratico);
                    Object[] fila = {catedratico.getRfc(), catedratico.getNombre()};
                    modelo.addRow(fila);
                }
                // ConsultarEspecialidad c1 = new ConsultarEspecialidad();
                tableCatedratico.setModel(modelo);

            }catch (SQLException e){
                //throw new RuntimeException(e);
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar mostrar tabla Especialidad.\n"
                                +"Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE);
            }finally {
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }
}

