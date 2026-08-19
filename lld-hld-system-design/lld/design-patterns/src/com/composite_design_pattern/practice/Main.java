package com.composite_design_pattern.practice;

// we have something like tree like structure
// Like Files and Folders
// Composite is Structural Design pattern

public class Main {

    public static void main(String[] args) {
        FileManagementSystem file1 = new File("a","..aa");
        FileManagementSystem file2 = new File("b","..bb");
        Folder folder1 = new Folder("test");

        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder1.display();
    }
}
