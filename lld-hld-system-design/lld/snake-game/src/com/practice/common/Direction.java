package com.practice.common;

public enum Direction {

    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int deltaRow;
    private final int deltaCol;

    Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }

    public int getDeltaRow() {
        return deltaRow;
    }

    public int getDeltaCol() {
        return deltaCol;
    }
}

/*
    (0,0), (0,1)
    (1,0), (1,1)

    up -> I at (1,1) has to move to up means (0,1) row reduced by 1, col remain same no change
    down -> I at (0,1) has to move down mean (1,1) row increase by 1, col remain same no change
    left -> I at (1,1) has to move left, mean (1,0) row remain same no change, col reduced by 1
    right -> I at (1,0) has to move right, mean (1,1) row remain same no change, col increased by 1
 */
