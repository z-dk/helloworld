package base.basedatatype;

import ch.qos.logback.core.net.SyslogOutputStream;
import edu.princeton.cs.algs4.StdOut;

/**
 * <b>类 名 称</b> :  StringTest<br/>
 * <b>类 描 述</b> :  string<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/3/2 14:41<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/3/2 14:41<br/>
 * <b>修改备注</b> :
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a+b;
        boolean flag = a+b == a+b;
        System.out.println(flag);
    }
}
