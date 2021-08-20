package view.jpanels;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Controller;

public class Interfaz extends JFrame{
    
    private PanelRequerimientos opcionesRequerimientos;

    private Controller control;

    public Interfaz() {

        super();
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Reto 5");

        this.opcionesRequerimientos = new PanelRequerimientos(this);

        add(opcionesRequerimientos, BorderLayout.SOUTH);

    }

    public void displayRequerimiento1(){
        
    }

}
