package com.kenzie.inheritance.visitorlogs.model;

public class InvalidVisit extends Visit {

    @Override
    public char getVisitCharacter() {
        return 'X';
    }

    @Override
    public VisitColor getVisitColor() {
        return VisitColor.INVALID_COLOR;
    }
}
