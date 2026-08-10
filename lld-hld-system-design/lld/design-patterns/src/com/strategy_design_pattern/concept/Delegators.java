package com.strategy_design_pattern.concept;

// This is context class
// which acts as Intermidate between client and concerte classes
public class Delegators {

    private IParent parent;

    public Delegators() {
    }

    public Delegators(IParent parent) {
        this.parent = parent;
    }

    public void setParent(IParent parent) {
        this.parent = parent;
    }

    public void process() {

        parent.print(); //runtime polymorphism
    }
}
