/**
 * 
 */

/**
 * My O(n^2) iterative solution of SelectionSort
 * From n, n-1, n-2 ... 1 = (n+1) * n /2
 * @author sid16
 *
 */
public class selectionSort {
	
	public void SelectionSort (String[] data) {
		//Strategy: Walk-up, find min, swap, move-up
		int n = data.length;
		for(int i = 0; i < n-1; i++) { //Walk-up
			int minElement = i; // index of minelement
			for(int j = i; i < n; j++) { //find min
				if(data[minElement].compareToIgnoreCase(data[j]) > 0) {
					minElement = j;
				}
			}
			//Swap min
			String buffer = data[i];
			data[i] = data[minElement];
			data[minElement] = buffer;
		}
	}
}
