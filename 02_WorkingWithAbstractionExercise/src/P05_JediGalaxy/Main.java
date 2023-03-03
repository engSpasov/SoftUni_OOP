package P05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] initialMatrix = new int[dimensions[0]][dimensions[1]];

        Galaxy galaxy = new Galaxy(initialMatrix);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] jediCoordinatesArr = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            Coordinates jediCoordinates = new Coordinates(jediCoordinatesArr[0], jediCoordinatesArr[1]);

            int[] evilCoordinatesArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Coordinates evilCoordinates = new Coordinates(evilCoordinatesArr[0], evilCoordinatesArr[1]);

            galaxy.moveEvil(evilCoordinates);
            sum += galaxy.moveJediAndCollectStars(jediCoordinates);


            command = scanner.nextLine();
        }

        System.out.println(sum);

    }
}
