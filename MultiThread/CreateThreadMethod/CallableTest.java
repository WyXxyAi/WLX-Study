package MultiThread.CreateThreadMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" : "+i);
            if (i == 9){
                return Thread.currentThread().getName()+"  Callable测试";
            }
        }
        return null;
    }
}
class CallableMain{
    public static void main(String[] args) {
        CallableTest c = new CallableTest();
        FutureTask f1 = new FutureTask(c);
        FutureTask f2 = new FutureTask(c);
        new Thread(f1,"F1").start();
        new Thread(f2,"F2").start();
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
