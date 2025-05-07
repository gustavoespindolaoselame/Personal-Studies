package org.example.scriptbinds;

import javafx.scene.input.KeyCode;
import java.util.HashMap;
import java.util.Map;

public class AnsiKeyMapper {

    private static final Map<KeyCode, String> keyToAnsiMap = new HashMap<>();

    static {
        keyToAnsiMap.put(KeyCode.UP, "\u001B[A");
        keyToAnsiMap.put(KeyCode.DOWN, "\u001B[B");
        keyToAnsiMap.put(KeyCode.RIGHT, "\u001B[C");
        keyToAnsiMap.put(KeyCode.LEFT, "\u001B[D");

        keyToAnsiMap.put(KeyCode.F1, "\u001BOP");
        keyToAnsiMap.put(KeyCode.F2, "\u001BOQ");
        keyToAnsiMap.put(KeyCode.F3, "\u001BOR");
        keyToAnsiMap.put(KeyCode.F4, "\u001BOS");
        keyToAnsiMap.put(KeyCode.F5, "\u001B[15~");
        keyToAnsiMap.put(KeyCode.F6, "\u001B[17~");
        keyToAnsiMap.put(KeyCode.F7, "\u001B[18~");
        keyToAnsiMap.put(KeyCode.F8, "\u001B[19~");
        keyToAnsiMap.put(KeyCode.F9, "\u001B[20~");
        keyToAnsiMap.put(KeyCode.F10, "\u001B[21~");
        keyToAnsiMap.put(KeyCode.F11, "\u001B[23~");
        keyToAnsiMap.put(KeyCode.F12, "\u001B[24~");

        keyToAnsiMap.put(KeyCode.ENTER, "\r");
        keyToAnsiMap.put(KeyCode.ESCAPE, "\u001B");
        keyToAnsiMap.put(KeyCode.TAB, "\t");
        keyToAnsiMap.put(KeyCode.BACK_SPACE, "\b");
        // You can extend this map further as needed
    }

    public static String getAnsi(KeyCode keyCode, String characterText) {
        return keyToAnsiMap.getOrDefault(keyCode,
                characterText != null && !characterText.isEmpty() ? characterText : null);
    }
}
