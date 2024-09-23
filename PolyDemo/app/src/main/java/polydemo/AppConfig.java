package polydemo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import polydemo.Character.PlayerCharacter;
import polydemo.Character.PlayerEffect;
import polydemo.Enemies.EnemyCharacter;

public class AppConfig {

    public PlayerEffect playerEffect = new PlayerEffect();  
    
    public PlayerCharacter player;
    public Scanner scanner = new Scanner(System.in);
    public List<EnemyCharacter> Inimigos = new ArrayList<>();
    public int currentEnemy = 0;
    public ObjectMapper objectMapper = new ObjectMapper();
    
        
    {
        try {
            File jsonFile = new File("/home/maglab/Desktop/PersonalStudies/Personal-Studies/PolyDemo/app/src/main/java/polydemo/Resources/Enemies.json");
            List<EnemyCharacter> enemies = objectMapper.readValue(jsonFile, new TypeReference<List<EnemyCharacter>>() {});
            Inimigos.addAll(enemies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
