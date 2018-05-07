
package persistencia;

import java.util.ArrayList;
/**
 * @author Fernando Vasques
 */
public interface IDAO<T> {
    
    public T carregar(int id);
    public int inserir(T entidade);
    public void excluir(int id);
    public void atualizar(T entidade);
    public ArrayList<T> listar();
    
}