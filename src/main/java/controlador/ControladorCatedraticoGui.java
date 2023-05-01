package controlador;

import dao.DAOCatedratico;
import modelo.ModeloCatedratico;
import vista.VistaCatedraticoGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCatedraticoGui implements ActionListener {
    private final ModeloCatedratico modelo;
    private final VistaCatedraticoGui vista;

    public ControladorCatedraticoGui(ModeloCatedratico modelo,
                                     VistaCatedraticoGui vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        //this.vista.btnConsultar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        DAOCatedratico dao = new DAOCatedratico();
        if (this.vista.btnNuevo == evento.getSource()) {
            clear();
        } else if (vista.btnGuardar == evento.getSource()) {
            modelo.setRFC(vista.jtxRFC.getText());
            modelo.setNombre(vista.jtxNombre.getText());
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
            clear();
        } else if (vista.btnSalir == evento.getSource()) {
            Salir();
        } else if (vista.btnEliminar == evento.getSource()) {
            dao.eliminar(vista.jtxRFC.getText());
        } else if (vista.btnActualizar==evento.getSource()) {
            ModeloCatedratico nuevo=new ModeloCatedratico();
            nuevo.setNombre(vista.jtxNombre.getText());
            dao.actualizar(vista.jtxRFC.getText(),nuevo);
        }
    }

    public void clear() {
        this.vista.jtxRFC.setText("");
        this.vista.jtxNombre.setText("");
    }

    public void Salir() {
        System.exit(0);
    }
}