package base.clone;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>类 名 称</b> :  ListCloneTest<br/>
 * <b>类 描 述</b> :  list集合深拷贝与浅拷贝<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/15 9:23<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/15 9:23<br/>
 * <b>修改备注</b> :  <br/>
 * 这里的浅拷贝和深拷贝均是针对集合里的对象，而非集合本身
 * @author zdk
 */
public class ListCloneTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("111","222"));
        List<String> des = shallowListClone(list);
        des.add("333");
        des.remove("222");
        System.out.println("src:" + list);
        System.out.println("des:" + des);
    }

    /**
     * 深拷贝方式拷贝集合
     * @param src 待拷贝数据源
     * @param <T> 集合数据类型
     * @return 拷贝后的对象
     */
    public static <T> List<T> depthListClone(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(src);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        
        @SuppressWarnings("unchecked")
        List<T> des = (List<T>) objectInputStream.readObject();

        return des;
    }

    /**
     * 浅拷贝方式拷贝集合
     * @param src 拷贝数据源
     * @param <T> 集合中的数据类型
     * @return 返回拷贝的新集合
     */
    public static <T> List<T> shallowListClone(List<T> src) {
        /// 第一种拷贝方式
        /// List<T> des = new ArrayList<>(src);

        List<T> des = new ArrayList<>();
        //System.arraycopy(src, 0, des, 0, src.size());
        
        des.addAll(src);
        // 
        return des;
    }
    
}
