package com.jiker.keju;

import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;

public class Receipt {
    private final List<ReceiptItem> receiptItems;

    public Receipt(String filePath) {
        try {
            receiptItems = readAllLines(get(filePath)).stream().map(ReceiptItem::new).collect(toList());
        }catch (IOException e) {
            throw new InvalidInput(filePath);
        }
    }

    public int size() {
        return receiptItems.size();
    }

    public String bill() {
        List<String> chargeLines = receiptItems.stream().map(ReceiptItem::chargeLine).collect(toList());
        return String.join("\n", chargeLines);
    }
}
