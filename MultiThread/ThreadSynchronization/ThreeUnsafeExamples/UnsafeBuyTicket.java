package MultiThread.ThreadSynchronization.ThreeUnsafeExamples;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTickets buyTickets = new BuyTickets();
        new Thread(buyTickets,"小红").start();
        new Thread(buyTickets,"小王").start();
        new Thread(buyTickets,"小张").start();
    }
}

class BuyTickets implements Runnable{
    private int tickets = 5;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //判断是否有票
    private boolean ticketAlive(){
        if (tickets<=0){
            System.out.println("没票了");
            return false;
        }
        return true;
    }
    //购买票
    private  void buy() throws InterruptedException {
        Thread.sleep(100);
        if(ticketAlive()){
            System.out.println(Thread.currentThread().getName()+" 买到了第 "+tickets-- + " 张票 ");
        }else {
            return;
        }
    }
}
