package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.EvilBo;
import org.junit.Assert;
import org.junit.Test;

public class EvilBoTest {

    @Test
    public void whenCreateEvilBoObject_ThenShouldReturnObject() {
        EvilBo evilBo = new EvilBo("name", 10, 10, 10, 10,  1, 49);
        Assert.assertNotNull(evilBo);
    }
}
