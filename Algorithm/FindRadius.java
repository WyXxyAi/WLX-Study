package Algorithm;

public class FindRadius {
    public static int findRadius(int[] houses,int[] heaters){
        int r=houses[houses.length-1]%2==0?houses[houses.length-1]/2:(houses[houses.length-1]+1)/2;
        while (check(houses,heaters,r)&&r!=1){
            r=r%2==0?r/2:(r+1)/2;
        }
        return r;
    }
    public static boolean check(int[] houses,int[] heaters,int r){
        for (int i = 0; i < heaters.length; i++) {
            for (int j = 0; j < houses.length; j++) {
                if (houses[j]<(heaters[i]+r)&&houses[j]>(heaters[i]-r)){
                    houses[j]=0;
                }
            }
        }
        for (int i = 0; i < houses.length; i++) {
            if (houses[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] houses={1,5};
        int[] heaters={10};
        System.out.println(findRadius(houses,heaters));
    }
}
