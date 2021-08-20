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
    
    public Controller(String url) {
        super();
        req1s = new ArrayList<>();
        req2s = new ArrayList<>();
        req3s = new ArrayList<>();
        conectorDB = new Conector(url);
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
    
    public void printReq1() {
        for (Req1 req1 : req1s) {
            System.out.println(req1);
        }
    }

    public void printReq2() {
        for (Req2 req2 : req2s) {
            System.out.println(req2);
        } 
    }

    public void printReq3() {
        for (Req3 req3 : req3s) {
            System.out.println(req3);
        }
    }

    public ArrayList<Req1> getReq1s() {
        return req1s;
    }
    
    public ArrayList<Req2> getReq2s() {
        return req2s;
    }

    public ArrayList<Req3> getReq3s() {
        return req3s;
    }
}
