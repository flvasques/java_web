
package persistenia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
   public Connection getConexao(){
        String host = "localhost";
        String port = "5432";
        String dbname = "times";
        String user = "postgres";
        String password = "a";//"postgres";
        String url = "jdbc:postgresql://"+host+":"+port+"/"+dbname;
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Falha na conexão");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
