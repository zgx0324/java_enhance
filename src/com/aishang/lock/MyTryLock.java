package com.aishang.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Author 爱尚实训赵国鑫
 * @ClassName MyTryLock
 * @Date 2019/12/10/15:28
 * @Description TODO:(一句话描述这个类)
 */
/**
 * 观察现象：一个线程获得锁后，另一个线程取不到锁，不会一直等待
 * @author
 *
 */
public class MyTryLock {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    //lock.tryLock();获取锁立即返回true，否则返回false
                    // 等待1000毫秒，若在此期间获取到锁返回true，否则false
                    boolean b = lock.tryLock(1000,TimeUnit.MILLISECONDS);
                    System.out.println(Thread.currentThread().getName() + "flag=" + b);
                    if (b) {
                        System.out.println(Thread.currentThread().getName() + "获取到锁");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了锁");
                }

            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                boolean b = lock.tryLock(1000, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + "flag=" + b);
                    if (b) {
                        System.out.println(Thread.currentThread().getName() + "获取到锁");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了锁");
                }

            }
        }.start();
    }
}
