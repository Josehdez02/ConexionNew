package dao;

import conexion.Conexion;
import modelo.ModeloCatedratico;
import vista.ConsultarCatedratico;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCatedratico implements  DAOGeneral<String, ModeloCatedratico> {
    private Conexion conexion;
    //public final static List<ModeloCatedratico> lista= new ArrayList<>();
    public DAOCatedratico(){
        conexion=new Conexion();
    }

    @Override
    public boolean agregar(ModeloCatedratico element) {
        if (conexion.abrir()) {
            String sql = "INSERT INTO catedratico(rfc, nombre) VALUES(?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setString(1, element.getRFC());
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
                    catedratico.setRFC(resultados.getString("rfc"));
                    catedratico.setNombre(resultados.getString("nombre"));
                    lista.add(catedratico);
                    Object[] fila = {catedratico.getRFC(), catedratico.getNombre()};
                    modelo.addRow(fila);
                }
                ConsultarCatedratico c1 = new ConsultarCatedratico();
                c1.tableCatedratico.setModel(modelo);
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

    @Override
    public boolean actualizar(String rfc, ModeloCatedratico nuevo) {
        if (conexion.abrir()){
            String sql="UPDATE especialidad SET nombre=? WHERE rfc=?";
            Connection enlace= conexion.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1,nuevo.getNombre());
                stmt.setString(2,rfc);
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
    public boolean eliminar(String rfc) {
        if (conexion.abrir()){
            String sql="DELETE FROM catedratico WHERE rfc=?";
            Connection con= conexion.obtener();
            try {
                PreparedStatement statement= con.prepareStatement(sql);
                statement.setString(1,rfc);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        "Catedratico Eliminado!",
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