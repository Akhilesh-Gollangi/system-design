package com.proxy_design_pattern.notes.bad_code;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // pain point: this constructs and loads ALL 100 documents upfront,
        // even though the user might only ever open 2 or 3 of them
        List<Document> documents = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            documents.add(new RealDocument("file" + i + ".txt"));
        }

        // user only opens document #5
        documents.get(4).display();
    }
}
