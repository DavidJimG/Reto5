package model;
//import java.sql.Date;

public class Req2 {

    private int estrato;
    private String fechaInicio;
    private int financiable;
    private double porcentaje;  
    
    public Req2(int estrato, String date, int financiable, double porcentaje) {
        this.estrato = estrato;
        this.fechaInicio = date;
        this.financiable = financiable;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Req2 [estrato=" + estrato + ", fechaInicio=" + fechaInicio + ", financiable=" + financiable
                + ", porcetaje=" + porcentaje + "]";
    }

}