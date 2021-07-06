package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.enums.Gender;
import com.tarabut.puzzle.enums.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.tarabut.puzzle.repository.FighterRepository.readFighter;
import static com.tarabut.puzzle.repository.FighterRepository.saveFighter;

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
        String [][] layout = new String[50][50];
        saveFighter(fighterBo);
    }

    @Test
    public void whenReadFighterObjectOnFile_ThenShouldReturnSuccess() {
        String [][] layout = new String[50][50];
        saveFighter(fighterBo);
        FighterBo fighterBo = readFighter();
        Assert.assertNotNull(fighterBo);
    }
}
