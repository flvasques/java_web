/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import modelo.Aluno;

@Controller
public class AlunoController {
   private final Result result;
   
   protected AlunoController(){
       this(null);
   }
   
   @Inject
    public AlunoController(Result result) {
	this.result = result;
    }
   
   @Get
   @Path("/aluno/editar/{Aluno.matricula}")
   public Aluno editar(int matricula){
       return new Aluno();
   }
   @Post
   @Path("/aluno/salvar")
   public void salvar(Aluno aluno){
       aluno.salvar();
       result.redirectTo(IndexController.class).index();
   }
}
