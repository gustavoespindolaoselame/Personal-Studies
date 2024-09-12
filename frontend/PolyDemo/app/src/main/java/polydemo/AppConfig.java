package polydemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import polydemo.Character.CharacterClasses;
import polydemo.Enemies.EnemyClasses;

public class AppConfig {
    CharacterClasses classe;
    public Scanner scanner = new Scanner(System.in);
    public List<EnemyClasses> Inimigos = new ArrayList<>();
    int currentEnemy = 0;
    ObjectMapper objectMapper = new ObjectMapper();
    
    {
        try {
            File jsonFile = new File("app\\src\\main\\java\\polydemo\\Resources\\Enemies.json");
            List<EnemyClasses> enemies = objectMapper.readValue(jsonFile, new TypeReference<List<EnemyClasses>>() {});
            Inimigos.addAll(enemies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
