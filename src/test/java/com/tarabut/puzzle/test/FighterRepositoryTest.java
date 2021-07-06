package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.enums.Gender;
import com.tarabut.puzzle.enums.Level;
import com.tarabut.puzzle.repository.FighterRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.tarabut.puzzle.repository.FighterRepository.*;

public class FighterRepositoryTest {

    private FighterBo fighterBo;

    @Before
    public void setUp() throws Exception {
        fighterBo = new FighterBo();
        fighterBo.setName("Fighter");
        fighterBo.setGender(Gender.FEMALE);
        fighterBo.setLevel(Level.PROFESSIONAL);
        fighterBo.setHealth(50);
        fighterBo.setAttack(50);
        fighterBo.setDefense(50);
        fighterBo.setyPosition(10);
        fighterBo.setxPosition(49);
    }

    @Test
    public void whenWriteFighterObjectOnFile_ThenShouldReturnSuccess() {
        save(fighterBo);
    }

    @Test
    public void whenReadFighterObjectOnFile_ThenShouldReturnSuccess() {
        save(fighterBo);
        FighterBo fighterBo = read();
        Assert.assertNotNull(fighterBo);
    }
}
