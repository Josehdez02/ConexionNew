package dao;

import conexion.Conexion;
import modelo.ModeloGrupo;
import vista.ConsultarGrupo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOGrupo  {

    private Conexion conexion;

    //public final static List<ModeloGrupo> lista= new ArrayList<>();
    public DAOGrupo() {
        conexion = new Conexion();
    }


    public boolean agregar(ModeloGrupo element) {
        if (conexion.abrir()) {
            String sql = "INSERT INTO grupo(clave, hora, salon) VALUES(?,?,?)";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement pstm = enlace.prepareStatement(sql);
                pstm.setInt(1, element.getClave());
                pstm.setString(2, element.getHora());
                pstm.setInt(3, element.getSalon());
                pstm.execute();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR");
                return false;
            } finally {
                conexion.cerrar();
            }
        }
        return false;
    }

    public List<ModeloGrupo> consultar() {
        List<ModeloGrupo> lista = new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Clave");
        modelo.addColumn("Hora");
        modelo.addColumn("Salon");
        if (conexion.abrir()) {
            String sql = "SELECT * FROM grupo";
            Connection enlace = conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while (resultados.next()) {
                    ModeloGrupo grupo = new ModeloGrupo();
                    grupo.setClave(resultados.getInt("Clave"));
                    grupo.setHora(resultados.getString("Hora"));
                    grupo.setSalon(resultados.getInt("Salon"));
                    lista.add(grupo);
                    Object[] fila = {grupo.getClave(), grupo.getHora(), grupo.getSalon()};
                    modelo.addRow(fila);
                }
                ConsultarGrupo c1 = new ConsultarGrupo();
                c1.tableGrupo.setModel(modelo);
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar mostrar tabla Grupo.\n"
                                + "Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE);
            } finally {
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }


    public boolean actualizar(Integer clave, ModeloGrupo nuevo, Integer Salon) {
        if (conexion.abrir()) {
            String sql = "UPDATE grupo SET hora=? WHERE clave=? WHERE Salon=?";
            Connection enlace = conexion.obtener();
            try {
                PreparedStatement stmt = enlace.prepareStatement(sql);
                stmt.setString(1, nuevo.getHora());
                stmt.setInt(2, clave);
                stmt.setInt(3, Salon);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                conexion.cerrar();
            }
        }
        return false;
    }



    public boolean eliminar(Integer clave) {
        if (conexion.abrir()) {
            String sql = "DELETE FROM grupo WHERE clave=?";
            Connection con = conexion.obtener();
            try {
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, clave);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        "Grupo Eliminado!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                conexion.cerrar();
            }
        }
        return false;
    }
}


