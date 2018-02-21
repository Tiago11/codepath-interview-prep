public class Solution {
    public int countInversions(ArrayList<Integer> A) {
        int[] arr = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            arr[i] = A.get(i);
        }

        return mergeSort(arr);
    }

    public int mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];

        return mergeSort(arr, tmp, 0, arr.length-1);
    }

    public int mergeSort(int[] arr, int[] tmp, int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = (left + right)/2;

            invCount += mergeSort(arr, tmp, left, mid);
            invCount += mergeSort(arr, tmp, mid+1, right);

            invCount += merge(arr, tmp, left, mid, right);
        }

        return invCount;
    }

    public int merge(int[] arr, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        int invCount = 0;

        while ((i <= mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                i++;
                k++;
            } else {
                tmp[k] = arr[j];
                j++;
                k++;
                invCount = invCount + (mid - i + 1);
            }
        }

        while (i <= mid) {
            tmp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            tmp[k] = arr[j];
            j++;
            k++;
        }

        for (i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }

        return invCount;
    }
}
