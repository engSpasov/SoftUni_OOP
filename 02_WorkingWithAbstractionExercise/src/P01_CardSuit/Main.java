package P01_CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        CardSuit[] values = CardSuit.values();
        for(CardSuit value:values){
            System.out.printf("Ordinal value: %d; Name value: %s%n",value.ordinal(),value.name());
        }

    }
}
