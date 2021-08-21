package controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Req1;
import model.Req2;
import model.Req3;
import services.Conector;

public class Controller {

    private ArrayList<Req1> req1s;
    private ArrayList<Req2> req2s;
    private ArrayList<Req3> req3s;
    private Conector conectorDB;
    
    public Controller() {
        super();
        req1s = new ArrayList<>();
        req2s = new ArrayList<>();
        req3s = new ArrayList<>();
        conectorDB = new Conector();
        req1();
        req2();
        req3();
    }

    public void req1() {
        ResultSet rs = conectorDB.getReq1DB();
        try {
            while (rs.next()) {
                Req1 tmp = new Req1(rs.getInt("total"), rs.getInt("ID_Proyecto"), 
                                    rs.getString("Pagado"), rs.getString("Proveedor"));
                req1s.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void req2() {
        ResultSet rs = conectorDB.getReq2DB();
        try {
            while (rs.next()) {
                Req2 tmp = new Req2(rs.getInt("Estrato"), rs.getString("inicio"), 
                                    rs.getInt("Financiable"), rs.getDouble("porcentaje"));
                req2s.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void req3() {
        ResultSet rs = conectorDB.getReq3DB();
        try {
            while (rs.next()) {
                Req3 tmp = new Req3(rs.getInt("ID_Proyecto"), 
                                    rs.getString("Pagado"), rs.getString("Clasificacion"));
                req3s.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getReq1s() {
        return convertirListaArray(req1s);
    }
    
    public String[] getReq2s() {
        return convertirListaArray(req2s);
    }

    public String[] getReq3s() {
        return convertirListaArray(req3s);
    }

    private String[] convertirListaArray(ArrayList requerimientos){
        String[] array = new String[requerimientos.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = requerimientos.get(i).toString();
        }
        return array;
    }
}
