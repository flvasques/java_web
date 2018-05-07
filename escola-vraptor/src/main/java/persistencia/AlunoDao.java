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
import modelo.Aluno;

/**
 *
 * @author Fernando Vasques
 */
public class AlunoDao implements IDAO<Aluno> {

    @Override
    public Aluno carregar(int id) {
        String sql = "SELECT * FROM aluno WHERE matricula = ?;";
        Aluno entidade = new Aluno();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement;
            sqlPreparedStatement = connection.prepareStatement(sql);
            sqlPreparedStatement.setInt(1, id);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            if (rs.next()) {
                entidade.setMatricula(rs.getInt("id"));
                entidade.setNome(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            Log.salvaLog(AlunoDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidade;
    }

    @Override
    public int inserir(Aluno entidade) {
        String sql = "INSERT INTO aluno (nome) VALUES (?);";
        int id = 0;
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getNome());
            id = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Log.salvaLog(AlunoDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE matricula = ?;";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Log.salvaLog(AlunoDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Aluno entidade) {
        String sql = "UPDATE aluno SET nome = ? WHERE matricula = ?;";
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setInt(2, entidade.getMatricula());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Log.salvaLog(AlunoDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Aluno> listar() {
        String sql = "SELECT * FROM aluno;";
        ArrayList<Aluno> lista = new ArrayList<>();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement = null;
            sqlPreparedStatement = connection.prepareStatement(sql);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            while (rs.next()) {
                Aluno item = new Aluno();
                item.setMatricula(rs.getInt("matricula"));
                item.setNome(rs.getString("nome"));
                lista.add(item);

            }
        } catch (SQLException ex) {
            Log.salvaLog(AlunoDao.class.getName() + ": " + ex.toString());
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
