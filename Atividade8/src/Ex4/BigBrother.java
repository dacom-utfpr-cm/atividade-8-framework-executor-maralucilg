
package Ex4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Essa classe é responsável por monitorar atividades.
 * 
 * @maralucilg
 */
public class BigBrother implements Runnable {
    
    /* https://www.tutorialspoint.com/java/io/java_io_printwriter.htm */
        PrintWriter pt;
	Path dir;
	
	BigBrother(String default_path){
		
	try {
	dir  = Paths.get(default_path);
	FileWriter fw = new FileWriter(new File("/home/thanatos/Documentos/logger.txt"),true);
	pt.println("we are watching you" + new Date().toString());
	pt.flush();
	} catch (IOException e) {
                e.printStackTrace();
		}
	}

	@Override
	public void run() {
           // em dúvida aqui

	}
    
}
