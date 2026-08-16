package com.factor_design_pattern.practice.abstract_factor_design_pattern;

public class VictorianFurnitureFactory implements FurnitureFactory{
    @Override
    public IChair createChair() {
        return new VictorianChair();
    }

    @Override
    public ISofa createSofa() {
        return new VictorianSofa();
    }
}
