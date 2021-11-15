package DesignPattern;

import java.util.ArrayList;

/**
 * 如果老板回屋，则所有人停止摸鱼
 * */
public class ObserverMode {
}
//观察者接口
interface Observers{
    public void update();
}
//被观察对象
class Subject{
    private ArrayList<Observers> observers = new ArrayList<>();
    public void addObserver(Observers observer){
        this.observers.add(observer);
    }
    public void tellAllObservers(){
        for (Observers observer : this.observers) {
            observer.update();
        }
    }
}
//具体观察者
class Observer implements Observers{
    String name;
    public Observer(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public void update() {
        System.out.println(this.getName()+" Stop fishing!");
    }
}
//被观察者行为之类
class Boss extends Subject{
    public void comeHere(){
        System.out.println("Boss come!");
        this.tellAllObservers();
    }
}
class Test{
    public static void main(String[] args) {
        //观察者
        Observer xiaoWan = new Observer("xiaoWan");
        Observer xiaoCheng = new Observer("xiaoCheng");
        //被观察者
        Boss boss = new Boss();
        //添加观察者
        boss.addObserver(xiaoWan);
        boss.addObserver(xiaoCheng);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i==6){
                boss.comeHere();
            }
        }
    }
}