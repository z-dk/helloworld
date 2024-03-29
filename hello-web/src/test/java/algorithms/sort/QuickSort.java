package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  QuickSort<br/>
 * <b>类 描 述</b> :  快速排序代码实现<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/22 10:58<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/22 10:58<br/>
 * <b>修改备注</b> :
 */
public class QuickSort {
    
    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15};
        System.out.println("排序前："+Arrays.toString(a));
        sort(a,0,a.length-1);
        System.out.println("排序后："+Arrays.toString(a));
    }

    /**
     * 快速排序:先选一个基准值，然后将数组分为两部分，左边的都比基准值小，右边的都比基准值大
     * 然后再对左右两部分进行递归排序
     * @param a 待排序数组
     * @param lo 待排序数组区间左边界
     * @param hi 待排序数组区间右边界
     */
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = partition(a,lo,hi);
        sort(a,lo,mid-1);
        sort(a,mid+1,hi);
    }
    
    private static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int mid = a[lo], left = lo, right = hi+1;
        // 小于mid的元素都在左边，大于mid的元素都在右边
        // 左右扫描指针相遇时结束循环
        while (true) {
            while (a[++left] < mid) {
                if (left == hi) {
                    break;
                }
            }
            while (a[--right] > mid) {
                if (right == lo) {
                    break;
                }
            }
            if (left >= right) break;
            int swap = a[left];
            a[left] = a[right];
            a[right] = swap;
        }
        // 将mid放到正确的位置
        int swap = a[right];
        a[right] = a[lo];
        a[lo] = swap;
        return right;
    }
    
}
