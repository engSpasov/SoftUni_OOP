package P04_TrafficLights;

public class Trafficlight {

    enum Lights {
        RED,
        GREEN,
        YELLOW,
    }

    private Lights light;

    public Trafficlight(Lights light) {
        this.light = light;
    }

    public Lights getLight() {
        return light;
    }

    public void update() {

        switch (this.light) {
            case RED:
                this.light = Lights.GREEN;
                break;
            case GREEN:
                this.light = Lights.YELLOW;
                break;
            case YELLOW:
                this.light = Lights.RED;
                break;
            default: throw new IllegalArgumentException("unknown light"+this.light);
        }
    }
}
