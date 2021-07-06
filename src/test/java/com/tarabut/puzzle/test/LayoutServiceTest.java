package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.enums.Gender;
import com.tarabut.puzzle.enums.Level;
import com.tarabut.puzzle.repository.EvilRepository;
import com.tarabut.puzzle.service.LayoutService;
import com.tarabut.puzzle.service.impl.LayoutServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class LayoutServiceTest {

    private LayoutService layoutService;
    private FighterBo fighterBo;

    @Before
    public void setUp() throws Exception {
        layoutService = new LayoutServiceImpl();
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
    public void whenCallLayout_ThenShouldReturnLayout() {
        String[][] strings = layoutService.buildLayout(fighterBo, EvilRepository.listOfEvils());
        Assert.assertTrue(strings.length != 0);
    }
}
