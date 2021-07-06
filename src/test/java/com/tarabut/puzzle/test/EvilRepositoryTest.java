package com.tarabut.puzzle.test;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.repository.EvilRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class EvilRepositoryTest {

    @Test
    public void whenCallListOfEvil_ThenShouldReturnListOfEvil() {
        Set<EvilBo> evils = EvilRepository.listOfEvils();
        Assert.assertTrue(!evils.isEmpty());
    }
}
