package leetcode.p0900.p0912;

public class SortArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        //heapSort(nums);
        return nums;
    }

    private void mergeSort(int[] nums) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] tmp, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(nums, tmp, l, m);
        mergeSort(nums, tmp, m + 1, r);
        merge(nums, tmp, l, r);
    }

    private void merge(int[] nums, int[] tmp, int l, int r) {
        int m = l + (r - l) / 2;
        if (m + 1 - l >= 0) System.arraycopy(nums, l, tmp, l, m + 1 - l);
        if (r + 1 - (m + 1) >= 0) System.arraycopy(nums, m + 1, tmp, m + 1, r + 1 - (m + 1));

        for (int i = l, j = m + 1, k = l; k <= r; k++) {
            if (i > m || (j <= r && tmp[i] > tmp[j])) {
                nums[k] = tmp[j];
                j++;
            } else {
                nums[k] = tmp[i];
                i++;
            }
        }
    }

    private void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heap(nums, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heap(nums, i, 0);
        }
    }

    private void heap(int[] nums, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && nums[l] > nums[largest]) largest = l;
        if (r < n && nums[r] > nums[largest]) largest = r;

        if (largest != i) {
            int tmp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = tmp;
            heap(nums, n, largest);
        }
    }
}
