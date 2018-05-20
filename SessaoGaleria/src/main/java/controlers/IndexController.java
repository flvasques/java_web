package controlers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import java.util.ArrayList;
import java.util.List;
import modelo.Imagem;

@Controller
public class IndexController {
	@Path("/")
	public List<Imagem> index() { 
            return Imagem.listarTodas();
	}
}