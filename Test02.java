import java.util.UUID;

public class Test02 {

    public static void main(String[] args) {
        String[] s = new String[5];
        for (int i = 0; i < 5; i++) {
            s[i]=UUID.randomUUID().toString();
            System.out.println(s[i]);
        }

    }
}
