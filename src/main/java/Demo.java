import controller.Control;
import model.map.Area;
import model.Node;
import util.Movable;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Area area = new Area(5, 5);

        Control control = new Control(area);
        Movable<Node> current = control.go(0,0);

        String word;
        Scanner scanner = new Scanner(System.in);
        System.out.println(control.getLocation());
        while (!(word = scanner.nextLine()).equalsIgnoreCase("stop")) {

            switch (word) {
                case ("W"):
                    current.nextI();
                    break;
                case ("S"):
                    current.previousI();
                    break;
                case ("D"):
                    current.nextJ();
                    break;
                case ("A"):
                    current.previousJ();
                    break;
            }
            System.out.println(control.getLocation());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(current);
        }
    }
}
