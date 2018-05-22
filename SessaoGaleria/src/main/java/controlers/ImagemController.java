
package controlers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import modelo.Imagem;
import persistencia.ImagemDAO;

/**
 *
 * @author Fernando Vasques
 */
@Controller
public class ImagemController {
    @Inject
    private Result result;
    
    @Path("/imagem/editar")
    public void editar(){ }
    
    @Post
    @Path("/imagem/salvar")
    public void salvar(Imagem img){
         String pathName = "..\\..\\webapp\\WEB-INF\\img\\";
         if (null != img.getArquivo()){
             if (img.getArquivo().getContentType().trim().equals("image/png") || img.getArquivo().getContentType().trim().equals("image/jpeg")){
                File f = new File(pathName + img.getUploader() + (img.getArquivo().getContentType().trim().equals("image/png") ? ".png" : ".jpg"));
                 try {   
                     img.getArquivo().writeTo(f);
                 } catch (IOException ex) {
                     this.result.include("mensagem", ex.toString());
                     persistencia.Log.salvaLog(ImagemDAO.class.getName() + ": " + ex.toString());
                     Logger.getLogger(ImagemController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                this.result.include("mensagem", "Sucesso....");
                this.result.redirectTo(IndexController.class).index();
            } else {
                this.result.include("mensagem", "Tipo de dado invalido...");
                //this.result.redirectTo(ImagemController.class).tela_adicionar();
            }            
        } else {
            this.result.include("mensagem", "Nenhum arquivo");
            this.result.redirectTo(ImagemController.class).editar();
        }
    }
}
