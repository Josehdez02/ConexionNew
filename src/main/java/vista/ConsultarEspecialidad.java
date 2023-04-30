package vista;

import javax.swing.*;

public class ConsultarEspecialidad extends JFrame{
    private JPanel panelPrincipal;
    public JTable tableEspecialidad;
    public ConsultarEspecialidad(){
        super("Especialidad");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setVisible(true);
    }
}
//fgfd