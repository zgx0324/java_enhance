package com.aishang.thread;

/**
 * @Author 爱尚实训赵国鑫
 * @ClassName MyThreadWithImplements
 * @Date 2019/12/10/14:33
 * @Description TODO:(基于实现 Runnable)
 */
public class MyThreadWithImplements implements Runnable{
    private static int ticket = 100;
    private String flag;

    MyThreadWithImplements(String flag){
        this.flag=flag;
    }
    @Override
    public void run() {
        while (ticket>0){
            System.out.println(this.flag+": "+Thread.currentThread().getName()+"--------"+(--ticket));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThreadWithImplements("t1"),"Thread 0");
        Thread t2 = new Thread(new MyThreadWithImplements("t2"),"Thread 1");

        t1.start();
        t2.start();


    }
}
