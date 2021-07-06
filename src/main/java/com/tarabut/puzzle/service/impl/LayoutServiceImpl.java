package com.tarabut.puzzle.service.impl;

import com.tarabut.puzzle.bo.EvilBo;
import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.service.LayoutService;

import java.util.Set;

import static java.util.Objects.isNull;

public class LayoutServiceImpl implements LayoutService {



    @Override
    public String [] [] buildLayout(FighterBo fighter, Set<EvilBo> evils) {
        String[][] map = generate();
        addFighterToLayout(map, fighter.getxPosition(), fighter.getyPosition(), fighter.getName());
        addEvilsToLayout(map, evils);
        return map;
    }

    @Override
    public void print(String[][] layout) {
        for (Integer x = 0; x < layout[0].length; x++) {
            for (Integer y = 0; y < layout[x].length; y++) {
                if (!isNull(layout[x][y]))
                    System.out.println(layout[x][y]);
            }
            System.out.println();
        }
    }

    private void addEvilsToLayout(String[][] map, Set<EvilBo> evils) {
        evils.stream().forEach(evil -> {
            map[evil.getxPosition()][evil.getyPosition()] = evil.getName();
        });
    }

    private String [] [] generate() {
        String [] [] map = new String [50] [50];
        for (Integer x = 1; x < map[0].length; x ++) {
            map[0][x] = "-";
            map[49][x] = "_";
            map[x][0] = "/";
            map[x][49] = "/";
        }
        return map;
    }

    private void addFighterToLayout(String[][] map, Integer xPosition, Integer yPosition, String name) {
        map[xPosition][yPosition] = name;
    }
}
