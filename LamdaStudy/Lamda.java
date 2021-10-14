package LamdaStudy;

interface GoOffWork{
    void goOffWork();
}
//1.实现类
class I1 implements GoOffWork{
    @Override
    public void goOffWork() {
        System.out.println("我下班 1 次！");
    }
}

public class Lamda {
    //2.静态内部类
    static class I2 implements GoOffWork{
        @Override
        public void goOffWork() {
            System.out.println("我下班 2 次！");
        }
    }

    public static void main(String[] args) {
        //3.局部内部类
        class I3 implements GoOffWork{
            @Override
            public void goOffWork() {
                System.out.println("我下班 3 次！");
            }
        }

        //4.匿名内部类
        GoOffWork i4 = new GoOffWork() {
            @Override
            public void goOffWork() {
                System.out.println("我下班 4 次！");
            }
        };

        //5.lamda简化
        GoOffWork i5 = () ->{System.out.println("我下班 5 次！");};
        I1 i1 = new I1();i1.goOffWork();
        I2 i2 = new I2();i2.goOffWork();
        I3 i3 = new I3();i3.goOffWork();
        i4.goOffWork();
        i5.goOffWork();




    }
}
