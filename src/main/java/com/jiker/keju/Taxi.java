package com.jiker.keju;

public class Taxi {
    public static void main(String[] args) {
        Receipt receipt = new Receipt("src/main/resources/testData.txt");
        System.out.println(receipt.bill());
    }
}
