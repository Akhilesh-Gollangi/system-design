package com.composite_design_pattern.notes;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {

    private String name;
    private List<FileSystemItem> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public long getSize() {
        long total = 0;
        for (FileSystemItem child : children) {
            total += child.getSize();
        }
        return total;
    }
}
