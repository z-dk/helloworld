package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  InsertSort<br/>
 * <b>类 描 述</b> :  插入排序<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/26 9:44<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/26 9:44<br/>
 * <b>修改备注</b> :
 */
public class InsertSort {
    
    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15,13,7};
        System.out.println("排序前："+ Arrays.toString(a));
        sort(a);
        System.out.println("排序后："+Arrays.toString(a));
    }
    
    /**
     * 方法描述: 数组i左侧始终有序，但可能不是最终的位置，后续有更小的值时需要通过移动来为更小值腾出位置
     * @param a 待排序数组
     * @return void
     * @author zdk
     * <br/><b>创建时间:</b>2020/12/26 9:52
     * <br/><b>修 改 人:</b>zdk
     * <br/><b>修改时间:</b>2020/12/26 9:52
     * @since  1.0.0
     */
    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                int swap = a[j];
                a[j] = a[j-1];
                a[j-1] = swap;
            }
        }
    }
    
}
