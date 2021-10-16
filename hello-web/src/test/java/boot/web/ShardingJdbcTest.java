package boot.web;

import com.zdk.hello.HelloworldApplication;
import com.zdk.hello.service.province.entity.Province;
import com.zdk.hello.service.province.mapper.ProvinceExtendMapper;
import com.zdk.hello.service.province.mapper.ProvinceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <b>类 名 称</b> :  ShardingJdbcTest<br/>
 * <b>类 描 述</b> :  sharding-jdbc<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/10/14 23:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/10/14 23:02<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloworldApplication.class})
public class ShardingJdbcTest {
    
    @Autowired
    ProvinceExtendMapper provinceExtendMapper;
    
    @Resource
    ProvinceMapper provinceMapper;
    
    @Test
    public void insertCity() {
        Province province = new Province();
        province.setProvinceId(2);
        province.setCityId(12);
        province.setProvinceName("2号");
        province.setCityName("12号");
        province.setId(new Random().nextInt());
        int insert = provinceExtendMapper.insertProvince(province);
        System.out.println(insert);
    }
    
    @Test
    public void insertCity2() {
        Province province = new Province();
        province.setProvinceId(2);
        province.setCityId(12);
        province.setProvinceName("2号");
        province.setCityName("12号");
        province.setId(new Random().nextInt());
        int insert = provinceMapper.insert(province);
        System.out.println(insert);
    }
    
}
