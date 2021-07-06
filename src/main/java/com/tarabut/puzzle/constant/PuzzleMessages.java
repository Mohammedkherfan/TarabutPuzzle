package com.tarabut.puzzle.constant;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;

public class PuzzleMessages {

    public static void callPuzzlePresentation() {
        System.out.println(String.format(PuzzleConstants.STARS));
        System.out.println(String.format(PuzzleConstants.WELCOME_MESSAGE));
        System.out.println(String.format(PuzzleConstants.SELECT_OPTIONS));
        System.out.println(String.format(PuzzleConstants.NEW_GAME));
        System.out.println(String.format(PuzzleConstants.RESUME_GAME));
        System.out.println(String.format(PuzzleConstants.EXIST_GAME));
        System.out.println(String.format(PuzzleConstants.STARS));
    }

    public static void callPuzzleExist() {
        System.out.println(String.format(PuzzleConstants.EXIST));
    }

    public static void callPuzzlePlayOperation() {
        System.out.println(String.format(PuzzleConstants.PLAYING_GUID));
        System.out.println(String.format(PuzzleConstants.MOVE_FORWARD));
        System.out.println(String.format(PuzzleConstants.MOVE_RIGHT));
        System.out.println(String.format(PuzzleConstants.MOVE_LEFT));
        System.out.println(String.format(PuzzleConstants.MOVE_BACKWARD));
        System.out.println(String.format(PuzzleConstants.ESCAPE));
    }

    public static void callPuzzleEscape() {
        System.out.println(String.format(PuzzleConstants.ESCAPE_OPTIONS));
        System.out.println(String.format(PuzzleConstants.CHECK_ATTRIBUTE));
        System.out.println(String.format(PuzzleConstants.SAVE_GAME));
        System.out.println(String.format(PuzzleConstants.EXIST_GAME));
    }

    public static void callPuzzleFighterAttribute(FighterBo fighter) {
        System.out.println(String.format(PuzzleConstants.FIGHTER_ATTRIBUTE));
        System.out.println(String.format(PuzzleConstants.FILL_NAME + " " + fighter.getName()));
        System.out.println(String.format(PuzzleConstants.FILL_GENDER + " " + fighter.getGender()));
        System.out.println(String.format(PuzzleConstants.FILL_LEVEL + " " + fighter.getLevel()));
        System.out.println(String.format(PuzzleConstants.HEALTH + " " + fighter.getHealth()));
        System.out.println(String.format(PuzzleConstants.EXPERIENCE + " " + fighter.getExperienceValue()));
        System.out.println(String.format(PuzzleConstants.ATTACK + " " + fighter.getAttack()));
        System.out.println(String.format(PuzzleConstants.DEFENSE + " " + fighter.getDefense()));
    }

    public static void callPuzzleConfrontation(FighterBo fighter, EvilBo evilBo) {
        System.out.println(PuzzleConstants.FILL_NAME + " " + fighter.getName());
        System.out.println(PuzzleConstants.HEALTH + " " + fighter.getHealth());

        System.out.println(PuzzleConstants.VS);

        System.out.println(PuzzleConstants.EVIL_NAME + " " + evilBo.getName());
        System.out.println(PuzzleConstants.EVIL_HEALTH + " " + evilBo.getHealth());
    }

    public static void callPuzzleAttacking() {
        System.out.println(PuzzleConstants.SPACE);
        System.out.println(PuzzleConstants.START_ATTACK);
        System.out.println(PuzzleConstants.SHOOT_ATTACK);
        System.out.println(PuzzleConstants.DEFENSE_ATTACK);
    }
}
