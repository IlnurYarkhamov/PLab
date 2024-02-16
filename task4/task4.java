import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class task4 {
    public static void main(String[] args) throws FileNotFoundException {
        File nums = new File(args[0]);
        Scanner scr = new Scanner(nums);
        List<Integer> numsList = new ArrayList<>();

        while (scr.hasNext()) {
            numsList.add(scr.nextInt());
        }
        int min = Integer.MAX_VALUE;
        for (int i = Collections.min(numsList); i <= Collections.max(numsList); i++) {
            min = Math.min(min, cost(i, numsList));
        }
        System.out.println(min);
    }
    public static int cost(int target, List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int a = Math.abs(target - list.get(i));
            sum += a;
        }
        return sum;
    }
}
