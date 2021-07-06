package com.tarabut.puzzle.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Level {
    PROFESSIONAL(1), MIDDLE(2), BEGINNER(3);

    private Integer level;

    Level(Integer level) {
        this.level = level;
    }

    private static final Map<Integer, Level> levels = new HashMap<>();

    static {
        Stream.of(values()).forEach(value -> levels.put(value.level, value));
    }

    public static Level from(Integer level) {
        return levels.get(level);
    }

    public Integer getLevel() {
        return level;
    }
}
