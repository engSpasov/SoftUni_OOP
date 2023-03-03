package P06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag=new Bag(capacity);

        for (int i = 0; i < safe.length; i += 2) {
            String item = safe[i];
            String itemType = ParseItemType(item);
            long itemQuantity = Long.parseLong(safe[i + 1]);

            if(itemType==null){
                continue;
            }

            if(!bag.hasCapacity(itemQuantity)){
                continue;
            }

           if(bag.canPutNewItem(itemType,itemQuantity)){
               bag.putItem(item, itemType, itemQuantity);
           }

        }

        bag.print();
    }

    private static String ParseItemType(String item) {
        String type=null;
        if (item.length() == 3) {
            type = "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            type = "Gem";
        } else if (item.equalsIgnoreCase("gold")) {
            type = "Gold";
        }
        return type;
    }
}
