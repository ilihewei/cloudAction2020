package com.lihewei;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * 空间效率非常高的概率性算法
 * 存储40亿的数据，二个数占4个比特位，内存需要16位
 * bitmap（位图）
 * int 4个字节-32个比特位（可以存储32个十进制的数据）
 *16G-512m
 */
public class BloomFilterDemo {
    public static void main(String[] args) {
        BloomFilter bloomFilter=BloomFilter.create (Funnels.stringFunnel (Charset.defaultCharset ()),
                1000000,0.001);//
        bloomFilter.put ("mic");
        System.out.println (bloomFilter.mightContain ("mic"));
        bloomFilter.put ("mic");
        System.out.println (bloomFilter.mightContain ("mic"));



    }
}
