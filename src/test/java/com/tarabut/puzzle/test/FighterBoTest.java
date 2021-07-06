package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.enums.Gender;
import com.tarabut.puzzle.enums.Level;
import org.junit.Assert;
import org.junit.Test;

public class FighterBoTest {

    @Test
    public void whenCreateFighterBoObject_ThenShouldReturnObject() {
        FighterBo fighterBo = new FighterBo();
        fighterBo.setName("Fighter");
        fighterBo.setGender(Gender.FEMALE);
        fighterBo.setLevel(Level.PROFESSIONAL);
        fighterBo.setHealth(50);
        fighterBo.setAttack(50);
        fighterBo.setDefense(50);
        fighterBo.setyPosition(10);
        fighterBo.setxPosition(49);
        Assert.assertNotNull(fighterBo);
    }
}
