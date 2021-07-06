package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.service.EvilService;
import com.tarabut.puzzle.service.impl.EvilServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class EvilServiceTest {

    private EvilService evilService;

    @Before
    public void setUp() throws Exception {
        evilService = new EvilServiceImpl();
    }

    @Test
    public void whenCallEvilService_ThenShouldReturnListOfEvils() {
        Set<EvilBo> set = evilService.buildEvilsCharacter();
        Assert.assertTrue(!set.isEmpty());
    }
}
