package ua.com.alevel.charac;

import org.apache.commons.lang3.*;

public class Pudge extends Character {
    public Pudge() {
        this.name = "Pudge";

    }

    public void hook(Character character){
        System.out.println("Хукаю " + StringUtils.upperCase(character.name));

    }
}