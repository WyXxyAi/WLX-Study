package Thread02Study;

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 的优先级: "+Thread.currentThread().getPriority());
    }
}

public class PriorityTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyPriority());
        Thread t2 = new Thread(new MyPriority());
        Thread t3 = new Thread(new MyPriority());
        Thread t4 = new Thread(new MyPriority());
        Thread t5 = new Thread(new MyPriority());
        //主线程默认优先级=5
        System.out.println(Thread.currentThread().getName()+" 的优先级: "+Thread.currentThread().getPriority());
        //启动的线程默认的优先级=5
        t1.start();
        //MIN_PRIORITY=1
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        //NORM_PRIORITY=5
        t3.setPriority(Thread.NORM_PRIORITY);
        t3.start();
        //MAX_PRIORITY=10
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
        //
        t5.setPriority(3);
        t5.start();
    }
}
