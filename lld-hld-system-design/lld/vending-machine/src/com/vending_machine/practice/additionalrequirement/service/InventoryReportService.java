package com.vending_machine.practice.additionalrequirement.service;

import com.vending_machine.practice.additionalrequirement.machine.Slot;

import java.util.List;

public class InventoryReportService {

    public boolean hasStock(List<Slot> slots) {
        for(Slot slot:slots) {
            if(slot.hasStock()) {
                return true;
            }
        }
        return false;
    }
}
