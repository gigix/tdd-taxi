package com.jiker.keju;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReceiptTest {

    private Receipt receipt;

    @Before
    public void setUp() {
        receipt = new Receipt("src/main/resources/testData.txt");
    }

    @Test
    public void should_parse_receipt_items() {
        assertThat(receipt.size(), is(4));
    }

    @Test(expected = InvalidInput.class)
    public void should_deal_with_invalid_input() {
        new Receipt("file/does/not/exist");
    }

    @Test
    public void should_generate_bill() {
        String bill = receipt.bill();
        assertThat(bill, is(
                "收费6元\n" +
                "收费7元\n" +
                "收费13元\n" +
                "收费7元"));
    }
}
