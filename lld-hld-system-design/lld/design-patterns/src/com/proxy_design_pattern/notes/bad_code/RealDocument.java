package com.proxy_design_pattern.notes.bad_code;

public class RealDocument implements Document {

    private String filename;

    public RealDocument(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk... (slow)");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
