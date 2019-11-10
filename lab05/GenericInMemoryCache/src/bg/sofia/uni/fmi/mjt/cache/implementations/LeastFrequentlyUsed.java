package bg.sofia.uni.fmi.mjt.cache.implementations;

import bg.sofia.uni.fmi.mjt.cache.interfaces.Cache;
import bg.sofia.uni.fmi.mjt.cache.interfaces.CacheFactory;
import bg.sofia.uni.fmi.mjt.cache.enums.EvictionPolicy;
import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequentlyUsed implements Cache, CacheFactory {

    private Map<Object, Object> cache;
    private long capacity;
    private double hitRate;
    private int usesCount;
    private EvictionPolicy evictionPolicy;

    @Contract(pure = true)
    public LeastFrequentlyUsed() {
        this.cache = new HashMap<>();
        this.hitRate = 0.0;
        this.usesCount = 0;
        this.capacity = 0L;
        this.evictionPolicy = EvictionPolicy.LEAST_FREQUENTLY_USED;
    }

    @Contract(pure = true)
    public LeastFrequentlyUsed(Map<Object, Object> cache, long capacity) {
        this.cache = cache;
        this.capacity = capacity;
        this.evictionPolicy = EvictionPolicy.LEAST_FREQUENTLY_USED;
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
            this.hitRate++;
            this.usesCount++;
        } else {
            if (this.capacity < CAPACITY) {
                this.cache.put(key, value);
                this.hitRate++;
                this.usesCount++;
                this.capacity++;
            } else {
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
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        Cache<K, V> newInstance = new LeastFrequentlyUsed();
        this.capacity = capacity;
        this.evictionPolicy = policy;
        return newInstance;
    }

    <K, V> Cache<K, V> getInstance(EvictionPolicy policy) {
        Cache<K, V> newInstance = new LeastFrequentlyUsed();
        this.capacity = 10000;
        this.evictionPolicy = policy;
        return newInstance;
    }
}
