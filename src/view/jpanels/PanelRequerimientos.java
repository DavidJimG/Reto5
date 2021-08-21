package view.jpanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelRequerimientos extends JPanel implements ActionListener{
    
    
    public final static String BTN_REQ1 = "Requerimiento 1";
    public final static String BTN_REQ2 = "Requerimiento 2";
    public final static String BTN_REQ3 = "Requerimiento 3";


    private JButton btnReg1;
    private JButton btnReg2;
    private JButton btnReg3;

    private Interfaz interfaz;


    public PanelRequerimientos(Interfaz interfaz) {
        super();
        this.interfaz = interfaz;

        setLayout(new GridLayout(1,3));
        setBorder(new TitledBorder("Casos"));

        btnReg1 = new JButton(BTN_REQ1);
        btnReg2 = new JButton(BTN_REQ2);
        btnReg3 = new JButton(BTN_REQ3);

        btnReg1.setActionCommand(BTN_REQ1);
        btnReg2.setActionCommand(BTN_REQ2);
        btnReg3.setActionCommand(BTN_REQ3);

        btnReg1.addActionListener(this);
        btnReg2.addActionListener(this);
        btnReg3.addActionListener(this);

        add(btnReg1);
        add(btnReg2);
        add(btnReg3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(BTN_REQ1)){
            interfaz.mostrarRequerimiento1();
        }
        else if (e.getActionCommand().equals(BTN_REQ2)){
            interfaz.mostrarRequerimiento2();
        }
        else if (e.getActionCommand().equals(BTN_REQ3)){
            interfaz.mostrarRequerimiento3();
        }
    }



}
