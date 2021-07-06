package com.tarabut.puzzle.process.impl;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.process.Process;
import com.tarabut.puzzle.repository.FighterRepository;
import com.tarabut.puzzle.service.EvilService;
import com.tarabut.puzzle.service.LayoutService;
import com.tarabut.puzzle.service.PlayService;
import com.tarabut.puzzle.service.impl.EvilServiceImpl;
import com.tarabut.puzzle.service.impl.LayoutServiceImpl;
import com.tarabut.puzzle.service.impl.PlayServiceImpl;

import java.util.Scanner;
import java.util.Set;

public class ResumeGameProcessImpl implements Process {

    private EvilService evilService;
    private LayoutService layoutService;
    private PlayService playService;

    public ResumeGameProcessImpl() {
        evilService = new EvilServiceImpl();
        layoutService = new LayoutServiceImpl();
        playService = new PlayServiceImpl();
    }

    @Override
    public void startProcess(Scanner scanner) {
        FighterBo fighterBo = FighterRepository.readFighter();
        Set<EvilBo> evils = evilService.buildEvilsCharacter();
        String [] [] layout = FighterRepository.readLayout();
        playService.play(scanner, fighterBo, evils, layout);
    }
}
