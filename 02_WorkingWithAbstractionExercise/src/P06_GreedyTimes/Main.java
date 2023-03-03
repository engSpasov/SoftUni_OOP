package P06_GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safe.length; i += 2) {

            String item = safe[i];
            String itemType = parseItemType(item);
            long itemQuantity = Long.parseLong(safe[i + 1]);

            if (itemType == null) {
                continue;
            }

            if (!bag.hasEnoughFreeCapacity(itemQuantity)) {
                continue;
            }

            if(bag.canPut(itemType,itemQuantity)){
                bag.putItem(itemType,item,itemQuantity);
            }
        }

        bag.printBag();
    }
    private static String parseItemType(String name) {
        String itemType = null;

        if (name.length() == 3) {
            itemType = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            itemType = "Gold";
        }
        return itemType;
    }
}
