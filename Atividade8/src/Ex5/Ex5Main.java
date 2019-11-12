
package Ex5;

import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 5. Faça um programa que possibilite agendar uma tarefa para ser executada em um horário especı́fico.
 * 
 * @maralucilg
 */
public class Ex5Main {
    
    public static void main(String[] args) {
		
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR, 15);
    cal.set(Calendar.MINUTE, 32);
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    long seconds  = (cal.getTime().getTime() - new Date().getTime()) / 1000;
    ScheduledFuture f = executor.schedule(new Runnable(){
		
	@Override
	public void run() {
	System.out.println("Hour... " + new Date().toString());
	}
	
        }, // https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/TimeUnit.html
         (long) seconds, TimeUnit.SECONDS);
	    try {
		f.get();
		} catch (Exception e) {
                    e.printStackTrace();
		}	
		executor.shutdown();

	}

    
}
