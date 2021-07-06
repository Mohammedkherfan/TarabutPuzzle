package com.tarabut.puzzle.service;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;

import java.util.Scanner;
import java.util.Set;

public interface PlayService {
    void play(Scanner scanner, FighterBo fighter, Set<EvilBo> evils, String[][] layout);
}
