// Binary Search — O(log n) search on sorted arrays
public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
        int target = 23;
        int index = search(sorted, target);
        if (index != -1)
            System.out.println("Found " + target + " at index: " + index);
        else
            System.out.println(target + " not found.");
    }
}
