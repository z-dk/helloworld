package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  ShellSort<br/>
 * <b>类 描 述</b> :  希尔排序<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/26 10:10<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/26 10:10<br/>
 * <b>修改备注</b> :
 */
public class ShellSort {
    
    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15,13,7};
        System.out.println("排序前："+ Arrays.toString(a));
        sort(a);
        System.out.println("排序后："+Arrays.toString(a));
    }
    
    /**
     * 方法描述: 希尔排序的思想是使数组中任意间隔为h的元素都是有序的
     * 这里代码是以3为基数来实现
     * @param a 待排序数组
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/12/26 10:18
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/12/26 10:18
     * @since  1.0.0
     */
    private static void sort(int[] a) {
        int h = 1;
        while (h < a.length/3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int swap = a[j];
                    a[j] = a[j - h];
                    a[j - h] = swap;
                }
            }
            h = h / 3;
        }
    }
    
}
