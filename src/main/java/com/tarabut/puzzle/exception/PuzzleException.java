package com.tarabut.puzzle.exception;

import com.tarabut.puzzle.constant.PuzzleConstants;

public class PuzzleException extends RuntimeException {

    public PuzzleException() {
    }

    public PuzzleException(String message) {
        super(message);
        System.out.println(String.format(PuzzleConstants.ERROR_TRY_AGAIN));
    }

    public PuzzleException(String message, Throwable cause) {
        super(message, cause);
    }

    public PuzzleException(Throwable cause) {
        super(cause);
    }

    public PuzzleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
