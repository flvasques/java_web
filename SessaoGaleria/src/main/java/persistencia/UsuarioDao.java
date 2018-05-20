/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author Fernando Vasques
 */
public class UsuarioDao implements IDAO<Usuario>{

    @Override
    public Usuario carregar(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?;";
        Usuario entidade = new Usuario();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement;
            sqlPreparedStatement = connection.prepareStatement(sql);
            sqlPreparedStatement.setInt(1, id);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            if (rs.next()) {
                entidade.setId(rs.getInt("id"));
                entidade.setLogin(rs.getString("login"));
                entidade.setSenha(rs.getString("senha"));
            }

        } catch (SQLException ex) {
            Log.salvaLog(UsuarioDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidade;
    }

    @Override
    public int inserir(Usuario entidade) {
         String sql = "INSERT INTO usuario (login,senha) VALUES (?,?);";
        int id = 0;
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getLogin());
            preparedStatement.setString(2, entidade.getSenha());
            id = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Log.salvaLog(UsuarioDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Usuario entidade) {
        String sql = "UPDATE usuario SET senha = ? WHERE id = ?;";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getSenha());
            preparedStatement.setInt(2, entidade.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Log.salvaLog(UsuarioDao.class.getName() + ": " + ex.toString());
            System.out.println("Falha no update");
        }
    }

    @Override
    public ArrayList<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
