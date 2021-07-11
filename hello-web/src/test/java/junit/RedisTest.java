package junit;

import com.zdk.hello.HelloworldApplication;
import com.zdk.hello.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * <b>类 名 称</b> :  RedisTest<br/>
 * <b>类 描 述</b> :  redis测试类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/11 10:53<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/11 10:53<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloworldApplication.class})
public class RedisTest {
    
    private static final String STRING_REDIS_KEY_PRE = "redis:string:";

    @Resource
    RedisUtils redisUtils;
    
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void getRedisStringDataTest() {
        //Assert.assertSame("k1值发生变动", "newK1", redisUtils.get("k1"));
        System.out.println(redisUtils.set("redisUtilsKey1", "redisUtilsValue1"));
        stringRedisTemplate.opsForValue().set(STRING_REDIS_KEY_PRE+"stringRedisKey1", "stringRedisValue1");
    }
    
    @Test
    public void getRedisHashDataTest() {
        Map<String,String> stringMap = new HashMap<>(16);
        stringMap.put("stringK1", "stringNewV1");
        stringMap.put("stringK4", "stringV4");
        stringMap.put("stringK5", "stringV5");
        // 如果key值已存在,并且存在的key对应的value类型与新值类型不一致会报错
        stringRedisTemplate.opsForHash().putAll(STRING_REDIS_KEY_PRE+"stringHashRedisKey1", stringMap);
        System.out.println("hash:"+stringRedisTemplate.opsForHash().entries(STRING_REDIS_KEY_PRE+"stringHashRedisKey1"));

        System.out.println(redisUtils.hashPutAll("hashKey1", stringMap));
        System.out.println(redisUtils.hashGetAll("hash"));
    }
    
    @Test
    public void getRedisListDataTest() {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("value1", "value2", "value3"));
        // 如果key值已存在,并且存在的key对应的value类型与新值类型不一致会报错
        //stringRedisTemplate.opsForList().leftPushAll(STRING_REDIS_KEY_PRE+"stringListRedisKey1", strings);
        System.out.println("list:"+stringRedisTemplate.opsForList().size(STRING_REDIS_KEY_PRE+"stringListRedisKey1"));
        System.out.println(stringRedisTemplate.opsForList().range(STRING_REDIS_KEY_PRE + "stringListRedisKey1", 0, 10));
        
        System.out.println(redisUtils.listAddAllInHead("listKey1", strings));
        System.out.println(redisUtils.listGetByRange("listKey1",0,10));
    }

}
