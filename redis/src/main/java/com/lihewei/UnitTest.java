package com.lihewei;


/**
 * tName:5-->成功获得锁4cdb3bdb-ab3e-46d6-9999-73d6b7c8e021
 * updateOrder--------开始释放锁4cdb3bdb-ab3e-46d6-9999-73d6b7c8e021
 * tName:4-->成功获得锁497ea339-829f-444d-869f-772b31afb507
 * updateOrder--------开始释放锁497ea339-829f-444d-869f-772b31afb507
 * tName:2-->成功获得锁bfba85df-71e4-48b7-9afa-947b2d004a7d
 * updateOrder--------开始释放锁bfba85df-71e4-48b7-9afa-947b2d004a7d
 * tName:5-->成功获得锁1ad9dffa-7588-4dac-af92-1ca7d6e92bc0
 * updateOrder--------开始释放锁1ad9dffa-7588-4dac-af92-1ca7d6e92bc0
 * tName:8-->成功获得锁dfa754dc-45ee-4458-bb60-0bad934f24fb
 * updateOrder--------开始释放锁dfa754dc-45ee-4458-bb60-0bad934f24fb
 *
 * 构建了分布式锁，底层是watch ，exec，multi，加setnx这几个字段属性
 */
public class UnitTest extends Thread {
    @Override
    public  void run(){
        while (true){
            DistributedLock distributedLock = new DistributedLock ();
            String rs = distributedLock.acquireLock ("updateOrder", 2000, 5000);
            if (rs!=null){
                System.out.println (Thread.currentThread ().getName ()+"-->成功获得锁"+rs);
                try {
                    Thread.sleep (1000);
                    distributedLock.releaseLock ("updateOrder",rs);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public static void main(String[] args) {
        UnitTest unitTest = new UnitTest ();
        for (int i = 0; i <10 ; i++) {
            new Thread (unitTest,"tName:"+i).start ();
        }
    }
}
