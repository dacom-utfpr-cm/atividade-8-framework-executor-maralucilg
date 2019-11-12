
package Ex6;

import java.util.concurrent.Callable;

/**
 * Código SelectionSort
 *  parte da ordenação </*https://www.geeksforgeeks.org>
 *  // https://www.geeksforgeeks.org/selection-sort/
 * 
 * @maralucilg
 */
public class SelectionSort implements Callable<Integer[]> {
    
    Integer[] v;

    public SelectionSort(Integer[] v) {
        
        v = v.clone();
    }
    
    @Override
	public Integer[] call() {
		for (int i = 0; i < v.length; i++) {
			int key = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[key] > v[j]) {
					key = j;
				}
			}
			Integer temp = v[i];
			v[i] = v[key];
			v[key] = temp;
		}
		return v;
	}
    
}
