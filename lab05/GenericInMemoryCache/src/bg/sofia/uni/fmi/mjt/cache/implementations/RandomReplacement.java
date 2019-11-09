package bg.sofia.uni.fmi.mjt.cache.implementations;

import bg.sofia.uni.fmi.mjt.cache.interfaces.Cache;
import bg.sofia.uni.fmi.mjt.cache.interfaces.CacheFactory;
import bg.sofia.uni.fmi.mjt.cache.enums.EvictionPolicy;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class RandomReplacement implements Cache, CacheFactory {

    private Map<Object, Object> cache;
    private long capacity;
    private double hitRate;
    private int usesCount;
    private EvictionPolicy evictionPolicy;

    @Contract(pure = true)
    public RandomReplacement() {
        this.cache = new HashMap<>();
        this.hitRate = 0.0;
        this.usesCount = 0;
        this.capacity = 0l;
        this.evictionPolicy = EvictionPolicy.RANDOM_REPLACEMENT;
    }

    @Contract(pure = true)
    public RandomReplacement(Map<Object, Object> cache, long capacity) {
        this.cache = cache;
        this.capacity = capacity;
        this.evictionPolicy = EvictionPolicy.RANDOM_REPLACEMENT;
    }

    @Nullable
    public static <E> Set<E> pickRandomElement(Set<E> keys, int n) {
        List<E> list = new LinkedList<>(keys);
        Random r = new Random();
        int length = keys.size();
        if (length < n) return null;
        for (int i = length - 1; i >= length - n; --i)
        {
            Collections.swap(list, i , r.nextInt(i + 1));
        }
        keys.addAll(list.subList(length - n, length));
        return keys;
    }

    @Override
    public Object get(Object key) {
        if (key == this.cache.get(key)) {
            this.hitRate++;
            this.usesCount++;
            return key;
        } else {
            return null;
        }
    }

    @Override
    public void set(Object key, Object value) {
        if (key == null || value == null) {
            return;
        } else if (this.cache.containsKey(key)) {
            this.cache.replace(key, value);
        } else {
            if (this.capacity < CAPACITY) {
                this.cache.put(key, value);
                this.capacity++;
            } else {
                this.cache.remove(pickRandomElement(this.cache.keySet(), 1));
                this.cache.put(key, value);
            }
        }
    }

    @Override
    public boolean remove(Object key) {
        if (!this.cache.containsKey(key)) {
            return false;
        } else {
            this.cache.remove(key);
            return true;
        }
    }

    @Override
    public long size() {
        return this.cache.size();
    }

    @Override
    public void clear() {
        this.cache.clear();
        this.hitRate = 0.0;
    }

    @Override
    public double getHitRate() {
        return this.hitRate;
    }

    @Override
    public int getUsesCount(Object key) {
        if (!this.cache.containsKey(key)) {
            return 0;
        } else {
            return this.usesCount;
        }
    }

    <K, V> Cache<K, V> getInstance(long capacity, EvictionPolicy policy) {
        return null;
    }

    <K, V> Cache<K, V> getInstance(EvictionPolicy policy) {
        return null;
    }
}
