package ju;

public class MapTest {

    public static void main(String[] args) {

    }

    public void sort(int[] nums) {
        // 冒泡排序
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                // 从小到大排序
                if (nums[j] > nums[j + 1]) {
                    // 交换
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
                // 从大到小排序
                // if (nums[j] < nums[j + 1]) {
                //     // 交换
                //     int temp = nums[j + 1];
                //     nums[j + 1] = nums[j];
                //     nums[j] = temp;
                //     flag = true;
                // }
            }
            if (!flag) {
                break;
            }
        }
    }



}
