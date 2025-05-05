package org.example.scriptbinds;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonSingleton {
    private static final File FILE = new File(System.getProperty("user.home"), "hotkeys.json");
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveToJson(String hotkey, String script){
        Map<String, String> data = new HashMap<>();

        if (FILE.exists()) {
            try {
                data = mapper.readValue(FILE, new TypeReference<>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        data.put(hotkey, script);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(FILE, data);
            System.out.println("JSON updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
