package com.tarabut.puzzle.service;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;

import java.util.Set;

public interface LayoutService {

    String [] [] buildLayout(FighterBo fighter, Set<EvilBo> evils);

    void print(String[][] layout);
}
