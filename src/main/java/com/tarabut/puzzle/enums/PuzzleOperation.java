package com.tarabut.puzzle.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum PuzzleOperation {
    NEW_GAME(1, "New Game"),
    RESUME_GAME(2, "Resume Game"),
    EXIST_GAME(3, "Exist Game");

    private Integer code;
    private String description;

    PuzzleOperation(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    private static final Map<Integer, PuzzleOperation> codes = new HashMap<>();

    static {
        Stream.of(values()).forEach(value -> codes.put(value.code, value));
    }

    public static PuzzleOperation from(Integer code) {
        return codes.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
