package com.tarabut.puzzle.test;

import com.tarabut.puzzle.enums.*;
import org.junit.Assert;
import org.junit.Test;

public class EnumsTest {

    @Test
    public void AttackEnumTest_OutOfBoundaryValue() {
        Attack attack = Attack.from(3);
        Assert.assertNull(attack);
    }

    @Test
    public void AttackEnumTest() {
        Attack attack = Attack.from(1);
        Assert.assertNotNull(attack);
    }

    @Test
    public void EscapeEnumTest_OutOfBoundaryValue() {
        Escape escape = Escape.from(4);
        Assert.assertNull(escape);
    }

    @Test
    public void EscapeEnumTest() {
        Escape escape = Escape.from(1);
        Assert.assertNotNull(escape);
    }

    @Test
    public void GenderEnumTest_OutOfBoundaryValue() {
        Gender gender = Gender.from(4);
        Assert.assertNull(gender);
    }

    @Test
    public void GenderEnumTest() {
        Gender gender = Gender.from(1);
        Assert.assertNotNull(gender);
    }

    @Test
    public void LevelEnumTest_OutOfBoundaryValue() {
        Level level = Level.from(4);
        Assert.assertNull(level);
    }

    @Test
    public void LevelEnumTest() {
        Level level = Level.from(1);
        Assert.assertNotNull(level);
    }

    @Test
    public void PlayOperationEnumTest_OutOfBoundaryValue() {
        PlayOperation playOperation = PlayOperation.from(6);
        Assert.assertNull(playOperation);
    }

    @Test
    public void PlayOperationEnumTest() {
        PlayOperation playOperation = PlayOperation.from(1);
        Assert.assertNotNull(playOperation);
    }

    @Test
    public void PuzzleOperationEnumTest_OutOfBoundaryValue() {
        PuzzleOperation puzzleOperation = PuzzleOperation.from(4);
        Assert.assertNull(puzzleOperation);
    }

    @Test
    public void PuzzleOperationEnumTest() {
        PuzzleOperation puzzleOperation = PuzzleOperation.from(1);
        Assert.assertNotNull(puzzleOperation);
    }
}
