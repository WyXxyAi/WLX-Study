package MultiThread.ThreadSynchronization.SafeExamples;

public class UnsafeBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new Thread(bank,"付出").start();
        new Thread(bank,"收获").start();
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
    @Override
    public void run() {
        Acount acount = new Acount("XXY",2000);
        for (int i = 0; i < 10; i++) {
            if (Thread.currentThread().getName().equals("付出")){
                try {
                    Thread.sleep(2000);
                    saveMoney(Thread.currentThread().getName(),acount,500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Thread.sleep(1000);
                    drawMoney(Thread.currentThread().getName(),acount,1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void saveMoney(String name,Acount acount,int money){
        acount.setMoney(acount.getMoney()+money);
        System.out.println(name+" 存了: "+money+" 余额: "+acount.getMoney());
    }
    public void drawMoney(String name,Acount acount,int money){
        if (acount.getMoney()-money<0){
            System.out.println(" 余额不足,剩余: "+acount.getMoney());
        }
        acount.setMoney(acount.getMoney()-money);
        System.out.println(name+" 取走: "+money+" 余额: "+acount.getMoney());
    }
}