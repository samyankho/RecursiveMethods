import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] fibArray(int n) {
		/* Your Task. */
		int[] result = new int[n];
		if (n == 1) {
			result[0] = 1;
		} else if (n == 2) {
			result[0] = 1;
			result[1] = 1;
		} else {
			System.arraycopy(fibArray(n - 1), 0, result, 0, n - 1);
			result[n - 1] = result[n - 2] + result[n - 3];

		}
		return result;
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * 
	 * @param n the first n Fibonacci numbers
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> fibList(int n) {
		List<Integer> list = new ArrayList<>();
		if (n == 1) {
			list.add(1);
		} else if (n == 2) {
			list.add(1);
			list.add(1);
		} else {
			list.addAll(0, fibList(n - 1));
			list.add(list.get(n - 2) + list.get(n - 3));

		}
		return list;
	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibArray({1, 2}) returns false and
	 * isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibArray(int[] a) {
		/* Your Task. */
		return isFibArrayHelper(a, 0, a.length - 1);
	}

	public boolean isFibArrayHelper(int[] a, int from, int to) {
		/* Your Task. */
		if (a.length == 0)
			return false;
		if (a.length == 1)
			return a[0] == 1;
		if (a[0] != 1 || a[1] != 1)
			return false;
		return isFibArrayHelper(2, a);
	}

	private boolean isFibArrayHelper(int i, int[] a) {
		if (i >= a.length)
			return true;
		boolean result = a[i] == a[i - 1] + a[i - 2];
		return result && isFibArrayHelper(i + 1, a);
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibList({1, 2}) returns false and
	 * isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibList(List<Integer> list) {
		if (list.size() == 0)
			return false;
		if (list.size() == 1)
			return list.get(0) == 1;
		if (list.get(0) != 1 || list.get(1) != 1)
			return false;
		return isFibListHelper(2, list);
	}

	private boolean isFibListHelper(int i, List<Integer> list) {
		if (i >= list.size())
			return true;
		boolean result = list.get(i) == list.get(i - 1) + list.get(i - 2);
		return result && isFibListHelper(i + 1, list);
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		int[] b = new int[a.length + 1];
		boolean sorted = false;
		if (a.length == 0) {
			b[0] = i;
		} else {
			insertIntoSortedArrayHelper(a, b, i, 0, sorted);
		}
		return b;
	}

	private void insertIntoSortedArrayHelper(int[] a, int[] b, int i, int j, boolean sorted) {
		if (j == a.length) {
			if (sorted) {
				b[j] = a[j - 1];
			} else {
				b[j] = i;
			}
		} else {
			if (i >= a[j]) {
				if (sorted) {
					b[j] = a[j - 1];
					insertIntoSortedArrayHelper(a, b, i, j + 1, sorted);
				} else {
					b[j] = a[j];
					insertIntoSortedArrayHelper(a, b, i, j + 1, sorted);
				}
			} else if (i < a[j]) {
				if (sorted) {
					b[j] = a[j - 1];
					insertIntoSortedArrayHelper(a, b, i, j + 1, sorted);
				} else {
					b[j] = i;
					sorted = true;
					insertIntoSortedArrayHelper(a, b, i, j + 1, sorted);
				}
			}
		}

	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> sortlist, int i) {
		List<Integer> list = new ArrayList<>();
		boolean sorted = false;
		if (sortlist.size() == 0) {
			list.add(i);
		} else {
			insertIntoSortedListdHelper(sortlist, list, i, 0, sorted);
		}
		return list;
	}

	private void insertIntoSortedListdHelper(List<Integer> list, List<Integer> sorted, int i, int j, boolean inserted) {
		if (j == list.size()) {
			if (inserted) {
				sorted.add(j, list.get(j - 1));

			} else {
				sorted.add(j, i);
			}

		} else {
			if (i >= list.get(j)) {
				if (inserted) {
					sorted.add(j, list.get(j - 1));
					insertIntoSortedListdHelper(list, sorted, i, j + 1, inserted);
				} else {
					sorted.add(j, list.get(j));

					insertIntoSortedListdHelper(list, sorted, i, j + 1, inserted);
				}
			} else if (i < list.get(j)) {
				if (inserted) {
					sorted.add(j, list.get(j - 1));
					insertIntoSortedListdHelper(list, sorted, i, j + 1, inserted);
				} else {
					sorted.add(j, i);
					inserted = true;
					insertIntoSortedListdHelper(list, sorted, i, j + 1, inserted);
				}
			}
		}

	}

	/**
	 * Given two sorted arrays left and right, return a sorted array of size
	 * left.length + right.length, consisting of all elements of arrays left and
	 * right.
	 * 
	 * @param left  a sorted array
	 * @param right a sorted array
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArrays({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedLists method below to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] leftArray, int[] rightArray) {
		int[] result = new int[leftArray.length + rightArray.length];
		if (leftArray.length == 0)
			return rightArray;
		else if (rightArray.length == 0)
			return leftArray;
		else if (result.length == 0)
			return result;
		mergeSortedArraysHelper(leftArray, rightArray, result, 0, 0, 0);
		return result;
	}

	private void mergeSortedArraysHelper(int[] left, int[] right, int[] result, int leftSize, int rightSize,
			int index) {

		if (index == result.length - 1) {
			if (leftSize == left.length)
				result[index] = right[rightSize];
			else if (rightSize == right.length)
				result[index] = left[leftSize];
			else {
				if (left[leftSize] > right[rightSize])
					result[index] = right[rightSize];
				else if (left[leftSize] < right[rightSize])
					result[index] = left[leftSize];
				else {
					result[index] = left[leftSize];
					result[index + 1] = right[rightSize];
				}
			}
		} else {
			if (leftSize == left.length) {
				result[index] = right[rightSize];
				mergeSortedArraysHelper(left, right, result, leftSize, rightSize + 1, index + 1);
			} else if (rightSize == right.length) {
				result[index] = left[leftSize];
				mergeSortedArraysHelper(left, right, result, leftSize + 1, rightSize, index + 1);
			} else {
				if (left[leftSize] > right[rightSize]) {
					result[index] = right[rightSize];
					mergeSortedArraysHelper(left, right, result, leftSize, rightSize + 1, index + 1);
				} else if (left[leftSize] < right[rightSize]) {
					result[index] = left[leftSize];
					mergeSortedArraysHelper(left, right, result, leftSize + 1, rightSize, index + 1);
				} else {
					result[index] = left[rightSize];
					result[index + 1] = right[rightSize];
					mergeSortedArraysHelper(left, right, result, leftSize + 1, rightSize + 1, index + 1);
				}
			}
		}
	}

	/**
	 * Given two sorted lists left and right, return a sorted list of size
	 * left.size() + right.size(), consisting of all elements of lists left and
	 * right.
	 * 
	 * @param left  a sorted list
	 * @param right a sorted list
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedLists({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedArrays method above to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<>();
		int total = left.size() + right.size();
		if (left.size() == 0)
			return right;
		else if (right.size() == 0)
			return left;
		else if (total == 0)
			return result;
		mergeSortedListsHelper(left, right, result, 0, 0, 0, total);
		return result;
	}

	private void mergeSortedListsHelper(List<Integer> left, List<Integer> right, List<Integer> result, int leftSize,
			int rightSize, int index, int total) {
		if (index == total - 1) {
			if (leftSize == left.size())
				result.add(index, right.get(rightSize));
			else if (rightSize == right.size())
				result.add(index, left.get(leftSize));
			else {
				if (left.get(leftSize) > right.get(rightSize))
					result.add(index, right.get(rightSize));
				else if (left.get(leftSize) < right.get(rightSize))
					result.add(index, left.get(leftSize));
				else {
					result.add(index, left.get(leftSize));
					result.add(index + 1, right.get(rightSize));
				}
			}
		} else {
			if (leftSize == left.size()) {
				result.add(index, right.get(rightSize));
				mergeSortedListsHelper(left, right, result, leftSize, rightSize + 1, index + 1, total);
			} else if (rightSize == right.size()) {
				result.add(index, left.get(leftSize));
				mergeSortedListsHelper(left, right, result, leftSize + 1, rightSize, index + 1, total);
			} else {
				if (left.get(leftSize) > right.get(rightSize)) {
					result.add(index, right.get(rightSize));
					mergeSortedListsHelper(left, right, result, leftSize, rightSize + 1, index + 1, total);
				} else if (left.get(leftSize) < right.get(rightSize)) {
					result.add(index, left.get(leftSize));
					mergeSortedListsHelper(left, right, result, leftSize + 1, rightSize, index + 1, total);
				} else {
					result.add(index, left.get(leftSize));
					result.add(index + 1, right.get(rightSize));
					mergeSortedListsHelper(left, right, result, leftSize + 1, rightSize + 1, index + 1, total);
				}
			}
		}
	}
}