package me.newsong.cache;

import me.newsong.util.ProtoStuffSerializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by SinjinSong on 2017/4/12.
 */
@Component
public class RedisCacheManager implements CacheManager {
    /**
     * 默认缓存名
     */
    public static final String CACHE_NAME = "SinjinSong";
    /**
     * 默认缓存时间
     */
    public static final int CACHE_TIME  = 60;
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Override
    public <T> T get(String key, Class<T> resultType) {
        byte[] result = (byte[]) redisTemplate.execute((RedisCallback) (conn)->{
           return conn.get(key.getBytes()); 
        });
        if(result == null){
            return null;
        }
        return ProtoStuffSerializerUtil.deserialize(result,resultType);
    }

    @Override
    public <T> void put(String key, T obj) {
       redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.setNX(key.getBytes(), ProtoStuffSerializerUtil.serialize(obj));
			}
		});
    }

    @Override
    public <T> void putWithExpireTime(String key, T obj, long expireTime) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.setEx(key.getBytes(),expireTime,ProtoStuffSerializerUtil.serialize(obj));
                return true;
            }
        });
    }
    

    @Override
    public <T> List<T> getList(String key, Class<T> returnType) {
        byte[] result = (byte[]) redisTemplate.execute((RedisCallback) (conn)->{
            return conn.get(key.getBytes());
        });
        if(result == null){
            return null;
        }
        return ProtoStuffSerializerUtil.deserializeList(result,returnType);
    }

    @Override
    public <T> void putList(String key, List<T> objs) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.setNX(key.getBytes(),ProtoStuffSerializerUtil.serializeList(objs));
                return true;
            }
        });
    }

    @Override
    public <T> void putListWithExpireTime(String key, List<T> objs, long expireTime) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.setEx(key.getBytes(),expireTime,ProtoStuffSerializerUtil.serializeList(objs));
                return true;
            }
        });
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void deleteWithPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }

    @Override
    public void clear() {
        deleteWithPattern("*");
    }
}
