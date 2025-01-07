package polydemo.Character;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import polydemo.AppConfig;

public class PlayerEffect extends AppConfig {
    // Use BiConsumer to pass both ticksLeft and effectStrength
    private final Map<String, BiConsumer<Integer, Integer>> effectMap = new HashMap<>();

    public PlayerEffect() {
        // Initialize the effects with their corresponding methods
        effectMap.put("poison", this::poisoned);
        effectMap.put("fire", this::fire);
        effectMap.put("weaken", this::weakened);
        effectMap.put("confusion", this::confused);
        effectMap.put("drowsy", this::drowsy);
    }

    public void callEffect(String effectName, int ticksLeft, int effectStrength) {
        BiConsumer<Integer, Integer> effect = effectMap.get(effectName); // Use BiConsumer here
        if (effect != null) {
            effect.accept(ticksLeft, effectStrength); // Pass both ticksLeft and effectStrength
        } else {
            System.out.println("Efeito desconhecido: " + effectName);
        }
    }
    
    public void poisoned(int ticksLeft, int effectStrength) {
        if (ticksLeft >= 0) {
            System.out.println("Executando método 'poison' com " + ticksLeft + " ticks restantes e força " + effectStrength);
            this.player.setHealth(this.player.getHealth() - (5 * effectStrength)); // Adjust health based on effect strength
            ticksLeft--;
        }
    }

    public void fire(int ticksLeft, int effectStrength) {
        if (ticksLeft >= 0) {
            System.out.println("Executando método 'fire' com " + ticksLeft + " ticks restantes e força " + effectStrength);
            this.player.setHealth(this.player.getHealth() - (5 * effectStrength));
            ticksLeft--;
        }
    }

    public void weakened(int ticksLeft, int effectStrength) {
        if (ticksLeft >= 0) {
            System.out.println("Executando método 'weaken' com " + ticksLeft + " ticks restantes e força " + effectStrength);
            this.player.setHealth(this.player.getHealth() - (5 * effectStrength));
            ticksLeft--;
        }
    }

    public void confused(int ticksLeft, int effectStrength) {
        if (ticksLeft >= 0) {
            System.out.println("Executando método 'confused' com " + ticksLeft + " ticks restantes e força " + effectStrength);
            this.player.setHealth(this.player.getHealth() - (5 * effectStrength));
            ticksLeft--;
        }
    }

    public void drowsy(int ticksLeft, int effectStrength) {
        if (ticksLeft >= 0) {
            System.out.println("Executando método 'drowsy' com " + ticksLeft + " ticks restantes e força " + effectStrength);
            this.player.setHealth(this.player.getHealth() - (5 * effectStrength));
            ticksLeft--;
        }
    }
}
