/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;
import modelo.Usuario;

/**
 *
 * @author Fernando Vasques
 */
@Controller
public class LoginController {
    private final Result result;
    
    protected LoginController(){
        this(null);
    }
    @Inject
    public LoginController(Result result){
        this.result = result;
    }
    
   @Path("/login/casdastro")
   public void cadastro(){ }
   
   @Post
   @Path("/login/casdastrar")
   public void casdastrar(Usuario usr){
    usr.salvar();
    result.redirectTo(IndexController.class).index();
   }
}
