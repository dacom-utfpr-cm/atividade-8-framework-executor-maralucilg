
package Ex4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Date;
import java.util.List;

/**
 *  Essa classe é responsável por monitorar atividades.
 *  Essa classe utiliza um WatchService, que segundo a documentação: 
 * " A watch service that watches registered objects for changes and events.".
 * 
 * @maralucilg
 */
public class BigBrother implements Runnable {
    
    /* https://www.tutorialspoint.com/java/io/java_io_printwriter.htm */
       PrintWriter pt;
    /* https://docs.oracle.com/javase/7/docs/api/java/nio/file/WatchService.html */
	WatchService watchService;
	Path dir;
	
	BigBrother(String default_path){
		
	try {
	dir  = Paths.get(default_path);
        // https://howtodoinjava.com/java8/java-8-watchservice-api-tutorial/
	watchService = dir.getFileSystem().newWatchService();
	dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);   
        // https://howtodoinjava.com/java/io/java-write-to-file/
        FileWriter fileWriter = new FileWriter(new File("/home/thanatos/Documentos/logger.txt"),true);   
	BufferedWriter writer = new BufferedWriter(fileWriter);
	pt = new PrintWriter(writer);
	pt.println("we are watching you" + new Date().toString());

	} catch (IOException e) {
          e.printStackTrace();  
	}
	}

	@Override
	public void run() {
            while (true) {
			try {
             // https://howtodoinjava.com/java8/java-8-watchservice-api-tutorial/
			WatchKey watchKey = watchService.take();
			List<WatchEvent<?>> events_i = watchKey.pollEvents();
			for (WatchEvent<?> event : events_i) {
             // https://www.programcreek.com/java-api-examples/?class=java.nio.file.StandardWatchEventKinds&method=OVERFLOW
                            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
				pt.println("[Creating] " + event.context().toString() + " *** " + new Date().toString());
                            } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
					pt.println("[Deleting]: " + event.context().toString() + " *** " + new Date().toString());
                            } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
					pt.println("Modify: " + event.context().toString() + " *** " + new Date().toString());
				}
				}
			// https://docs.oracle.com/javase/8/docs/api/java/nio/file/WatchEvent.html#reset--
			watchKey.reset();
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		
	}

	}
    
}
