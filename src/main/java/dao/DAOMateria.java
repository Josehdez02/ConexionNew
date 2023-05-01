package dao;

import conexion.Conexion;
import dao.DAOGeneral;
import modelo.ModeloEspecialidad;
import modelo.ModeloMateria;
import vista.ConsultarEspecialidad;
import vista.ConsultarMateria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMateria implements DAOGeneral<Integer, ModeloMateria> {
    private Conexion conexion;
    public final static List<ModeloMateria> lista= new ArrayList<>();
    public DAOMateria(){
        conexion=new Conexion();
    }

    @Override
    public boolean agregar(ModeloMateria element) {
        boolean result = false;
        if (conexion.abrir()) {
            String sql = "INSERT INTO materia (id, nombre) VALUES(?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, element.getId());
                pstm.setString(2, element.getNombre());
                pstm.execute();
                result = true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR");
            } finally {
                conexion.cerrar();
            }
        }
        return result;
    }



    @Override
    public List<ModeloMateria> consultar() {
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
                ConsultarMateria c1 = new ConsultarMateria();
                c1.tableMateria.setModel(modelo);
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


    @Override
    public boolean actualizar(Integer id, ModeloMateria nuevo) {
        if (conexion.abrir()){
            String sql="UPDATE materia SET nombre=? WHERE id=?";
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
    public boolean eliminar(Integer id) {
        if (conexion.abrir()){
            String sql="DELETE FROM materia WHERE id=?";
            Connection con= conexion.obtener();
            try {
                PreparedStatement statement= con.prepareStatement(sql);
                statement.setInt(1,id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        "Materia Eliminada!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
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