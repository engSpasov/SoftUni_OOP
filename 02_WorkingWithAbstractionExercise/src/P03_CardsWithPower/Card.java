package P03_CardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public String getName() {
        return this.rank +" of "+ this.suit;
    }
    public int getPower() {
        return this.rank.getPower()+this.suit.getPower();
    }

    public enum CardRank {
        ACE(14),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(8),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private int power;

        CardRank(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public enum CardSuit {
        CLUBS(0),
        DIAMONDS(13),
        HEARTS(26),
        SPADES(39);

        private int power;

        CardSuit(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }


}
