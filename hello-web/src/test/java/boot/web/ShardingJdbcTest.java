package boot.web;

import com.zdk.hello.HelloworldApplication;
import com.zdk.hello.service.customer.entity.Customer;
import com.zdk.hello.service.customer.mapper.CustomerMapper;
import com.zdk.hello.service.province.entity.Province;
import com.zdk.hello.service.province.mapper.ProvinceExtendMapper;
import com.zdk.hello.service.role.mapper.RoleExtendMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
    
    @Autowired
    RoleExtendMapper roleExtendMapper;    
    
    @Autowired
    CustomerMapper customerMapper;
    
    @Test
    public void insertCity() {
        Province province = new Province();
        province.setProvinceId(1);
        province.setCityId(11);
        province.setProvinceName("1号");
        province.setCityName("11号");
        province.setId(new Random().nextInt());
        int insert = provinceExtendMapper.insertProvince(province);
        System.out.println(insert);
    }
    
    @Test
    public void count() {
        int insert = provinceExtendMapper.count();
        System.out.println(insert);
    }
    
    @Test
    public void roleCount() {
        int insert = roleExtendMapper.count();
        System.out.println(insert);
    }
    
    @Test
    public void insertCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("nihao");
        customer.setAddress("beijing");
        customer.setBirthday(LocalDateTime.now());
        customer.setPhone(15535333322L);
        // 自定义的sql需要自行配置typehandler
        //Integer integer = customerMapper.insertCustomer(customer);
        int insert = customerMapper.insert(customer);
        System.out.println(insert == 1);
    }
    
    @Test
    public void getCustomer() {
        // 自定义的sql
        //Customer customer = customerMapper.getCustomerById(6);
        // mybatis-plus的sql
        Customer customer = customerMapper.selectById(6);
        System.out.println(customer.getAddress());
    }
    
}
