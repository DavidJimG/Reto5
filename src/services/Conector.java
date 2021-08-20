package services;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conector {

    private Connection connect;
    
    public Conector(String url) {
        super();
        connectDB(url);
    }
    
    public ResultSet getReq1DB() {    
        String sql = "SELECT SUM(compra.Cantidad) as total, "
                            + " compra.ID_Proyecto, compra.Pagado, compra.Proveedor"
                    +" FROM compra"
                    +" WHERE compra.Pagado = 'No'"
                    +" GROUP BY compra.ID_Proyecto"
                    +" HAVING SUM(compra.Cantidad) > 50;"; 
        return executeQuery(sql);
    }

    public ResultSet getReq2DB() {        
        String sql = "SELECT proyecto.Fecha_Inicio as inicio ,tipo.Financiable, " + 
                     " tipo.Estrato, Proyecto.Porcentaje_Cuota_Inicial * 100 as porcentaje " +
                     " FROM tipo, proyecto " +
                     " WHERE " +
                        " tipo.ID_Tipo = proyecto.ID_Tipo AND " +
                        " tipo.Estrato >= 5 AND " +
                        " tipo.Financiable = 0 AND " +
                        " proyecto.Porcentaje_Cuota_Inicial >= 0.3 " +
                     " ORDER BY proyecto.Fecha_Inicio ASC;"; 
        return executeQuery(sql);
    }

    public ResultSet getReq3DB() {
        String sql = "SELECT proyecto.ID_Proyecto, compra.Pagado, proyecto.Clasificacion" +
                     " FROM proyecto, compra, materialconstruccion " +
                     " WHERE "+
                     " proyecto.ID_Proyecto = compra.ID_Proyecto AND " +
                     " materialconstruccion.ID_MaterialConstruccion = compra.ID_MaterialConstruccion AND " +
                     " proyecto.Clasificacion IN ('Apartamento', 'Apartaestudio') AND " +
                     " compra.Pagado != 'Si' AND " +
                     " materialconstruccion.Importado = 'Si' AND " +
                     " proyecto.Acabados = 'No' " +
                     " GROUP BY " +
                     " proyecto.ID_Proyecto; ";
        return executeQuery(sql);
    }
        
    public Connection connectDB(String url) {
        try {
            connect = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}