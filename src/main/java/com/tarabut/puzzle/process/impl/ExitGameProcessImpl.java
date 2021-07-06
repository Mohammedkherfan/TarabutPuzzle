package com.tarabut.puzzle.process.impl;

import com.tarabut.puzzle.constant.PuzzleConstants;
import com.tarabut.puzzle.process.Process;

import java.util.Scanner;

public class ExitGameProcessImpl implements Process {

    @Override
    public void startProcess(Scanner scanner) {
        System.exit(0);
        System.out.println(String.format(PuzzleConstants.EXIST));
    }
}
