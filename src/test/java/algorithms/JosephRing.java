package algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * <b>类 名 称</b> :  Test<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/9 11:41<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/9 11:41<br/>
 * <b>修改备注</b> :  <br/>
 * 真实算法面试：输入一个数值N，产生一个长度为n的数组，内容为1~n，从头开始报数1，2...报数为1的留下，下
 * 次从留下的倒序开始报数1，2，3...为1的留下，直到只剩一个数字，返回该数字
 * 约瑟夫环问题：
 * 有 n (1<n<10000)个小朋友站成一个圆圈。
 * 选定一个小朋友为1号，从他（她）开始顺时针编号：1,2,3,4，...
 *
 * 游戏开始! 从1号小朋友起,顺时针报数,从1报起。
 * 即：1号小朋友报1，2号小朋友报2，3号小朋友报3, ....
 *
 * 游戏规定，报到数字 m(1<m<100) 的小朋友立即退出报数圈。
 * 在他（她）的顺时针方向的下一个小朋友（如果有的话）开始重新从1报数...
 * 游戏这样一直进行下去，直到圈中只剩下一个小朋友。
 *
 * 求最后剩下的小朋友的编号。
 * @author zdk
 */
public class JosephRing {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        int[] nums = Stream.generate(i::getAndIncrement).mapToInt(Integer::valueOf).limit(15).toArray();
        long now = System.currentTimeMillis();
        System.out.println(myJosephSolveMethod(nums));
        System.out.println("耗时" + (System.currentTimeMillis()-now) + "毫秒");
    }

    /**
     * 我的约瑟夫环变种问题解决方案
     * @param nums 数组
     * @return 最后剩余的数字
     */
    public static int myJosephSolveMethod(int[] nums) {
        int circles = 2;
        while (nums.length > 1) {
            int ln = nums.length;
            int newLn = ln/circles + (ln%circles==0?0:1);
            int[] newNums = new int[newLn];
            int j = newLn-1;
            for (int i = 0; j>=0; i++) {
                newNums[j] = nums[i*circles];
                j--;
            }
            nums = newNums;
            circles++;
        }
        return nums[0];
    }

    /**
     * 约瑟夫环经典解决方案
     * @param n 小朋友数量
     * @param m 报号退出的编号
     * @return 最后剩余小朋友的编号
     */
    private static Integer yuesefu(int n, int m) {
        //构建双向链表
        LinkedList<Integer> list = new LinkedList<>();
        //初始化数据
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int start = 1;
        while (list.size() > 1) {
            //构建链表迭代器
            Iterator<Integer> iterator = list.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (start == m) {
                    iterator.remove();
                    start = 1;
                } else {
                    start++;
                }
            }
        }

        return list.get(0);
    }
    
}
