package utils;

import java.io.*;
import java.util.*;

public class EnvLoader {
    
    private Map<String, String> env;
    
    public EnvLoader(Map<String, String> env) {
        this.env = env;
    }
    
    public static EnvLoader load() {
        return load(".env");
    }
    
    public static EnvLoader load(String filePath) {
        Map<String, String> env = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    env.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new EnvLoader(env);
    }
    
    public String get(String key) {
        return env.get(key);    
    }
}
