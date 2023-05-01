package controlador;

import dao.DAOAlumno;
import dao.DAOEspecialidad;
import modelo.ModeloAlumno;
import modelo.ModeloEspecialidad;
import vista.VistaAlumnoGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControladorAlumnoGui implements ActionListener{

    private final ModeloAlumno modeloAlumno;
    private final VistaAlumnoGui vistaAlumno;

    public ControladorAlumnoGui(ModeloAlumno modeloAlumno, VistaAlumnoGui vistaAlumno) {
        this.modeloAlumno = modeloAlumno;
        this.vistaAlumno = vistaAlumno;

        this.vistaAlumno.btnGuardar.addActionListener(this);
        this.vistaAlumno.btnNuevo.addActionListener(this);
        this.vistaAlumno.btnSalir.addActionListener(this);
        this.vistaAlumno.btnEliminar.addActionListener(this);
        //this.vista.btnConsultar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        DAOAlumno dao=new DAOAlumno();
        if (this.vistaAlumno.btnNuevo==evento.getSource()){
            clear();
        }
        else if (vistaAlumno.btnGuardar==evento.getSource()) {
            modeloAlumno.setNumControl(Integer.parseInt(vistaAlumno.jtxNumControl.getText()));
            modeloAlumno.setNombre(vistaAlumno.jtxNombre.getText());
            //modeloAlumno.getModeloEspecialidad().getNombre();
            // DAOEspecialidad dao=new DAOEspecialidad();
            if (dao.agregar(modeloAlumno)){
                JOptionPane.showMessageDialog(null,
                        "Registro Guardado!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else {
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar agregar Alumno.\n"
                                +"Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            clear();
        } else if (vistaAlumno.btnSalir==evento.getSource()) {
            Salir();
        } else if (vistaAlumno.btnEliminar==evento.getSource()) {
            dao.eliminar(Integer.parseInt(vistaAlumno.jtxNumControl.getText()));

            // }
        } else if (vistaAlumno.btnConsultar==evento.getSource()) {
            dao.consultar();
        }
    }

    public void clear(){
        this.vistaAlumno.jtxNumControl.setText("");

        this.vistaAlumno.jtxNombre.setText("");
    }
    public void Salir(){
        System.exit(0);
    }
}
