import controller.Control;
import model.Area;
import model.Node;
import util.Movable;

import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Area area = new Area(10, 10);

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

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(current);
        }
    }
}
