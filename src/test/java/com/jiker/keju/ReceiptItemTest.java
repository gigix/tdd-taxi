package com.jiker.keju;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReceiptItemTest {
    @Test
    public void should_create_ride_object_accordingly() {
        ReceiptItem receiptItem = new ReceiptItem("1公里,等待0分钟");
        Ride ride = receiptItem.toRide();
        assertThat(ride.price(), is(6));
    }

    @Test(expected = InvalidInput.class)
    public void should_deal_with_inappropriate_text() {
        ReceiptItem receiptItem = new ReceiptItem("错误的输入");
        receiptItem.toRide();
    }

    @Test
    public void should_generate_charge_line() {
        ReceiptItem receiptItem = new ReceiptItem("2公里,等待3分钟");
        assertThat(receiptItem.chargeLine(), is("收费7元"));
    }
}
