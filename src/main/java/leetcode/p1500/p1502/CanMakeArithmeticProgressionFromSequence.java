package leetcode.p1500.p1502;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, len = arr.length;
        for (var a : arr) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        int diff = (max - min) / (len - 1);
        for (int i = 0; i < len; i++) {
            int a = arr[i];
            if (diff == 0) {
                if (a != min) return false;
                else continue;
            }

            if ((a - min) % diff != 0) return false;
            int j = (a - min) / diff;
            if (i != j) {
                if (j >= len || a == arr[j]) return false;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        return true;
    }
}
