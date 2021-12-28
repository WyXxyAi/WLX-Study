package Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ScheduleCourse {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (int i = 0; i < courses.length; i++) {
            System.out.println(Arrays.toString(courses[i]));
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses));
    }
}
