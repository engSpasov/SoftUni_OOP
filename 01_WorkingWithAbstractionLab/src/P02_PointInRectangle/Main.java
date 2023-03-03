package P02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] pointsCoordinates= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeft=new Point(pointsCoordinates[0],pointsCoordinates[1]);
        Point topRight=new Point(pointsCoordinates[2],pointsCoordinates[3]);
        Rectangle rectangle=new Rectangle(bottomLeft,topRight);

        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Point currentPoint=PointUtil.parsePoint(scanner.nextLine());
            System.out.println(rectangle.contains(currentPoint));
        }
    }
}
