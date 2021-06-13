package generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <b>类 名 称</b> :  FanXing<br/>
 * <b>类 描 述</b> :  泛型测试类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/8/7 20:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/8/7 20:32<br/>
 * <b>修改备注</b> :
 */
public class GenericTest {
    
    private Map<String, Integer> map;
    
    public static void main(String[] args) throws NoSuchFieldException {
        getGenericType();
        //getGenericField();
    }
    
    public static void getGenericType() {
        //List<?> list = new ArrayList<String>();
        List<String> list = new ArrayList<>();
        Class<? extends List> listClass = list.getClass();
        Type[] genericInterfaces = listClass.getGenericInterfaces();
        Type genericSuperclass = listClass.getGenericSuperclass();
        //
        //System.out.println("class(typeName): " + listClass.getTypeName());
        //System.out.println("class(name): " + listClass.getName());
        //int[] intArray = new int[10];
        //Class<? extends int[]> arrayClass = intArray.getClass();
        //System.out.println("arrayClass(name): " + arrayClass.getName());
        //System.out.println("arrayClass(typeName): " + arrayClass.getTypeName());
        
        
        // 获取类的实现接口，包含接口的泛型定义java.util.AbstractList<E>
        System.out.println("genericSuperclass: " + genericSuperclass.getTypeName());
        System.out.println("genericInterfaces: ");
        for (int i = 0; i < genericInterfaces.length; i++) {
            if (genericInterfaces[i] instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[i];
                System.out.println("ParameterizedType: " + Arrays.toString(parameterizedType.getActualTypeArguments()));
            } else {
                System.out.println(genericInterfaces[i].getTypeName() + ";");
            }
        }
        
        /// 获取类的实现接口，不包含泛型的定义信息
        //Class<?>[] interfaces = listClass.getInterfaces();
        //System.out.println("interfaces: ");
        //for (int i = 0; i < interfaces.length; i++) {
        //    System.out.println(interfaces[i].getName() + ";");
        //}
    }
    
    public static void getGenericField() throws NoSuchFieldException {
        Class<GenericTest> genericTestClass = GenericTest.class;
        Field map = genericTestClass.getDeclaredField("map");
        Type genericType = map.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            System.out.println("map属性的具体泛型是：" + Arrays.toString(parameterizedType.getActualTypeArguments()));
        } else {
            System.out.println("map的类型为：" + genericType.getTypeName());
        }
    }
    
    public static void test(){
        List<?> p = new ArrayList<>();
    }
    
}
