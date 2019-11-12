
package Ex1;

import java.util.concurrent.Callable;

/**
 * Essa classe é pra encontrar o maior valor em um vetor.
 * 
 * @maralucilg
 */
public class FindMax implements Callable <Integer> {
    
int first;
int last;
int[] v;

// construtor
public FindMax(int[] v, int first, int last) {
    this.v = v;
    this.first = first;
    this.last = last;
}

@Override
public Integer call() {
    
    int result = v[first];
    for(int i = first + 1; i <= last; i++) {
        if(result < v[i]) {
            result = v[i];
        }
    }
    
    return result;
}
    
}
