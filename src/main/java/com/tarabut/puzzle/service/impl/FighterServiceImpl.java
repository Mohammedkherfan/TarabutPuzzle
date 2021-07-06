package com.tarabut.puzzle.service.impl;

import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.constant.PuzzleConstants;
import com.tarabut.puzzle.enums.Gender;
import com.tarabut.puzzle.enums.Level;
import com.tarabut.puzzle.service.FighterService;

import java.util.Scanner;

public class FighterServiceImpl implements FighterService {

    @Override
    public FighterBo buildFighterCharacter(Scanner scanner) {
        FighterBo fighterBo = new FighterBo();
        System.out.println(String.format(PuzzleConstants.CREATE_FIGHTER_CHARACTER));
        System.out.println(String.format(PuzzleConstants.FILL_NAME));

        String name = scanner.next();
        fighterBo.setName(name);

        System.out.println(String.format(PuzzleConstants.FILL_GENDER));
        System.out.println(String.format(PuzzleConstants.MALE));
        System.out.println(String.format(PuzzleConstants.FEMALE));
        scanner.reset();
        Gender gender = null;
        while (!Gender.MALE.equals(gender) && !Gender.FEMALE.equals(gender)) {
            gender = Gender.from(scanner.nextInt());
            if (!Gender.MALE.equals(gender) && !Gender.FEMALE.equals(gender)) {
                System.out.println(String.format(PuzzleConstants.WRONG_VALUE));
                System.out.println(String.format(PuzzleConstants.MALE));
                System.out.println(String.format(PuzzleConstants.FEMALE));
            }
        }
        fighterBo.setGender(gender);

        System.out.println(String.format(PuzzleConstants.FILL_LEVEL));
        System.out.println(String.format(PuzzleConstants.PROFESSIONAL));
        System.out.println(String.format(PuzzleConstants.MIDDLE));
        System.out.println(String.format(PuzzleConstants.BEGINNER));
        scanner.reset();
        Level level = null;
        while (!Level.PROFESSIONAL.equals(level) && !Level.MIDDLE.equals(level) && !Level.BEGINNER.equals(level)) {
            level = Level.from(scanner.nextInt());
            if (!Level.PROFESSIONAL.equals(level) && !Level.MIDDLE.equals(level) && !Level.BEGINNER.equals(level)) {
                System.out.println(String.format(PuzzleConstants.WRONG_VALUE));
                System.out.println(String.format(PuzzleConstants.PROFESSIONAL));
                System.out.println(String.format(PuzzleConstants.MIDDLE));
                System.out.println(String.format(PuzzleConstants.BEGINNER));
            }
        }
        fighterBo.setLevel(level);
        fillAttribute(fighterBo);

        System.out.println(String.format(PuzzleConstants.STARS));
        System.out.println(String.format(PuzzleConstants.FILL_NAME + " " + fighterBo.getName()));
        System.out.println(String.format(PuzzleConstants.FILL_GENDER + " " + fighterBo.getGender()));
        System.out.println(String.format(PuzzleConstants.FILL_LEVEL + " " + fighterBo.getLevel()));
        System.out.println(String.format(PuzzleConstants.STARS));
        return fighterBo;
    }

    private void fillAttribute(FighterBo fighterBo) {
        switch (fighterBo.getLevel()) {
            case BEGINNER: {
                fighterBo.setHealth(70);
                fighterBo.setExperienceValue(10);
                fighterBo.setAttack(10);
                fighterBo.setDefense(70);
                fighterBo.setxPosition(49);
                fighterBo.setyPosition(5);
            } break;
            case MIDDLE: {
                fighterBo.setHealth(50);
                fighterBo.setExperienceValue(30);
                fighterBo.setAttack(20);
                fighterBo.setDefense(50);
                fighterBo.setxPosition(49);
                fighterBo.setyPosition(5);
            } break;
            case PROFESSIONAL: {
                fighterBo.setHealth(20);
                fighterBo.setExperienceValue(40);
                fighterBo.setAttack(40);
                fighterBo.setDefense(20);
                fighterBo.setxPosition(49);
                fighterBo.setyPosition(5);
            } break;
        }
    }
}
