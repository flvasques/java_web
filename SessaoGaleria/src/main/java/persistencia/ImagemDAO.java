
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Imagem;

/**
 *
 * @author Fernando Vasques
 */
public class ImagemDAO implements IDAO<Imagem> {

    public ArrayList<Imagem> listarTodas(){
        String sql = "SELECT * FROM imagem;";
        ArrayList<Imagem> lista = new ArrayList<>();
        try {
            Connection connection = new Conexao().getConexao();
            PreparedStatement sqlPreparedStatement = null;
            sqlPreparedStatement = connection.prepareStatement(sql);
            ResultSet rs = sqlPreparedStatement.executeQuery();
            while (rs.next()) {
                Imagem item = new Imagem();
                item.setId(rs.getInt("id"));
                item.setUrl(rs.getString("url"));
                item.setLegenda(rs.getString("leganda"));
                item.setUploader(rs.getInt("uploader"));
            }
        } catch (SQLException ex) {
            Log.salvaLog(ImagemDAO.class.getName() + ": " + ex.toString());
            System.out.println("Falha ao listar");
        }
        return lista;
    }
    
    @Override
    public Imagem carregar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserir(Imagem entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Imagem entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Imagem> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
