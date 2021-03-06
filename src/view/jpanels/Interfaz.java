package view.jpanels;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.Controller;

public class Interfaz extends JFrame{
    
    private PanelRequerimientos opcionesRequerimientos;
    private PanelDatos datos;

    private Controller control;

    public Interfaz() {
        super();

        this.control = new Controller();

        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Reto 5");

        this.opcionesRequerimientos = new PanelRequerimientos(this);
        add(opcionesRequerimientos, BorderLayout.SOUTH);

        this.datos = new PanelDatos();
        add(datos, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(datos.getListaRequerimientos());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        add(scroll);
    }

    public Controller getControl() {
        return control;
    }

    public void mostrarRequerimiento1(){
        datos.actualizarLista(control.getReq1s());
    }

    public void mostrarRequerimiento2(){
        datos.actualizarLista(control.getReq2s());
    }

    public void mostrarRequerimiento3(){
        datos.actualizarLista(control.getReq3s());
    }

}
