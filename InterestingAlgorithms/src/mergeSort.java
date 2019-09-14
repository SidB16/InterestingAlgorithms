import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author sid16
 *
 */
public class mergeSort {

	// List param can be unsorted!
	public List<Integer> sort(List<Integer> list) {
		// Strategy for Recursive case: Split, Sort and Merge
		List<Integer> sortedList;
		if (list.size() == 0)// Basecase#1: Empty list. Note: empty list preserves all properties!
			return list;
		else if (list.size() == 1) { // Basecase#2: one element list and one element preserves the property of being
										// sorted.
			sortedList = new ArrayList<Integer>();
			sortedList.add(list.get(0));
		} else {// Recursive case: split, sort and merge
			int middle = list.size() / 2;
			List<Integer> leftSublist = list.subList(0, middle); // to but not including middle. Similar to substring
																	// method for strings!
			List<Integer> RightSublist = list.subList(middle, list.size());

			List<Integer> leftSortedlist = sort(leftSublist);
			List<Integer> rightSortedlist = sort(leftSublist);

			sortedList = merge(leftSortedlist, rightSortedlist);
		}
		return sortedList;
	}

	private List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<Integer>();
		int i = 0, j = 0; // left and right list index counters to track when we have reached the end our
							// left or right lists
		// In essence,
		while (i < left.size() && j < right.size()) {
			if (left.get(i) < right.get(j)) {
				result.add(left.get(i));
				i++;
			} else {
				result.add(right.get(j));
				j++;
			}
		}
		// However, if we reach of the end left or right, based on the conjuction-based
		// boolean expression above
		// then we check and add the elements of the sortedist(left or right), whose
		// elements are yet to added to
		// our result

		// These for-loops are very COOL b/c they perform checking and addition of
		// elements at the same time, b/c of for-loop syntax

		// one or the other but not both, logical expression here to think about these
		// two for-loops at high-level.
		// if loop invariant holds before the start of this iteration then it holds
		// Immediately before the start of the next iteration! (3101 approach)
		for (int k = i; k < left.size(); k++) {
			// loop will be skipped if we have reached end of left list i.e. counter of left
			// list, i = left.size()
			// else,
			result.add(left.get(k));
		}
		// if invariant holds before
		for (int k = j; k < right.size(); k++) {
			// this loop will be skipped if we reached end of right list
			result.add(right.get(k));
		}

		return result;

	}
}
