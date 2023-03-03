package P02_CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        CardRank[] values = CardRank.values();
        for(CardRank value:values){
            System.out.printf("Ordinal value: %d; Name value: %s%n",value.ordinal(),value.name());
        }
    }
}
