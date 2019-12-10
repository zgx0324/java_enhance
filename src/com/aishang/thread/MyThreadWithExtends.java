package com.aishang.thread;

/**
 * TODO 卖票案例
 * @Author 爱尚实训赵国鑫
 * @ClassName MyThreadWithExtends
 * @Date 2019/12/10/14:17
 * @Description TODO:( 继承Thread类 )
 */
public class MyThreadWithExtends extends Thread{
    private static int ticket = 100;
    private String flag;
    MyThreadWithExtends(String flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        while (ticket>0){
            System.out.println(this.flag+": "+Thread.currentThread().getName()+"--------"+(--ticket));
        }
    }

    public static void main(String[] args) {

        Thread t1 = new MyThreadWithExtends("t1");
        Thread t2 = new MyThreadWithExtends("t2");
        // start 是开启线程并调用run方法，只调用run则不会开启线程
        t1.start();
        t2.start();

    }
}
