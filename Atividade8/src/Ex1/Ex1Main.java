
package Ex1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1. Faça um programa que localize o maior valor em um vetor. 
 * Divida o programa em tarefas que localizam o maior valor em um segmento do vetor. 
 * O programa deve possibilitar especificar o número de tarefas e o número de threads para resolver o problema.
 * 
 * @maralucilg
 */
public class Ex1Main {
    
    
	public static void main(String[] args) {
        int num_tasks = 8;
        int num_threads = 4;
        int[] v = new int[] {1,2,3,4,5};
        ExecutorService executor = Executors.newFixedThreadPool(num_threads);
        int position = 0;
        int qtd_task = v.length/num_tasks;
        
        Set<Callable<Integer>> tasks = new HashSet<Callable<Integer>>();
        
        for(int i = 1; i <num_tasks; i++){
            tasks.add(new FindMax(v, position, v.length-1));
            position += qtd_task;
        }
            tasks.add(new FindMax(v, position, v.length-1));
        
        try {
        List<Future<Integer>> f = executor.invokeAll(tasks);
        
        int result = f.get(0).get();
        for(int i = 1; i < f.size(); i++) {
            int value = f.get(i).get();
            if(result < value) {
                result = value;
            }
        }
        System.out.println(result);
        } catch(InterruptedException | ExecutionException e) {
            
        }
        executor.shutdown();
        
    
        }
}
