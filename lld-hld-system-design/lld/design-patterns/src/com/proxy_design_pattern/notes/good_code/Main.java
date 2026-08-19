package com.proxy_design_pattern.notes.good_code;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Document> documents = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            documents.add(new DocumentProxy("file" + i + ".txt"));
        }
        // building this list is now instant — zero disk loading happened yet

        // only when we actually display document #5 does loadFromDisk() run,
        // and only for that one file
        documents.get(4).display();

        // calling display() again on the same proxy is fast now,
        // since realDocument is already cached from the first call
        documents.get(4).display();
    }
}
