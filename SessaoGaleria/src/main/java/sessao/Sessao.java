
package sessao;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Fernando Vasques
 */
@SessionScoped
public class Sessao implements Serializable {
   private String login;
    private String senha;

    public Sessao() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    } 
}
