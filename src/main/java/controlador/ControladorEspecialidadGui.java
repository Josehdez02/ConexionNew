package controlador;

import dao.DAOEspecialidad;
import modelo.ModeloEspecialidad;
import vista.VistaEspecialidadGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEspecialidadGui implements ActionListener {
    private final ModeloEspecialidad modelo;
    private final VistaEspecialidadGui vista;

    public ControladorEspecialidadGui(ModeloEspecialidad modelo, VistaEspecialidadGui vista){
        this.modelo=modelo;
        this.vista=vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        //this.vista.btnConsultar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        DAOEspecialidad dao = new DAOEspecialidad();
        String cadena = vista.jtxId.getText();
        String nomb = vista.jtxNombre.getText();
        int id = 0;
        boolean err = true;

        if (nomb.length() > 0 & cadena.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err = false;
        } else if (nomb.length() == 0 & cadena.length() > 0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err = false;
        }
        if (cadena.length() == 0 & nomb.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err = false;

        } else if (cadena.length() > 0 & nomb.length() > 0) {
            try {
                id = Integer.parseInt(vista.jtxId.getText());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,
                        "Se ingreso una letra en el ID",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE);
                err = false;
            }
        }

            if (this.vista.btnNuevo == evento.getSource()) {
                clear();
            }
        if (err == true) {
            if (vista.btnGuardar == evento.getSource()) {
                modelo.setId(Integer.parseInt(cadena));
                modelo.setNombre(nomb);
                // DAOEspecialidad dao=new DAOEspecialidad();
                if (dao.agregar(modelo)) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Guardado!",
                            "Aviso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Ups! Fallo al intentar agregar Especialidad.\n"
                                    + "Intente nuevamente",
                            "Aviso",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
                clear();
            } else if (vista.btnSalir == evento.getSource()) {
                Salir();
            } else if (vista.btnEliminar == evento.getSource()) {
                dao.eliminar(Integer.parseInt(vista.jtxId.getText()));

            } else if (vista.btnActualizar == evento.getSource()) {
                ModeloEspecialidad nuevo = new ModeloEspecialidad();
                nuevo.setNombre(vista.jtxNombre.getText());
                dao.actualizar(Integer.parseInt(vista.jtxId.getText()), nuevo);
            }
    }
    public void clear(){
        this.vista.jtxId.setText("");
        this.vista.jtxNombre.setText("");
    }
    public void Salir(){
        System.exit(0);
    }
}
//fff