
package Ex3;

import java.util.concurrent.Callable;

/**
 * Essa classe é responsável pela multiplicação de matrizes.
 * 
 * @maralucilg
 */
public class MultiMat implements Callable <Integer> {
    
        int[][] mat;
	int[][] mat2;
	int m;
	int n;
	
	public MultiMat(int[][]mat, int[][]mat2, int m, int n) {
		
		this.mat = mat;
		this.mat2 = mat2;
		this.m=m;
		this.n=n;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;

		for(int i = 0; i < mat[m].length; i++) {
			
			result+= mat[m][i]*mat2[i][n];
		}
		return result;
	}
	
    
}
