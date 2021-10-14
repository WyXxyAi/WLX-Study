package ThreadStudy;

public class TortoiseAndRabbitRace implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子")&&i%20==0){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flags = win(i);
            if (!flags){
                System.out.println(Thread.currentThread().getName()+"跑了 "+i+"m");
            }else {
                break;
            }
        }
    }

    public boolean win(int step){
        if(step >= 100){
            System.out.println(Thread.currentThread().getName()+"赢了");
            return true;
        }
        return false;
    }

}

class TortoiseAndRabbitRaceMain{
    public static void main(String[] args) {
        TortoiseAndRabbitRace tRR = new TortoiseAndRabbitRace();
        Thread t1 = new Thread(tRR,"兔子");
        Thread t2 = new Thread(tRR,"乌龟");

        t1.start();
        t2.start();
    }
}

