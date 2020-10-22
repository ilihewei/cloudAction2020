package com.lihewei;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.UUID;

public class DistributedLock {

    /**
     *获得锁
     * @param lockName 锁的名称
     * @param acquireTimeout 获得锁的超时时间
     * @param lockTimeout 锁本身的过期时间
     * @return
     */
    public  String acquireLock(String lockName,long acquireTimeout,long lockTimeout) {

        String identifier = UUID.randomUUID ().toString ();//保证释放锁的时候是同一个持有锁的人

        String lockKey = "lock:" + lockName;
        int lockExpire = (int) (lockTimeout / 1000);
        Jedis jedis = null;
        try {
            jedis = JedisConnectionUtils.getJedis ();

            long end = System.currentTimeMillis () + acquireTimeout;
            //获取锁的限定时间
            while (System.currentTimeMillis () < end) {
                if (jedis.setnx (lockKey, identifier) == 1) {
                    //设置成功
                    jedis.expire (lockKey, lockExpire);//设置超时时间
                    return identifier;//获得锁成功
                }
                try {
                    //等待片刻获取锁的重试
                    Thread.sleep (100);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }

            }
        }catch (Exception e){
            jedis.close ();
        }
        return  null;
    }

    /**
     * 释放锁
     * @param lockName
     * @param identifier
     * @return
     */

    public  boolean releaseLock(String lockName,String identifier){
        System.out.println (lockName+"--------开始释放锁"+identifier);
        String lockKey="lock:"+lockName;
        Jedis jedis=null;
        boolean isRelease=false;
        try {
            jedis= JedisConnectionUtils.getJedis ();
            while (true){
                jedis.watch (lockKey);
                if (identifier.equals (jedis.get (lockKey))){
                    Transaction transaction=jedis.multi ();
                    transaction.decr (lockKey);
                    if (transaction.exec ().isEmpty ()){
                        continue;
                    }
                    isRelease=true;
                }
                jedis.unwatch ();
                break;
            }

        }finally {
            jedis.close ();
        }
        return  isRelease;
    }
}
