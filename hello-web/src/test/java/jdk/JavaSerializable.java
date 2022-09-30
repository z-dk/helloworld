package jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * <b>类 名 称</b> :  JavaSerializable<br/>
 * <b>类 描 述</b> :  序列化测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/9/30 21:18<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/9/30 21:18<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class JavaSerializable {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaSerializable.class);

    public static void main(String[] args) {
        FirstBean firstBean = new FirstBean("123", "数字");
        FirstBean deserialize = JavaSerializable.deserialize(serialize(firstBean));
        LOGGER.info("first to first:{}", deserialize);
    }
    
    public static FirstBean deserialize(ByteArrayOutputStream outputStream) {
        try(InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray())) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (FirstBean) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error("反序列化失败", e);
        }
        return null;
    }
    
    public static ByteArrayOutputStream serialize (FirstBean firstBean) {
        ByteArrayOutputStream rs = new ByteArrayOutputStream();
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(rs)) {
            objectOutputStream.writeObject(firstBean);
        } catch (IOException e) {
            LOGGER.error("序列化异常", e);
        }
        return rs;
    }
    
    
    
    static class FirstBean implements Serializable {

        private static final long serialVersionUID = 1L;

        public FirstBean() {
        }

        public FirstBean(String id, String name) {
            this.id = id;
            this.name = name;
        }

        private String id;

        /**
         * transient不会被序列化
         */
        private transient String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "FirstBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    
    static class SecondBean implements Serializable {

        private static final long serialVersionUID = 2L;
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "SecondBean{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
    
    static class ThirdBean implements Externalizable {

        private static final long serialVersionUID = -5813366503816530379L;
        private Long id;

        public ThirdBean() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "ThirdBean{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            ThirdBean o = (ThirdBean) in.readObject();
            
        }
    }
    
}
