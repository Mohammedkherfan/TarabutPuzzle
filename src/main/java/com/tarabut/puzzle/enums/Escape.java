package com.tarabut.puzzle.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Escape {

    CHECK_ATTRIBUTE(1), SAVE_GAME(2), EXIST_GAME(3);

    public Integer escape;

    Escape(Integer escape) {
        this.escape = escape;
    }

    private static final Map<Integer, Escape> escapeMap = new HashMap<>();

    static {
        Stream.of(values()).forEach(value -> escapeMap.put(value.escape, value));
    }

    public static Escape from(Integer escape) {
        return escapeMap.get(escape);
    }

    public Integer getEscape() {
        return escape;
    }
}
