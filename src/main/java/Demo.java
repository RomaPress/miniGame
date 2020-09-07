import controller.Control;
import model.map.Area;
import model.Node;
import util.Movable;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Area area = new Area(5, 5);

        Control control = new Control(area);
        Movable<Node> current = control.go(0, 0);

        String word;
        Scanner scanner = new Scanner(System.in);
        System.out.println(control.getLocation());
        while (!(word = scanner.nextLine()).equalsIgnoreCase("stop")) {

            switch (word) {
                case ("W"):
                    current.nextY();
                    break;
                case ("S"):
                    current.previousY();
                    break;
                case ("D"):
                    current.nextX();
                    break;
                case ("A"):
                    current.previousX();
                    break;
            }
            System.out.println(control.getLocation());
        }
    }
}
