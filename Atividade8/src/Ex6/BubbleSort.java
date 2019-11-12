
package Ex6;

import java.util.concurrent.Callable;

/**
 * Código BubbleSort
 * parte da ordenação </*https://www.geeksforgeeks.org>
 * // https://www.geeksforgeeks.org/bubble-sort/
 * 
 * @maralucilg
 */
public class BubbleSort implements Callable<Integer[]> {
    
    Integer[] v;

    public BubbleSort(Integer[] v) {
        
        this.v = v.clone();
    }
    
    @Override
	public Integer[] call() {
		for (int i = 0; i < v.length; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] > v[j]) {
					Integer temp = v[i];
					v[i] = v[j];
					v[j] = temp;
				}
			}
		}
		return v;
	}
    
    
    
}
