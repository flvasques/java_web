
package persistenia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Time;

/**
 * @author Fernando Vasques
 */
public class TimeDao implements IDAO<Time>{

    @Override
    public Time carregar(int id) {
        String sql = "SELECT * FROM times WHERE id = ?;";
        Time entidade = new Time();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement;
            sqlPreparedStatement = connection.prepareStatement(sql);
            sqlPreparedStatement.setInt(1, id);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            if (rs.next()) {
                entidade.setId(rs.getInt("id"));
                entidade.setNome(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            Log.salvaLog(TimeDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidade;
    }

    @Override
    public void inserir(Time entidade) {
       String sql = "INSERT INTO times (nome) VALUES (?);";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Log.salvaLog(TimeDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM times WHERE id = ?;";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Time entidade) {
        String sql = "UPDATE times SET nome = ? WHERE id = ?;";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setInt(2, entidade.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Log.salvaLog(TimeDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Time> listar() {
        String sql = "SELECT * FROM times;";
        ArrayList<Time> lista = new ArrayList<>();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement;
            sqlPreparedStatement = connection.prepareStatement(sql);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            while (rs.next()) {
                Time item = new Time();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                lista.add(item);

            }
        } catch (SQLException ex) {
            Log.salvaLog(TimeDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    
}
