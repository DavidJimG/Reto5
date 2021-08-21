package view;
import controller.Controller;
import view.jpanels.Interfaz;

//Pruebas unicamente
public class App {
    public static void main(String[] args) throws Exception {
        // Controller ct = new Controller();
        // ct.req3();
        // String[] prueba = ct.getReq3s();
        // for (String string : prueba) {
        //      System.out.println(string);
        // }
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }
}   
