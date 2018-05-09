package controlers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

@Controller
public class IndexController {
	@Path("/")
	public List<Aluno> index() { 
            ArrayList<Aluno> retorno = Aluno.listar();
            return retorno;
	}
}