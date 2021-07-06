package com.tarabut.puzzle.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum Attack {
    SHOOt(1), DEFENCE(2);

    private Integer attack;

    Attack(Integer attack) {
        this.attack = attack;
    }

    private static final Map<Integer, Attack> attacks = new HashMap<>();

    static {
        Stream.of(values()).forEach(value -> attacks.put(value.attack, value));
    }

    public static Attack from(Integer attack) {
        return attacks.get(attack);
    }

    public Integer getAttack() {
        return attack;
    }
}
