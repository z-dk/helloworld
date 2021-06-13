package algorithms.sort;

import java.util.Arrays;

/**
 * <b>类 名 称</b> :  CountSort<br/>
 * <b>类 描 述</b> :  计数排序<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/3 11:43<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/3 11:43<br/>
 * <b>修改备注</b> :  <br/>
 * 时间复杂度：总体运算量为 n+n+k+n ，总体运算是 3n + k 所以时间复杂度为 O(N+K)；
 * 空间复杂度：辅助数组（前缀和数组），空间复杂度为 O（n）
 * 稳定性在我们最后存入临时数组时有体现，我们当时让其放入临时数组的合适位置，并减一，所以某元素前面的相同元素，在临时数组，仍然在其前面。所以计数排序是稳定的排序算法。
 *
 * 虽然计数排序效率不错但是用到的并不多。
 * 这是因为其当数组元素的范围太大时，并不适合计数排序，不仅浪费时间，效率还会大大降低。
 * 当待排序的元素非整数时,也不适用
 * @author zdk
 */
public class CountSort {

    public static void main(String[] args) {
        int[] a = {1,7,13,5,18,3,9,6,15,13,7};
        System.out.println("排序前："+ Arrays.toString(a));
        System.out.println("排序后："+Arrays.toString(sort(a)));
    }
    
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (nums.length < 1) {
            return nums;
        }
        //求出最大最小值
        int max = nums[0];
        int min = nums[0];
        for (int x : nums) {
            if (max < x)  max = x;
            if (min > x)  min = x;
        }
        //设置 presum 数组长度,然后求出我们的前缀和数组，
        //这里我们可以把求次数数组和前缀和数组用一个数组处理
        int[] presum = new int[max-min+1];
        for (int x : nums) {
            presum[x-min]++;
        }
        for (int i = 1; i < presum.length; ++i) {
            presum[i] = presum[i-1]+presum[i];
        }
        //临时数组
        int[] temp = new int[len];
        //遍历数组，开始排序,注意偏移量
        for (int i = len-1; i >= 0; --i) {
            //查找 presum 字典，然后将其放到临时数组，注意偏移度
            int index = presum[nums[i]-min]-1;
            temp[index] = nums[i];
            //相应位置减一
            presum[nums[i]-min]--;
        }
        //copy回原数组
        System.arraycopy(temp,0,nums,0,len);
        return nums;
    } 
    
}
