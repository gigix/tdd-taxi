package com.jiker.keju;

public class Distance {
    private final int total;

    public Distance(int total) {
        this.total = total;
    }

    public int amountOfBasic() {
        return 2;
    }

    public int amountOfExtra() {
        return total > 2 ? total - 2 : 0;

    }

    public int amountOfLong() {
        return total > 8 ? total - 8 : 0;
    }

    public double price() {
        return amountOfBasic() * 3 + amountOfExtra() * 0.8 + amountOfLong() * 0.4;
    }
}
