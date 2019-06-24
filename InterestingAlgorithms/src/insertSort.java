/**
 * 
 */

/**
 * @author sid16
 *
 */
public class insertSort {
	public void InsertSort(char[] data) {
		int n = data.length; //best practises fro encapsulation.
		//Insert
		for (int i = 1; i < n; i++) { //walk up the array/ insert elements
			char curr = data[i];
			
			//Sort section
			int j = i;
			while (j>0 && data[j-1] > curr) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = curr; //wherever j falls too
		}
	}
}
