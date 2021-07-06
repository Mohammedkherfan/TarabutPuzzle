package com.tarabut.puzzle.service.impl;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.constant.PuzzleConstants;
import com.tarabut.puzzle.constant.PuzzleMessages;
import com.tarabut.puzzle.enums.Attack;
import com.tarabut.puzzle.enums.Escape;
import com.tarabut.puzzle.enums.PlayOperation;
import com.tarabut.puzzle.repository.FighterRepository;
import com.tarabut.puzzle.service.LayoutService;
import com.tarabut.puzzle.service.PlayService;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class PlayServiceImpl implements PlayService {

    private static Boolean missionComplete = Boolean.TRUE;
    private LayoutService layoutService;

    public PlayServiceImpl() {
        this.layoutService = new LayoutServiceImpl();
    }

    @Override
    public void play(Scanner scanner, FighterBo fighter, Set<EvilBo> evils, String[][] layout) {
        layoutService.print(layout);
        while (missionComplete) {
            PuzzleMessages.callPuzzlePlayOperation();
            scanner.reset();

            PlayOperation playOperation = null;
            while (!PlayOperation.MOVE_FORWARD.equals(playOperation) &&
                    !PlayOperation.MOVE_RIGHT.equals(playOperation) &&
                    !PlayOperation.MOVE_LEFT.equals(playOperation) &&
                    !PlayOperation.MOVE_BACKWARD.equals(playOperation) &&
                    !PlayOperation.ESCAPE.equals(playOperation)) {
                playOperation = PlayOperation.from(scanner.nextInt());
                if (!PlayOperation.MOVE_FORWARD.equals(playOperation) &&
                        !PlayOperation.MOVE_RIGHT.equals(playOperation) &&
                        !PlayOperation.MOVE_LEFT.equals(playOperation) &&
                        !PlayOperation.MOVE_BACKWARD.equals(playOperation) &&
                        !PlayOperation.ESCAPE.equals(playOperation)) {
                    PuzzleMessages.callPuzzlePlayOperation();
                }
            }

            switch (playOperation) {
                case ESCAPE: {
                    escape(scanner, fighter, evils, layout);
                }
                break;
                default:
                    createPlayOperation(scanner, fighter, evils, layout, playOperation);
            }
        }
        if (!missionComplete) {
            System.out.println(String.format(PuzzleConstants.MISSION_COMPLETE));
            System.exit(0);
        }

        scanner.close();
    }

    private void escape(Scanner scanner, FighterBo fighter, Set<EvilBo> evils, String[][] layout) {
        PuzzleMessages.callPuzzleEscape();
        scanner.reset();

        Escape escape = null;
        while (!Escape.CHECK_ATTRIBUTE.equals(escape) &&
                !Escape.SAVE_GAME.equals(escape) &&
                !Escape.EXIST_GAME.equals(escape)) {
            escape = Escape.from(scanner.nextInt());
            if (!Escape.CHECK_ATTRIBUTE.equals(escape) &&
                    !Escape.SAVE_GAME.equals(escape) &&
                    !Escape.EXIST_GAME.equals(escape)) {
                PuzzleMessages.callPuzzlePlayOperation();
            }
        }

        switch (escape) {
            case CHECK_ATTRIBUTE: {
                checkAttribute(fighter);
            } break;
            case SAVE_GAME: {
                saveGame(fighter);
            } break;
            case EXIST_GAME: {
                System.out.println(String.format(PuzzleConstants.MISSION_COMPLETE));
                System.exit(0);
            } break;
        }

    }

    private void saveGame(FighterBo fighter) {
        FighterRepository.save(fighter);
        System.out.println(PuzzleConstants.SAVED_SUCCESSFULLY);
    }

    private void checkAttribute(FighterBo fighter) {
        PuzzleMessages.callPuzzleFighterAttribute(fighter);
    }

    private void createPlayOperation(Scanner scanner, FighterBo fighter, Set<EvilBo> evils, String[][] layout, PlayOperation playOperation) {
        switch (playOperation) {
            case MOVE_FORWARD: {
                Boolean result = checkLayoutPosition(layout, fighter.getxPosition() -1, fighter.getyPosition());
                if (result) {
                    String opponent = findOpponent(layout, fighter.getxPosition() -1, fighter.getyPosition());
                    fight(scanner, fighter, evils, opponent, fighter.getxPosition() -1, fighter.getyPosition());
                    updateLayout(fighter, layout, fighter.getxPosition() -1, fighter.getyPosition(), playOperation);
                    operation(fighter, playOperation);
                }
            } break;
            case MOVE_LEFT: {
                Boolean result = checkLayoutPosition(layout, fighter.getxPosition() , fighter.getyPosition() -1);
                if (result) {
                    String opponent = findOpponent(layout, fighter.getxPosition(), fighter.getyPosition() -1);
                    fight(scanner, fighter, evils, opponent, fighter.getxPosition(), fighter.getyPosition() -1);
                    updateLayout(fighter, layout, fighter.getxPosition(), fighter.getyPosition() -1, playOperation);
                    operation(fighter, playOperation);
                }
            } break;
            case MOVE_RIGHT: {
                Boolean result = checkLayoutPosition(layout, fighter.getxPosition() , fighter.getyPosition() +1);
                if (result) {
                    String opponent = findOpponent(layout, fighter.getxPosition(), fighter.getyPosition() +1);
                    fight(scanner, fighter, evils, opponent, fighter.getxPosition(), fighter.getyPosition() +1);
                    updateLayout(fighter, layout, fighter.getxPosition(), fighter.getyPosition() +1, playOperation);
                    operation(fighter, playOperation);
                }
            } break;
            case MOVE_BACKWARD: {
                Boolean result = checkLayoutPosition(layout, fighter.getxPosition() +1, fighter.getyPosition());
                if (result) {
                    String opponent = findOpponent(layout, fighter.getxPosition() +1, fighter.getyPosition());
                    fight(scanner, fighter, evils, opponent, fighter.getxPosition() +1, fighter.getyPosition());
                    updateLayout(fighter, layout, fighter.getxPosition() +1, fighter.getyPosition(), playOperation);
                    operation(fighter, playOperation);
                }
            } break;
        }
    }

    private void operation(FighterBo fighter, PlayOperation playOperation) {
        switch (playOperation) {
            case MOVE_FORWARD:
                fighter.setxPosition(fighter.getxPosition() - 1);
                break;
            case MOVE_LEFT:
                fighter.setyPosition(fighter.getyPosition() - 1);
                break;
            case MOVE_RIGHT:
                fighter.setyPosition(fighter.getyPosition() + 1);
                break;
            case MOVE_BACKWARD:
                fighter.setxPosition(fighter.getxPosition() + 1);
                break;
        }
    }

    private void updateLayout(FighterBo fighter, String[][] layout, Integer xPosition, Integer yPosition, PlayOperation playOperation) {
        switch (playOperation) {
            case MOVE_FORWARD:
                layout[xPosition+1][yPosition] = " ";
                break;
            case MOVE_LEFT:
                layout[xPosition][yPosition+1] = " ";
                break;
            case MOVE_RIGHT:
                layout[xPosition][yPosition-1] = " ";
                break;
            case MOVE_BACKWARD:
                layout[xPosition-1][yPosition] = " ";
                break;
        }
        layout[xPosition][yPosition] = fighter.getName();
    }

    private void fight(Scanner scanner, FighterBo fighterBo, Set<EvilBo> evils, String opponent, Integer xPosition, Integer yPosition) {
        if (!opponent.trim().isEmpty()) {
            EvilBo evilBo = getEvil(evils, xPosition, yPosition);
            while (fighterBo.getHealth() > 0 && evilBo.getHealth() > 0) {
                PuzzleMessages.callPuzzleConfrontation(fighterBo, evilBo);
                PuzzleMessages.callPuzzleAttacking();

                Attack attack = null;
                while (!Attack.SHOOt.equals(attack) &&
                        !Attack.DEFENCE.equals(attack)) {
                    attack = Attack.from(scanner.nextInt());
                    if (!Attack.SHOOt.equals(attack) &&
                            !Attack.DEFENCE.equals(attack)) {
                        PuzzleMessages.callPuzzleAttacking();
                    }
                }

                Boolean position = Boolean.FALSE;
                switch (attack) {
                    case SHOOt: {
                        position = attack(fighterBo, evilBo, position);
                    } break;
                    case DEFENCE: {
                        position = defence(fighterBo, evilBo, Boolean.TRUE);
                    } break;
                }
            }
            if (fighterBo.getHealth() <= 0){
                System.out.println(PuzzleConstants.GAME_OVER);
                System.exit(0);
            }
            System.out.println(PuzzleConstants.SPACE);
            System.out.println(PuzzleConstants.KILLED+ evilBo.getName());
            System.out.println(PuzzleConstants.SPACE);
            fighterBo.setExperienceValue(fighterBo.getExperienceValue()+10);
            fighterBo.setAttack(fighterBo.getAttack()+5);
            fighterBo.setHealth(fighterBo.getHealth()+5);
        }

    }

    private Boolean defence(FighterBo fighterBo, EvilBo evilBo, Boolean position) {
        if (position) {
            Integer damage = evilDamaging(fighterBo, evilBo, 1, Boolean.TRUE);
            removeHealth(fighterBo, evilBo, damage, 1, Boolean.FALSE);
            position = Boolean.FALSE;
        }else {
            Integer damage = evilDamaging(fighterBo, evilBo, 0, Boolean.TRUE);
            removeHealth(fighterBo, evilBo, damage, 0, Boolean.FALSE);
        }
        return position;
    }

    private Integer evilDamaging(FighterBo fighterBo, EvilBo evilBo, Integer factor, Boolean type) {
        if (type) {
            if ((evilBo.getAttack() + factor) - (fighterBo.getDefense() / 2) < 0)
                return 0;
            return ((evilBo.getAttack() + factor) - (fighterBo.getDefense() / 2));
        }else {
            if ((evilBo.getAttack() * factor) - (fighterBo.getDefense() / 2) < 0)
                return 0;
            return ((evilBo.getAttack() * factor) - (fighterBo.getDefense() / 2));
        }
    }

    private void increaseHealth(FighterBo fighterBo, Integer defence) {
        fighterBo.setHealth(defence);
    }

    private Integer fighterDefencing(FighterBo fighterBo, Integer health) {
        return fighterBo.getHealth() + health;
    }


    private Boolean attack(FighterBo fighterBo, EvilBo evilBo, Boolean position) {
        if (position) {
            Integer damage = fighterDamaging(fighterBo, evilBo, 1, Boolean.TRUE);
            removeHealth(fighterBo, evilBo, damage, 1, Boolean.TRUE);
            position = Boolean.FALSE;
        }else {
            Integer damage = fighterDamaging(fighterBo, evilBo, 0, Boolean.TRUE);
            removeHealth(fighterBo, evilBo, damage, 0, Boolean.TRUE);
        }
        return position;
    }

    private void removeHealth(FighterBo fighterBo, EvilBo evilBo, Integer damage, Integer removing, Boolean isFighter) {
        if (isFighter)
            evilBo.setHealth(evilBo.getHealth() - damage);
        else
            fighterBo.setHealth(fighterBo.getHealth() - damage);
    }

    private Integer fighterDamaging(FighterBo fighterBo, EvilBo evilBo, Integer factor, Boolean type) {
        if (type) {
            if ((fighterBo.getAttack() + factor) - (evilBo.getDefense() / 2) < 0)
                return 0;
            return ((fighterBo.getAttack() + factor) - (evilBo.getDefense() / 2));
        }else {
            if ((fighterBo.getAttack() * factor) - (evilBo.getDefense() / 2) < 0)
                return 0;
            return ((fighterBo.getAttack() * factor) - (evilBo.getDefense() / 2));
        }
    }

    private EvilBo getEvil(Set<EvilBo> evils, Integer xPosition, Integer yPosition) {
        Optional<EvilBo> optionalEvilBo = evils.stream().filter(evilBo -> xPosition.equals(evilBo.getxPosition()) && yPosition.equals(evilBo.getyPosition())).findFirst();
        return optionalEvilBo.get();
    }

    private String findOpponent(String[][] layout, Integer xPosition, Integer yPosition) {
        if (layout[xPosition][yPosition] == "Evil1")
            return "Evil1";
        if (layout[xPosition][yPosition] == "Evil2")
            return "Evil2";
        if (layout[xPosition][yPosition] == "Evil3")
            return "Evil3";
        if (layout[xPosition][yPosition] == "Evil4")
            return "Evil5";
        if (layout[xPosition][yPosition] == "Evil5")
            return "Evil5";
        if (layout[xPosition][yPosition] == "Evil6")
            return "Evil6";
        return " ";
    }

    private Boolean checkLayoutPosition(String[][] layout, Integer xPosition, Integer yPosition) {
        if (layout[xPosition][yPosition] == "/" || layout[xPosition][yPosition] == "-" || layout[xPosition][yPosition] == "_")
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }
}
