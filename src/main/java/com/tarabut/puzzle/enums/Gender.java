package com.tarabut.puzzle.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Gender {
    MALE(1), FEMALE(2);

    private Integer gender;

    Gender(Integer gender) {
        this.gender = gender;
    }

    private static final Map<Integer, Gender> genders = new HashMap<>();

    static {
        Stream.of(values()).forEach(value -> genders.put(value.gender, value));
    }

    public static Gender from(Integer gender) {
        return genders.get(gender);
    }

    public Integer getGender() {
        return gender;
    }
}
