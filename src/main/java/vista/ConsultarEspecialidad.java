package vista;

import conexion.Conexion;
import modelo.ModeloEspecialidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarEspecialidad extends JFrame{
    private JPanel panelPrincipal;
    public JTable tableEspecialidad;
    public ConsultarEspecialidad(){
        super("Especialidad");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
    }

    Conexion conexion=new Conexion();
    public List<ModeloEspecialidad> consultar() {
        List<ModeloEspecialidad> lista= new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        if (conexion.abrir()){
            String sql = "SELECT * FROM especialidad";
            Connection enlace= conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados= stnt.executeQuery(sql);
                while (resultados.next()){
                    ModeloEspecialidad especialidad=new ModeloEspecialidad();
                    especialidad.setId(resultados.getInt("id"));
                    especialidad.setNombre(resultados.getString("nombre"));
                    lista.add(especialidad);
                    Object[] fila = {especialidad.getId(), especialidad.getNombre()};
                    modelo.addRow(fila);
                }
               // ConsultarEspecialidad c1 = new ConsultarEspecialidad();
                tableEspecialidad.setModel(modelo);

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
    public void mostrarVentana() {
        consultar();
        setVisible(true);
    }
}

