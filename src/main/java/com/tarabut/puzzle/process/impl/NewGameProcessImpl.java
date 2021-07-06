package com.tarabut.puzzle.process.impl;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.process.Process;
import com.tarabut.puzzle.service.EvilService;
import com.tarabut.puzzle.service.FighterService;
import com.tarabut.puzzle.service.LayoutService;
import com.tarabut.puzzle.service.PlayService;
import com.tarabut.puzzle.service.impl.EvilServiceImpl;
import com.tarabut.puzzle.service.impl.FighterServiceImpl;
import com.tarabut.puzzle.service.impl.LayoutServiceImpl;
import com.tarabut.puzzle.service.impl.PlayServiceImpl;

import java.util.Scanner;
import java.util.Set;

public class NewGameProcessImpl implements Process {

    private FighterService fighterService;
    private EvilService evilService;
    private LayoutService layoutService;
    private PlayService playService;

    public NewGameProcessImpl() {
        fighterService = new FighterServiceImpl();
        evilService = new EvilServiceImpl();
        layoutService = new LayoutServiceImpl();
        playService = new PlayServiceImpl();
    }

    @Override
    public void startProcess(Scanner scanner) {
        FighterBo fighter = fighterService.buildFighterCharacter(scanner);
        Set<EvilBo> evils = evilService.buildEvilsCharacter();
        String [] [] layout = layoutService.buildLayout(fighter, evils);

        playService.play(scanner, fighter, evils, layout);

    }
}
