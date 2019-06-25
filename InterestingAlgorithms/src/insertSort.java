/**
 * 
 */

/**
 * This is my O(n^2) implementation for insert-sort.
 * @author sid16
 *
 */
public class insertSort {
	public void InsertSort (char[] data) {
		//Our strategy: Walk up the array (using for-loop), and sort in non-decreasing order(using while-loop).
		int n = data.length; //array length
		//Insert i.e. walk up the array
		for (int i = 1; i<n; i++) {
			char currentElement = data[i]; //current element
			int j = i; //index of current element
			//Sort
				//short circuiting here
			while (j>0 && data[j-1]>currentElement) {
					data[j] = data[j-1];
					j--;
			}//execution of this loop holds until we reach index 0 (for sorting) or prev element <= currentElement
			
			//When we reach index 0 after sorting, or a case where current > prevElement
			data[j] = currentElement;
		}
	}
}
