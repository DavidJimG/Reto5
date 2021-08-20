package view;
import controller.Controller;

//Pruebas unicamente
public class App {
    public static void main(String[] args) throws Exception {
        //Pruebas locales
        Controller controller = new Controller("jdbc:mysql://localhost:3306/proyectos"); 
        // Controller controller = new Controller("jdbc:mysql:ProyectosConstruccion.db");
        controller.req1();
        controller.printReq1();
        controller.req2();
        controller.printReq2();
        controller.req3();
        controller.printReq3();
    }
}   
