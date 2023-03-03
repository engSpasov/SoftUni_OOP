package P04_TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLights = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        Trafficlight[] trafficlights=new Trafficlight[inputLights.length];

        for (int i = 0; i < inputLights.length; i++) {
            Trafficlight t = new Trafficlight(Trafficlight.Lights.valueOf(inputLights[i]));
            trafficlights[i]=t;
        }

        for (int i = 0; i < n; i++) {
            updateTrafickLights(trafficlights);
            printTraffickLights(trafficlights);
        }

    }

    private static void printTraffickLights(Trafficlight[] trafficlights) {
        for(Trafficlight t:trafficlights){
            System.out.print(t.getLight()+" ");
        }
        System.out.println();
    }

    private static void updateTrafickLights(Trafficlight[] trafficlights) {
        for (Trafficlight t:trafficlights){
            t.update();
        }

    }
}
