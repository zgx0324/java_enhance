package com.aishang.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 爱尚实训赵国鑫
 * @ClassName MyLock
 * @Date 2019/12/10/15:11
 * @Description TODO:(一句话描述这个类)
 */
public class MyLock {
    static  Lock lock = new ReentrantLock();
    static  int ticket = 100;
    public static void main(String[] args) {


        new Thread(){
            @Override
            public void run() {
                // 添加锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                try{
                    while (ticket>0){
                        System.out.println(Thread.currentThread().getName()+":=====:"+(--ticket));
                    }
                   Thread.sleep(100);
                }catch (Exception e){

                }finally {
                    // 释放锁
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"释放了锁");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                // 添加锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获取到了锁");
                try{
                    while (ticket>0){
                        System.out.println(Thread.currentThread().getName()+":=====:"+(--ticket));
                    }
                }catch (Exception e){

                }finally {
                    // 释放锁
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+"释放了锁");
                }
            }
        }.start();
    }
}
