package com.codeclan.example.CourseBookingSystem.models;

public enum CourseRating {

    ONESTAR(1),
    TWOSTAR(2),
    THREESTAR(3),
    FOURSTAR(4),
    FIVESTAR(5);

    private final int value;

    CourseRating(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
