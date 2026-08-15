package com.factor_design_pattern.notes.abstract_factor_design_pattern;

public class FurnitureStore {

    private FurnitureFactory furnitureFactory;

    public FurnitureStore() {

    }

    public FurnitureStore(FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    public void setFurnitureFactory(FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    public void furnish() {
        IChair chair = furnitureFactory.createChair();
        ISofa sofa = furnitureFactory.createSofa();
        chair.sitson();
        sofa.lieson();
    }
}
