package view.jpanels;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelDatos extends JPanel {
    
    //private Interfaz interfaz;

    private JList<String> listaRequerimientos;

    //public PanelDatos(Interfaz interfaz) {
    public PanelDatos() {
        super();
        //this.interfaz = interfaz;
        
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Requerimiento"));
        listaRequerimientos = new JList<>();

        add(listaRequerimientos);
    }

    public JList<String> getListaRequerimientos() {
        return listaRequerimientos;
    }

    public void actualizarLista(String[] requerimientos){
        listaRequerimientos.setListData(requerimientos);
    }
    
}
