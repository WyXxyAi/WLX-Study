public class Test {
    public void math(int i,int j){
        System.out.print(j/3-i%3+",");
    }
    public static void main(String[] args) {
        for (int j = 0; j < 9; j++) {
            new Test().math(3,j);
        }
    }
}
