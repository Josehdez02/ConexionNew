package controlador;

import dao.DAOEspecialidad;
import dao.DAOMateria;
import modelo.ModeloEspecialidad;
import modelo.ModeloMateria;
import vista.VistaMateriaGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMateriaGui implements ActionListener {
    private final ModeloMateria modelo;
    private final VistaMateriaGui vista;

    public ControladorMateriaGui(ModeloMateria modelo, VistaMateriaGui vista) {
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
        DAOMateria dao=new DAOMateria();
        if (this.vista.btnNuevo==evento.getSource()){
            clear();
        }
        else if (vista.btnGuardar==evento.getSource()) {
            modelo.setId(Integer.parseInt(vista.txtID.getText()));
            modelo.setNombre(vista.txtNombre.getText());
            // DAOMateria dao=new DAOMateria();
            if (dao.agregar(modelo)){
                JOptionPane.showMessageDialog(null,
                        "Registro Guardado!",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }else {
                JOptionPane.showMessageDialog(null,
                        "Ups! Fallo al intentar agregar Materia.\n"
                                +"Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            clear();
        } else if (vista.btnSalir==evento.getSource()) {
            Salir();
        } else if (vista.btnEliminar==evento.getSource()) {
            dao.eliminar(Integer.parseInt(vista.txtID.getText()));

        } else if (vista.btnConsultar==evento.getSource()) {
            ModeloMateria nuevo=new ModeloMateria();
            nuevo.setNombre(vista.txtNombre.getText());
            dao.actualizar(Integer.parseInt(vista.txtID.getText()),nuevo);
        }
    }

    public void clear(){
        this.vista.txtID.setText("");
        this.vista.txtNombre.setText("");
    }
    public void Salir(){
        System.exit(0);
    }
}
//modificaciones