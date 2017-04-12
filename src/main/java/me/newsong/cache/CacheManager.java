package me.newsong.cache;

import java.util.List;

/**
 * Created by SinjinSong on 2017/4/12.
 */
public interface CacheManager {
    <T> T  get(final String key,Class<T> resultType);
    <T> void put(final String key,T obj);
    <T> void putWithExpireTime(final String key,T obj,final long expireTime);
    <T> List<T> getList(final String key,Class<T> returnType);
    <T> void putList(final String key, List<T> objs);
    <T> void putListWithExpireTime(final String key, List<T> objs,final long expireTime);
    void delete(final String key);
    void deleteWithPattern(final String pattern);
    void clear();
}
