
package Ex4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 4. Faça um programa que periodicamente monitore mudanças em um conjunto de arquivos especificados. 
 * Se ocorreram mudanças, o programa deve registrá-las em um arquivo de log.
 * 
 * @maralucilg
 */
public class Ex4Main {
    
    // Executor
    
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(new BigBrother("/home/thanatos/Documentos/pasta"));
     

    
}
