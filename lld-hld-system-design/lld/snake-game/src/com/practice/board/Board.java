package com.practice.board;

// This boundary height and width
public class Board {

    private final int height;

    private final int width;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWithBoundary(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }
}
