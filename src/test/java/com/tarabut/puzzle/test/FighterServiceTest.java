package com.tarabut.puzzle.test;

import com.tarabut.puzzle.service.FighterService;
import com.tarabut.puzzle.service.impl.FighterServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class FighterServiceTest {

    private FighterService fighterService;

    @Before
    public void setUp() throws Exception {
        fighterService = new FighterServiceImpl();
    }

    @Test
    public void whenCallFighterService_ThenShouldReturnFighterObject() {

    }
}
