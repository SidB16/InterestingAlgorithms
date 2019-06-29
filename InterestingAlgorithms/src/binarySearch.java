/**
 * 
 */

/**
 * This is a recursive solution that has O(log n) for a SORTED ARRAY (lexogrphical or natural ordering).
 * For a unsorted array, you can utilize a brute force approach: linear or sequential search.
 * 
 * 3 important things to remember about using a recursive:
 * 1)always have base condition to ground the recursive case
 * 2)base case should not have more recursion
 * 3) the recursive case should be called on strictly smaller parts.
 * 4) try and eliminate tail recursion
 * @author sid16
 *
 */
public class binarySearch<E>{
	public boolean BinarySearch (String[] array, String target) {
		if (isSorted.IsSorted(array)) {
			return BinarySearchHelper(array, target, 0, array.length-1);
		}else {
			throw new IllegalArgumentException("Array has to be sorted!");
		}
		
	}	
		//modulation								element(obj) vs index(int)
	private boolean BinarySearchHelper (String[] array, String target, int low, int high) {
		String[] resultArray = array; //encapsulation!
		boolean result = false;
		if (low > high) { //base case1: empty array!
			return false;
		}else if (low == high) {//base case2: 1 element in the array
			result = target.equals(resultArray[low]) ? true : false;
		}else {	//recursive case
			int mid = (high + low)/2;//calculating mid
			if( resultArray[mid].compareToIgnoreCase(target) < 0) {
				BinarySearchHelper(resultArray, target, mid+1, high);
			}else if(resultArray[mid].compareToIgnoreCase(target) > 0) {
				BinarySearchHelper(resultArray, target, low, mid-1);
			}else { //if result[mid] < target 
				result = resultArray[mid].compareToIgnoreCase(target) == 0 ? true : false;
			}	
		}
		return result;
	}
}
