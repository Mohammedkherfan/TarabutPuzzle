package com.tarabut.puzzle.repository;

import com.tarabut.puzzle.bo.EvilBo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class EvilRepository {

    public static Set<EvilBo> listOfEvils() {
        Set<EvilBo> set = new HashSet<>();
        set.add(new EvilBo("Evil1", 10, 10, 10, 5, new Random().nextInt((45 - 1) + 1) , new Random().nextInt((45 - 1) + 1) ,  Boolean.FALSE));
        set.add(new EvilBo("Evil2", 20, 20, 20, 10, new Random().nextInt((45 - 1) + 1) , new Random().nextInt((45 - 1) + 1) ,  Boolean.FALSE));
        set.add(new EvilBo("Evil3", 30, 30, 11, 15, new Random().nextInt((45 - 1) + 1) , new Random().nextInt((45 - 1) + 1) ,  Boolean.FALSE));
        set.add(new EvilBo("Evil4", 44, 40, 22, 35, new Random().nextInt((45 - 1) + 1) , new Random().nextInt((45 - 1) + 1) ,  Boolean.FALSE));
        set.add(new EvilBo("Evil5", 70, 22, 65, 55, new Random().nextInt((45 - 1) + 1) , new Random().nextInt((45 - 1) + 1) ,  Boolean.FALSE));
        set.add(new EvilBo("Evil6", 66, 50, 50, 75, new Random().nextInt((45 - 1) + 1) , new Random().nextInt((45 - 1) + 1) ,  Boolean.TRUE));
        return set;
    }
}
