package Algorithm.Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistributeCandies {
    /**
     *
     */
    public int distributeCandies01(int[] candyType) {
        Set set = new HashSet();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(candyType.length/2,set.size());
    }

    public static void main(String[] args) {
        int[] candyType = {1,1,2,3};
        System.out.println(new DistributeCandies().distributeCandies01(candyType));
    }
}
