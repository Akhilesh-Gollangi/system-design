package com.proxy_design_pattern;

// the problem here
// we create object it will take some  time to create object because loadFromdisk has complex logic and operaitons
public class RealDocument implements Document{
    private String name;

    public RealDocument(String name) {
         this.name = name;
         loadFromDisk();
    }

    public void loadFromDisk() {
        System.out.println("Loading from disk");
    }

    @Override
    public void display() {
        System.out.println("Displaying the document");
    }
}
