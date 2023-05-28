package com.kenzie.inheritance.visitorlogs.model;

public class ZapposAccountVisit extends Visit {
    @Override
    public char getVisitCharacter() {
        return '@';
    }

    @Override
    public VisitColor getVisitColor() {
        return VisitColor.ZAPPOS_VISITOR_COLOR;
    }
}
