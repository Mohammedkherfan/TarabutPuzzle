package com.tarabut.puzzle.service.impl;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.repository.EvilRepository;
import com.tarabut.puzzle.service.EvilService;

import java.util.Set;

public class EvilServiceImpl implements EvilService {

    @Override
    public Set<EvilBo> buildEvilsCharacter() {
        Set<EvilBo> evils = EvilRepository.listOfEvils();
        return evils;
    }
}
