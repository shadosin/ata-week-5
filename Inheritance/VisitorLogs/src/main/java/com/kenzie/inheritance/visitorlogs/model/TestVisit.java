package com.kenzie.inheritance.visitorlogs.model;

public class TestVisit extends Visit{
    @Override
    public char getVisitCharacter() {
        return ' ';
    }

    @Override
    public VisitColor getVisitColor() {
        return VisitColor.TEST_VISITOR_COLOR;
    }
}
