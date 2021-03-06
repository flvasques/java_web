
package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Fernando Vasques
 */
public class Log {
   public static void salvaLog(String s){
        LocalDateTime dth = LocalDateTime.now();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        s = dth.format(forma) + " => " + s + ".";
        try {  	
            BufferedWriter arquivo = new BufferedWriter (new FileWriter(new File("..\\..\\webap\\WEB-INF\\imgLogErro.txt"),true));
            arquivo.newLine();
            arquivo.write(s);
            arquivo.flush();
            arquivo.close();

        } catch ( IOException e ) {
            System.out.println(new File("..\\..\\..").getAbsolutePath());
            e.printStackTrace();
        }
    } 
}
