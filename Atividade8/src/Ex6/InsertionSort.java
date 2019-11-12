
package Ex6;

import java.util.concurrent.Callable;

/**
 *  Código InsertionSort
 *  parte da ordenação </*https://www.geeksforgeeks.org>
 *  // https://www.geeksforgeeks.org/insertion-sort/
 * 
 * @maralucilg
 */
public class InsertionSort implements Callable<Integer[]> {
    
    Integer[] v;

    public InsertionSort(Integer[] v) {
        
        this.v = v.clone();
    }
    
    @Override
	public Integer[] call() {
    
	for (int i = 1; i < v.length; ++i) {
        int key = v[i]; 
        int j = i - 1; 

        while (j >= 0 && v[j] > key) { 
        v[j + 1] = v[j]; 
        j = j - 1; 
        } 
        v[j + 1] = key; 
            }
        return v;
	}

    
}
