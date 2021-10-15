package LamdaStudy;

interface Mylove{
    void myLoveWho(String name);
}

public class Lamda02 {
    public static void main(String[] args) {
        //1.普通lamda
        Mylove mylove = ((String name)->{
            System.out.println(name);
        });
        //2.简化参数类型
        mylove = (name -> {
            System.out.println(name);
        });
        //3.简化方法体
        mylove = name -> System.out.println(name);


    }
}
