package org.gustavogustavo.desafio;

public class PlayerCharacter {
    private String name;
    private Integer level;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public PlayerCharacter(String name, Integer level) {
        this.name = name;
        this.level = level;
    }
}
