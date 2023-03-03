package P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String rankInput=scanner.nextLine();
        String suitInput=scanner.nextLine();

        Card.CardRank rank=Card.CardRank.valueOf(rankInput);
        Card.CardSuit suit=Card.CardSuit.valueOf(suitInput);
        Card card=new Card(rank,suit);

        System.out.printf("Card name: %s; Card power: %d",card.getName(), card.getPower());
    }
}
