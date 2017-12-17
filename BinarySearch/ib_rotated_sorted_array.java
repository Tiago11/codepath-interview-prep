public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    //return binarySearch(a, 0, a.size()-1, b);

	    int left = 0;
	    int right = a.size() - 1;

	    while (left <= right) {

	        int mid = left + (right - left)/2;

	        if (a.get(mid) == b) {
	            return mid;
	        }

	        if (a.get(left) <= a.get(mid)) {

	            if (a.get(left) <= b && b < a.get(mid)) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }

	        } else {

	            if (a.get(mid) < b && b <= a.get(right)) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }

	        }
	    }

	    return -1;
	}

	/*
	public int binarySearch(final List<Integer> a, int start, int end, int target) {

	    if (start > end) {
	        return -1;
	    }

	    int mid = start + (start + end)/2;

	    if (a.get(start) <= a.get(mid)) {

	        if (a.get(start) <= target && target < a.get(mid)) {
	            return binarySearch(a, start, mid-1, target);
	        } else {
	            return binarySearch(a, mid+1, end, target);
	        }

	    } else {

	        if (a.get(mid) < target && target <= a.get(end)) {
	            return binarySearch(a, mid+1, end, target);
	        } else {
	            return binarySearch(a, start, mid-1, target);
	        }

	    }
	}
	*/
}
