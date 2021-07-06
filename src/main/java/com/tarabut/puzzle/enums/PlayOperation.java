package com.tarabut.puzzle.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum PlayOperation {
    MOVE_FORWARD(1), MOVE_RIGHT(2), MOVE_LEFT(3), MOVE_BACKWARD(4), ESCAPE(5);

    private Integer operation;

    PlayOperation(Integer operation) {
        this.operation = operation;
    }

    private static final Map<Integer, PlayOperation> operations = new HashMap<>();

    static {
        Stream.of(values()).forEach(value -> operations.put(value.operation, value));
    }

    public static PlayOperation from(Integer operation) {
        return operations.get(operation);
    }

    public Integer getOperation() {
        return operation;
    }
}
