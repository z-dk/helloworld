package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  SelectSort<br/>
 * <b>类 描 述</b> :  选择排序；<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/26 9:30<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/26 9:30<br/>
 * <b>修改备注</b> :
 */
public class SelectSort {
    
    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15,13,7};
        System.out.println("排序前："+ Arrays.toString(a));
        sort(a);
        System.out.println("排序后："+Arrays.toString(a));
    }
    
    /**
     * 方法描述: 选择排序是每次循环找到剩余待排序中的最小值与下一待确认值位置交换
     * 首先找到数组中最小值，与数组第一位交换，然后在剩下的值中找到最小值与第二位置交换。。。
     * @param a 待排序数组
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/12/26 9:37
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/12/26 9:37
     * @since  1.0.0
     */
    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int mid = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[mid] > a[j]) {
                    mid = j;
                }
            }
            if (mid != i && a[mid] != a[i]) {
                int swap = a[i];
                a[i] = a[mid];
                a[mid] = swap;
            }
        }
    }
    
}
