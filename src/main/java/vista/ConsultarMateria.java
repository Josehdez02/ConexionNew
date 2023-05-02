package vista;

import conexion.Conexion;
import modelo.ModeloMateria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarMateria extends  JFrame{
    private JPanel panelPrincipal;
    public JTable tableMateria;

    public ConsultarMateria(){
        super("Materia");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
    }

    public List<ModeloMateria> consultar() {
        Conexion conexion=new Conexion();
        List<ModeloMateria> lista= new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        if (conexion.abrir()){
            String sql = "SELECT * FROM materia";
            Connection enlace= conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados= stnt.executeQuery(sql);
                while (resultados.next()){
                    ModeloMateria materia=new ModeloMateria();
                    materia.setId(resultados.getInt("id"));
                    materia.setNombre(resultados.getString("nombre"));
                    lista.add(materia);
                    Object[] fila = {materia.getId(), materia.getNombre()};
                    modelo.addRow(fila);
                }
                //ConsultarMateria c1 = new ConsultarMateria();
                tableMateria.setModel(modelo);
            }catch (SQLException e){
                //throw new RuntimeException(e);
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar mostrar tabla Materia.\n"
                                +"Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE);
            }finally {
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }
    public void mostrarVentana() {
        consultar();
        setVisible(true);
    }
}
//po
