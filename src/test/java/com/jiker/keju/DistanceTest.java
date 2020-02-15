package com.jiker.keju;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class DistanceTest {
    @Test
    public void should_separate_3_types_of_distances() {
        Distance shortDistance = new Distance(1);
        assertThat(shortDistance.amountOfBasic(), is(2));
        assertThat(shortDistance.amountOfExtra(), is(0));
        assertThat(shortDistance.amountOfLong(), is(0));

        Distance midDistance = new Distance(5);
        assertThat(midDistance.amountOfBasic(), is(2));
        assertThat(midDistance.amountOfExtra(), is(3));
        assertThat(midDistance.amountOfLong(), is(0));

        Distance longDistance = new Distance(10);
        assertThat(longDistance.amountOfBasic(), is(2));
        assertThat(longDistance.amountOfExtra(), is(8));
        assertThat(longDistance.amountOfLong(), is(2));
    }

    @Test
    public void should_calculate_distance_charge_properly() {
        assertThat(new Distance(1).price(), is(6d));
        assertThat(new Distance(3).price(), is(6.8));
        assertThat(new Distance(10).price(), closeTo(13.2, 0.0001));
    }
}
