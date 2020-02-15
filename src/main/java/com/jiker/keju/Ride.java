package com.jiker.keju;

import static java.lang.Math.round;

public class Ride {
    private final Distance distance;
    private final int idle;

    public Ride(int distance, int idle) {
        this.distance = new Distance(distance);
        this.idle = idle;
    }

    public int price() {
        double result = distance.price() + idle * 0.25;
        return (int) round(result);
    }
}
