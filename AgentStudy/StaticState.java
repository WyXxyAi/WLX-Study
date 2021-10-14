package AgentStudy;

public class StaticState {
    public static void main(String[] args) {
        Manager manager = new Manager(new I());//代理对象代理真实角色
        manager.SalaryUp();
    }
}
interface RaiseSalary{
    void SalaryUp();
}
//真实对象
class I implements RaiseSalary{
    @Override
    public void SalaryUp() {
        System.out.println("我要加薪了！");
    }
}
//代理对象
class Manager implements RaiseSalary{
    private RaiseSalary who;
    public Manager(RaiseSalary who) {
        this.who = who;
    }
    @Override
    public void SalaryUp() {
        before();
        this.who.SalaryUp();
        after();
    }
    public void before(){
        System.out.println("阻止员工加薪!");
    }
    public void after(){
        System.out.println("祝贺员工加薪!");
    }
}