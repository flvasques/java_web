
package persistenia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jogador;

/**
 * @author Fernando Vasques
 */
public class JogadorDao implements IDAO<Jogador> {

    @Override
    public Jogador carregar(int id) {
        String sql = "SELECT * FROM jogador WHERE id = ?;";
        Jogador entidade = new Jogador();
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
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidade;
    }

    @Override
    public void inserir(Jogador entidade) {
        
        String sql = "INSERT INTO jogador (nome, id_time) VALUES (?, ?);";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setInt(2, entidade.getMeutime().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(int id) {
      String sql = "DELETE FROM jogador WHERE id = ?;";
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
    public void atualizar(Jogador entidade) {
        String sql = "UPDATE jogador SET nome = ?, id_time  ? WHERE id = ?;";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setInt(2, entidade.getMeutime().getId());
            preparedStatement.setInt(3, entidade.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Jogador> listar() {
        String sql = "SELECT * FROM jogador WHERE id = ?;";
        ArrayList<Jogador> lista = new ArrayList<>();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement;
            sqlPreparedStatement = connection.prepareStatement(sql);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            while (rs.next()) {
                Jogador item = new Jogador();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                lista.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public ArrayList<Jogador> listar(int id) {
        String sql = "SELECT * FROM jogador;";
        ArrayList<Jogador> lista = new ArrayList<>();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement;
            sqlPreparedStatement = connection.prepareStatement(sql);
            sqlPreparedStatement.setInt(1, id);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            while (rs.next()) {
                Jogador item = new Jogador();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                lista.add(item);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
