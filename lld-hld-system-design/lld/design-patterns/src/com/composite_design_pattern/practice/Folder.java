package com.composite_design_pattern.practice;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileManagementSystem{
    private String name;
    private List<FileManagementSystem> fileManagementSystemList;

    public Folder(String name) {
        this.name = name;
        this.fileManagementSystemList = new ArrayList<>();
    }


    // this function is composite design pattern
    // where child method called everytime
    @Override
    public void display() {
        for(FileManagementSystem component:fileManagementSystemList) {
            component.display();
        }
    }

    public void addComponent(FileManagementSystem fileManagementSystem) {
        // we can add file or folder
        fileManagementSystemList.add(fileManagementSystem);
    }

}
