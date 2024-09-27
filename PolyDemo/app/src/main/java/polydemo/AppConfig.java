package polydemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import polydemo.Effects.EffectDefinition;
import polydemo.Enemies.EnemyCharacter;

public class AppConfig {
    
    public PlayerCharacter player;
    public Scanner scanner = new Scanner(System.in);
    public List<EnemyCharacter> Inimigos = new ArrayList<>();
    public int currentEnemy = 0;
    public ObjectMapper objectMapper = new ObjectMapper();
    public EffectDefinition effectDefinition;

    {
        try {
            File jsonFile = new File("app/src/main/java/polydemo/Resources/Enemies.json");
            List<EnemyCharacter> enemies = objectMapper.readValue(jsonFile, new TypeReference<List<EnemyCharacter>>() {});
            Inimigos.addAll(enemies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
