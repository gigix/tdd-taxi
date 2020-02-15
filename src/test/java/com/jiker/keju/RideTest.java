package com.jiker.keju;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RideTest {
    /*
    1. 不大于2公里时只收起步价6元。
    2. 超过2公里时每公里0.8元。
    3. 超过8公里则每公里加收50%长途费。
    4. 停车等待时加收每分钟0.25元。
    5. 最后计价的时候司机会四舍五入只收到元
     */

    @Test
    public void should_charge_only_6_rmb_if_distance_is_no_more_than_2_km() {
        Ride ride = new Ride(2, 0);
        assertThat(ride.price(), is(6));
    }

    @Test
    public void should_charge_8_mao_for_every_extra_km() {
        Ride ride = new Ride(3, 0);
        assertThat(ride.price(), is(7));
    }
    
    @Test
    public void should_charge_long_distance_fee_if_exceeds_8_km() {
        Ride ride = new Ride(9, 0);
        assertThat(ride.price(), is(12));
        // (8-2)*0.8=4.8
        // (9-8)*1.2=1.2
        // 4.8+1.2+6=12
    }

    @Test
    public void should_charge_idle_fee() {
        Ride ride = new Ride(3, 4);
        assertThat(ride.price(), is(8));
    }

    @Test
    public void should_round_price_properly() {
        Ride ride = new Ride(4, 1);
        assertThat(ride.price(), is(8));
    }
}
