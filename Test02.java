import java.util.UUID;

class Test01 {
    private int a = 0;
    private static Test01 t1 = null;
    private Test01() {}
    public static Test01 getTest01(){
        t1 = t1==null?new Test01():t1;
        return t1;
    }
    public void init (){
        this.a = 0;
    }
    public void setA(int a){
        this.a=a;
    }
}

public class Test02 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Test01 ts = Test01.getTest01();
            System.out.println(ts);
        }
    }

}
