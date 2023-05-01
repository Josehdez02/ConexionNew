package controlador;
import dao.DAOGrupo;
import modelo.ModeloGrupo;
import vista.VistaGrupoGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGrupoGui implements ActionListener {

    private final ModeloGrupo modelo;
    private final VistaGrupoGui vista;
    public ControladorGrupoGui(ModeloGrupo modelo, VistaGrupoGui vista) {
        this.modelo =modelo;
        this.vista= vista;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        DAOGrupo dao = new DAOGrupo();
        if (this.vista.btnNuevo == evento.getSource()) {
            clear();
        } else if (vista.btnGuardar == evento.getSource()) {
            modelo.setClave(Integer.parseInt(vista.jtxtClave.getText()));
            modelo.setHora(vista.jtxtHora.getText());
            modelo.setSalon(Integer.parseInt(vista.jtxtSalon.getText()));

            if (dao.agregar(modelo)) {
                JOptionPane.showMessageDialog(null,
                        "Registro Guardado!",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null,
                        "Ups! Falló al intentar agragar Grupo.\n"
                                + "Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            clear();
        }else if (vista.btnSalir==evento.getSource()){
            Salir();

        } else if (vista.btnEliminar==evento.getSource()) {
            dao.eliminar(Integer.parseInt(vista.jtxtClave.getText()));

        }else if (vista.btnActualizar==evento.getSource()){
            ModeloGrupo nuevo = new ModeloGrupo();
            nuevo.setHora(vista.jtxtHora.getText());
            dao.actualizar(Integer.parseInt(vista.jtxtClave.getText()), nuevo, Integer.valueOf(vista.jtxtSalon.getText()));
        }

    }

    public void clear(){
        this.vista.jtxtClave.setText("");
        this.vista.jtxtHora.setText("");
        this.vista.jtxtSalon.setText("");
    }

    public void Salir(){System.exit(0);}

}
