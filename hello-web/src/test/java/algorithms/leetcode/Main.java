package algorithms.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Main {

    static Pattern p = Pattern.compile("\0*[-+]?(\\d*.\\d+)|\\d+([eE][-+]?\\d+)?");

    public static void main(String[] args) {
        MedianFinder medianFinder = new Main().new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        Arrays.sort(new String[]{"1", "2", "3"}, Comparator.comparing(a -> a, (a, b) -> (a + b).compareTo(b + a)));
    }


    private static void test() {
        System.out.println(p.matcher("123").matches());
    }


    class MedianFinder {

        int[] arr;
        int size;
        int len;

        /** initialize your data structure here. */
        public MedianFinder() {
            len = 64;
            arr = new int[64];
            size = 0;
        }

        public void addNum(int num) {
            if (size + 1 >= len) {
                len *= 2;
                arr = Arrays.copyOf(arr, len);
            }

            int left = 0, right = size - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if(arr[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int idx = size == 0 ? 0 : num > arr[left] ? left + 1 : left;
            if (size > 0) {
                for (int i = size; i > idx; i--) {
                    arr[i] = arr[i - 1];
                }
            }
            arr[idx] = num;
            size++;
        }

        public double findMedian() {
            if (size == 0) {
                return 0;
            }
            if (size % 2 == 0) {
                int mid = size / 2;
                return (double) (arr[mid - 1] + arr[mid]) / 2;
            } else {
                return arr[size / 2];
            }
        }
    }

}
