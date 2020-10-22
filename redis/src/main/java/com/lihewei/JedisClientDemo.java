package com.lihewei;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 哨兵模式下，客户端应该连接到哪个redis-server， 哨兵
 */
public class JedisClientDemo {
    public static void main(String[] args) {
        //sentinel


        Set<HostAndPort> hostAndPortSet=new HashSet<> ();
        hostAndPortSet.add (new HostAndPort ("127.0.0.1",7000));
        hostAndPortSet.add (new HostAndPort ("127.0.0.1",7001));
        //哨兵集群的地址
        JedisCluster jedisCluster = new JedisCluster (hostAndPortSet);

    }
}
