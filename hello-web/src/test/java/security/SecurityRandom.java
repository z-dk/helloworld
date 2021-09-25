package security;

import java.security.SecureRandom;
import java.util.Random;

/**
 * <b>类 名 称</b> :  SecurityRandom<br/>
 * <b>类 描 述</b> :  security包下的random<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/9/25 21:25<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/9/25 21:25<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class SecurityRandom {

    public static void main(String[] args) {
        //random();
        secureRandom();
    }
    
    public static void random() {
        // 种子相同时,每次获取随机数的值是相同的
        // Random random = new Random(999);
        // 默认无参构造方法使用了系统的纳秒数来生成种子,以此来保证每次生成的random对象的种子是随机的
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }


    public static void secureRandom() {
        // SecureRandom的无参构造方法使用了更多的元素()来保证种子是随机的
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(secureRandom.nextInt(100));
        }
    }
    
}
