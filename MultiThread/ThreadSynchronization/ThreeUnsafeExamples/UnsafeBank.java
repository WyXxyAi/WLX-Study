package MultiThread.ThreadSynchronization.ThreeUnsafeExamples;

public class UnsafeBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new Thread(bank,"小王").start();
        new Thread(bank,"小红").start();
        new Thread(bank,"小刘").start();
    }
}

class Acount{
    private String name;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Acount(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

class Bank implements Runnable{
    private Acount acount = new Acount("XXY",2000);
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (Thread.currentThread().getName().equals("小王")){
                try {
                    Thread.sleep(2000);
                    saveMoney(Thread.currentThread().getName(),acount,500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Thread.sleep(1000);
                    drawMoney(Thread.currentThread().getName(),acount,1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void saveMoney(String name,Acount acount,int money){
        acount.setMoney(acount.getMoney()+money);
        System.out.println(name+" 存了: "+money+" 余额: "+acount.getMoney());
    }
    public synchronized void drawMoney(String name,Acount acount,int money){
        if (acount.getMoney()-money<0){
            System.out.println(" 余额不足,剩余: "+acount.getMoney());
        }else {
            acount.setMoney(acount.getMoney()-money);
            System.out.println(name+" 取走: "+money+" 余额: "+acount.getMoney());
        }
    }
}