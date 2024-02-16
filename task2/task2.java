import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws FileNotFoundException {
        String pathFileTo1 = args[0];
        String pathFileTo2 = args[1];

        Scanner scr1 = new Scanner(new File(pathFileTo1));
        Scanner scr2 = new Scanner(new File(pathFileTo2));

        double coordinateX = scr1.nextDouble();
        double coordinateY = scr1.nextDouble();
        double radius = scr1.nextDouble();

        while (scr2.hasNext()) {
            double x = scr2.nextDouble();
            double y = scr2.nextDouble();
            double distance = Math.sqrt(Math.pow(x-coordinateX, 2) + Math.pow(y - coordinateY, 2));
            if(distance > radius) {
                System.out.println(2);
            }
            else if (distance < radius) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
