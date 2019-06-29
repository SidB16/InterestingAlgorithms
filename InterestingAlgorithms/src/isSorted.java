/**
 * 
 */

/**
 * Assume correct, unless proven otherwise.
 * @author sid16
 *
 */
public class isSorted {
	public static boolean IsSorted(String[] array) {
		return IsSortedHelper(array, 0, array.length-1);
	}
	private static boolean IsSortedHelper(String[] array, int from, int to) {
		String[] resultArray = array;
		boolean result = false;
		if(from > to) { //base case1: empty array is sorted array. 
			return true;
		}else if (from == to) { //base case2: if there is only element then the array is sorted!
			return true;
		}else {//recursive case	
			result =  resultArray[from].compareToIgnoreCase(resultArray[from+1]) > 0 && IsSortedHelper(resultArray, from+1, to);  
		}
		return result;
	}

}
