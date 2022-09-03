package base;

/**
 * <b>类 名 称</b> :  StringTest<br/>
 * <b>类 描 述</b> :  String相关基础内容测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/9 7:24<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/9 7:24<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class StringTest {

    public static void main(String[] args) {
        // 长度6
        splitTest(",,,,,1");
        // 长度6
        splitTest(",,,,,1,,,");
    }
    
    public static void splitTest(String s) {
        String[] split = s.split(",");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }
        System.out.println("end");
    }
    
    public void test() {
        String maxString = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();
    }
    
}
