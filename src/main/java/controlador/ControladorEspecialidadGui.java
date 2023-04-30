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
        DAOEspecialidad dao=new DAOEspecialidad();
        if (this.vista.btnNuevo==evento.getSource()){
            clear();
        }
        else if (vista.btnGuardar==evento.getSource()) {
            modelo.setId(Integer.parseInt(vista.jtxId.getText()));
            modelo.setNombre(vista.jtxNombre.getText());
            // DAOEspecialidad dao=new DAOEspecialidad();
            if (dao.agregar(modelo)){
                JOptionPane.showMessageDialog(null,
                        "Registro Guardado!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else {
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar agregar Especialidad.\n"
                                +"Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            clear();
        } else if (vista.btnSalir==evento.getSource()) {
            Salir();
        } else if (vista.btnEliminar==evento.getSource()) {
            dao.eliminar(Integer.parseInt(vista.jtxId.getText()));

        } else if (vista.btnActualizar==evento.getSource()) {
            ModeloEspecialidad nuevo=new ModeloEspecialidad();
            nuevo.setNombre(vista.jtxNombre.getText());
            dao.actualizar(Integer.parseInt(vista.jtxId.getText()),nuevo);
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