package com.composite_design_pattern.practice;

public class File implements FileManagementSystem {

    private String name;
    private String filePath;

    public File(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void display() {
        System.out.println("File Name: " + name + ", File Path: " + filePath);
    }
}