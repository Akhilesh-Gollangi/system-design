package com.factor_design_pattern.practice.abstract_factor_design_pattern;

public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public IChair createChair() {
        return new ModernChair();
    }

    @Override
    public ISofa createSofa() {
        return new ModernSofa();
    }
}
