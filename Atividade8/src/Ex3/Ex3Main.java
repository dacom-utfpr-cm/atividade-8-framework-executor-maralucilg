
package Ex3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;
/**
 * 3. Faça um programa concorrente para multiplicar duas matrizes.
 * 
 * @maralucilg
 */
public class Ex3Main {
    
    public static void main(String[] args) {
		int num_threads = 4;
		int[][]mat = new int[][]{{1,2},{1,2}};
		int[][]mat2 = new int[][]{{1,2},{1,2}};
		
		ExecutorService executor = Executors.newFixedThreadPool(num_threads);
		
		List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
		for(int i = 0; i < mat.length;i++) {
			for(int j = 0; j < mat[i].length;j++) {
				tasks.add(new MultiMat(mat, mat2, i, j));
			}
		}
		
		try {
			List<Future<Integer>> f = executor.invokeAll(tasks);
			int position = 0;
			
			for(int i = 0; i < mat.length;i++) {
				for(int j = 0; j < mat2[0].length;j++) {
					System.out.println("" + f.get(position).get() + "");
					position++;
				}
			}
			
		} catch(Exception e) {
                    e.printStackTrace();
		}
		
		executor.shutdown();
		

	}
    
    
    
}
