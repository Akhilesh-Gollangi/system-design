package com.proxy_design_pattern;

public class DocumentProxy implements Document{
    private String name;
    private RealDocument realDocument;

    public DocumentProxy(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if(realDocument==null) {
            realDocument = new RealDocument(name);
        }
        realDocument.display();
    }
}
