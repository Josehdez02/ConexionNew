package vista;

import conexion.Conexion;
import modelo.ModeloAlumno;
import modelo.ModeloCatedratico;
import modelo.ModeloGrupo;
import modelo.ModeloMateria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarGrupo extends JFrame {
    private JPanel panelPrincipal;
    public JTable tableGrupo;

    public ConsultarGrupo() {
        super("Grupo");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setVisible(true);
    }
        Conexion conexion=new Conexion();
    public List<ModeloGrupo> consultar() {
        List<ModeloGrupo> lista = new ArrayList<>();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Clave");
        modelo.addColumn("Hora");
        modelo.addColumn("Salon");
        modelo.addColumn("Catedratico");
        modelo.addColumn("Alumno");
        modelo.addColumn("Materia");
        if (conexion.abrir()) {
            String sql = "select grupo.clave, grupo.hora, grupo.salon," +
                    "catedratico.nombre as catedratico, " +
                    "alumno.nombre as alumno, " +
                    "materia.nombre as materia " +
                    "from grupo, catedratico, alumno, materia " +
                    "where grupo.catedratico = catedratico.rfc " +
                    "and grupo.alumno = alumno.nomControl " +
                    "and grupo.materia = materia.id;";
            Connection enlace = conexion.obtener();
            try {
                Statement stnt = enlace.createStatement();
                ResultSet resultados = stnt.executeQuery(sql);
                while (resultados.next()) {
                    ModeloGrupo grupo = new ModeloGrupo();
                    grupo.setClave(resultados.getInt("Clave"));
                    grupo.setHora(resultados.getString("Hora"));
                    grupo.setSalon(resultados.getInt("Salon"));
                    grupo.setModeloCatedratico(new ModeloCatedratico(
                            resultados.getString("rfc"),
                            resultados.getString("catedratico")));
                    grupo.setModeloAlumno(new ModeloAlumno());
                    grupo.setModeloMateria(new ModeloMateria());
                    lista.add(grupo);
                    Object[] fila = {grupo.getClave(), grupo.getHora(),
                            grupo.getSalon(), grupo.getModeloCatedratico(),
                            grupo.getModeloAlumno(), grupo.getModeloMateria()};
                    modelo.addRow(fila);
                }
                tableGrupo.setModel(modelo);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                conexion.cerrar();
            }
        }
        return lista.stream().toList();
    }
}
