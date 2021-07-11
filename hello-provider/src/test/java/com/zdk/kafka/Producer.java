package com.zdk.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * <b>类 名 称</b> :  Producer<br/>
 * <b>类 描 述</b> :  kafka生产者<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/6/19 12:25<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/6/19 12:25<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class Producer {

    private static final Properties properties = new Properties();
    static {
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG,"DemoProducer");
        properties.put("acks","0");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
    }
        

    public static void main(String[] args) {
        kafkaProduce();
    }
    
    public static void kafkaProduce() {
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 100; i++) {
                producer.send(new ProducerRecord<>("MessageTopic", "key" + i, i + "value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
