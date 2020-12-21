package com.bosssoft.gpmscloud.utils;

import java.util.Arrays;
import java.util.BitSet;

public class MyBloomFilter<T> {
    //你的布隆过滤器容量
    private static final int DEFAULT_SIZE = 2 << 28;
    //bit数组，用来存放结果
    private static BitSet bitSet = new BitSet(DEFAULT_SIZE);


    public static void main(String[] args) {
        bitSet.set(1, true);
        System.out.println(bitSet.size());
    }

    //后面hash函数会用到，用来生成不同的hash值，可随意设置，别问我为什么这么多8，图个吉利
    private static final int[] ints = {1, 6, 16, 38, 58, 68};

    //add方法，计算出key的hash值，并将对应下标置为true
    public void add(T key) {
        Arrays.stream(ints).forEach(i -> bitSet.set(hash(key, i)));
    }

    //判断key是否存在，true不一定说明key存在，但是false一定说明不存在
    public boolean isContain(T key) {
        boolean result = true;
        for (int i : ints) {
            //短路与，只要有一个bit位为false，则返回false
            result = result && bitSet.get(hash(key, i));
        }
        return result;
    }

    //hash函数，借鉴了hashmap的扰动算法

    /**
     * <p>
     * 由于hashCode可能相同，所以一些误差的办法也没有办法避免，
     * 基于假设每一个key 的hashCode尽可能不同，并且hashMap的从槽数N是2的倍数，那么在2进制的情况下就是
     * 高位一个1，其他都是0，然后N-1就会是连续很多个1，然后这时候用key的hashCode进行异或（N-1）
     * 只要hashCode不同，最后的结果一定不同，并且还能考虑到map的最大个数！
     * <p>
     * 干扰算法其实就是把HashCode右移16和HashCode相异或，然后在重复上述的动作！
     * </p>
     */
    private int hash(T key, int i) {
        int h;
        return key == null ? 0 : (i * (DEFAULT_SIZE - 1) & ((h = key.hashCode()) ^ (h >>> 16)));
    }
}