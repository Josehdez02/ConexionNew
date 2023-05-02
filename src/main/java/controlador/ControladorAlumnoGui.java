package controlador;

import dao.DAOAlumno;
import modelo.ModeloAlumno;
import modelo.ModeloCatedratico;
import modelo.ModeloEspecialidad;
import vista.VistaAlumnoGui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ControladorAlumnoGui implements ActionListener {

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
        DAOAlumno dao = new DAOAlumno();
        String cadena = vistaAlumno.jtxNumControl.getText();
        int noControl = 0;
        boolean err = true;
        String nombre = vistaAlumno.jtxNombre.getText();

        if (nombre.length() > 0) {

        } else if (nombre.length() == 0 & cadena.length() > 0 & DAOAlumno.lista.size() > 0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err = false;
        }
        if (cadena.length() == 0 & nombre.length() == 0 & vistaAlumno.btnGuardar == evento.getSource()) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err = false;
        } else if (cadena.length() > 0 & nombre.length() > 0) {
            try {
                noControl = Integer.parseInt(vistaAlumno.jtxNumControl.getText());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,
                        "Se ingreso una letra en el noControl",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE);
                err = false;
            }
        }
        if (err == true) {

                if (this.vistaAlumno.btnNuevo == evento.getSource()) {
                    clear();
                } else if (vistaAlumno.btnGuardar == evento.getSource()) {
                    modeloAlumno.setNumControl(Integer.parseInt(vistaAlumno.jtxNumControl.getText()));
                    modeloAlumno.setNombre(vistaAlumno.jtxNombre.getText());
                    modeloAlumno.setModeloEspecialidad((ModeloEspecialidad) vistaAlumno.cbxEspecialidad.getSelectedItem());
                    if (dao.agregar(modeloAlumno)) {
                        JOptionPane.showMessageDialog(null,
                                "Registro Guardado!",
                                "Aviso",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Ups! Fallo al intentar agregar Alumno.\n"
                                        + "Intente nuevamente",
                                "Aviso",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                clear();

            } else if (vistaAlumno.btnSalir == evento.getSource()) {
                Salir();
            } else if (vistaAlumno.btnEliminar == evento.getSource()) {
                dao.eliminar(Integer.parseInt(vistaAlumno.jtxNumControl.getText()));
            } else if (vistaAlumno.btnActualizar == evento.getSource()) {
                ModeloAlumno nuevo = new ModeloAlumno();
                nuevo.setNombre(vistaAlumno.jtxNombre.getText());
                dao.actualizar(Integer.valueOf(vistaAlumno.jtxNumControl.getText()), nuevo);
            }
        }

        public void clear () {
            this.vistaAlumno.jtxNumControl.setText("");

            this.vistaAlumno.jtxNombre.setText("");
        }
        public void Salir () {
            System.exit(0);
        }
    }
