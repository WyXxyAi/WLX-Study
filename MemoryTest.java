public class MemoryTest {
    static TestM t1 = new TestM();
    TestM t2 = new TestM();
    public void M(){
        TestM t3 = new TestM();
    }
}
class TestM{}
class Main{
    public static void main(String[] args) {
        MemoryTest mT = new MemoryTest();
        mT.M();
        while (true){

        }
    }
}