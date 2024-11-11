/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.gustavogustavo.desafio;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author gustavo
 */
public class DesafioStreamFilterCod3r {

    public static void main(String[] args) {
    List<PlayerCharacter> playerCharacters = List.of(
        new PlayerCharacter("Kauren", 90),
        new PlayerCharacter("Lonolquiqui", 90),
        new PlayerCharacter("Zibiliqui", 85),
        new PlayerCharacter("Claos", 35),
        new PlayerCharacter("Horldar", 50),
        new PlayerCharacter("Devaltour", 72)
        );
    Predicate<PlayerCharacter> isHighLevel = player -> player.getLevel() >=80;
    Predicate<PlayerCharacter> isNameLong = player -> player.getName().length()>8;
    UnaryOperator<PlayerCharacter> setAsElite = player -> {
        player.setName(player.getName().concat(" - ELITE")); 
        return player;
        };
    Function<PlayerCharacter,String> retrieveName = player -> player.getName();

        playerCharacters.stream().filter(
            isHighLevel).filter(
                isNameLong).map(
                    setAsElite).map(
                        retrieveName).forEach(
                            System.out::println);
    }
}
