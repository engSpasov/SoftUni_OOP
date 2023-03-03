package P04_HotelReservation;

public enum Discount {
    VIP(0.2), SecondVisit(0.1), None(0.0);
    private final double rate;

    Discount(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
