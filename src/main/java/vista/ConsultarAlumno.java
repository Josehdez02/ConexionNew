package vista;

import conexion.Conexion;
import dao.DAOAlumno;
import modelo.ModeloAlumno;
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
    }
    public List<ModeloAlumno> consultar() {
        Conexion conexion=new Conexion();
        List<ModeloAlumno> lista= new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NumControl");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especialidad");
        if (conexion.abrir()){
            String sql = "select alumno.nomControl," +
                    "alumno.nombre,especialidad.id as id," +
                    "especialidad.nombre as especialidad " +
                    "from alumno, especialidad " +
                    "where alumno.especialidad = especialidad.id;";
            Connection enlace= conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados= stnt.executeQuery(sql);
                while (resultados.next()){
                    ModeloAlumno Alumno=new ModeloAlumno();
                    Alumno.setNumControl(resultados.getInt("nomControl"));
                    Alumno.setNombre(resultados.getString("nombre"));
                    Alumno.setModeloEspecialidad(new ModeloEspecialidad(
                            resultados.getInt("id"),
                            resultados.getString("especialidad")
                    ));
                    lista.add(Alumno);
                    Object[] fila = {Alumno.getNumControl(), Alumno.getNombre(), Alumno.getModeloEspecialidad()};
                    modelo.addRow(fila);
                }
                tableAlumno.setModel(modelo);
            }catch (SQLException e){
                throw new RuntimeException(e);
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
//A
