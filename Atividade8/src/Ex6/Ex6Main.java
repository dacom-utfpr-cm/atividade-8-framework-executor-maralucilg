
package Ex6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 6. Faça um programa que execute três algoritmos de ordenação para um conjunto de valores e exiba o resultado apenas 
 * do algoritmo que finalizar primeiro (use invokeAny ).
 * 
 * @maralucilg
 */
public class Ex6Main {
    
    public static void main(String[] args) {
         ExecutorService executor = Executors.newFixedThreadPool(3);
	 Integer[] v  = new Integer[] { 10, 9, 8, 7, 6 };

	 List<Callable<Integer[]>> tasks = new ArrayList<Callable<Integer[]>>();
	 tasks.add(new BubbleSort(v));
	 tasks.add(new InsertionSort(v));
	 tasks.add(new SelectionSort(v));
			
	try {
	    Integer[] result = executor.invokeAny(tasks);
	    System.out.println(Arrays.toString(result));
		} catch (Exception e) {
		e.printStackTrace();
		}
	executor.shutdown();

	}
    
}
