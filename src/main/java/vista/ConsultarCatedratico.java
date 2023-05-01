package vista;

import javax.swing.*;

public class ConsultarCatedratico extends JFrame{
    private JPanel panelPrincipal;
    public JTable tableCatedratico;

    public ConsultarCatedratico(){
        super("Catedratico");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setVisible(true);
    }
}

