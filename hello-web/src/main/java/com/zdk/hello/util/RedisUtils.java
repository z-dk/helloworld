package com.zdk.hello.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <b>类 名 称</b> :  RedisUtil<br/>
 * <b>类 描 述</b> :  redis<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/11 10:28<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/11 10:28<br/>
 * <b>修改备注</b> :  <br/>
 * StringRedisTemplate 和 RedisTemplate 区别？
 * 两者的关系是 StringRedisTemplate 继承 RedisTemplate。
 * 两者的数据是不共通的；也就是说 StringRedisTemplate 只能管理StringRedisTemplate 里面的数据，RedisTemplate 只能管理RedisTemplate 中的数据。
 * 序列化方式不一样：
 * RedisTemplate 使用的是 JdkSerializationRedisSerializer，存入数据会将数据先序列化成字节数组然后在存入 Redis 数据库。
 * StringRedisTemplate 使用的是 StringRedisSerializer，
 * RedisTemplate 使用的序列类在在操作数据的时候，比如说存入数据会将数据先序列化成字节数组然后在存入 Redis 数据库，这个时候打开 Redis 查看的时候，你会看到你的数据不是以可读的形式展现的，而是以字节数组显示
 * @author zdk
 */
@Component
@SuppressWarnings("unused")
public class RedisUtils {
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisUtils.class);

    private static final String REDIS_UTILS_KEY_PRE = "redis:utils:";
    
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 设置缓存
    public boolean set(String key, Object value) { 
        try {
            redisTemplate.opsForValue().set(REDIS_UTILS_KEY_PRE+key, value); 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 设置值并设置过期时间（单位秒）
    public boolean set(String key, Object value, long time) {
        try { 
            if (time > 0) {
                redisTemplate.opsForValue().set(REDIS_UTILS_KEY_PRE+key, value, time, TimeUnit.SECONDS);
            } else {
                set(REDIS_UTILS_KEY_PRE+key, value);
            } 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 设置一个已经存在的key的值，并返回旧值
    public Object getAndSet(String key, Object value) {
        try {
            return redisTemplate.opsForValue().getAndSet(REDIS_UTILS_KEY_PRE+key, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return null;
        }
    }

    // 如果不存在则设置值value，返回true。 否则返回false
    public Boolean setIfAbsent(String key, String value) {
        try {
            return redisTemplate.opsForValue().setIfAbsent(REDIS_UTILS_KEY_PRE+key, value);
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); return false;
        }
    }

    // 批量设置 k->v 到 redis
    public boolean multiSetString(HashMap<String, String> valueMap) {
        try {
            HashMap<String, String> newKeyMap = new HashMap<>(16);
            valueMap.forEach((key, value) -> newKeyMap.put(REDIS_UTILS_KEY_PRE+key, value));
            redisTemplate.opsForValue().multiSet(newKeyMap); 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 如果不存在对应的Map，则批量设置 k->v 到 redis
    public boolean multiSetStringIfAbsent(HashMap<String, String> valueMap) {
        try {
            HashMap<String, String> newKeyMap = new HashMap<>(16);
            valueMap.forEach((key, value) -> newKeyMap.put(REDIS_UTILS_KEY_PRE+key, value));
            redisTemplate.opsForValue().multiSetIfAbsent(newKeyMap); 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 在原有的值基础上新增字符串到末尾
    public boolean append(String key, String value) {
        try {
            redisTemplate.opsForValue().append(REDIS_UTILS_KEY_PRE+key, value); 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 获取value
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(REDIS_UTILS_KEY_PRE+key);
    }

    // 批量获取值
    public List<Object> multiGet(Collection<String> keys) {
        if (CollectionUtils.isEmpty(keys)) { 
            return null;
        }
        return redisTemplate.opsForValue().multiGet(keys.stream().map(key -> REDIS_UTILS_KEY_PRE+key)
                .collect(Collectors.toList()));
    }

    // 删除缓存，支持批量删除
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(REDIS_UTILS_KEY_PRE+key[0]);
            } else {
                redisTemplate.delete(Arrays.stream(key).map(k -> REDIS_UTILS_KEY_PRE+k).collect(Collectors.toList()));
            }
        }
    }

    // 判断key是否存在
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(REDIS_UTILS_KEY_PRE+key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 根据key 获取key的过期时间
    public Long getKeyExpire(String key) {
        return redisTemplate.getExpire(REDIS_UTILS_KEY_PRE+key, TimeUnit.SECONDS);
    }

    // 指定缓存失效时间
    public boolean expireKey(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(REDIS_UTILS_KEY_PRE+key, time, TimeUnit.SECONDS);
            } 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 通过increment(K key, long increment)方法以增量方式存储long值（正值则自增，负值则自减）
    public void increment(String key, long increment) {
        redisTemplate.opsForValue().increment(REDIS_UTILS_KEY_PRE+key, increment);
    }

    // 通过increment(K key, double increment)方法以增量方式存储double值（正值则自增，负值则自减）
    public void increment(String key, double increment) {
        redisTemplate.opsForValue().increment(REDIS_UTILS_KEY_PRE+key, increment);
    }

    // 修改redis中key的名称
    public void renameKey(String oldKey, String newKey) {
        redisTemplate.rename(REDIS_UTILS_KEY_PRE+oldKey, REDIS_UTILS_KEY_PRE+newKey);
    }

    // 如果旧值key存在时，将旧值改为新值
    public Boolean renameOldKeyIfAbsent(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(REDIS_UTILS_KEY_PRE+oldKey, REDIS_UTILS_KEY_PRE+newKey);
    }

    // 批量添加Map中的键值对
    public boolean hashPutAll(String mapName, Map<String, String> maps) {
        try {
            redisTemplate.opsForHash().putAll(REDIS_UTILS_KEY_PRE+mapName, maps); 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 添加一个键值对
    public boolean hashPutOne(String mapName, String key, String value) {
        try {
            redisTemplate.opsForHash().put(REDIS_UTILS_KEY_PRE+mapName, key, value); 
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 添加一个键值对,仅当hashKey不存在时才设置
    public boolean hashPutOneIfAbsent(String mapName, String hashKey, String value) {
        try {
            redisTemplate.opsForHash().putIfAbsent(REDIS_UTILS_KEY_PRE+mapName, hashKey, value);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 获取mapName中的所有的键值对
    public Object hashGetOne(String mapName, Object hashKey) {
        return redisTemplate.opsForHash().get(REDIS_UTILS_KEY_PRE+mapName, hashKey);
    }

    // 获取mapName中的所有的键值对
    public Map<Object, Object> hashGetAll(String mapName) {
        return redisTemplate.opsForHash().entries(REDIS_UTILS_KEY_PRE+mapName);
    }

    // 删除一个或者多个hash表字段
    public Long hashDelete(String key, Object... fields) {
        return redisTemplate.opsForHash().delete(REDIS_UTILS_KEY_PRE+key, fields);
    }

    // 查看hash表中指定字段是否存在
    public boolean hashExists(String key, String field) {
        return redisTemplate.opsForHash().hasKey(REDIS_UTILS_KEY_PRE+key, field);
    }

    // 给哈希表key中的指定字段的整数值加上增量increment
    public Long hashIncrementByLong(String key, Object field, long increment) {
        return redisTemplate.opsForHash().increment(REDIS_UTILS_KEY_PRE+key, field, increment);
    }

    // 给哈希表key中的指定字段的double加上增量increment
    public Double hashIncrementByDouble(String key, Object field, double delta) {
        return redisTemplate.opsForHash().increment(REDIS_UTILS_KEY_PRE+key, field, delta);
    }

    // 获取hash表中存在的所有的key
    public Set<Object> hashKeys(String mapName) {
        return redisTemplate.opsForHash().keys(REDIS_UTILS_KEY_PRE+mapName);
    }

    // 获取hash表中存在的所有的Value
    public List<Object> hashValues(String mapName) {
        return redisTemplate.opsForHash().values(REDIS_UTILS_KEY_PRE+mapName);
    }

    // 获取hash表的大小
    public Long hashSize(String mapName) {
        return redisTemplate.opsForHash().size(REDIS_UTILS_KEY_PRE+mapName);
    }

    // 设置值到List中的头部
    public Boolean listAddInHead(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPush(REDIS_UTILS_KEY_PRE+key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 批量设置值到List中的头部
    public Boolean listAddAllInHead(String key, Collection<?> values) {
        try {
            // 该leftPushAll方法有可变参数的重载问题
            redisTemplate.opsForList().leftPushAll(REDIS_UTILS_KEY_PRE+key, values.toArray());
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage()); 
            return false;
        }
    }

    // 如果存在List->key, 则设置值到List中的头部
    public Boolean listAddIfPresent(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPushIfPresent(REDIS_UTILS_KEY_PRE+key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    // 设置值到List中的尾部
    public Boolean listAddInEnd(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(REDIS_UTILS_KEY_PRE+key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    // 批量设置值到List中的尾部
    public Boolean listAddAllInEnd(String key, Collection<Object> values) {
        try {
            redisTemplate.opsForList().rightPushAll(REDIS_UTILS_KEY_PRE+key, values);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    // 通过索引去设置List->key中的值
    public Boolean listAddByIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(REDIS_UTILS_KEY_PRE+key, index, value);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    // 根据索引获取list中的值
    public Object listGetByIndex(String key, long index) {
        return redisTemplate.opsForList().index(REDIS_UTILS_KEY_PRE+key, index);
    }

    // 根据索引范围获取list中的值
    public List<?> listGetByRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(REDIS_UTILS_KEY_PRE+key, start, end);
    }

    // 移除并获取列表中第一个元素(如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止)
    public Object listLeftPop(String key) { 
        return redisTemplate.opsForList().leftPop(REDIS_UTILS_KEY_PRE+key);
    }

    // 移除并获取列表中最后一个元素(如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止)
    public Object listRightPop(String key) {
        return redisTemplate.opsForList().rightPop(REDIS_UTILS_KEY_PRE+key);
    }

    // 删除集合中值等于value的元素
    public Long listRemove(String key, long index, Object value) {
        return redisTemplate.opsForList().remove(REDIS_UTILS_KEY_PRE+key, index, value);
    }

    // 设置值到Set集合(支持批量)
    public Boolean setAdd(String key, Object... value) {
        try {
            redisTemplate.opsForSet().add(REDIS_UTILS_KEY_PRE+key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    // 移除Set集合中的值，支持批量
    public Long setRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(REDIS_UTILS_KEY_PRE+key, values);
    }

    // 判断Set中是否存在value
    public Boolean setIsExist(String key, Object value) {
        return redisTemplate.opsForSet().isMember(REDIS_UTILS_KEY_PRE+key, value);
    }

    // 将指定的地理空间位置（纬度、经度、名称）添加到指定的key中。
    public Long geoAdd(String key, double longitude, double latitude, String name) {
        /// Long addedNum = redisTemplate.opsForGeo().add("city", new Point(116.405285, 39.904989), "北京");
        return redisTemplate.opsForGeo().add(REDIS_UTILS_KEY_PRE+key, new Point(longitude, latitude), name);
    }

    // 从key里返回所有给定位置元素的位置（经度和纬度）
    public List<Point> geoGet(String key, List<String> nameList) {
        return redisTemplate.opsForGeo().position(REDIS_UTILS_KEY_PRE+key, nameList);
    }

    // 根据redis中键名（key）中，名字为 name1 和 name2 两个坐标的距离
    public Double geoGetDistance(String key, String name1, String name2) {
        return Objects.requireNonNull(redisTemplate.opsForGeo()
                .distance(REDIS_UTILS_KEY_PRE+key, name1, name2, RedisGeoCommands.DistanceUnit.METERS)).getValue();
    }

    // 以给定的经纬度为中心画圆， 返回键（key）包含的位置元素当中，与中心的距离不超过给定最大距离的所有位置元素，并给出所有位置元素与中心的平均距离。
    public GeoResults<RedisGeoCommands.GeoLocation<Object>> geoGetCoordinatesWithinRange(String key,
                                                                                         double longitude, double latitude,
                                                                                         Integer distance,
                                                                                         Integer count) { //以当前坐标为中心画圆，标识当前坐标覆盖的distance的范围， Point(经度, 纬度) Distance(距离量, 距离单位)
        Circle circle = new Circle(new Point(longitude, latitude), new Distance(distance, RedisGeoCommands.DistanceUnit.METERS));
        // 从redis获取的信息包含：距离中心坐标的距离、当前的坐标、并且升序排序，如果count > 0 则只取count个坐标，否则返回所有
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs
                .newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending();
        if (count > 0) {
            args.limit(count);
        }
        return redisTemplate.opsForGeo().radius(REDIS_UTILS_KEY_PRE+key, circle, args);
    }

    /**
     * 【获取指定范围内的坐标】
     * 以给定的键（key）中的坐标名字（标识）name为中心画圆， 返回键包含的位置元素当中，
     * 与中心的距离不超过给定最大距离的所有位置元素，并给出所有位置元素与中心的平均距离。
     */
    public GeoResults<RedisGeoCommands.GeoLocation<Object>> geoGetCoordinatesWithinRange(String key,
                                                                                         String name,
                                                                                         Integer distance,
                                                                                         Integer count) { // 创建距离对象
        Distance distances = new Distance(distance, RedisGeoCommands.DistanceUnit.METERS); // 需要从redis获取的参数
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs
                .newGeoRadiusArgs().includeDistance().includeCoordinates().sortAscending();
        if (count > 0) {
            args.limit(count);
        }
        return redisTemplate.opsForGeo()
                .radius(REDIS_UTILS_KEY_PRE+key, name, distances, args);
    }

}
