
package modelo;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import java.util.ArrayList;
import persistencia.ImagemDAO;

/**
 *
 * @author Fernando Vasques
 */
public class Imagem {
    private int  id;
    private String url;
    private UploadedFile arquivo;
    private String legenda;
    private int uploader;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public int getUploader() {
        return uploader;
    }

    public void setUploader(int uploader) {
        this.uploader = uploader;
    }

    public UploadedFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }
    
    public static ArrayList<Imagem> listarTodas(){
        return new ImagemDAO().listarTodas();
    }
}
