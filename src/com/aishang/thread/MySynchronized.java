package com.aishang.thread;

/**
 * @Author 爱尚实训赵国鑫
 * @ClassName MySynchronized
 * @Date 2019/12/10/14:43
 * @Description TODO:(同步锁)
 */
public class MySynchronized implements Runnable {
    final static MySynchronized mySynchronized = new MySynchronized();
    private static int tickets=100;
    public static void main(String[] args) {
        Thread t1 = new Thread(new MySynchronized(),"thread0");
        Thread t2 = new Thread(new MySynchronized(),"thread1");

        t1.start();
        t2.start();
    }

    /**
     * 释放线程锁的两种情况： 1，执行完同步代码块内的代码后  2，发生异常，JVM会自动释放
     */

    @Override
    public void run() {
        synchronized (mySynchronized){
            while (tickets>0){
                System.out.println(Thread.currentThread().getName()+"--------"+(--tickets));
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 *  缺点：
 */