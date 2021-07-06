package com.tarabut.puzzle.repository;

import com.tarabut.puzzle.bo.FighterBo;
import com.tarabut.puzzle.constant.PuzzleConstants;

import java.io.*;

public class FighterRepository {

    public static void save(FighterBo fighterBo)  {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("myFighters.txt"));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(fighterBo);
        } catch (Exception e) {
            System.out.println(PuzzleConstants.ERROR_TRY_AGAIN + e.getMessage());
        }finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println(PuzzleConstants.ERROR_TRY_AGAIN + e.getMessage());
            }
        }
    }

    public static FighterBo read() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("myFighters.txt"));
            objectInputStream = new ObjectInputStream(fileInputStream);
            FighterBo fighterBo = (FighterBo) objectInputStream.readObject();
            return fighterBo;
        } catch (Exception e) {
            System.out.println(PuzzleConstants.ERROR_TRY_AGAIN + e.getMessage());
        }finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(PuzzleConstants.ERROR_TRY_AGAIN + e.getMessage());
            }
        }
        return null;
    }
}
