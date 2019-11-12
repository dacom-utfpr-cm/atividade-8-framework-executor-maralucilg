
package Ex2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 2. Faça um programa que calcule a soma dos elementos de uma matriz MxN. 
 * Divida o programa em tarefas que somam as linhas.
 * O programa deve possibilitar especificar o número de threads para resolver o problema.
 * 
 * @maralucilg
 */
public class Ex2Main {
    
    public static void main(String[] args) {
		 
	    int num_threads = 4;
	    int[][] mat = new int[][] {{1,5,6}, {1,5,6}, {1,5,6}};
	    ExecutorService executor = Executors.newFixedThreadPool(num_threads);
	    
	    Set<Callable<Integer>> tasks = new HashSet<Callable<Integer>>();
	    
	    for(int i = 0; i < mat.length; i++) {
	        tasks.add(new LineSums(mat[i]));
	        }
	    
	    try {
	      List<Future<Integer>> f = executor.invokeAll(tasks);
	      
	      int s = 0;
	      
	      for(Future<Integer> j: f) {
	    	  
	    	  s+= j.get();
	      }
	      
	      System.out.println(s);
	    } catch (InterruptedException | ExecutionException e) {
	    	
	    }
	    executor.shutdown();

	}
    
}
