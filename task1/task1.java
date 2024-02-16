import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if(n < 1) {
           throw new IllegalArgumentException("Переменная n не должна быть меньше единицы");
        }
        int m = Integer.parseInt(args[1]);
        if(m < 1) {
            throw new IllegalArgumentException("Переменная m не должна быть меньше единицы");
        }

        int[] circularArray = new int[n];
        for (int i = 0; i < circularArray.length; i++) {
            circularArray[i] = i+1;
        }
        System.out.print(circularArray[0]);
        for (int i = m-1; ; i+=m-1) {
            if (i%circularArray.length == 0) break;
            System.out.print(circularArray[i % circularArray.length]);
        }
    }
}
