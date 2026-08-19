package com.proxy_design_pattern.notes.good_code;

public class DocumentProxy implements Document {

    private String filename;
    private RealDocument realDocument;

    public DocumentProxy(String filename) {
        this.filename = filename;
        // note: no loading happens here — construction is now cheap
    }

    @Override
    public void display() {
        if (realDocument == null) {
            realDocument = new RealDocument(filename);
        }
        realDocument.display();
    }
}
