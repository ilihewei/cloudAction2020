package com.lihewei;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionUtils {
    private  static JedisPool pool=null;
    static {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig ();
        jedisPoolConfig.setMaxTotal (100);
        pool=new JedisPool (jedisPoolConfig,"127.0.0.1",7000);
    }
    public static Jedis getJedis() {
        return pool.getResource ();
    }
}
