
package Ex2;

import java.util.concurrent.Callable;

/**
 * Essa classe é responsável por somar as linhas da matriz.
 * 
 * @amaralucilg
 */
public class LineSums implements Callable<Integer> {
    
     int[] m; // linha
	    
	    public LineSums(int[] m) {
	        
	        this.m = m;
	    }
	    
	    @Override
	    public Integer call() {
	        
	        int result = 0;
	        
	        for(int i = 0; i < m.length; i++) 
	            
	            result += m[i];
	        return result;

}
    
}
