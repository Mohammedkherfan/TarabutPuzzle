package com.tarabut.puzzle.bo;

import com.tarabut.puzzle.enums.Gender;
import com.tarabut.puzzle.enums.Level;

import java.io.Serializable;

public class FighterBo implements Serializable {

    private String name;
    private Gender gender;
    private Level level;
    private Integer health;
    private Integer experienceValue;
    private Integer attack;
    private Integer defense;
    private Integer xPosition;
    private Integer yPosition;

    public FighterBo() {
    }

    public FighterBo(String name, Gender gender, Level level, Integer health, Integer experienceValue, Integer attack, Integer defense, Integer xPosition, Integer yPosition) {
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.health = health;
        this.experienceValue = experienceValue;
        this.attack = attack;
        this.defense = defense;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getxPosition() {
        return xPosition;
    }

    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getyPosition() {
        return yPosition;
    }

    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }
}
