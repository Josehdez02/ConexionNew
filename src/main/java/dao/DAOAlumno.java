package dao;

import conexion.Conexion;
import modelo.ModeloAlumno;
import vista.ConsultarAlumno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAlumno implements  DAOGeneral<Integer, ModeloAlumno> {
    private Conexion conexion;
   // public final static List<ModeloAlumno> lista= new ArrayList<>();
    public DAOAlumno(){
        conexion=new Conexion();
    }

    @Override
    public boolean agregar(ModeloAlumno element) {
        if (conexion.abrir()) {
            String sql = "INSERT INTO Alumno(NumControl, nombre) VALUES(?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, element.getNumControl());
                pstm.setString(2, element.getNombre());
                pstm.execute();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR");
                return false;
            } finally {
                conexion.cerrar();
            }
        }
        return false;
    }
    @Override
    public List<ModeloAlumno> consultar() {
         List<ModeloAlumno> lista= new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NumControl");
        modelo.addColumn("Nombre");
        modelo.addColumn("Especialidad");
        if (conexion.abrir()){
            String sql = "SELECT * FROM Alumno";
            Connection enlace= conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados= stnt.executeQuery(sql);
                while (resultados.next()){
                    ModeloAlumno Alumno=new ModeloAlumno();
                    Alumno.setNumControl(resultados.getInt("NumControl"));
                    Alumno.setNombre(resultados.getString("nombre"));
                    lista.add(Alumno);
                    Object[] fila = {Alumno.getNumControl(), Alumno.getNombre()};
                    modelo.addRow(fila);
                }
                ConsultarAlumno ca=new ConsultarAlumno();
                ca.tableAlumno.setModel(modelo);
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }

    @Override
    public boolean actualizar(Integer id, ModeloAlumno nuevo) {
        if (conexion.abrir()){
            String sql="UPDATE especialidad SET nombre=? WHERE NumContro=?";
            Connection enlace= conexion.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1,nuevo.getNombre());
                stmt.setInt(2,id);
                stmt.executeUpdate();
                return true;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                conexion.cerrar();
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer NumControl) {
        if (conexion.abrir()){
            String sql="DELETE FROM alumno WHERE numControl=?";
            Connection con= conexion.obtener();
            try {
                PreparedStatement statement= con.prepareStatement(sql);
                statement.setInt(1,NumControl);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Se elimino el Alumno con exito");
                return true;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }finally {
                conexion.cerrar();
            }
        }
        return false;
    }
}
