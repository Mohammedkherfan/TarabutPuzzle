package com.tarabut.puzzle.operation;

import com.tarabut.puzzle.constant.PuzzleConstants;
import com.tarabut.puzzle.constant.PuzzleMessages;
import com.tarabut.puzzle.enums.PuzzleOperation;
import com.tarabut.puzzle.exception.PuzzleException;
import com.tarabut.puzzle.process.Process;
import com.tarabut.puzzle.process.impl.ExitGameProcessImpl;
import com.tarabut.puzzle.process.impl.NewGameProcessImpl;
import com.tarabut.puzzle.process.impl.ResumeGameProcessImpl;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class Puzzle {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        PuzzleMessages.callPuzzlePresentation();

        Integer choice = scanner.nextInt();
        PuzzleOperation puzzleOperation = getPuzzleOperation(choice);

        Process process = null;
        switch (puzzleOperation) {
            case NEW_GAME: {
                process = new NewGameProcessImpl();
            } break;
            case RESUME_GAME: {
                process = new ResumeGameProcessImpl();
            } break;
            case EXIST_GAME: {
                process = new ExitGameProcessImpl();
            } break;
        }
        process.startProcess(scanner);
    }

    private PuzzleOperation getPuzzleOperation(Integer choice) {
        PuzzleOperation puzzleOperation = PuzzleOperation.from(choice);
        if (isNull(puzzleOperation))
            throw new PuzzleException(PuzzleConstants.ERROR_TRY_AGAIN);
        else
            return puzzleOperation;
    }


}
