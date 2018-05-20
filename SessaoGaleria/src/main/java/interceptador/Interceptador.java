
package interceptador;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import javax.inject.Inject;
import sessao.Sessao;

/**
 *
 * @author Fernando Vasques
 */
@Intercepts
public class Interceptador {
    @Inject 
    private Sessao sessao;
    
    @Inject
    private Result result;
    
    
    @Accepts
    public boolean accepts(ControllerMethod m){
        //return ! m.getController().getType().equals(IndexController.class);
      return false;  
    }
    
    @BeforeCall
    public void before(){
        if (!(this.sessao.getLogin().equals("login") && this.sessao.getSenha().equals("senha"))){
            //this.result.redirectTo(IndexController.class).index();
        }
    } 
}
